package org.example.dao;

import org.example.entity.Customer;
import org.example.model.CustomerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class CustomerDAOImpl implements CustomerDAO {


    private SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public String registerCustomer(Customer customer) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(customer);
            System.out.println("Customer registered successfully. List provided.."+customer);

        }catch(Exception e){
            System.err.println("Error Details : "+e.getMessage());
        }finally{
            if(session !=null){
                session.close();
            }
        }
        return "success";
    }

    @Override
    public List<Customer> fetchCustomer() {
        List<Customer> customers = new ArrayList<Customer>();
        String hql = "FROM Customer";
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            customers = session.createQuery(hql).list();
        }catch(Exception e){
            System.err.println("Customer DAO Exception: " + e.getMessage());

        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
       return customers;
    }



}
