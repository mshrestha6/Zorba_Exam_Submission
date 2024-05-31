package org.example.service;


import org.example.dao.ItemInfoDAO;
import org.example.entity.ItemInfo;
import org.example.entity.ItemType;
import org.example.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service

public class ItemService {
    @Autowired
    private ItemInfoDAO itemInfoDAO;

    @Transactional
    public String saveItem(ItemModel itemModel) {
        if(itemModel.getItemName()==null||itemModel.getItemType()==null||
        itemModel.getItemQuantity()==null||itemModel.getItemPrice()==null){
            return "Invalid Item and fail to add";
        }

        ItemInfo itemInfo = new ItemInfo();
        ItemType itemType = new ItemType();

        itemType=this.itemInfoDAO.getItemType(itemModel.getItemType());

        if(itemType==null){
            itemType.setItemType(itemModel.getItemType());
        }
        itemInfo.setItemType(itemType);
        itemInfo.setItemName(itemModel.getItemName());
        itemInfo.setItemPrice(itemModel.getItemPrice());
        itemInfo.setItemQuantity(itemModel.getItemQuantity());

        String check=this.itemInfoDAO.saveItem(itemInfo);
        return check;
    }
    public List<ItemModel> getAllItemInfo(){
        List<ItemInfo> itemInfoList=this.itemInfoDAO.getAllItemInfo();
        List<ItemModel> itemModelList=new ArrayList<ItemModel>();
        for(ItemInfo itemInfo:itemInfoList){
            ItemModel itemModel=new ItemModel();
            itemModel.setItemType(itemInfo.getItemType().getItemType());
            itemModel.setItemName(itemInfo.getItemName());
            itemModel.setItemPrice(itemInfo.getItemPrice());
            itemModel.setItemQuantity(itemInfo.getItemQuantity());
            itemModelList.add(itemModel);

        }
        return itemModelList;
    }


}
