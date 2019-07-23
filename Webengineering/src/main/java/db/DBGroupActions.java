package main.java.db;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.GroupPojo;

public class DBGroupActions {

	private DBGroupActions() {
		// May be empty.
	}

	private static final Logger logger = LogManager.getLogger(DBGroupActions.class);
	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static final GroupPojo findGroupByID(final int inGroupID) {
		logger.info("Looking for Group with GroupID: {}", inGroupID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", inGroupID);
		GroupPojo group = (GroupPojo) query.uniqueResult();
		session.close();
		return group;
	}

	static String findGroupNameByPaymentID(int inPaymentID) {
		logger.info("Looking for Groupname for PaymentID: {}", inPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select groupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = :paymentID)");
		query.setParameter("paymentID", inPaymentID);
		String payment = (String) query.uniqueResult();
		session.close();
		return payment;
	}

	// TODO: duplicate of findAllGroupsByUserID?!
	public static List<GroupPojo> findGroupsForGroupOverview(int inUserID) {
		logger.info("Looking for all groups for User with UserID: {}", inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID in (select group from USERTOGROUP where USERID = :UserID)");
		query.setParameter("UserID", inUserID);
		List<GroupPojo> groups = (List<GroupPojo>) query.getResultList();
		session.close();
		return groups;
	}

	// TODO: duplicate of findGroupsForGroupOverview?!
	public static List<GroupPojo> findAllGroupsByUserID(int inUserID) {
		logger.info("Looking for all groups for User with UserID: {}", inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from GROUPS where GROUPID in (select group from USERTOGROUP where USERID = :UserID)");
		query.setParameter("UserID", inUserID);
		List<GroupPojo> groups = (List<GroupPojo>) query.getResultList();
		session.close();
		return groups;
	}

	public static void saveGroup(GroupPojo inGroup) {
		logger.info("Saving Group: {}", inGroup);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inGroup);
		session.getTransaction().commit();
		session.close();
	}

}
