package main.java.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.db.DBActions;
import main.java.db.DBUserActions;
import main.java.pojos.GroupPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;

public class ActionUtil {

	private static final Logger logger = LogManager.getLogger(ActionUtil.class);

	private ActionUtil() {
		// May be empty.
	}

	/**
	 * @param inFName
	 *            Vorname
	 * @param inLName
	 *            Nachname
	 * @param inUsername
	 *            Username
	 * @param inEmail
	 *            E-Mail
	 * @param inPassword
	 *            Password
	 * @return Gibt ein boolean zurück, ob die Regestrierung erfolgreich war
	 *         oder nicht
	 */
	public static boolean register(String inFName, String inLName, String inUsername, String inEmail, String inPassword) {
		if (!UserUtil.usernameOrEmailisPresent(inUsername, inEmail)) {
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
				logger.info("Succesfully Registered user: name - {} {}, username - {}, email - {}.", user.getFirstName(), user.getLastName(),
						user.getUsername(), user.getEmail());
				return true;
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				logger.error("Error when registering.");
				return false;
			}
		}
		logger.info("Error while registering.");
		return false;
	}

	/**
	 * @param inUsernameOrEmail
	 *            Username / Email
	 * @param inPassword
	 *            Password
	 * @return Benutzer, wenn er in der Datenbank vorhanden ist, ansonsten wird
	 *         ein leerer Benutzer zurückgegeben
	 */
	public static Optional<UserPojo> login(String inUsernameOrEmail, String inPassword) {
		Optional<UserPojo> user = DBUserActions.findUserByName(inUsernameOrEmail);
		if (!user.isPresent()) {
			user = DBUserActions.findUserByEmail(inUsernameOrEmail);
		}
		if (user.isPresent()) {
			try {
				if (PasswordUtil.validatePassword(inPassword, user.get().getPassword(), user.get().getSalt(), user.get().getIterations())) {
					logger.info("User {} was succesfully logged in.", user.get().getUsername());
					return user;
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				logger.error("Error while trying to login {}.", inUsernameOrEmail, e);
			}
		}
		logger.info("User {} was not Logged in.", inUsernameOrEmail);
		return Optional.empty();
	}

	/**
	 * Benutzer der angegeben Bezahlung werden in der DB gesucht und als Liste
	 * zurück gegeben.
	 * 
	 * @param inPaymentPojo
	 *            Bezahlung von der die Benutzer gesucht werden sollen
	 * @return Liste der Benutzer die einer Zahlung angehörig sind
	 */
	public static List<UserPojo> getUsersToPayment(PaymentPojo inPaymentPojo) {
		List<PaymentToUserPojo> userList = DBActions.getPaymentToUserPojosByPaymentId(inPaymentPojo.getPaymentID());
		List<UserPojo> userPojoList = new ArrayList<>();
		for (PaymentToUserPojo userToGroupPojo : userList) {
			userPojoList.add(DBUserActions.findUserByID(userToGroupPojo.getUser().getId()));
		}
		return userPojoList;
	}

	/**
	 * Benutzer der angegebenen Gruppe werden in der DB gesucht un dem Objekt
	 * hinzugefügt und dann das Ojekt zurückgegeben.
	 * 
	 * @param inGroupPojo
	 *            Gruppe von der die Benutzer gesucht werden sollen
	 * @return Gibt die gleiche Gruppe inkl. aller Benutzer (als String) zurück
	 */
	public static GroupPojo addUsersToGroupPojo(GroupPojo inGroupPojo) {
		List<UserToGroupPojo> userList = DBActions.findUserToGroupByGroupId(inGroupPojo.getGroupID());
		List<UserPojo> userPojoList = new ArrayList<>();
		for (UserToGroupPojo userToGroupPojo : userList) {
			userPojoList.add(DBUserActions.findUserByID(userToGroupPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		inGroupPojo.setUsers(builder.toString());
		return inGroupPojo;
	}

	/**
	 * @param inPaymentID
	 *            Die Zahlungs ID zu der Benutzer gesucht werden sollen
	 * @return Gibt alle Benutzer einer Zahlung als String zurück
	 */
	public static String getUsersToPayment(int inPaymentID) {
		List<PaymentToUserPojo> paymentToUsers = DBActions.getPaymentToUserPojosByPaymentId(inPaymentID);
		List<UserPojo> userPojoList = new ArrayList<>();
		for (PaymentToUserPojo paymentToUserPojo : paymentToUsers) {
			userPojoList.add(DBUserActions.findUserByID(paymentToUserPojo.getUser().getId()));
		}
		StringBuilder builder = new StringBuilder();
		for (UserPojo userPojo : userPojoList) {
			builder.append(userPojo.getUsername() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length() - 1);
		return builder.toString();
	}
}
