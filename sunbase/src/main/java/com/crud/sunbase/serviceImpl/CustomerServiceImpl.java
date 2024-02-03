package com.crud.sunbase.serviceImpl;

import com.crud.sunbase.entities.Customer;
import com.crud.sunbase.entities.PostResponse;
import com.crud.sunbase.exception.UserNotFoundException;
import com.crud.sunbase.repository.CustomerRepository;
import com.crud.sunbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        String custUUID = UUID.randomUUID().toString();
        customer.setCustId(custUUID);
        Customer customerSave = customerRepository.save(customer);

        return customerSave;
    }

    @Override
    public Customer updateCustomer(String id, Customer newCustomer) {

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        if (newCustomer.getFirst_name() != null || !newCustomer.getFirst_name().isEmpty()) {
            String newName = newCustomer.getFirst_name();
            existingCustomer.setFirst_name(newName);
        }
        if (newCustomer.getLast_name() != null || !newCustomer.getLast_name().isEmpty()) {
            String last_Name = newCustomer.getLast_name();
            existingCustomer.setLast_name(last_Name);
        }
        if (newCustomer.getAddress() != null || !newCustomer.getAddress().isEmpty()) {
            String address = newCustomer.getAddress();
            existingCustomer.setAddress(address);
        }
        if (newCustomer.getCity() != null || !newCustomer.getCity().isEmpty()) {
            String city = newCustomer.getCity();
            existingCustomer.setCity(city);
        }

        if (newCustomer.getEmail() != null || !newCustomer.getEmail().isEmpty()) {
            String email = newCustomer.getEmail();
            existingCustomer.setEmail(email);
        }
        if (newCustomer.getEmail() != null || !newCustomer.getEmail().isEmpty()) {
            String email = newCustomer.getEmail();
            existingCustomer.setEmail(email);
        }

        if (newCustomer.getPhone() != null || !newCustomer.getPhone().isEmpty()) {
            String phone = newCustomer.getPhone();
            existingCustomer.setPhone(phone);
        }

        if (newCustomer.getState() != null || !newCustomer.getState().isEmpty()) {
            String state = newCustomer.getState();
            existingCustomer.setState(state);
        }


        if (newCustomer.getStreet() != null || !newCustomer.getStreet().isEmpty()) {
            String street = newCustomer.getStreet();
            existingCustomer.setStreet(street);
        }
        Customer updateCustomer = customerRepository.save(existingCustomer);
        return updateCustomer;
    }


    @Override
    public PostResponse getAllCustomerByPaging(Integer pageNumber, Integer pageSize, String sortBy) {

        PageRequest pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Customer> pageCustomers = customerRepository.findAll(pageable);
        List<Customer> allCustomers = pageCustomers.getContent();
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(allCustomers);
        postResponse.setPageSize(pageCustomers.getSize());
        postResponse.setPageNumber(pageCustomers.getNumber());
        postResponse.setTotalElements((int) pageCustomers.getTotalElements());
        postResponse.setLastPage(pageCustomers.isLast());
        postResponse.setTotalPages(pageCustomers.getTotalPages());
        return postResponse;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    @Override
    public Customer getCustomerById(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return customer;

    }

    @Override
    public String deleteCustomerById(String customerUuid) {

        if (!customerRepository.existsById(customerUuid)) {
            throw new UserNotFoundException(customerUuid);
        }
        customerRepository.deleteById(customerUuid);
        return "Customer with " + customerUuid + "has been deleted Success !! ";
    }

    @Override
    public List<Customer> createListOfCustomer(List<Customer> customerList) {
        for (Customer customer : customerList) {
            String custUUID = UUID.randomUUID().toString();
            customer.setCustId(custUUID);
        }
        List<Customer> customers = customerRepository.saveAll(customerList);
        return customers;
    }

    @Override
    public List<Customer> searchCustomerByName(String customerName) {
        List<Customer> customerList = customerRepository.findByFirstName("%"+customerName+"%");
        return customerList;
    }

    @Override
    public List<Customer> searchCustomerByCity(String customerCity) {
        List<Customer> customerList = customerRepository.findByCity("%"+customerCity+"%");
        return customerList;
    }

    @Override
    public List<Customer> searchCustomerByEmail(String customerEmail) {
        List<Customer> customerList = customerRepository.findByEmail("%"+customerEmail+"%");
        return customerList;
    }

    @Override
    public List<Customer> searchCustomerByPhone(String customerPhone) {
        List<Customer> customerList = customerRepository.findByPhone("%"+customerPhone+"%");
        return customerList;
    }
}