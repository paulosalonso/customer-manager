package com.github.paulosalonso.customer.adapter.controller.mapper;

import com.github.paulosalonso.customer.usecase.Criteria.SortDirection;
import org.springframework.data.domain.Pageable;

import java.util.Map;

import static com.github.paulosalonso.customer.usecase.Criteria.SortDirection.ASC;
import static com.github.paulosalonso.customer.usecase.Criteria.SortDirection.DESC;
import static java.util.stream.Collectors.toMap;

public interface SortMapper {

    static Map<String, SortDirection> to(Pageable pageable) {
        return pageable.getSort().stream()
                .collect(toMap(order -> order.getProperty(), order -> order.isAscending() ? ASC : DESC));
    }

}
