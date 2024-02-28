package com.compassuol.sp.challenge.msaddress.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.compassuol.sp.challenge.msaddress.commons.AddressConstants;
import com.compassuol.sp.challenge.msaddress.dto.ViaCepDto;
import com.compassuol.sp.challenge.msaddress.feign.ViaCepFeign;
import com.compassuol.sp.challenge.msaddress.model.Address;
import com.compassuol.sp.challenge.msaddress.repo.AddressRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private ViaCepFeign viaCepFeign;

    @Test
    public void getAddressIdByCepTest() {
        Address address = AddressConstants.ADDRESS_VALID;
        when(addressRepository.findByCep(anyString())).thenReturn(Optional.of(address));
        Address result = addressService.getAddressIdByCep(address.getCep());
        assertEquals(address, result);
    }

    @Test
    public void getAddressIdByCepNotFoundTest() {
        Address address = AddressConstants.ADDRESS_VALID;
        when(addressRepository.findByCep(anyString())).thenReturn(Optional.empty());
        ViaCepDto viaCepDto = AddressConstants.VIA_CEP_DTO_VALID;
        when(viaCepFeign.bucarEnderecoCep(anyString())).thenReturn(viaCepDto);
        Address result = addressService.getAddressIdByCep(address.getCep());
        when(null != result).thenReturn(true);
    }

    @Test
    public void getAddressIdByCep_WhenExceptionThrown_ThenRuntimeException() {
        String cep = "12345678";

        when(addressRepository.findByCep(cep)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            addressService.getAddressIdByCep(cep);
        });
    }
}
