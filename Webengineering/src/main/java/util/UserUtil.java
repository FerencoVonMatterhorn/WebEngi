package main.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.db.DBUserActions;
import main.java.pojos.UserPojo;

public class UserUtil {

	private UserUtil() {
		// May be empty.
	}

	/**
	 * @param inUsersStr
	 *            eine Liste an Benutzernamen, mit "," getrennt
	 * @return List<UserPojo>
	 */
	public static List<UserPojo> findUsersByName(String inUsersStr) {
		List<String> formattedUserStrings = userStringsToList(inUsersStr);
		List<UserPojo> users = new ArrayList<>();
		for (String user : formattedUserStrings) {
			Optional<UserPojo> foundUser = DBUserActions.findUserByName(user);
			if (foundUser.isPresent()) {
				users.add(foundUser.get());
			}
		}
		return users;
	}

	/**
	 * @param inUsersStr
	 * @return eine Liste der Benutzernamen als String
	 */
	public static List<String> userStringsToList(String inUsersStr) {
		List<String> users = new ArrayList<>();
		String[] userStrArr = inUsersStr.split(",");
		for (int i = 0; i < userStrArr.length; i++) {
			userStrArr[i] = userStrArr[i].trim();
			users.add(userStrArr[i]);
		}
		return users;
	}

	/**
	 * @param inUsername
	 * @param inEmail
	 * @return boolean ob der Benutzername oder die Email schon vergeben ist
	 */
	public static boolean usernameOrEmailisPresent(String inUsername, String inEmail) {
		return (DBUserActions.findUserByName(inUsername).isPresent() || DBUserActions.findUserByEmail(inEmail).isPresent());
	}

	/**
	 * Updatet die Informationen des Benutzers in der DB
	 * 
	 * @param inModalValues
	 */
	public static void updateProfile(Map<String, String> inModalValues) {
		UserPojo user = DBUserActions.findUserByID(Integer.valueOf(inModalValues.get("userID")));

		for (String input : inModalValues.keySet()) {
			if (!inModalValues.get(input).isEmpty()) {
				switch (input) {
				case "firstName":
					user.setFirstName(inModalValues.get(input));
					break;
				case "lastName":
					user.setLastName(inModalValues.get(input));
					break;
				case "userName":
					user.setUsername(inModalValues.get(input));
					break;
				case "eMail":
					user.setEmail(inModalValues.get(input));
					break;
				default:
					break;
				}
			}
		}
		DBUserActions.updateUser(user);
	}

}
