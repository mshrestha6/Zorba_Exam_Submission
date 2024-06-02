package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public String registerCustomerData(CustomerModel customerModel) {
        if (customerModel.getCustomerName() == null || customerModel.getCustomerEmail() == null ||
                customerModel.getMobileNo() == null || customerModel.getCustomerAddress() == null ||
                customerModel.getCustomerUserName() == null || customerModel.getCustomerPassword() == null) {
            return "Please validate all the information should be correct..";
        } else if (!customerModel.getCustomerEmail().contains("@")) {
            return "Please enter a valid email address.";
        } else if (customerModel.getMobileNo().length() != 10) {
            return "Please provide valid mobile no.";
        } else if (customerModel.getCustomerPassword().length() < 6) {
            return "Please provide valid password.";
        } else {
            Customer customer = new Customer();
            customer.setCustomerName(customerModel.getCustomerName());
            customer.setMobileNo(customerModel.getMobileNo());
            customer.setCustomerEmail(customerModel.getCustomerEmail());
            customer.setCustomerAddress(customerModel.getCustomerAddress());
            customer.setCustomerUserName(customerModel.getCustomerUserName());
            customer.setCustomerPassword(customerModel.getCustomerPassword());

            String status = customerDAO.registerCustomer(customer);

            return status;
        }
    }

    public List<CustomerModel> fetchCustomer() {
        List<Customer> customerList = this.customerDAO.fetchCustomer();
        List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();
        for (Customer customer : customerList) {
            CustomerModel customerModel = new CustomerModel();
            customerModel.setCustomerName(customer.getCustomerName());
            customerModel.setMobileNo(customer.getMobileNo());
            customerModel.setCustomerEmail(customer.getCustomerEmail());
            customerModel.setCustomerAddress(customer.getCustomerAddress());
            customerModel.setCustomerUserName(customer.getCustomerUserName());
            customerModel.setCustomerPassword(customer.getCustomerPassword());
            customerModelList.add(customerModel);
        }
        return customerModelList;
    }


}
