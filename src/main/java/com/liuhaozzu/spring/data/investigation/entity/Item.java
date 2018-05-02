package com.liuhaozzu.spring.data.investigation.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "customer_id")
    private Long customerId;

    public Long getId() {
        return id;
    }

    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Item setPrice(String price) {
        this.price = price;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Item setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }
}
