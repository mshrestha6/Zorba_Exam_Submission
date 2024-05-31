package org.example.dao;


import org.example.entity.Vendor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class VendorDAOImpl implements VendorDAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public String registerVendor(Vendor vendor) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(vendor);
            System.out.println("Vendor registered successfully"+vendor);
        }catch(Exception e){
            System.err.println("Vendor register failed"+vendor);
        }finally{
            session.getTransaction().commit();
            if(session !=null){
                session.close();
            }
        }
        return "success";
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<Vendor>();
        String hql = "from Vendor";
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery(hql);
            vendors = query.list();
        }catch(Exception e){
            System.err.println("Vendor list failed"+e.getMessage());
        }finally {
            if(session !=null){
                session.close();
            }
        }
        return vendors;
    }
}
