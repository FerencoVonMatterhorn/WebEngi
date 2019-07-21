package main.java.db;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToGroupPojo;
import main.java.pojos.PaymentToUserPojo;
import main.java.pojos.UserPojo;
import main.java.util.InputDataValidationUtil;

public class DBPaymentActions {

	private DBPaymentActions() {
		// May be empty.
	}

	private static final SessionFactory sessionFactory = DBConfig.getSessionFactory();

	public static int getRecentMonthlyPaymentID(int groupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID ORDER BY ID DESC");
		query.setParameter("groupID", groupID);

		int monthlyID = ((MonthlyPaymentPojo) query.uniqueResult()).getMonthlyPaymentID();

		session.close();
		return monthlyID;
	}

	public static List<PaymentPojo> getPaymentsForMonthlyPaymentByUserID(int monthlyPaymentID, int userID) {

		System.out.println(userID);
		System.out.println(monthlyPaymentID);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from MONTHLYPAYMENTTOPAYMENT where MONTHLYPAYMENTID = :monthlyPaymentID ) AND PAYMENTID in (select payment from PAYMENTTOUSER where USERID = :userID)");
		query.setParameter("monthlyPaymentID", monthlyPaymentID);
		query.setParameter("userID", userID);

		List<PaymentPojo> payments = (List<PaymentPojo>) query.getResultList();

		session.close();
		return payments;
	}

	public static PaymentPojo findPaymentById(int paymentID) {

		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from PAYMENTS where PAYMENTID = :paymentID");
		query.setParameter("paymentID", paymentID);

		PaymentPojo payment = (PaymentPojo) query.uniqueResult();

		session.close();
		return payment;

	}

	private static List<PaymentPojo> findPaymentsDescendingByUserId(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");
		query.setParameter("userID", userID);

		List<PaymentPojo> paymentList = (List<PaymentPojo>) query.getResultList();

		if (paymentList.isEmpty()) {
			paymentList.add(new PaymentPojo());
		}
		session.close();
		return paymentList;
	}

	public static PaymentPojo findPaymentForIndexLoggedInByUserId(int userID) {
		Session session = sessionFactory.openSession();
		PaymentPojo payment = findPaymentsDescendingByUserId(userID).get(0);
		Query<?> query = session.createQuery(
				"select groupName FROM GROUPS WHERE GROUPID IN (SELECT group FROM PAYMENTTOGROUP WHERE PAYMENTID = 177)");
		String groupName = (String) query.uniqueResult();
		payment.setGroupName(groupName);
		session.close();
		return payment;
	}

	public static long getPaymentAmount(int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"select count(*) FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID)");
		query.setParameter("userID", userID);
		Long count = (Long) query.uniqueResult();
		session.close();
		return count;
	}

	public static List<PaymentPojo> getPaymentsForSpecificPage(int offset, int limit, int userID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"FROM PAYMENTS WHERE PAYMENTID IN (SELECT payment FROM PAYMENTTOUSER WHERE USERID = :userID) ORDER BY DATECREATED DESC");
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		query.setParameter("userID", userID);
		List<PaymentPojo> listPayments = (List<PaymentPojo>) query.getResultList();
		for (PaymentPojo paymentPojo : listPayments) {
			String paymentGroup = DBGroupActions.getGroupNameByPaymentId(paymentPojo.getPaymentID());
			paymentPojo.setGroupName(paymentGroup);
			paymentPojo.setUsers(DBActions.getUsersToPayment(paymentPojo.getPaymentID()));
		}
		session.close();
		return listPayments;
	}

	public static void createPayment(Map<String, String> modalValues) {
		PaymentPojo payment = new PaymentPojo();
		payment.setAmount(Double.valueOf(modalValues.get("paymentValue")));
		payment.setDateCreated(OffsetDateTime.now());
		payment.setGroupName(DBGroupActions.findGroupById(Integer.valueOf(modalValues.get("groupId"))).getGroupName());
		payment.setPaymentDescription(modalValues.get("paymentdescription"));
		savePayment(payment);

		// TODO: prozente beachten?
		Map<String, String> users = InputDataValidationUtil.getUserStrings(modalValues);
		for (String userString : users.keySet()) {
			Optional<UserPojo> user = DBUserActions.findUserByName(modalValues.get(userString));
			if (user.isPresent()) {
				PaymentToUserPojo paymentToUser = new PaymentToUserPojo();
				paymentToUser.setPayment(payment);
				paymentToUser.setUser(user.get());
				paymentToUser.setPercentage(Integer.parseInt(modalValues.get(userString + "P")));
				savePaymentToUser(paymentToUser);
			}
		}
		PaymentToGroupPojo paymentToGroup = new PaymentToGroupPojo();
		paymentToGroup.setGroup(DBGroupActions.findGroupById(Integer.valueOf(modalValues.get("groupId"))));
		paymentToGroup.setPayment(payment);
		savePaymentToGroup(paymentToGroup);
	}

	private static void savePaymentToGroup(PaymentToGroupPojo inPaymentToGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPaymentToGroup);
		session.getTransaction().commit();
		session.close();
	}

	private static void savePaymentToUser(PaymentToUserPojo inPaymentToUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPaymentToUser);
		session.getTransaction().commit();
		session.close();
	}

	private static void savePayment(PaymentPojo inPayment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inPayment);
		session.getTransaction().commit();
		session.close();
	}
}
