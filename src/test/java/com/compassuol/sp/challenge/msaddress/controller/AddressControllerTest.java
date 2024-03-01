package com.compassuol.sp.challenge.msaddress.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.compassuol.sp.challenge.msaddress.model.Address;
import com.compassuol.sp.challenge.msaddress.service.AddressService;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    @Test
    public void testGetAddressIdByCep() throws Exception {
        String cep = "01001000";
        Address address = new Address(1l,
                "SP",
                "Praça da Sé",
                "Sé",
                "Liberdade",
                "São Paulo",
                "01001000");

        when(addressService.getAddressIdByCep(cep)).thenReturn(address);

        mockMvc.perform(get("/v1/address-api/get-address-by-cep/{cep}", cep)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cep", is(cep)));

    }
}