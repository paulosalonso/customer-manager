package com.github.paulosalonso.customer.adapter.controller.mapper;

import com.github.paulosalonso.customer.adapter.controller.model.city.CityResponseAdapter;
import com.github.paulosalonso.customer.adapter.controller.model.customer.AddressAdapter;
import com.github.paulosalonso.customer.domain.Address;
import com.github.paulosalonso.customer.domain.City;

public interface AddressAdapterMapper {

    static Address to(AddressAdapter dto) {
        City city = null;

        if (dto.getCity() != null) {
            city = CityAdapterMapper.to(dto.getCity());
        }

        return Address.of()
                .city(city)
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .district(dto.getDistrict())
                .postalCode(dto.getPostalCode())
                .build();
    }

    static AddressAdapter from(Address address) {
        CityResponseAdapter city = null;

        if (address.getCity() != null) {
            city = CityAdapterMapper.from(address.getCity());
        }

        return AddressAdapter.of()
                .city(city)
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .district(address.getDistrict())
                .postalCode(address.getPostalCode())
                .build();
    }
}
