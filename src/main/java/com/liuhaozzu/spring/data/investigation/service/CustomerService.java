package com.liuhaozzu.spring.data.investigation.service;

import com.liuhaozzu.spring.data.investigation.entity.Customer;
import com.liuhaozzu.spring.data.investigation.entity.Item;
import com.liuhaozzu.spring.data.investigation.repository.CustomerRepository;
import com.liuhaozzu.spring.data.investigation.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private ItemRepository itemRepo;


    @Transactional(rollbackFor = {Exception.class}) // 默认只对RuntimeException回滚
    public Customer updateItemNum(Long customerId,Long itemId) throws Exception {
        Customer customer = customerRepo.findOne(customerId);
        customer.setHabit(Long.toString(itemId));
        try {
            customerRepo.save(customer);
        } catch (Exception e) {
            // 当检测到期待异常时，支持手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        Item item = itemRepo.findOne(itemId);
        if (item.getCustomerId().equals(Long.valueOf(1))) {
            throw new Exception("updateItemCId error..."+customerId+":::"+itemId);
        }
        item.setCustomerId(customerId);
        itemRepo.save(item);
        return customer;
    }
}
