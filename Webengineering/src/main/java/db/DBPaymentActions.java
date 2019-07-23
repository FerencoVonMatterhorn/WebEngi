package main.java.db;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.pojos.GroupPojo;
import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.MonthlyPaymentToGroupPojo;
import main.java.pojos.MonthlyPaymentToPaymentPojo;
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

	public static MonthlyPaymentPojo findMonthlyPaymentByID(int monthlyPaymentID) {

		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from MONTHLYPAYMENTS where MONTHLYPAYMENTID = :monthlyPaymentID");
		query.setParameter("monthlyPaymentID", monthlyPaymentID);

		MonthlyPaymentPojo pojo = (MonthlyPaymentPojo) query.uniqueResult();

		session.close();
		return pojo;

	}

	public static List<MonthlyPaymentPojo> getAllMonthlyPaymentsToGroup(int groupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"from MONTHLYPAYMENTS where MONTHLYPAYMENTID in (select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID) ORDER BY MONTHLYPAYMENTID DESC");
		query.setParameter("groupID", groupID);

		List<MonthlyPaymentPojo> pojosList = (List<MonthlyPaymentPojo>) query.getResultList();

		session.close();
		return pojosList;
	}

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

	public static int createPayment(Map<String, String> modalValues) {
		PaymentPojo payment = new PaymentPojo();
		payment.setAmount(Double.valueOf(modalValues.get("paymentValue")));
		payment.setDateCreated(OffsetDateTime.now());
		payment.setGroupName(DBGroupActions.findGroupById(Integer.valueOf(modalValues.get("groupId"))).getGroupName());
		payment.setPaymentDescription(modalValues.get("paymentdescription"));
		savePayment(payment);

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

		MonthlyPaymentPojo mpp = getMonthlyPaymentById(
				getRecentMonthlyPaymentbyGroupId(Integer.valueOf(modalValues.get("groupId"))));
		MonthlyPaymentToPaymentPojo mptpp = new MonthlyPaymentToPaymentPojo();
		mptpp.setMonthlyPayment(mpp);
		mptpp.setPayment(payment);
		saveMonthlyPaymentToPayment(mptpp);

		return payment.getPaymentID();
	}

	private static MonthlyPaymentPojo getMonthlyPaymentById(int inrecentMonthlyPaymentID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from MONTHLYPAYMENTS WHERE MONTHLYPAYMENTID = :MonthlyPaymentId");
		query.setParameter("MonthlyPaymentId", inrecentMonthlyPaymentID);
		MonthlyPaymentPojo mpp = (MonthlyPaymentPojo) query.uniqueResult();
		session.close();
		return mpp;
	}

	public static int getRecentMonthlyPaymentbyGroupId(int groupID) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery(
				"select monthlyPayment from MONTHLYPAYMENTTOGROUP where GROUPID = :groupID ORDER BY ID DESC");
		query.setParameter("groupID", groupID);
		try {
			int monthlyID = ((MonthlyPaymentPojo) query.getResultList().get(0)).getMonthlyPaymentID();
			System.out.println(monthlyID);
			session.close();
			return monthlyID;
		} catch (IndexOutOfBoundsException e) {
			session.close();
			return -1;
		}

	}

	public static void updateMonthlyPayment(int inUserId) {
		List<GroupPojo> groups = DBGroupActions.findAllGroupsByUserId(inUserId);
		for (GroupPojo groupPojo : groups) {
			int monthlyPaymentID = getRecentMonthlyPaymentbyGroupId(groupPojo.getGroupID());

			if (monthlyPaymentID == -1) {
				MonthlyPaymentPojo newPojo = new MonthlyPaymentPojo();
				newPojo.setDateCreated(OffsetDateTime.now());
				newPojo.setDateUntil(OffsetDateTime.now().plusMonths(1).plusDays(7));
				MonthlyPaymentToGroupPojo mptg = new MonthlyPaymentToGroupPojo();
				mptg.setGroup(groupPojo);
				mptg.setMonthlyPayment(newPojo);
				saveMonthlyPayment(newPojo);
				saveMonthlyPaymentToGroup(mptg);
			} else if (!getMonthlyPaymentById(monthlyPaymentID).getDateCreated().getMonth()
					.equals(OffsetDateTime.now().getMonth())) {
				MonthlyPaymentPojo newMonthlyPayment = new MonthlyPaymentPojo();
				newMonthlyPayment.setDateCreated(OffsetDateTime.now());
				newMonthlyPayment.setDateUntil(OffsetDateTime.now().plusMonths(1).plusDays(7));
				MonthlyPaymentToGroupPojo mptg = new MonthlyPaymentToGroupPojo();
				mptg.setMonthlyPayment(newMonthlyPayment);
				saveMonthlyPayment(newMonthlyPayment);
				saveMonthlyPaymentToGroup(mptg);
			}
		}
	}

	private static void saveMonthlyPaymentToGroup(MonthlyPaymentToGroupPojo inMonthlyPaymentToGroup) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentToGroup);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveMonthlyPayment(MonthlyPaymentPojo inMonthlyPaymentPojo) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentPojo);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveMonthlyPaymentToPayment(MonthlyPaymentToPaymentPojo inMonthlyPaymentToPayment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inMonthlyPaymentToPayment);
		session.getTransaction().commit();
		session.close();
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
