package org.example.utility;


import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Product_type;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.relation.Role;

public class HibernateUtility {
    public static SessionFactory getSessionFactory() {
        //Read the hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //Need to add all the entity class into addAnnotationClass.
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Product_type.class);


        //Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
