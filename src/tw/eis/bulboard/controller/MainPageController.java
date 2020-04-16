package tw.eis.bulboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//不加圖片顯示不出來
@RequestMapping(path ="/login")
public class MainPageController {
	
	@RequestMapping(path = "/BullBoard",method = RequestMethod.GET)
	public String MainPage() {
		return "Bullboard";
	}
	
	@RequestMapping(path = "/Title",method = RequestMethod.GET)
	public String Title() {
		return "Title";
	}
	
	@RequestMapping(path = "/index",method = RequestMethod.GET)
	public String index() {
		return "index";
	}
//	讓jstl可以抓到該網頁用
	@RequestMapping(path = "/LoginSucess",method = RequestMethod.GET)
	public String LoginSucess() {
		return "LoginSucess";
	}
}
