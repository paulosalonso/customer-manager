package com.github.paulosalonso.customer.usecase.port.customer;

import com.github.paulosalonso.customer.domain.Customer;

public interface DeleteCustomerPort {
    void delete(Customer customer);
    void deleteById(Long id);
}
