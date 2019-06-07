package main.java.util;

import org.hibernate.Session;

import main.java.db.DBConfig;
import main.java.pojos.GroupPojo;

public class InsertTestData {

	public InsertTestData() {

	}

	public static void main(String[] args) {

		Session session = DBConfig.getSessionFactory().openSession();

		session.beginTransaction();

		GroupPojo testGroup = new GroupPojo();
		testGroup.setGroupName("testName");
		testGroup.setGroupDescription("TestGroup Data BLABLABLA");

		session.save(testGroup);

		session.getTransaction().commit();
	}

}
