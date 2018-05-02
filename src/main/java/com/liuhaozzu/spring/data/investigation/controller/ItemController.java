package com.liuhaozzu.spring.data.investigation.controller;

import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@RestController
public class ItemController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/transaction-test")
    public ResponseEntity<Customer> transactionTest(Long customerId, Long itemId) {
        Customer customer = null;
        try {
            customer = customerService.updateItemNum(customerId, itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(customer);
    }

}
