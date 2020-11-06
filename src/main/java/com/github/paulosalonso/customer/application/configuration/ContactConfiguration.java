package com.github.paulosalonso.customer.application.configuration;

import com.github.paulosalonso.customer.adapter.controller.CustomerContactController;
import com.github.paulosalonso.customer.usecase.contact.CreateContact;
import com.github.paulosalonso.customer.usecase.contact.DeleteContact;
import com.github.paulosalonso.customer.usecase.contact.ReadContact;
import com.github.paulosalonso.customer.usecase.contact.UpdateContact;
import com.github.paulosalonso.customer.usecase.port.contact.CreateContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.DeleteContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.ReadContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.UpdateContactPort;
import com.github.paulosalonso.customer.usecase.port.customer.ReadCustomerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfiguration {

    @Bean
    public CreateContact createContact(CreateContactPort createContactPort, ReadCustomerPort readCustomerPort) {
        return new CreateContact(createContactPort, readCustomerPort);
    }

    @Bean
    public ReadContact readContact(ReadContactPort readContactPort, ReadCustomerPort readCustomerPort) {
        return new ReadContact(readContactPort, readCustomerPort);
    }

    @Bean
    public UpdateContact updateContact(UpdateContactPort updateContactPort,
            ReadContactPort readContactPort, ReadCustomerPort readCustomerPort) {
        return new UpdateContact(updateContactPort, readContactPort, readCustomerPort);
    }

    @Bean
    public DeleteContact deleteContact(DeleteContactPort deleteContactPort, ReadContactPort readContactPort) {
        return new DeleteContact(deleteContactPort, readContactPort);
    }

    @Bean
    public CustomerContactController customerContactController(CreateContact createContact,
                       ReadContact readContact, UpdateContact updateContact, DeleteContact deleteContact) {
        return new CustomerContactController(createContact, readContact, updateContact, deleteContact);
    }

}
