package com.customermanage.service.impl;


import com.customermanage.model.Customer;
import com.customermanage.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleCustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1L, "Nguyen Khac Nhat", "nhat@codegym.vn", "Ha Noi"));
        customers.put(2, new Customer(2L, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Da Nang"));
        customers.put(3, new Customer(3L, "Le Thi Chau", "chau.le@codegym.vn", "Ha Noi"));
        customers.put(4, new Customer(4L, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sai Gon"));
        customers.put(5, new Customer(5L, "CodeGym", "codegym@codegym.vn", "Viet Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
//        customers.put(customer.getId(), customer);
    }
}