package com.liuhaozzu.spring.data.investigation.entity;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@Entity
@Component
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false, length = 5)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "create_time")
    private long createTime;
    private String mobile;
    private String habit;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName=lastName;
    }

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Customer setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Customer setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getHabit() {
        return habit;
    }

    public Customer setHabit(String habit) {
        this.habit = habit;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
