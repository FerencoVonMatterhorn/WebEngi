package main.java.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.Util.PasswordUtil;
import main.java.beans.UserBean;

public class dbActions {

	Session session;

	private dbActions() {
		// Constructor may be empty
	}

	public static void register() {
		// TODO: register user
	}

	public static Optional<UserBean> login(String inUsername, String inPassword) {
		Session session = dbConfig.getSessionFactory().openSession();
		Optional<UserBean> user = findUser(session, inUsername);
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(), user.get().getIterations())) {
					// TODO: anmeldung war erfolgreich
				} else {
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO: Add Logger to project.
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * Helper methods.
	 */

	private static Optional<UserBean> findUser(Session session, String inUsername) {
		session.beginTransaction();
		Query<?> query = session.createQuery("from USER where USERNAME := username");
		query.setParameter("username", inUsername);
		return (Optional<UserBean>) query.uniqueResultOptional();
	}

}