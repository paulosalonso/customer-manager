package com.github.paulosalonso.customer.adapter.repository.postalcode.viacep;

import com.github.paulosalonso.customer.domain.PostalCodeInfo;

public interface ViaCEPResponseMapper {

    static PostalCodeInfo to(ViaCEPResponse response) {
        return PostalCodeInfo.of()
                .cityName(response.getLocalidade())
                .complement(response.getComplemento())
                .district(response.getBairro())
                .ibgeCode(response.getIbge())
                .postalCode(response.getCep())
                .stateInitials(response.getUf())
                .street(response.getLogradouro())
                .build();
    }
}
