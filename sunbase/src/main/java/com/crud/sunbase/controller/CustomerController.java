package com.crud.sunbase.controller;

import com.crud.sunbase.entities.Customer;
import com.crud.sunbase.entities.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.crud.sunbase.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")

public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer saveCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(saveCustomer,ObjectUtils.isEmpty(saveCustomer) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
    @PostMapping("/createListCustomer")
    public ResponseEntity<List<Customer>> createListOfCustomer(@RequestBody List<Customer> customer) {
        List<Customer> saveListCustomer = customerService.createListOfCustomer(customer);
        return new ResponseEntity<>(saveListCustomer,ObjectUtils.isEmpty(saveListCustomer) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }


    @GetMapping("/getAllCustomerByPaging")
    public ResponseEntity<PostResponse> getAllCustomerByPaging(@RequestParam (value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                               @RequestParam (value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                                                               @RequestParam (value = "sortBy",defaultValue = "custId",required = false)String sortBy) {
        PostResponse postResponse = customerService.getAllCustomerByPaging(pageNumber,pageSize,sortBy );
        return new ResponseEntity<>(postResponse,ObjectUtils.isEmpty(postResponse) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }


    @GetMapping("/getAllCustomer")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = customerService.getAllCustomer();
        return new ResponseEntity<>(customerList,ObjectUtils.isEmpty(customerList) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }


    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer,ObjectUtils.isEmpty(customer) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAllCustomer(@PathVariable String id) {
        String mgs = customerService.deleteCustomerById(id);
        return new ResponseEntity<>(mgs, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> allCustomer(@PathVariable String id,@RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }


    //search
    @GetMapping("/customerByName/{firstName}")
    public  ResponseEntity<List<Customer>> searchCustomerByName(@PathVariable String firstName){
        List<Customer> customerList = customerService.searchCustomerByName(firstName);
        return  new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/customerByCity/{city}")
    public  ResponseEntity<List<Customer>> searchCustomerByCity(@PathVariable String city){
        List<Customer> customerList = customerService.searchCustomerByCity(city);
        return  new ResponseEntity<>(customerList,HttpStatus.OK);
    }


    @GetMapping("/customerByEmail/{email}")
    public  ResponseEntity<List<Customer>> searchCustomerByEmail(@PathVariable String email){
        List<Customer> customerList = customerService.searchCustomerByName(email);
        return  new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/customerByPhone/{phone}")
    public  ResponseEntity<List<Customer>> searchCustomerByPhone(@PathVariable String phone){
        List<Customer> customerList = customerService.searchCustomerByPhone(phone);
        return  new ResponseEntity<>(customerList,HttpStatus.OK);
    }

}