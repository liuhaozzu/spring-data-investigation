package com.liuhaozzu.spring.data.investigation.repository;

import com.google.gson.Gson;
import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.util.OffsetBasedPageRequest;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepo;

    @Test
    public void testFindByLastName() {


        Customer customer = new Customer().setFirstName("hao");
        //Pageable pageable = new PageRequest(3,5,new Sort(Sort.Direction.DESC, Lists.newArrayList("id")));
        Pageable pageable = new OffsetBasedPageRequest(3,5,new Sort(Sort.Direction.DESC, Lists.newArrayList("id")));
        List<Customer> list0 = customerRepo.findByFirstName(customer.getFirstName(),pageable);
        System.out.println(list0);
        /*List<Customer> list1 = customerRepo.findAll(Example.of(new Customer().setFirstName("first")));
        System.err.println(new Gson().toJson(list0));
        System.err.println(new Gson().toJson(list1));
        List<Customer> list2=customerRepo.findByFullName("first", "last");
        assertThat(list2).contains(new Customer().setFirstName("first").setFirstName("last"));*/
        //assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
        //assertThat(list0).extracting(Customer::getLastName).contains(customer.getLastName());
        //assertThat(list1).extracting(Customer::getLastName).contains(customer.getLastName());
    }
}
