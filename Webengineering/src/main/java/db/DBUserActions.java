package main.java.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	static void saveUser(UserPojo inUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUser);
		session.getTransaction().commit();
		session.close();
	}

	public static UserPojo findUserById(int inId) {
		logger.info("Looking for User by ID: {}", inId);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where USERID = :id");
		query.setParameter("id", inId);
		UserPojo user = (UserPojo) query.uniqueResult();
		session.close();
		return user;
	}

	static Optional<UserPojo> findUserByName(String inUsername) {
		logger.info("Looking for User by Username: {}", inUsername);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where USERNAME = :username");
		query.setParameter("username", inUsername);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	static Optional<UserPojo> findUserByEmail(String inEmail) {
		logger.info("Looking for User by EMail: {}", inEmail);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERS where EMAIL = :email");
		query.setParameter("email", inEmail);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	static List<UserPojo> findUsersByName(String inUsersStr) {
		logger.info("Looking for Users by Name: {}", inUsersStr);
		List<String> formattedUserStrings = userStringsToList(inUsersStr);
		List<UserPojo> users = new ArrayList<>();
		for (String user : formattedUserStrings) {
			Optional<UserPojo> foundUser = findUserByName(user);
			if (foundUser.isPresent()) {
				users.add(foundUser.get());
			}
		}
		return users;
	}

	// TODO in utils verschieben
	public static List<String> userStringsToList(String inUsersStr) {
		List<String> users = new ArrayList<>();
		String[] userStrArr = inUsersStr.split(",");
		for (int i = 0; i < userStrArr.length; i++) {
			userStrArr[i] = userStrArr[i].trim();
			users.add(userStrArr[i]);
		}
		return users;
	}

	public static List<String> searchForUser(String inSearchQuery) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("SELECT u.username from USERS u where u.username LIKE :username");
		query.setParameter("username", inSearchQuery + "%");
		List<String> userlist = (List<String>) query.getResultList();
		session.close();
		return userlist;
	}

	static boolean usernameOrEmailisPresent(String inUsername, String inEmail) {
		return (DBUserActions.findUserByName(inUsername).isPresent()
				|| DBUserActions.findUserByEmail(inEmail).isPresent());
	}

	public static void updateProfile(Map<String, String> modalValues) {
		UserPojo user = findUserById(Integer.valueOf(modalValues.get("userID")));

		for (String input : modalValues.keySet()) {
			if (!modalValues.get(input).isEmpty()) {
				switch (input) {
				case "firstName":
					user.setFirstName(modalValues.get(input));
					break;
				case "lastName":
					user.setLastName(modalValues.get(input));
					break;
				case "userName":
					user.setUsername(modalValues.get(input));
					break;
				case "eMail":
					user.setEmail(modalValues.get(input));
					break;
				default:
					break;
				}
			}
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

}
