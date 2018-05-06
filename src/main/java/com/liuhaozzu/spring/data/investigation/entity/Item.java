package com.liuhaozzu.spring.data.investigation.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
@Entity
public class Item {
    private long itemId;
    private String name;
    private String price;
    private Long customerId;

    @Id
    @Column(name = "item_id")
    public long getItemId() {
        return itemId;
    }

    public Item setItemId(long itemId) {
        this.itemId = itemId;
        return this;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public Item setPrice(String price) {
        this.price = price;
        return this;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public Item setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (itemId != item.itemId) {
            return false;
        }
        if (name != null ? !name.equals(item.name) : item.name != null) {
            return false;
        }
        if (price != null ? !price.equals(item.price) : item.price != null) {
            return false;
        }
        return customerId != null ? customerId.equals(item.customerId) : item.customerId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
