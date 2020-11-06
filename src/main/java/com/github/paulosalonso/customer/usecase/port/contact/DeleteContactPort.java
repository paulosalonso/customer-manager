package com.github.paulosalonso.customer.usecase.port.contact;

import com.github.paulosalonso.customer.domain.Contact;

public interface DeleteContactPort {
    void delete(Contact contact);
    void deleteById(Long customerId, Long contactId);
}
