package main.java.db;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.MonthlyPaymentToGroupPojo;
import main.java.pojos.MonthlyPaymentToPaymentPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToGroupPojo;
import main.java.pojos.PaymentToUserPojo;

public class DBPaymentActions {

	private static final Logger logger = LogManager.getLogger(DBPaymentActions.class);
	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	private DBPaymentActions() {
		// May be empty.
	}

	public static MonthlyPaymentPojo findMonthlyPaymentByID(int inMonthlyPaymentID) {
		logger.info("Looking for MonthlyPayment with MonthlyPAymentID: {}", inMonthlyPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from MONTHLYPAYMENTS where MONTHLYPAYMENTID = :monthlyPaymentID");
		query.setParameter("monthlyPaymentID", inMonthlyPaymentID);
		MonthlyPaymentPojo pojo = (MonthlyPaymentPojo) query.uniqueResult();
		session.close();
		return pojo;
	}

	public static List<MonthlyPaymentPojo> findAllMonthlyPaymentsToGroup(int inGroupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from MONTHLYPAYMENTS where MONTHLYPAYMENTID in (select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID) ORDER BY MONTHLYPAYMENTID DESC");
		query.setParameter("groupID", inGroupID);
		List<MonthlyPaymentPojo> pojosList = (List<MonthlyPaymentPojo>) query.getResultList();
		session.close();
		return pojosList;
	}

	public static int findRecentMonthlyPaymentID(int inGroupID) {
		logger.info("Looking for recent MonthlyPayment with GroupID: {}", inGroupID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID ORDER BY ID DESC");
		query.setParameter("groupID", inGroupID);
		int monthlyID = ((MonthlyPaymentPojo) query.uniqueResult()).getMonthlyPaymentID();
		session.close();
		return monthlyID;
	}

	public static List<PaymentPojo> findPaymentsForMonthlyPaymentByUserID(int inMonthlyPaymentID, int inUserID) {
		logger.info("Looking for Payments with MonthlyPaymentID: {} and UserID: {}", inMonthlyPaymentID, inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from MONTHLYPAYMENTTOPAYMENT where MONTHLYPAYMENTID = :monthlyPaymentID ) AND PAYMENTID in (select payment from PAYMENTTOUSER where USERID = :userID)");
		query.setParameter("monthlyPaymentID", inMonthlyPaymentID);
		query.setParameter("userID", inUserID);
		List<PaymentPojo> payments = (List<PaymentPojo>) query.getResultList();
		session.close();
		return payments;
	}

	public static PaymentPojo findPaymentByID(int inPaymentID) {
		logger.info("Looking for Payment with PaymentID: {}", inPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTS where PAYMENTID = :paymentID");
		query.setParameter("paymentID", inPaymentID);
		PaymentPojo payment = (PaymentPojo) query.uniqueResult();
		session.close();
		return payment;
	}

	// TODO: HARDCODED FIX THIS!!!!
	public static PaymentPojo findPaymentForIndexLoggedInByUserID(int inUserID) {
		Session session = sessionFactory.openSession();
		PaymentPojo payment = findPaymentsDescendingByUserID(inUserID).get(0);
		Query<?> query = session.createQuery("select groupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = 177)");
		String groupName = (String) query.uniqueResult();
		payment.setGroupName(groupName);
		session.close();
		return payment;
	}

	public static long getAmountOfPayments(int inUserID) {
		logger.info("Looking for amount of Payment for User with UserID: {}", inUserID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select count(*) FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID)");
		query.setParameter("userID", inUserID);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count;
	}

	// TODO: DUPLICATE OF findPaymentsForSpecificPage?!?
	private static List<PaymentPojo> findPaymentsDescendingByUserID(int inUserID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session
				.createQuery("from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");
		query.setParameter("userID", inUserID);
		List<PaymentPojo> paymentList = (List<PaymentPojo>) query.getResultList();
		if (paymentList.isEmpty()) {
			paymentList.add(new PaymentPojo());
		}
		session.close();
		return paymentList;
	}

	// TODO: DUPLICATE OF findPaymentsDescendingByUserID?!
	public static List<PaymentPojo> findPaymentsForSpecificPage(int inOffset, int inLimit, int uinUserID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session
				.createQuery("FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID) ORDER BY DATECREATED DESC");
		query.setMaxResults(inLimit);
		query.setFirstResult(inOffset);
		query.setParameter("userID", uinUserID);
		List<PaymentPojo> listPayments = (List<PaymentPojo>) query.getResultList();
		for (PaymentPojo paymentPojo : listPayments) {
			String paymentGroup = DBGroupActions.findGroupNameByPaymentID(paymentPojo.getPaymentID());
			paymentPojo.setGroupName(paymentGroup);
			paymentPojo.setUsers(DBActions.getUsersToPayment(paymentPojo.getPaymentID()));
		}
		session.close();
		return listPayments;
	}

	public static int findRecentMonthlyPaymentbyGroupID(int inGroupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID ORDER BY ID DESC");
		query.setParameter("groupID", inGroupID);
		try {
			int monthlyID = ((MonthlyPaymentPojo) query.getResultList().get(0)).getMonthlyPaymentID();
			session.close();
			return monthlyID;
		} catch (IndexOutOfBoundsException e) {
			session.close();
			return -1;
		}
	}

	public static void saveMonthlyPaymentToGroup(MonthlyPaymentToGroupPojo inMonthlyPaymentToGroup) {
		logger.info("Saving MonthlyPaymentToGroup: {}", inMonthlyPaymentToGroup);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentToGroup);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveMonthlyPayment(MonthlyPaymentPojo inMonthlyPaymentPojo) {
		logger.info("Saving MonthlyPayment: {}", inMonthlyPaymentPojo);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentPojo);
		session.getTransaction().commit();
		session.close();
	}

	public static void saveMonthlyPaymentToPayment(MonthlyPaymentToPaymentPojo inMonthlyPaymentToPayment) {
		logger.info("Saving MonthlyPaymentToPayment: {}", inMonthlyPaymentToPayment);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentToPayment);
		session.getTransaction().commit();
		session.close();
	}

	public static void savePaymentToGroup(PaymentToGroupPojo inPaymentToGroup) {
		logger.info("Saving PaymentToGroup: {}", inPaymentToGroup);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPaymentToGroup);
		session.getTransaction().commit();
		session.close();
	}

	public static void savePaymentToUser(PaymentToUserPojo inPaymentToUser) {
		logger.info("Saving PaymentToUser: {}", inPaymentToUser);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPaymentToUser);
		session.getTransaction().commit();
		session.close();
	}

	public static void savePayment(PaymentPojo inPayment) {
		logger.info("Saving Payment: {}", inPayment);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPayment);
		session.getTransaction().commit();
		session.close();
	}
}
