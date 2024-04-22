package org.example.utility;

import org.example.entity.Employee;
import org.example.entity.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    public static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Skill.class);


        //Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
