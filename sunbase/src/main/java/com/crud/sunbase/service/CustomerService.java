package com.crud.sunbase.service;

import com.crud.sunbase.entities.Customer;
import com.crud.sunbase.entities.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

//- Create a customer
//- Update a customer
//- Get a list of customer (API with pagination sorting and searching )
//- Get a single customer based on ID
//- Delete a customer

@Service
public interface CustomerService {



    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(String id, Customer customer);


    public List<Customer> getAllCustomer();
    public PostResponse getAllCustomerByPaging(Integer pageNum, Integer pageSize, String sortBy);

    public Customer getCustomerById(String id);

    public  String deleteCustomerById(String id);


    List<Customer> createListOfCustomer(List<Customer> customer);

    List<Customer> searchCustomerByName(String customerName);
    List<Customer> searchCustomerByCity(String customerCity);
    List<Customer> searchCustomerByEmail(String customerEmail);

    List<Customer> searchCustomerByPhone(String customerPhone);
}