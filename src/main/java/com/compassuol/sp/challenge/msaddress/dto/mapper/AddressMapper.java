package com.compassuol.sp.challenge.msaddress.dto.mapper;

import com.compassuol.sp.challenge.msaddress.dto.AddressResponse;
import com.compassuol.sp.challenge.msaddress.dto.ViaCepDto;
import com.compassuol.sp.challenge.msaddress.model.Address;

public class AddressMapper {

    public static Address toAddress(ViaCepDto cep) {
        return Address.builder()
                .complemento(cep.getComplemento())
                .neighborhood(cep.getBairro())
                .city(cep.getLocalidade())
                .state(cep.getUf())
                .cep(cep.getCep())
                .street(cep.getLogradouro())
                .build();
    }

    public static AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .city(address.getCity())
                .state(address.getState())
                .cep(address.getCep())
                .build();
    }

}
