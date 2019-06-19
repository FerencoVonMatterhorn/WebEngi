package main.java.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.PaymentPojo;

public class DBPaymentActions {

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	private static List<PaymentPojo> findPaymentsDescendingByUserId(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session
				.createQuery("from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");
		query.setParameter("userID", userID);

		List<PaymentPojo> paymentList = (List<PaymentPojo>) query.getResultList();

		if (paymentList.isEmpty()) {
			paymentList.add(new PaymentPojo());
		}

		return paymentList;
	}

	public static PaymentPojo findPaymentForIndexLoggedInByUserId(int userID) {
		Session session = sessionFactory.openSession();
		PaymentPojo payment = findPaymentsDescendingByUserId(userID).get(0);
		Query<?> query = session.createQuery("select GroupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = 177)");
		String groupName = (String) query.uniqueResult();
		payment.setGroupName(groupName);
		return payment;
	}

	public static long getPaymentAmount(int userID) {

		Session session = sessionFactory.openSession();

		Query<?> query = session.createQuery("select count(*) FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID)");

		query.setParameter("userID", userID);

		return (Long) query.uniqueResult();
	}

	public static List<PaymentPojo> getPaymentsForSpecificPage(int offset, int limit, int userID) {
		Session session = sessionFactory.openSession();

		Query<?> query = session
				.createQuery("FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID) ORDER BY DATECREATED DESC");

		query.setMaxResults(limit);
		query.setFirstResult(offset);

		query.setParameter("userID", userID);

		List<PaymentPojo> listPayments = (List<PaymentPojo>) query.getResultList();

		for (PaymentPojo paymentPojo : listPayments) {
			String paymentGroup = DBGroupActions.getGroupNameByPaymentId(paymentPojo.getPaymentID());
			paymentPojo.setGroupName(paymentGroup);
			paymentPojo.setUsers(DBActions.getUsersToPayment(paymentPojo.getPaymentID()));
		}

		return listPayments;
	}

}
