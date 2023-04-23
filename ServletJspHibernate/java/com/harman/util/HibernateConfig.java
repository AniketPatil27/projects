package com.harman.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.harman.entity.Employee;
import java.util.Properties;

public class HibernateConfig {

	private static SessionFactory sf=null;
	
	public static SessionFactory getSessionFactory() {
			if(sf==null) {
				try {
					Configuration cfg=new Configuration();
					Properties settings = new Properties();
					settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
					settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb?useSSL=false");
					settings.put(Environment.USER, "root");
					settings.put(Environment.PASS, "root");

					settings.put(Environment.SHOW_SQL, "true");

					settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

					settings.put(Environment.HBM2DDL_AUTO, "update");

					cfg.setProperties(settings);
					cfg.addAnnotatedClass(Employee.class);

					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
					System.out.println("Hibernate Java Config serviceRegistry created");
					sf = cfg.buildSessionFactory(serviceRegistry);
					return sf;
				}	
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			return sf;
		}
	}


