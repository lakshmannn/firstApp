package com.ecomapp.controller;

import com.ecomapp.model.Customer;
import com.ecomapp.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id){
        Customer c =customerService.getCustomerById(id);
        if(c !=null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("No Customer found for id:"+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable Long  id){
        return new ResponseEntity<>(customerService.updateCustomer(customer,id), HttpStatus.OK);
    }
}
