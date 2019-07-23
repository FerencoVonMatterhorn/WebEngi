package main.java.db;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.UserPojo;

public class DBUserActions {

	private static final Logger logger = LogManager.getLogger(DBUserActions.class);
	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	private DBUserActions() {
		// May be empty.
	}

	public static UserPojo findUserByID(int inUserID) {
		logger.info("Looking for User by ID: {}", inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where USERID = :id");
		query.setParameter("id", inUserID);
		UserPojo user = (UserPojo) query.uniqueResult();
		session.close();
		return user;
	}

	public static Optional<UserPojo> findUserByName(String inUsername) {
		logger.info("Looking for User by Username: {}", inUsername);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where USERNAME = :username");
		query.setParameter("username", inUsername);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	public static Optional<UserPojo> findUserByEmail(String inEmail) {
		logger.info("Looking for User by Email: {}", inEmail);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where EMAIL = :email");
		query.setParameter("email", inEmail);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	/**
	 * Sucht in der DB nach benutzer die dem eingegebenen String vom Namen
	 * ähnlich sind
	 * 
	 * @param inSearchQuery
	 * @return eine Liste der gefunden Benutzernamen, die passen
	 */
	public static List<String> searchForUser(String inSearchQuery) {
		logger.info("Looking for User with a name Similar to: {}", inSearchQuery);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("SELECT u.username from USERS u where u.username LIKE :username");
		query.setParameter("username", inSearchQuery + "%");
		List<String> userlist = (List<String>) query.getResultList();
		session.close();
		return userlist;
	}

	public static void saveUser(UserPojo inUser) {
		logger.info("Saving User: {}", inUser);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUser);
		session.getTransaction().commit();
		session.close();
	}

	public static void updateUser(UserPojo inUser) {
		logger.info("Updating User: {}", inUser);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(inUser);
		session.getTransaction().commit();
		session.close();
	}

}
