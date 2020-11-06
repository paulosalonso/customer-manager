package com.github.paulosalonso.customer.usecase.port.customer;

import com.github.paulosalonso.customer.domain.Customer;
import com.github.paulosalonso.customer.usecase.Page;

import java.util.List;
import java.util.Optional;

public interface ReadCustomerPort {

    boolean existsById(Long id);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    Page<Customer> findByCriteria(CustomerCriteria criteria);

}
