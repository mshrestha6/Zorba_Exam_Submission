package org.example.dao;

import org.example.model.CustomerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDAOImpl implements CustomerDAO {


    private SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String registerCustomer(CustomerModel customer) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(customer);

        }catch(Exception e){
            System.err.println("Error Details : "+e.getMessage());
        }finally{
            if(session !=null){
                session.close();
            }
        }
        return "success";
    }
}
