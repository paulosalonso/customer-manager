package com.github.paulosalonso.customer.usecase.customer;

import com.github.paulosalonso.customer.domain.Customer;
import com.github.paulosalonso.customer.usecase.city.CreateCity;
import com.github.paulosalonso.customer.usecase.port.customer.UpdateCustomerPort;

public class UpdateCustomer {

    private final UpdateCustomerPort updateCustomerPort;
    private final CreateCity createCity;

    public UpdateCustomer(UpdateCustomerPort updateCustomerPort, CreateCity createCity) {
        this.updateCustomerPort = updateCustomerPort;
        this.createCity = createCity;
    }

    public Customer update(Customer customer) {
        createCity.resolveCity(customer.getAddress());
        return updateCustomerPort.update(customer);
    }
}
