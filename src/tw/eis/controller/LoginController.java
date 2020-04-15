package tw.eis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.eis.model.Employee;
import tw.eis.model.EmployeeService;
import tw.eis.model.Users;
import tw.eis.model.UsersService;
import tw.eis.util.AESUtil;
import tw.eis.util.EmailUtil;



@Controller
@SessionAttributes(names = {"usersResultMap", "errorMsgMap", "LoginOK", "userName"})
@RequestMapping(path ="/login")
public class LoginController {
	private UsersService uService;
	private EmployeeService eService;
	AESUtil aes = new AESUtil();
	
	@Autowired
	public LoginController(UsersService uService, EmployeeService eService){
		this.uService = uService;
		this.eService=eService;
		
	}
	
	@RequestMapping(path = "/userLogin", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "UserLogin";
	}
	
	@RequestMapping(path = "/userLoginCheck", method = RequestMethod.POST)
	public String processLoginAction(@RequestParam("userName") String userAccount,
			@RequestParam("userPassword") String userPwd, Model model) throws IOException, Exception {
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		model.addAttribute("errorMsgMap", errorMsgMap);

		if (userAccount == null || userAccount.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "User account should not be empty");
		}
		
		if (userPwd == null || userPwd.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "User password should not be empty");
		}

		if (!errorMsgMap.isEmpty()) {
			return "UserLogin";
		}
		
		String encryptPwd=aes.parseByte2HexStr(aes.encrypt(userPwd));
		
		List<Users> loginResult=uService.findUsers(userAccount, encryptPwd);
		
		if(loginResult.size()>0) {
			Iterator<Users> loginResultIT = loginResult.iterator();
			Users uBean = loginResultIT.next();
			model.addAttribute("LoginOK", uBean);
			Map<String, String> usersResultMap = new HashMap<String, String>();
			usersResultMap.put("EmployeeID", String.valueOf(uBean.getEmployeeID()));
			usersResultMap.put("UserName", uBean.getUserName());
			usersResultMap.put("UserPassword", encryptPwd);
			usersResultMap.put("Title", uBean.getTitle());
			usersResultMap.put("Department", uBean.getDepartment());
			model.addAttribute("usersResultMap", usersResultMap);
			return "LoginSucess";
			
		}
		else {
			errorMsgMap.put("LoginError", "Account doesn't exit or password wrong");
			return "UserLogin";
		}
	} 
	
	@RequestMapping(path = "/forgetPwd", method = RequestMethod.GET)
	public String goToSendEmailPage() {
		return "CheckEmail";
	}
	
	@RequestMapping(path = "/sendMail", method = RequestMethod.POST)
	public String ProcessForgotPwd(@RequestParam("email") String email, Model model) {
		List<Employee> employeeByEmail=eService.findEmployeeByEmail(email);
		Map<String, String> errorMsgFromForgetPwd = new HashMap<String, String>();
		model.addAttribute("errorMsgFromForgetPwd", errorMsgFromForgetPwd);
		
		if(employeeByEmail.size() <= 0) {						
			errorMsgFromForgetPwd.put("emailNotFound", "E-mail�S�Q���U�L");
			return "CheckEmail";
		}
		
		Iterator<Employee> employeeByEmailIT = employeeByEmail.iterator();
		Employee eBean = employeeByEmailIT.next();
		List<Users> uList=uService.findUsersByID(eBean.getEmpID());
		Iterator<Users> uListIT=uList.iterator();
		Users uBean=uListIT.next();
		EmailUtil eUtil=new EmailUtil();
		eUtil.sendResetPasswordEmail(uBean, email);
		errorMsgFromForgetPwd.put("emailSucess", "���榨�\�A�Ьd�ݧA��E-mail�H�c");
		return "CheckEmail";
	}
	
	@RequestMapping(path = "/resetPassword", method = RequestMethod.GET)
	public String goToResetPwdPage(@RequestParam("userName") String userName, Model model) {
		model.addAttribute("userName",userName);
		return "resetPassword";
	}
	
	@RequestMapping(path = "/passwordChange", method = RequestMethod.POST)
	public String resetPew(@ModelAttribute("userName") String userName, @RequestParam("psw") String psw, Model model) {
		String encryptPwd=aes.parseByte2HexStr(aes.encrypt(psw));
		Boolean status=uService.updateUsersPassword(userName, encryptPwd);
		Map<String, String> MsgFromPwdReset = new HashMap<String, String>();
		model.addAttribute("MsgFromPwdReset", MsgFromPwdReset);
		if(status) {
			MsgFromPwdReset.put("resetSuccess", "�K�X���]���\�A�Э��s�n�J");
			return "UserLogin";
		}
		MsgFromPwdReset.put("resetFailed", "�K�X���]���ѡA�ЦA�դ@��");
		return "resetPassword";
	}
	
}