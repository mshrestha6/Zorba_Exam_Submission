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

@Controller
@RequestMapping(value="/item")

public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String items(Model model) {
       model.addAttribute("itemInfo", new ItemInfo());
      model.addAttribute("itemType", itemService);
        return "itemRegistration";
    }

    @PostMapping("/items")
    public String addItem(@ModelAttribute ItemModel itemModel, Model model) {
        String status = this.itemService.saveItem(itemModel);
        if (status.equalsIgnoreCase("validationFailed")) {
            return "fail";
        }
        model.addAttribute("response", status);
        return "success";

    }
}
