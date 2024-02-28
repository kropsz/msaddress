package com.compassuol.sp.challenge.msaddress.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.compassuol.sp.challenge.msaddress.dto.ViaCepDto;
import com.compassuol.sp.challenge.msaddress.feign.ViaCepFeign;

@SpringBootTest
public class ViaCepFeignTest {

    @MockBean
    private ViaCepFeign viaCepFeign;

    @Test
    public void testBuscarEnderecoCep() {
        String postalCode = "01001000";
        ViaCepDto viaCepDto = new ViaCepDto(
                "01001000",
                "Praça da Sé",
                "Sé",
                "Liberdade",
                "São Paulo",
                "SP");

        Mockito.when(viaCepFeign.bucarEnderecoCep(postalCode)).thenReturn(viaCepDto);

        ViaCepDto result = viaCepFeign.bucarEnderecoCep(postalCode);

        assertEquals(viaCepDto, result);
    }
}