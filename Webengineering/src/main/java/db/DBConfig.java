package main.java.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {

	public DBConfig() {
		// Constructor may be empty
	}

	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		try {
			// Build a SessionFactory object from session-factory config
			// defined in the hibernate.cfg.xml file. In this file we
			// register the JDBC connection information, connection pool,
			// the hibernate dialect that we used and the mapping to our
			// hbm.xml file for each pojo (plain old java object).

			Configuration config = new Configuration();
			return config.configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object." + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void shutdown() {
		getSessionFactory().close();
	}

}