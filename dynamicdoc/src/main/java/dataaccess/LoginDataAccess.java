package dataaccess;

import java.util.List;

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
}
