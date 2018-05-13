package com.liuhaozzu.spring.data.investigation.controller;

import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/cache-test/customer")
    public ResponseEntity<Customer> findbyId(@RequestHeader(value = "customerId") Long customerId) {
        Customer customer = null;
        try {
            customer = customerService.findCustomerById(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(customer);
    }
    @PostMapping("/cache-test/customer")
    public ResponseEntity<Customer> addCustomer(Customer customer) {
        try {
            customer = customerService.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(customer);
    }
    @PutMapping("/cache-test/customer")
    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        try {
            customer = customerService.updateById(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(customer);
    }
    @DeleteMapping("/cache-test/customer")
    public ResponseEntity<Customer> deleteCustomerBy(Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(null);
    }

}
