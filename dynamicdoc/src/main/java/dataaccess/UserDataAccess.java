package dataaccess;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import model.User;

public class UserDataAccess extends GenericDataAccess {

	public List<User> getAllUsers()	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		List<User> l = session.createQuery("from User").list();
		//List<User> l = session.createCriteria(User.class).list();
		
		return l;
	}
	
	public User getUserByName(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
		List<User> l;
		
		if(userName.contains("@")) 
			l = session.createQuery("from User u where u.emailId = '" + userName + "'").list();
		 else 
			l = session.createQuery("from User u where u.name = '" + userName + "'").list();
		
		
		if(l.size() == 1)
			user = l.get(0);
		
		return user;
	}
	
	public void createNewUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
	
	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	public User getUserById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (User) session.load(User.class, new Integer(id));
	}
}
