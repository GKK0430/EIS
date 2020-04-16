package tw.eis.bulboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
	
	@RequestMapping(path = "/LoginSucess",method = RequestMethod.GET)
	public String LoginSucess() {
		return "LoginSucess";
	}
}
