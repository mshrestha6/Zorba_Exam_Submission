package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service

public class CustomerService {

  @Autowired
  private CustomerDAO customerDAO;

  @Transactional
  public String registerCustomerData(CustomerModel customerModel) {
    if (customerModel.getCustomerName() == null || customerModel.getCustomerEmail()==null||
            customerModel.getMobileNo() == null || customerModel.getCustomerAddress() == null ||
            customerModel.getCustomerUserName() == null || customerModel.getCustomerPassword() == null) {
      return "Please validate all the information should be correct..";
    }
    if(!customerModel.getCustomerEmail().contains("@")){
      return "Please enter a valid email address.";

    }
    if(customerModel.getMobileNo().length()!=10) {
      return "Please provide valid mobile no.";
    }
    if(customerModel.getCustomerPassword().length()<6) {
      return "Please provide valid password.";
    }

    customerModel.setCustomerName(customerModel.getCustomerName());
    customerModel.setCustomerEmail(customerModel.getCustomerEmail());
    customerModel.setMobileNo(customerModel.getMobileNo());
    customerModel.setCustomerAddress(customerModel.getCustomerAddress());
    customerModel.setCustomerUserName(customerModel.getCustomerUserName());
    customerModel.setCustomerPassword(customerModel.getCustomerPassword());

    String status=this.customerDAO.registerCustomer(customerModel);
    return status;

  }

}
