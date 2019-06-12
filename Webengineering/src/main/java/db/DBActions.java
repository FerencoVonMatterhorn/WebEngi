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
import main.java.pojos.PaymentPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;
import main.java.util.PasswordUtil;

public class DBActions {

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static GroupPojo indexLoggedInGroup(int userID) {

		Session session = sessionFactory.openSession();
		Query<?> query;

		List<UserToGroupPojo> userToGroupList = getUserToGroupByUserID(userID);

		if (userToGroupList.isEmpty()) {
			return new GroupPojo();
		}
		query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", userToGroupList.get(0).getGroup().getGroupID());

		GroupPojo groupPojo = (GroupPojo) query.uniqueResult();
		session.close();

		if (groupPojo == null) {
			return new GroupPojo();
		}

		return getUsersToGroup(groupPojo);

	}

	private static List<UserToGroupPojo> getUserToGroupByGroupID(int groupID) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", groupID);

		return (List<UserToGroupPojo>) query.getResultList();

	}

	private static List<UserToGroupPojo> getUserToGroupByUserID(int userID) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID");
		query.setParameter("userID", userID);

		return (List<UserToGroupPojo>) query.getResultList();

	}

	private static List<PaymentPojo> getPaymentsFromUserDesc(int userID) {
		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");

		query.setParameter("userID", userID);

		return (List<PaymentPojo>) query.getResultList();
	}

	public static PaymentPojo getPaymentForIndexLoggedIn(int userID) {
		Session session = sessionFactory.openSession();

		List<PaymentPojo> listPayments = getPaymentsFromUserDesc(userID);

		int counter = 1;
		for (PaymentPojo paymentPojo : listPayments) {
			System.out.println(counter + " : " + paymentPojo.getPaymentID());
			counter++;
		}

		PaymentPojo payment;
		if (listPayments.isEmpty()) {
			payment = new PaymentPojo();
		} else {
			payment = listPayments.get(0);
		}

		Query<?> query = session.createQuery(
				"select GroupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = :paymentID)");

		query.setParameter("paymentID", payment.getPaymentID());

		String groupName = (String) query.uniqueResult();

		payment.setGroupName(groupName);

		return payment;

	}

	public static GroupPojo getUsersToGroup(GroupPojo group) {

		Session session = sessionFactory.openSession();

		Query<?> query;

		List<UserToGroupPojo> userList = getUserToGroupByGroupID(group.getGroupID());

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

	public static boolean register(String inFName, String inLName, String inUsername, String inEmail,
			String inPassword) {
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
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(),
						user.get().getIterations())) {
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

	public static long getPaymentAmount(int userID) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"select count(*) FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID)");

		query.setParameter("userID", userID);

		return (long) query.uniqueResult();
	}

	public static List<PaymentPojo> getPaymentsForSpecificPage(int offset, int limit, int userID) {
		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID) ORDER BY DATECREATED DESC");

		query.setMaxResults(limit);
		query.setFirstResult(offset);

		query.setParameter("userID", userID);

		return (List<PaymentPojo>) query.getResultList();
	}
}