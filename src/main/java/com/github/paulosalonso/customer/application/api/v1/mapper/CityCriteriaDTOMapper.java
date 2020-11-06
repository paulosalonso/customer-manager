package com.github.paulosalonso.customer.application.api.v1.mapper;

import com.github.paulosalonso.customer.adapter.controller.model.city.CityCriteriaAdapter;
import com.github.paulosalonso.customer.application.api.v1.model.city.CityCriteriaDTO;
import org.springframework.data.domain.Pageable;

public interface CityCriteriaDTOMapper {

    static CityCriteriaAdapter to(CityCriteriaDTO dto, Pageable pageable) {
        return CityCriteriaAdapter.of()
                .name(dto.getName())
                .state(dto.getState())
                .page(pageable.getPageNumber())
                .size(pageable.getPageSize())
                .sort(SortMapper.to(pageable))
                .build();
    }

}
