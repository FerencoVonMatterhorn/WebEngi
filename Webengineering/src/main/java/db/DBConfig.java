package main.java.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Build a SessionFactory object from session-factory config defined in the
	 * hibernate.cfg.xml file. In this file we register the JDBC connection
	 * information, connection pool, the hibernate dialect that we used and the
	 * mapping to our hbm.xml file for each pojo (plain old java object).
	 */
	public static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		return config.configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void shutdown() {
		getSessionFactory().close();
	}
}