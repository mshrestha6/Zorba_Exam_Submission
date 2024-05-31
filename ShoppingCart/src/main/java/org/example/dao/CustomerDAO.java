package org.example.dao;

import org.example.entity.Customer;
import org.example.model.CustomerModel;

import java.util.List;


public interface CustomerDAO {
String registerCustomer(Customer customer);

List<Customer> getCustomers();


}
