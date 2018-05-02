package com.liuhaozzu.spring.data.investigation.repository;

import com.liuhaozzu.spring.data.investigation.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@RepositoryRestResource(path="item")
public interface ItemRepository extends JpaRepository<Item, Long>{
    List<Item> findByName(String name);
    List<Item> findByPrice(String price);
}
