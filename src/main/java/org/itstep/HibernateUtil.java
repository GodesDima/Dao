 package org.itstep;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = configureSessionFactory();

	private static SessionFactory configureSessionFactory() {
		Configuration configuration = new Configuration().configure();
		return configuration.buildSessionFactory();
			
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
