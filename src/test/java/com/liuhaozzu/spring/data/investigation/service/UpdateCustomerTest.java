package com.liuhaozzu.spring.data.investigation.service;

import com.google.gson.Gson;
import com.liuhaozzu.spring.data.investigation.config.validation.ValidationService;
import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateCustomerTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ValidationService validationService;

    @Test
    public void findCustomerById() {
        try {
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
            System.out.println(customerService.findCustomerById(30L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Transactional
    public void testUpdateItemNumWithException() {
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        /*customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaabbbccc").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        customerRepo.save(new Customer().setCreateTime(System.currentTimeMillis()).setFirstName("aaa").setMobile("adfadfadf"));
        String abc = new String("abc");
        abc.indexOf("a");*/
    }
    @Test
    public void testNull(){
        String a=null;
        System.out.println(a + "abc");
        System.out.println("abc"+a);
        System.out.println("abc "+a);
        System.out.println(Long.toString(Long.MAX_VALUE).length());;
        System.out.println(Long.toString(Long.MAX_VALUE));;
        //System.out.println("abc".concat(a));
    }
}
