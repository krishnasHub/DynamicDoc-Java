package controller;

import model.LoginModel;
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
	public @ResponseBody LoginModel Login(String userName, String password) {		
		LoginDataAccess la = new LoginDataAccess();
		boolean isSuccess = la.checkUserLogin(userName, password);
		LoginModel model = new LoginModel();
		model.setIsSuccess(isSuccess);
		
		if(isSuccess) {
			UserDataAccess ua = new UserDataAccess();
			User user = ua.getUserByName(userName);
			model.setUser(user);
			if(user.getLoggedIn() == User.LOGGED_IN)
				model.setWarning("User already logged in.");
			else
				la.loginUser(user);
		}	
		
		return model;
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody LoginModel Logout(String userName) {
		LoginModel model = new LoginModel();
		UserDataAccess ua = new UserDataAccess();
		LoginDataAccess la = new LoginDataAccess();
		User user = ua.getUserByName(userName);
		if (user.getLoggedIn() == User.LOGGED_OUT)
			model.setWarning("User already logged out.");
		else
			la.logoutUser(user);
		
		model.setIsSuccess(true);
		
		return model;
	}
}
