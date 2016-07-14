package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

	@RequestMapping(value="login", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object Login(String userName, String password) {
		
		return userName + " - " + password;
	}
}
