package com.github.paulosalonso.customer.adapter.repository.mapper;

import com.github.paulosalonso.customer.usecase.Page;

import java.util.List;
import java.util.function.Function;

public interface PageMapper {

    static <I, O> Page<O> to(org.springframework.data.domain.Page<I> page, Function<List<I>, List<O>> contentMapper) {
        return Page.of()
                .page(page.getNumber())
                .pageSize(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .totalSize(Long.valueOf(page.getTotalElements()).intValue())
                .content(contentMapper.apply(page.getContent()))
                .build();
    }

}
