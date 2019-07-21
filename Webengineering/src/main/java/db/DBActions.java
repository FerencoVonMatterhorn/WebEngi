package main.java.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private DBActions() {
		// May be empty.
	}

	private static final Logger log = LogManager.getLogger(DBActions.class);

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static GroupPojo getUsersToGroup(GroupPojo group) {
		List<UserToGroupPojo> userList = DBActions.findUserToGroupByGroupId(group.getGroupID());
		List<UserPojo> userPojoList = new ArrayList<>();
		for (UserToGroupPojo userToGroupPojo : userList) {
			userPojoList.add(DBUserActions.findUserById(userToGroupPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		group.setUsers(builder.toString());
		return group;
	}

	public static List<UserPojo> getUsersToPayment(PaymentPojo payment) {
		List<PaymentToUserPojo> userList = DBActions.getPaymentToUserPojosByPaymentId(payment.getPaymentID());
		List<UserPojo> userPojoList = new ArrayList<>();
		for (PaymentToUserPojo userToGroupPojo : userList) {
			userPojoList.add(DBUserActions.findUserById(userToGroupPojo.getUser().getId()));
		}
		return userPojoList;
	}

	public static boolean register(String inFName, String inLName, String inUsername, String inEmail, String inPassword) {
		if (!DBUserActions.usernameOrEmailisPresent(inUsername, inEmail)) {
			String[] iterationsSaltPassword = null;
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
				DBUserActions.saveUser(user);
				log.info("Succesfully Registered user: name - {} {}, username - {}, email - {}.", user.getFirstName(), user.getLastName(), user.getUsername(),
						user.getEmail());
				return true;
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				log.error("Error when registering.");
				return false;
			}
		}
		log.info("Error while registering.");
		return false;
	}

	public static Optional<UserPojo> login(String inUsernameOrEmail, String inPassword) {
		Optional<UserPojo> user = DBUserActions.findUserByName(inUsernameOrEmail);
		if (!user.isPresent()) {
			user = DBUserActions.findUserByEmail(inUsernameOrEmail);
		}
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(), user.get().getIterations())) {
					log.info("User {} was succesfully logged in.", user.get().getUsername());
					return user;
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				log.error("Error while trying to login {}.", inUsernameOrEmail, e);
			}
		}
		log.info("User {} was not Logged in.", inUsernameOrEmail);
		return Optional.empty();
	}

	/*******************
	 * Helper methods. *
	 *******************/

	static void saveUserToGroup(UserToGroupPojo inUserToGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUserToGroup);
		session.getTransaction().commit();
		session.close();
	}

	static List<UserToGroupPojo> findUserToGroupByUserId(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID");
		query.setParameter("userID", userID);
		List<UserToGroupPojo> pojos = (List<UserToGroupPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	static List<UserToGroupPojo> findUserToGroupByGroupId(int groupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", groupID);
		List<UserToGroupPojo> pojos = (List<UserToGroupPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	public static List<PaymentToUserPojo> getPaymentToUserPojosByPaymentId(int paymentId) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTTOUSER where PAYMENTID = :paymentID");
		query.setParameter("paymentID", paymentId);
		List<PaymentToUserPojo> pojos = (List<PaymentToUserPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	static String getUsersToPayment(int paymentId) {
		List<PaymentToUserPojo> paymentToUsers = getPaymentToUserPojosByPaymentId(paymentId);
		List<UserPojo> userPojoList = new ArrayList<>();
		for (PaymentToUserPojo paymentToUserPojo : paymentToUsers) {
			userPojoList.add(DBUserActions.findUserById(paymentToUserPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		return builder.toString();
	}

	public static PaymentToUserPojo getPaymentToUserPojosByPaymentIdAndUserID(int paymentID, int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTTOUSER where PAYMENTID = :paymentID AND USERID = :userID");
		query.setParameter("paymentID", paymentID);
		query.setParameter("userID", userID);

		PaymentToUserPojo pojo = (PaymentToUserPojo) query.uniqueResult();

		session.close();
		return pojo;
	}

}
