package org.example.dao;

import org.example.entity.ItemInfo;
import org.example.entity.ItemType;
import org.example.model.ItemModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
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
            System.out.println("Details of items saved: "+itemInfo);

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
    public List<ItemInfo> getAllItemInfo() {
        List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
        String hql = "from ItemInfo";
        Session session= this.sessionFactory.openSession();
        try{
            Query query= session.createQuery(hql);
            itemInfoList = query.list();
        }catch(Exception e){
            System.err.println("Error Details : "+e.getMessage());
        }finally {
            if(session !=null){
                session.close();
            }
        }
        return itemInfoList;
    }

    @Override
    public ItemType getItemType(String itemType) {
        ItemType itemTypeObj = new ItemType();
        Session session= this.sessionFactory.openSession();
        try{
            Query query1= session.createQuery("from ItemType where itemType=:itemType");
            query1.setParameter("itemType", itemType);
            itemTypeObj = (ItemType) query1.uniqueResult();
        }catch(Exception e){
            System.err.println("Error Details : "+e.getMessage());

        }finally{
            if(session !=null){
                session.close();
            }
        }
        return itemTypeObj;
    }


}
