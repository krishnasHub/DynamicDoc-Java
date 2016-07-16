package controller;

import model.User;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dataaccess.GenericDataAccess;
import dataaccess.LoginDataAccess;
import dataaccess.UserDataAccess;
import util.HibernateUtil;

@Controller
@EnableWebMvc
public class LoginController {

	@RequestMapping(value="login", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object Login(String userName, String password) {		
		LoginDataAccess la = new LoginDataAccess();
		boolean isSuccess = la.checkUserLogin(userName, password);
		
		return isSuccess;
	}
}
