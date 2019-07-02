package main.java.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.GroupPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;

public class DBGroupActions {

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static void createGroup(String inGroupName, String inGroupDescription, String inGroupParticipants, int inCreatorId) {
		GroupPojo group = new GroupPojo();
		group.setGroupName(inGroupName);
		group.setGroupDescription(inGroupDescription);
		saveGroup(group);

		List<UserPojo> users = DBUserActions.findUsersByName(inGroupParticipants);
		users.add(DBUserActions.findUserById(inCreatorId));

		// logger.info("Creating group {} with participants {}", inGroupName,
		// inGroupParticipants);
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
	
	public static List<UserToGroupPojo> getGroupsfromUser(int userID){
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("SELECT GroupID from UserToGroups WHERE USERID = :UserID");
		query.setParameter("userID", userID);
		List<UserToGroupPojo> userToGroupList = (List<UserToGroupPojo>) query.getResultList();
		session.close();
		return userToGroupList;
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
		return (String) query.uniqueResult();
	}

	public static List<GroupPojo> getGroupsForGroupOverview(int userID) {
		List<GroupPojo> groups = new ArrayList<>();
		List<UserToGroupPojo> userToGroupList = getGroupsfromUser(userID);
		for (UserToGroupPojo userToGroupPojo : userToGroupList) {
			groups.add(findGroupById(userToGroupPojo.getGroup().getGroupID()));
		}
		return groups;
	}

}
