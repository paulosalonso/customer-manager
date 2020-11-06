package com.github.paulosalonso.customer.adapter.repository.specification;

import com.github.paulosalonso.customer.adapter.repository.model.CustomerEntity;
import com.github.paulosalonso.customer.usecase.port.customer.CustomerCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static com.github.paulosalonso.customer.adapter.repository.specification.LikeValueResolver.contains;

public interface CustomerSpecificationFactory {

    static Specification<CustomerEntity> findByCustomerCriteria(CustomerCriteria customerCriteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (customerCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(
                        root.get("name"), contains(customerCriteria.getName())));
            }

            if (customerCriteria.getCpf() != null) {
                predicates.add(criteriaBuilder.equal(root.get("cpf"), customerCriteria.getCpf()));
            }

            if (customerCriteria.getGender() != null) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), customerCriteria.getGender()));
            }

            if (customerCriteria.getBirthDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("birthDate"), customerCriteria.getBirthDate()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
