package com.github.paulosalonso.customer.usecase.mapper;

import com.github.paulosalonso.customer.domain.City;
import com.github.paulosalonso.customer.domain.PostalCodeInfo;

public interface PostalCodeInfoMapper {

    static City to(PostalCodeInfo postalCodeInfo) {
        return City.of()
                .ibgeCode(postalCodeInfo.getIbgeCode())
                .name(postalCodeInfo.getCityName())
                .state(postalCodeInfo.getStateInitials())
                .build();
    }
}
