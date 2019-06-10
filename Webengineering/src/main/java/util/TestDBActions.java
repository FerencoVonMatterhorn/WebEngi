package main.java.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.db.DBConfig;
import main.java.pojos.GroupPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.UserPojo;
import main.java.pojos.UserToGroupPojo;

public class TestDBActions {

	public static void main(String[] args) {

		TestDBActions testDBActions = new TestDBActions();

		testDBActions.testJoin();

	}

	public void testUserToGroup() {

		Session session = DBConfig.getSessionFactory().openSession();

		Query<?> query = session.createQuery("from USERTOGROUP where USERID = :userID");
		query.setParameter("userID", 82);

		UserToGroupPojo userToGroupPojo = (UserToGroupPojo) query.uniqueResult();

		query = session.createQuery("from GROUPS where GROUPID = :groupID");
		query.setParameter("groupID", userToGroupPojo.getGroup().getGroupID());

		GroupPojo groupPojo = (GroupPojo) query.uniqueResult();
		session.close();

		System.out.println(groupPojo.getGroupName());
	}

	public void getUsersTest() {

		Session session = DBConfig.getSessionFactory().openSession();

		Query<?> query = session.createQuery("from USERTOGROUP where GROUPID = :groupID");
		query.setParameter("groupID", 67);

		List<UserToGroupPojo> userList = (List<UserToGroupPojo>) query.getResultList();

		List<UserPojo> userPojoList = new ArrayList<>();

		for (UserToGroupPojo userToGroupPojo : userList) {
			query = session.createQuery("from USERS where USERID = :userID");
			query.setParameter("userID", userToGroupPojo.getUser().getId());

			userPojoList.add((UserPojo) query.uniqueResult());
		}

		for (UserPojo userPojo : userPojoList) {
			System.out.println(userPojo.getEmail());
		}

		session.close();
	}

	public void testJoin() {
		Session session = DBConfig.getSessionFactory().openSession();

		Query<?> query = session.createQuery(
				"from PAYMENTS where PAYMENTID in (select payment from PAYMENTTOUSER where userID = :userID) order by DATECREATED DESC");

		query.setParameter("userID", 114);

		List<PaymentPojo> listPayments = (List<PaymentPojo>) query.getResultList();

		for (PaymentPojo paymentPojo : listPayments) {
			System.out.println(paymentPojo.getAmount());
		}

	}

}
