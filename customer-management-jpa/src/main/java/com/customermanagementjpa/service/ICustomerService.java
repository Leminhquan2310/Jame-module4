package com.customermanagementjpa.service;

import com.customermanagementjpa.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}