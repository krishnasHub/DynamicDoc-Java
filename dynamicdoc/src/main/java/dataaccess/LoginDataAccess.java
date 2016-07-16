package dataaccess;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.User;

public class LoginDataAccess extends GenericDataAccess {

	public boolean checkUserLogin(String userName, String password) {
		UserDataAccess ua = new UserDataAccess();
		List<User> list = ua.getAllUsers();
		
		for (User user : list) {
			if ( (userName.contains("@") && user.getEmailId().equals(userName) && user.getPassword().equals(password))
					|| (user.getName().equals(userName) && user.getPassword().equals(password)))
				return true;
		}
		
		return false;
	}
	
	public void loginUser(User user) {
		user.setLoggedIn(User.LOGGED_IN);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	public void logoutUser(User user) {
		user.setLoggedIn(User.LOGGED_OUT);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
}
