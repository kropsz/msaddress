package com.compassuol.sp.challenge.msaddress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compassuol.sp.challenge.msaddress.dto.AddressResponse;
import com.compassuol.sp.challenge.msaddress.dto.mapper.AddressMapper;
import com.compassuol.sp.challenge.msaddress.model.Address;
import com.compassuol.sp.challenge.msaddress.service.AddressService;

@RestController
@RequestMapping("/v1/address-api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/get-address-by-cep/{cep}")
    public ResponseEntity<AddressResponse> getAddressIdByCep(@PathVariable String cep) {
        Address address = addressService.getAddressIdByCep(cep);
        return ResponseEntity.ok(AddressMapper.toAddressResponse(address));
    }
}
