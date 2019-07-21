package main.java.util;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import main.java.db.DBConfig;
import main.java.db.DBPaymentActions;
import main.java.db.DBUserActions;
import main.java.pojos.GroupPojo;
import main.java.pojos.MonthlyPaymentPojo;
import main.java.pojos.MonthlyPaymentToGroupPojo;
import main.java.pojos.PaymentPojo;
import main.java.pojos.PaymentToUserPojo;

public class InsertTestData {

	public InsertTestData() {
		// may be empty
	}

	public static void main(String[] args) {
		InsertTestData insertTestData = new InsertTestData();

		insertTestData.insertMonthlyPayment();
	}

	public void insertMonthlyPayment() {

		Session session = DBConfig.getSessionFactory().openSession();

		MonthlyPaymentPojo pojo = new MonthlyPaymentPojo();
		MonthlyPaymentToGroupPojo pojo2 = new MonthlyPaymentToGroupPojo();
		GroupPojo pojo3 = new GroupPojo();

		pojo3.setGroupDescription("MTPG Test");
		pojo3.setGroupName("TEESTMTGRP");

		pojo.setDateCreated(OffsetDateTime.now());
		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		pojo.setDateUntil(new Date(System.currentTimeMillis() + (7 * DAY_IN_MS)));

		pojo2.setMonthlyPayment(pojo);
		pojo2.setGroup(pojo3);

		session.beginTransaction();
		session.save(pojo3);
		session.save(pojo);
		session.save(pojo2);
		session.getTransaction().commit();
		session.close();

	}

	public void insertGroupTestData() {

		Session session = DBConfig.getSessionFactory().openSession();

		session.beginTransaction();

		List<GroupPojo> testDataList = new ArrayList<>();

		for (int i = 1; i <= 1; i++) {
			GroupPojo test = new GroupPojo();
			test.setGroupName("testGroup" + i);
			test.setGroupDescription("TestGroup Data Test Data " + i);
			testDataList.add(test);
			System.out.println(i);
		}

		for (GroupPojo groupPojo : testDataList) {
			session.save(groupPojo);
			System.out.println(groupPojo.getGroupID());

		}

		session.getTransaction().commit();
		session.close();
	}

	public void insertPaymentToUserTestData() {

		Session session = DBConfig.getSessionFactory().openSession();

		session.beginTransaction();

		List<PaymentToUserPojo> testDataList = new ArrayList<>();

		for (int i = 431; i <= 444; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PaymentToUserPojo test = new PaymentToUserPojo();
			test.setPayment(DBPaymentActions.findPaymentById(i));
			test.setUser(DBUserActions.findUserById(114));
			test.setPercentage(50);
			testDataList.add(test);
			System.out.println(i);
		}

		for (PaymentToUserPojo paymentPojo : testDataList) {
			session.save(paymentPojo);

		}

		session.getTransaction().commit();
		session.close();
	}

	public void insertPaymentTestData() {

		Session session = DBConfig.getSessionFactory().openSession();

		session.beginTransaction();

		List<PaymentPojo> testDataList = new ArrayList<>();

		for (int i = 1; i <= 14; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PaymentPojo test = new PaymentPojo();
			test.setAmount(100.00 + i);
			test.setDateCreated(OffsetDateTime.now());
			test.setPaymentDescription("Dies ist eine TestZahlung zu TestZwecken");
			testDataList.add(test);
			System.out.println(i);
		}

		for (PaymentPojo paymentPojo : testDataList) {
			session.save(paymentPojo);

		}

		session.getTransaction().commit();
		session.close();
	}
}
