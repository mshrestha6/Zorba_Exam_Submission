package org.example.controller;


import org.example.model.VendorModel;
import org.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/vendor")

public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/loadForm")
    public String loadForm() {
        return "VendorRegistration";
    }
    @PostMapping("/registerVendor")
    public String registerVendor(@ModelAttribute VendorModel vendorModel, Model model) {
        String status = this.vendorService.registerVendor(vendorModel);
        if(status.equalsIgnoreCase("ValidationFailed")) {
            return "fail";
        }
        model.addAttribute("vendor",status);
        return "success";
    }
    @GetMapping("/fetchVendor")
    public String fetchVendor(Model model) {
        List<VendorModel> vendorModelList=this.vendorService.getAllVendor();
        model.addAttribute("vendorModelList",vendorModelList);
        return "VendorViewPage";
    }

}
