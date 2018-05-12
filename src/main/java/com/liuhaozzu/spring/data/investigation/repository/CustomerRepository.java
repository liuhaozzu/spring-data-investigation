package com.liuhaozzu.spring.data.investigation.repository;


import com.liuhaozzu.spring.data.investigation.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@RepositoryRestResource(path="customer")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName, Pageable pageable);

    //Use Query
    @Query(value = "SELECT c FROM Customer c WHERE c.firstName=:firstName and c.lastName=:lastName")
    List<Customer> findByFullName(@Param("firstName") String firstName, @Param("lastName")String lastName);

}
