package com.customermanage.service;


import com.customermanage.model.Customer;
import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
}