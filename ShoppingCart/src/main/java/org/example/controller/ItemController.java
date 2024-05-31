package org.example.controller;

import org.example.entity.ItemInfo;
import org.example.model.ItemModel;
import org.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value="/item")

public class ItemController<List> {
    @Autowired
    private ItemService itemService;

    @GetMapping("/load")
    public String loadForm(Model model) {
        return "itemRegistration";
    }

    @PostMapping("/additem")
    public String addItem(@ModelAttribute ItemModel itemModel, Model model) {
        String status = this.itemService.saveItem(itemModel);
        if (status.equalsIgnoreCase("validationFailed")) {
            return "fail";
        }
        java.util.List<ItemModel> itemModelList=this.itemService.getAllItemInfo();
        model.addAttribute("itemInfo", itemModelList);
        return "success";

    }
    @GetMapping("/fetchItem")
    public String fetchItem(Model model) {
        java.util.List<ItemModel> itemModelList=this.itemService.getAllItemInfo();
        model.addAttribute("itemInfo", itemModelList);
        return "itemViewpage";
    }
}
