package main.java.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.beans.UserBean;
import main.java.util.PasswordUtil;

public class DBActions {

	Session session;

	private DBActions() {
		// Constructor may be empty
	}

	public static void register() {
		// TODO: empty method stub.
	}

	public static Optional<UserBean> login(String inUsername, String inPassword) {
		Session session = DBConfig.getSessionFactory().openSession();
		Optional<UserBean> user = findUser(session, inUsername);
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(), user.get().getIterations())) {
					return user;
				} else {
					return Optional.empty();
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	/**
	 * Helper methods.
	 */

	private static Optional<UserBean> findUser(Session session, String inUsername) {
		session.beginTransaction();
		Query<?> query = session.createQuery("from USER where USERNAME := username");
		query.setParameter("username", inUsername);
		return (Optional<UserBean>) query.uniqueResultOptional().orElse(null);
	}

}