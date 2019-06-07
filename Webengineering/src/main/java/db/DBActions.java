package main.java.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.UserPojo;
import main.java.util.PasswordUtil;

public class DBActions {
	static SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static boolean register(String inFName, String inLName, String inUsername, String inEmail,
			String inPassword) {
		if (!usernameOrEmailisPresent(inUsername, inEmail)) {
			String iterationsSaltPassword[] = null;
			try {
				iterationsSaltPassword = PasswordUtil.generateHashedPassword(inPassword).split(":");

				UserPojo user = UserPojo.builder() //
						.firstName(inFName) //
						.lastName(inLName) //
						.username(inUsername) //
						.email(inEmail) //
						.iterations(Integer.valueOf(iterationsSaltPassword[0])) //
						.salt(iterationsSaltPassword[1]) //
						.password(iterationsSaltPassword[2]) //
						.build();
				registerUser(user);

				return true;
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
				// TODO: Log this
				return false;
			}
		}
		return false;
	}

	public static Optional<UserPojo> login(String inUsername, String inPassword) {
		Optional<UserPojo> user = findUser(inUsername);
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(),
						user.get().getIterations())) {
					user.get().setLoggedIn(true);
					return user;
				} else {
					return Optional.empty();
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
				// TODO: Log this
			}
		}
		return Optional.empty();
	}

	/*******************
	 * Helper methods. *
	 *******************/

	private static void registerUser(UserPojo inUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUser);
		session.getTransaction().commit();
		session.close();
	}

	private static Optional<UserPojo> findUser(String inUsername) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from USER where USERNAME = :username");
		query.setParameter("username", inUsername);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	private static Optional<UserPojo> findEmail(String inEmail) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from USER where EMAIL = :email");
		query.setParameter("email", inEmail);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	private static boolean usernameOrEmailisPresent(String inUsername, String inEmail) {
		return (findUser(inUsername).isPresent() || findEmail(inEmail).isPresent()) ? true : false;
	}
}