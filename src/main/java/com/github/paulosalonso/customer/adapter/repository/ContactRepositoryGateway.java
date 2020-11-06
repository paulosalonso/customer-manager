package com.github.paulosalonso.customer.adapter.repository;

import com.github.paulosalonso.customer.adapter.repository.mapper.ContactEntityMapper;
import com.github.paulosalonso.customer.domain.Contact;
import com.github.paulosalonso.customer.usecase.port.contact.CreateContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.DeleteContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.ReadContactPort;
import com.github.paulosalonso.customer.usecase.port.contact.UpdateContactPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.github.paulosalonso.customer.adapter.repository.mapper.ContactEntityMapper.*;

@Repository
public class ContactRepositoryGateway implements ReadContactPort, CreateContactPort, DeleteContactPort, UpdateContactPort {

    private final ContactRepository repository;

    public ContactRepositoryGateway(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact create(Contact contact) {
        return to(repository.save(from(contact)));
    }

    @Override
    public void delete(Contact contact) {
        repository.delete(from(contact));
    }

    @Override
    public void deleteById(Long customerId, Long contactId) {
        repository.deleteById(contactId);
    }

    @Override
    public boolean existsById(Long customerId, Long contactId) {
        return repository.existsByCustomerIdAndId(customerId, contactId);
    }

    @Override
    public Optional<Contact> findById(Long customerId, Long contactId) {
        return repository.findByCustomerIdAndId(customerId, contactId).map(ContactEntityMapper::to);
    }

    @Override
    public List<Contact> findAll(Long customerId) {
        return toList(repository.findByCustomerId(customerId));
    }

    @Override
    public Contact update(Contact contact) {
        return to(repository.save(from(contact)));
    }
}
