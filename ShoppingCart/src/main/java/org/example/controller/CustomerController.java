package org.example.controller;

import org.example.entity.Customer;
import org.example.model.CustomerModel;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/customer")

public class CustomerController {
@Autowired
    private CustomerService customerService;

@GetMapping("/customerPage")
    public String customerPage() {
    return "CustomerRegistration";
}
@PostMapping("/register")
    public String registerCustomer(@ModelAttribute CustomerModel customerModel, Model model) {
    String status=this.customerService.registerCustomerData(customerModel);
    if(status.equalsIgnoreCase("validationFailed")){
        return "fail";
    }else {
        model.addAttribute("response", status);
        return "success";
    }
}
@GetMapping("/fetchCustomer")
    public String fetchCustomer(Model model) {
    List<CustomerModel> customerModelList=this.customerService.fetchCustomer();
    model.addAttribute("customerModelList",customerModelList);
    return "CustomerViewPage";
}

}
