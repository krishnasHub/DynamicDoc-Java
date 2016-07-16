package controller;

import model.User;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import util.HibernateUtil;

@Controller
@EnableWebMvc
public class LoginController {

	@RequestMapping(value="login", method = RequestMethod.GET, 
			produces = "application/json")
	//@RequestMapping("login")
	public @ResponseBody Object Login(String userName, String password) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object o = session.createCriteria(User.class).list();
		
		return o;
	}
}
