package org.example.dao;

import org.example.entity.ItemInfo;
import org.example.model.ItemModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ItemInfoDAOImpl implements ItemInfoDAO {

    private SessionFactory sessionFactory;


    public ItemInfoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public String saveItem(ItemInfo itemInfo) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(itemInfo);

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
