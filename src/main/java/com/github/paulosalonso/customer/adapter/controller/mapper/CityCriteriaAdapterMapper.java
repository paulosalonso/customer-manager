package com.github.paulosalonso.customer.adapter.controller.mapper;

import com.github.paulosalonso.customer.adapter.controller.model.city.CityCriteriaAdapter;
import com.github.paulosalonso.customer.usecase.port.city.CityCriteria;

public interface CityCriteriaAdapterMapper {

    static CityCriteria to(CityCriteriaAdapter dto) {
        return CityCriteria.of()
                .name(dto.getName())
                .state(dto.getState())
                .page(dto.getPage())
                .size(dto.getSize())
                .sort(dto.getSort())
                .build();
    }

}
