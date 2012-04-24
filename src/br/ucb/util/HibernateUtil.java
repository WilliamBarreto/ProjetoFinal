package br.ucb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class HibernateUtil {
	private static ServiceRegistry serviceRegistry;
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = (ServiceRegistry) new
					ServiceRegistryBuilder().applySettings(configuration.getProperties()).
					buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
