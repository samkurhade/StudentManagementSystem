package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		try {
			if(sessionFactory == null) {
				Configuration cfg = new Configuration();
				cfg.configure();
				
				sessionFactory = cfg.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Session factory object not created.");
		}
		
		
		return sessionFactory;
	}
}
