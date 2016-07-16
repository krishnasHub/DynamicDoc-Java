package dataaccess;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.User;

public class UserDataAccess extends GenericDataAccess {

	public List<User> getAllUsers()	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> l = session.createCriteria(User.class).list();
		
		return l;
	}
}
