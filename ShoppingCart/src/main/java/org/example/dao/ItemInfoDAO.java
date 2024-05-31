package org.example.dao;

import org.example.entity.ItemInfo;
import org.example.entity.ItemType;
import org.example.model.ItemModel;

import java.util.List;


public interface ItemInfoDAO {
     String saveItem(ItemInfo itemInfo) ;

     List<ItemInfo> getAllItemInfo() ;
     ItemType getItemType(String itemType) ;


}
