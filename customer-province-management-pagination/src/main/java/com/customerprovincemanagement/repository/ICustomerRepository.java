package com.customerprovincemanagement.repository;

import com.customerprovincemanagement.model.Customer;
import com.customerprovincemanagement.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
}
