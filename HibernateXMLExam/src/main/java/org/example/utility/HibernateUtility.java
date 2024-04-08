package org.example.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    public static SessionFactory getSessionFactory() {
        //Read the hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
