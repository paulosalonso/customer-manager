package com.github.paulosalonso.customer.usecase.port.city;

import com.github.paulosalonso.customer.domain.PostalCodeInfo;

import java.util.Optional;

public interface GetPostalCodeInfoPort {
    Optional<PostalCodeInfo> getPostalCodeInfo(String postalCode);
}
