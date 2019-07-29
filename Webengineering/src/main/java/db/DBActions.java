package main.java.db;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserToGroupPojo;

public class DBActions {

	private static final Logger logger = LogManager.getLogger(DBActions.class);
	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	private DBActions() {
		// May be empty.
	}

	/**
	 * @param UserID
	 *            des Benutzers zu der die Beziehungen gefunden werden sollen
	 * @return Eine Liste der Beziehung zwischen einem Nutzer zu seinen Gruppen
	 */
	public static List<UserToGroupPojo> findUserToGroupByUserId(int inUserID) {
		logger.info("Looking for UserToGroup with UserID {}", inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID ORDER BY ID DESC");
		query.setParameter("userID", inUserID);
		List<UserToGroupPojo> pojos = (List<UserToGroupPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	/**
	 * @param inGroupID
	 *            Die ID der Gruppe zu der die Beziehungen gefunden werden
	 *            sollen
	 * @return Eine Liste der Beziehungen zwischen einer Gruppe und einem Nutzer
	 */
	public static List<UserToGroupPojo> findUserToGroupByGroupId(int inGroupID) {
		logger.info("Looking for UserToGroup with GroupID {}", inGroupID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", inGroupID);
		List<UserToGroupPojo> pojos = (List<UserToGroupPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	/**
	 * @param inPaymentID
	 *            Die ID der Zahlung zu dem die Beziehungen gefunden werden
	 *            sollen
	 * @return Eine Liste der Beziehungen zwischen einer Zahlung und seiner
	 *         Benutzer
	 */
	public static List<PaymentToUserPojo> getPaymentToUserPojosByPaymentId(int inPaymentID) {
		logger.info("Looking for PaymentToUser with PaymentID {}", inPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTTOUSER where PAYMENTID = :paymentID");
		query.setParameter("paymentID", inPaymentID);
		List<PaymentToUserPojo> pojos = (List<PaymentToUserPojo>) query.getResultList();
		session.close();
		return pojos;
	}

	/**
	 * 
	 * @param inPaymentID
	 *            Die Zahlungs ID zu der die Beziehung gesucht werden soll
	 * @param inUserID
	 *            die ID des Benutzers zu der die Beziehungen gefunden werden
	 *            sollen
	 * @return Gibt einer PaymentToUserPojo zurück, welches die Beziehung
	 *         zwischen einem User und einer Zahlung darstellt
	 */
	public static PaymentToUserPojo findPaymentToUserPojosByPaymentIdAndUserID(int inPaymentID, int inUserID) {
		logger.info("Looking for PaymentToUser with UserID {} and PaymentID {}", inUserID, inPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTTOUSER where PAYMENTID = :paymentID AND USERID = :userID");
		query.setParameter("paymentID", inPaymentID);
		query.setParameter("userID", inUserID);
		PaymentToUserPojo pojo = (PaymentToUserPojo) query.uniqueResult();
		session.close();
		return pojo;
	}

	/**
	 * @param inUserToGroup
	 *            Der User welche in eine Gruppe hinzugefügt werden soll
	 */
	public static void saveUserToGroup(UserToGroupPojo inUserToGroup) {
		logger.info("Saving UserToGroup: {}", inUserToGroup);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inUserToGroup);
		session.getTransaction().commit();
		session.close();
	}

}
