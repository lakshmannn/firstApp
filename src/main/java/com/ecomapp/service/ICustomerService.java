package com.ecomapp.service;

import com.ecomapp.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer create(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    String deleteCustomer(Long id);
    String updateCustomer(Customer customer,Long id);

}
