package com.github.paulosalonso.customer.adapter.controller;

import com.github.paulosalonso.customer.adapter.controller.mapper.CustomerAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.mapper.CustomerCriteriaAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.mapper.PageAdapterMapper;
import com.github.paulosalonso.customer.adapter.controller.model.PageAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerCreateAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerCriteriaAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerResponseAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerUpdateAdapter;
import com.github.paulosalonso.customer.domain.Customer;
import com.github.paulosalonso.customer.usecase.Page;
import com.github.paulosalonso.customer.usecase.customer.CreateCustomer;
import com.github.paulosalonso.customer.usecase.customer.DeleteCustomer;
import com.github.paulosalonso.customer.usecase.customer.ReadCustomer;
import com.github.paulosalonso.customer.usecase.customer.UpdateCustomer;

import static com.github.paulosalonso.customer.adapter.controller.mapper.CustomerAdapterMapper.from;
import static com.github.paulosalonso.customer.adapter.controller.mapper.CustomerAdapterMapper.to;

public class CustomerController {

    private final CreateCustomer createCustomer;
    private final ReadCustomer readCustomer;
    private final UpdateCustomer updateCustomer;
    private final DeleteCustomer deleteCustomer;

    public CustomerController(CreateCustomer createCustomer,
            ReadCustomer readCustomer, UpdateCustomer updateCustomer, DeleteCustomer deleteCustomer) {
        this.createCustomer = createCustomer;
        this.readCustomer = readCustomer;
        this.updateCustomer = updateCustomer;
        this.deleteCustomer = deleteCustomer;
    }

    public PageAdapter<CustomerResponseAdapter> search(CustomerCriteriaAdapter customerCriteriaAdapter) {
        Page<Customer> page = readCustomer.findByCriteria(CustomerCriteriaAdapterMapper.to(customerCriteriaAdapter));
        return PageAdapterMapper.from(page, CustomerAdapterMapper::fromList);
    }

    public CustomerResponseAdapter create(CustomerCreateAdapter customerCreateAdapter) {
        return from(createCustomer.create(to(customerCreateAdapter)));
    }

    public CustomerResponseAdapter read(Long id) {
        Customer customer = readCustomer.findById(id);
        return from(customer);
    }

    public CustomerResponseAdapter update(Long id, CustomerUpdateAdapter customerUpdateAdapter) {
        Customer customer = readCustomer.findById(id);
        customer = updateCustomer.update(to(customerUpdateAdapter, customer));
        return from(customer);
    }

    public void delete(Long id) {
        deleteCustomer.deleteById(id);
    }
}
