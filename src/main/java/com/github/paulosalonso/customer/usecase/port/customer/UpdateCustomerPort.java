package com.github.paulosalonso.customer.usecase.port.customer;

import com.github.paulosalonso.customer.domain.Customer;

public interface UpdateCustomerPort {
    Customer update(Customer customer);
}
