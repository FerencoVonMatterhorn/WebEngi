package main.java.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.db.DBActions;
import main.java.db.DBGroupActions;
import main.java.db.DBUserActions;
import main.java.pojos.GroupPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;

public class GroupUtil {

	private static final Logger logger = LogManager.getLogger(GroupUtil.class);

	private GroupUtil() {
		// May be empty.
	}

	// TODO Ignoriern von selbst hinzufügen (string) in groupparticipans (kann
	// jemand hier einmal hin gucken, komme irgendwie nicht darauf wieso das
	// nicht so klappt?)
	public static void createGroup(String inGroupName, String inGroupDescription, String inGroupParticipants, int inCreatorID) {
		GroupPojo group = new GroupPojo();
		group.setGroupName(inGroupName);
		group.setGroupDescription(inGroupDescription);
		DBGroupActions.saveGroup(group);

		List<UserPojo> users = UserUtil.findUsersByName(inGroupParticipants);
		UserPojo creator = DBUserActions.findUserByID(inCreatorID);
		if (!users.contains(creator)) {
			users.add(creator);
		}

		logger.info("Creating group {} with participants {}", inGroupName, inGroupParticipants);
		for (UserPojo user : users) {
			UserToGroupPojo userToGroup = new UserToGroupPojo();
			userToGroup.setUser(user);
			userToGroup.setGroup(group);
			DBActions.saveUserToGroup(userToGroup);
		}
	}

	// TODO überprüfen ob das hier richtig ist
	// TODO: logging?
	public static GroupPojo findGroupForIndexLoggedInByUserID(int inUserId) {
		List<UserToGroupPojo> userToGroupList = DBActions.findUserToGroupByUserId(inUserId);

		if (userToGroupList.isEmpty()) {
			return new GroupPojo();
		}
		GroupPojo groupPojo = DBGroupActions.findGroupByID(userToGroupList.get(0).getGroup().getGroupID());
		if (groupPojo == null) {
			return new GroupPojo();
		}
		return ActionUtil.addUsersToGroupPojo(groupPojo);
	}

}
