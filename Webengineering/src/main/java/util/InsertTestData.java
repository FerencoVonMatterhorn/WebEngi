package main.java.util;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import main.java.db.DBConfig;
import main.java.pojos.GroupPojo;
import main.java.pojos.PaymentPojo;

public class InsertTestData {

	public InsertTestData() {

	}

	public static void main(String[] args) {
		InsertTestData insertTestData = new InsertTestData();

		insertTestData.insertPaymentTestData();
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

	public void insertPaymentTestData() {

		Session session = DBConfig.getSessionFactory().openSession();

		session.beginTransaction();

		List<PaymentPojo> testDataList = new ArrayList<>();

		for (int i = 1; i <= 15; i++) {
			PaymentPojo test = new PaymentPojo();
			test.setAmount(100.00 + i);
			test.setDateCreated(OffsetDateTime.now());
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
