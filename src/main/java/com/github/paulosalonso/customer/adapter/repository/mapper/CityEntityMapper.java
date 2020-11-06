package com.github.paulosalonso.customer.adapter.repository.mapper;

import com.github.paulosalonso.customer.adapter.repository.model.CityEntity;
import com.github.paulosalonso.customer.domain.City;

import java.util.List;
import java.util.stream.Collectors;

public interface CityEntityMapper {

    static CityEntity from(City city) {
        return CityEntity.of()
                .ibgeCode(city.getIbgeCode())
                .name(city.getName())
                .state(city.getState())
                .build();
    }

    static City to(CityEntity city) {
        return City.of()
                .ibgeCode(city.getIbgeCode())
                .name(city.getName())
                .state(city.getState())
                .build();
    }

    static List<City> toList(List<CityEntity> entities) {
        return entities.stream()
                .map(CityEntityMapper::to)
                .collect(Collectors.toList());
    }

}
