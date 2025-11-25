package com.customerprovincemanagement.repository;

import com.customerprovincemanagement.model.Customer;
import com.customerprovincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
