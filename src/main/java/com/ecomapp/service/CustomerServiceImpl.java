package com.ecomapp.service;

import com.ecomapp.model.Customer;
import com.ecomapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.delete(customer.get());
            return "deleted customer successfully";
        }else {
            return "No customer found for Id:"+id;
        }
    }

    @Override
    public String updateCustomer(Customer customer, Long id) {
        Optional<Customer> exitingCustomer = customerRepository.findById(id);
        if(exitingCustomer.isPresent()){
            Customer c = exitingCustomer.get();
                    c.setName(customer.getName());
                    c.setDept(customer.getDept());
                    c.setAddress(customer.getAddress());
            customerRepository.save(c);
            return "updated customer successfully";
        }else {
            return "No customer found for Id:"+id;
        }
    }
}
