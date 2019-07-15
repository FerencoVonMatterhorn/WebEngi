package main.java.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.GroupPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;

public class DBGroupActions {

	private static final Logger logger = LogManager.getLogger(DBGroupActions.class);

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static void createGroup(String inGroupName, String inGroupDescription, String inGroupParticipants, int inCreatorId) {
		GroupPojo group = new GroupPojo();
		group.setGroupName(inGroupName);
		group.setGroupDescription(inGroupDescription);
		saveGroup(group);

		List<UserPojo> users = DBUserActions.findUsersByName(inGroupParticipants);
		UserPojo creator = DBUserActions.findUserById(inCreatorId);
		if (!users.contains(creator)) {
			users.add(creator);
		}

		logger.info("Creating group {} with participants {}", inGroupName, inGroupParticipants);
		if (users.size() >= 2) {
			for (UserPojo user : users) {
				UserToGroupPojo userToGroup = new UserToGroupPojo();
				userToGroup.setUser(user);
				userToGroup.setGroup(group);
				DBActions.saveUserToGroup(userToGroup);
			}
		}
	}

	public static GroupPojo findGroupForIndexLoggedInByUserId(int userID) {
		List<UserToGroupPojo> userToGroupList = DBActions.findUserToGroupByUserId(userID);

		if (userToGroupList.isEmpty()) {
			return new GroupPojo();
		}
		GroupPojo groupPojo = findGroupById(userToGroupList.get(0).getGroup().getGroupID());
		if (groupPojo == null) {
			return new GroupPojo();
		}
		return DBActions.getUsersToGroup(groupPojo);
	}

	public static List<GroupPojo> getGroupsfromUser(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID in (select group from USERTOGROUP where USERID = :UserID)");
		query.setParameter("UserID", userID);
		System.out.println(userID);
		List<GroupPojo> userToGroupList = (List<GroupPojo>) query.getResultList();
		session.close();
		return userToGroupList;
	}

	static final GroupPojo findGroupById(final int groupId) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", groupId);
		GroupPojo group = (GroupPojo) query.getSingleResult();
		session.close();
		return group;
	}

	private static void saveGroup(GroupPojo inGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inGroup);
		session.getTransaction().commit();
		session.close();
	}

	static String getGroupNameByPaymentId(int paymentID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select groupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = :paymentID)");
		query.setParameter("paymentID", paymentID);
		String payment = (String) query.uniqueResult();
		session.close();
		return payment;
	}

	public static List<GroupPojo> getGroupsForGroupOverview(int userID) {
		List<GroupPojo> groups = getGroupsfromUser(userID);
		System.out.println(groups.size());
		return groups;
	}

}
