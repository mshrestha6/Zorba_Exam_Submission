package org.example.service;


import org.example.dao.ItemInfoDAO;
import org.example.entity.ItemInfo;
import org.example.entity.ItemType;
import org.example.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemService {
    @Autowired
    private ItemInfoDAO itemInfoDAO;

    public String saveItem(ItemModel itemModel) {
        if(itemModel.getItemName()==null||itemModel.getItemType()==null||
        itemModel.getItemQuantity()==null||itemModel.getItemPrice()==null){
            return "Invalid Item and fail to add";
        }

        ItemInfo itemInfo = new ItemInfo();
        ItemType itemType = new ItemType();

        itemType.setItemType(itemModel.getItemType());
        itemInfo.setItemName(itemModel.getItemName());
        itemInfo.setItemQuantity(itemModel.getItemQuantity());
        itemInfo.setItemPrice(itemModel.getItemPrice());

        itemInfo.setItemType(itemType);

        String status = this.itemInfoDAO.saveItem(itemInfo);
        return status;

    }


}
