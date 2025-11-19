package com.customermanagementjpa.repository;

import com.customermanagementjpa.model.Customer;

public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
}