package com.crud.sunbase.repository;

import com.crud.sunbase.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {


    @Query("Select c from Customer c where c.firstName like :name")
    List<Customer> findByFirstName(String name);

    @Query("Select c from Customer c where c.city like :city")
    List<Customer> findByCity(String city);

    @Query("Select c from Customer c where c.email like :email")
    List<Customer> findByEmail(String email);

    @Query("Select c from Customer c where c.phone like :phone")
    List<Customer> findByPhone(String phone);

}