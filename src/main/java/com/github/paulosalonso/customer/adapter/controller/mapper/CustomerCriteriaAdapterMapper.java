package com.github.paulosalonso.customer.adapter.controller.mapper;

import com.github.paulosalonso.customer.adapter.controller.model.customer.CustomerCriteriaAdapter;
import com.github.paulosalonso.customer.usecase.port.customer.CustomerCriteria;

public interface CustomerCriteriaAdapterMapper {

    static CustomerCriteria to(CustomerCriteriaAdapter dto) {
        return CustomerCriteria.of()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .page(dto.getPage())
                .size(dto.getSize())
                .sort(dto.getSort())
                .build();
    }

}
