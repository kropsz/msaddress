package com.compassuol.sp.challenge.msaddress.commons;

import com.compassuol.sp.challenge.msaddress.dto.ViaCepDto;
import com.compassuol.sp.challenge.msaddress.model.Address;

public class AddressConstants {

        public static final Address ADDRESS_VALID = new Address(1L,
                        "Rua dos Bobos",
                        "Perto dali",
                        "Laranjeiras",
                        "São Paulo",
                        "SP",
                        "00000-000");

        public static final ViaCepDto VIA_CEP_DTO_VALID = new ViaCepDto(
                        "00000-000",
                        "Rua dos Bobos",
                        "Perto dali",
                        "Laranjeiras",
                        "São Paulo",
                        "SP"

        );
}
