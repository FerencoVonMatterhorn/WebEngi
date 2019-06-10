package main.java.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.GroupPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;
import main.java.util.PasswordUtil;

public class DBActions {

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static GroupPojo indexLoggedInGroup(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID");
		query.setParameter("userID", userID);
		UserToGroupPojo userToGroupPojo = (UserToGroupPojo) query.uniqueResult();
		if (userToGroupPojo == null) {
			return new GroupPojo();
		}
		query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", userToGroupPojo.getGroup().getGroupID());

		GroupPojo groupPojo = (GroupPojo) query.uniqueResult();
		session.close();

		if (groupPojo == null) {
			return new GroupPojo();
		}

		return getUsersToGroup(groupPojo);

	}

	public static GroupPojo getUsersToGroup(GroupPojo group) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", group.getGroupID());

		List<UserToGroupPojo> userList = (List<UserToGroupPojo>) query.getResultList();

		List<UserPojo> userPojoList = new ArrayList<>();

		for (UserToGroupPojo userToGroupPojo : userList) {
			query = session.createQuery("from USERS where USERID = :userID");
			query.setParameter("userID", userToGroupPojo.getUser().getId());

			userPojoList.add((UserPojo) query.uniqueResult());
		}

		StringBuilder builder = new StringBuilder();

		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		group.setUsers(builder.toString());

		session.close();

		return group;
	}

	public static boolean register(String inFName, String inLName, String inUsername, String inEmail, String inPassword) {
		if (!usernameOrEmailisPresent(inUsername, inEmail)) {
			String iterationsSaltPassword[] = null;
			try {
				iterationsSaltPassword = PasswordUtil.generateHashedPassword(inPassword).split(":");
				UserPojo user = new UserPojo();
				user.setUsername(inUsername);
				user.setFirstName(inFName);
				user.setLastName(inLName);
				user.setUsername(inUsername);
				user.setEmail(inEmail);
				user.setIterations(Integer.valueOf(iterationsSaltPassword[0]));
				user.setSalt(iterationsSaltPassword[1]);
				user.setPassword(iterationsSaltPassword[2]);
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

	public static Optional<UserPojo> login(String inUsernameOrEmail, String inPassword) {
		Optional<UserPojo> user = findUserByName(inUsernameOrEmail);
		if (!user.isPresent()) {
			user = findUserByEmail(inUsernameOrEmail);
		}
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(), user.get().getIterations())) {
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

	public static UserPojo findUserByID(int inId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from USERS where USERID = :id");
		query.setParameter("id", inId);
		UserPojo user = (UserPojo) query.uniqueResult();
		session.close();
		return user;
	}

	private static Optional<UserPojo> findUserByName(String inUsername) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from USERS where USERNAME = :username");
		query.setParameter("username", inUsername);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	private static Optional<UserPojo> findUserByEmail(String inEmail) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from USERS where EMAIL = :email");
		query.setParameter("email", inEmail);
		Optional<UserPojo> user = (Optional<UserPojo>) query.uniqueResultOptional();
		session.close();
		return user;
	}

	private static boolean usernameOrEmailisPresent(String inUsername, String inEmail) {
		return (findUserByName(inUsername).isPresent() || findUserByEmail(inEmail).isPresent()) ? true : false;
	}
}