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
import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;
import main.java.util.PasswordUtil;

public class DBActions {

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static void createGroup(String inGroupName, String inGroupDescription, String inGroupParticipants,
			int inCreatorId) {
		GroupPojo group = new GroupPojo();
		group.setGroupName(inGroupName);
		group.setGroupDescription(inGroupDescription);
		saveGroup(group);

		List<UserPojo> users = findUsersByName(inGroupParticipants);
		users.add(findUserById(inCreatorId));

		if (users.size() >= 2) {
			for (UserPojo user : users) {
				UserToGroupPojo userToGroup = new UserToGroupPojo();
				userToGroup.setUser(user);
				userToGroup.setGroup(group);
				saveUserToGroup(userToGroup);
			}
		}
	}

	public static GroupPojo indexLoggedInGroup(int userID) {
		List<UserToGroupPojo> userToGroupList = findUserToGroupByUserId(userID);
		if (userToGroupList.isEmpty()) {
			return new GroupPojo();
		}
		GroupPojo groupPojo = findGroupById(userToGroupList.get(0).getGroup().getGroupID());
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

		String groupName = getGroupNameByPaymentId(payment.getPaymentID());

		payment.setGroupName(groupName);

		return payment;
	}

	private static String getGroupNameByPaymentId(int paymentID) {
		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"select GroupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = :paymentID)");

		query.setParameter("paymentID", paymentID);

		return (String) query.uniqueResult();
	}

	public static GroupPojo getUsersToGroup(GroupPojo group) {
		List<UserToGroupPojo> userList = findUserToGroupByGroupId(group.getGroupID());
		List<UserPojo> userPojoList = new ArrayList<>();
		for (UserToGroupPojo userToGroupPojo : userList) {
			userPojoList.add(findUserById(userToGroupPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		group.setUsers(builder.toString());
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
				saveUser(user);

				return true;
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				e.printStackTrace();
				// TODO: Log this
				return false;
			}
		}
		return false;
	}

	private static List<PaymentToUserPojo> getPaymentToUserPojosByPaymentId(int paymentId) {

		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTTOUSER where PAYMENTID = :paymentID");
		query.setParameter("paymentID", paymentId);
		return (List<PaymentToUserPojo>) query.getResultList();

	}

	private static String getUsersToPayment(int paymentId) {
		List<PaymentToUserPojo> paymentToUsers = getPaymentToUserPojosByPaymentId(paymentId);
		List<UserPojo> userPojoList = new ArrayList<>();
		for (PaymentToUserPojo paymentToUserPojo : paymentToUsers) {
			userPojoList.add(findUserById(paymentToUserPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		return builder.toString();
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

	private static void saveUserToGroup(UserToGroupPojo inUserToGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUserToGroup);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveUser(UserPojo inUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUser);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveGroup(GroupPojo inGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inGroup);
		session.getTransaction().commit();
		session.close();
	}

	public static UserPojo findUserById(int inId) {
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

	private static List<UserToGroupPojo> findUserToGroupByUserId(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID");
		query.setParameter("userID", userID);
		return (List<UserToGroupPojo>) query.getResultList();
	}

	private static List<UserToGroupPojo> findUserToGroupByGroupId(int groupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", groupID);
		return (List<UserToGroupPojo>) query.getResultList();
	}

	private static Optional<GroupPojo> findGroupByName(String inGroupName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from GROUPS where GROUPNAME = :name");
		query.setParameter("name", inGroupName);
		Optional<GroupPojo> group = (Optional<GroupPojo>) query.uniqueResultOptional();
		session.close();
		return group;
	}

	private static final GroupPojo findGroupById(final int groupId) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", groupId);
		GroupPojo group = (GroupPojo) query.getSingleResult();
		session.close();
		return group;
	}

	private static List<PaymentPojo> findPaymentsDescendingByUserId(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");
		query.setParameter("userID", 114);
		return (List<PaymentPojo>) query.getResultList();
	}

	public static PaymentPojo findPaymentForIndexLoggedInByUserId(int userID) {
		Session session = sessionFactory.openSession();
		PaymentPojo payment = findPaymentsDescendingByUserId(userID).get(0);
		Query<?> query = session.createQuery(
				"select GroupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = 177)");
		String groupName = (String) query.uniqueResult();
		payment.setGroupName(groupName);
		return payment;
	}

	private static List<UserPojo> findUsersByName(String inUsersStr) {
		List<String> formattedUserStrings = UserStringsToList(inUsersStr);
		List<UserPojo> users = new ArrayList<>();
		for (String user : formattedUserStrings) {
			Optional<UserPojo> foundUser = findUserByName(user);
			if (foundUser.isPresent()) {
				users.add(foundUser.get());
			}
		}
		return users;
	}

	public static List<String> UserStringsToList(String inUsersStr) {
		List<String> users = new ArrayList<>();
		String[] userStrArr = inUsersStr.split(",");
		for (int i = 0; i < userStrArr.length; i++) {
			userStrArr[i] = userStrArr[i].trim();
			users.add(userStrArr[i]);
		}
		return users;
	}

	private static boolean usernameOrEmailisPresent(String inUsername, String inEmail) {
		return (findUserByName(inUsername).isPresent() || findUserByEmail(inEmail).isPresent()) ? true : false;
	}

	public static long getPaymentAmount(int userID) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"select count(*) FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID)");

		query.setParameter("userID", userID);

		return (Long) query.uniqueResult();
	}

	public static List<PaymentPojo> getPaymentsForSpecificPage(int offset, int limit, int userID) {
		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery(
				"FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID) ORDER BY DATECREATED DESC");

		query.setMaxResults(limit);
		query.setFirstResult(offset);

		query.setParameter("userID", userID);

		List<PaymentPojo> listPayments = (List<PaymentPojo>) query.getResultList();

		for (PaymentPojo paymentPojo : listPayments) {
			String paymentGroup = getGroupNameByPaymentId(paymentPojo.getPaymentID());
			paymentPojo.setGroupName(paymentGroup);
			paymentPojo.setUsers(getUsersToPayment(paymentPojo.getPaymentID()));
		}

		return listPayments;
	}
}