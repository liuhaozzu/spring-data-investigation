package com.liuhaozzu.spring.data.investigation.service;

import com.alicp.jetcache.anno.*;
import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.entity.Item;
import com.liuhaozzu.spring.data.investigation.repository.CustomerRepository;
import com.liuhaozzu.spring.data.investigation.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private ItemRepository itemRepo;


    @Cached(name = "customerCache-", key = "#customerId", expire = 600, cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 300, stopRefreshAfterLastAccess = 60, timeUnit = TimeUnit.SECONDS)
    //@Transactional(rollbackFor = {Exception.class}) // 默认只对RuntimeException回滚
    //@CachePenetrationProtect //注解保证当缓存未命中的时候，一个JVM里面只有一个线程去执行方法，其它线程等待结果
    public Customer findCustomerById(Long customerId) throws Exception {
        Customer customer = customerRepo.findOne(customerId);
        return customer;
    }

    @CacheUpdate(name = "customerCache-", key = "#customer.id", value = "#customer")
    @CachePenetrationProtect
    public Customer updateById(Customer customer) throws Exception {
        return customerRepo.save(customer);
    }

    @CacheInvalidate(name="userCache-", key="#customerId")
    public void deleteCustomer(Long customerId){
        customerRepo.delete(customerId);
    }

    @Cached(expire = 30, cacheType = CacheType.REMOTE)
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }
}
