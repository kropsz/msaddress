package com.compassuol.sp.challenge.msaddress.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compassuol.sp.challenge.msaddress.dto.mapper.AddressMapper;
import com.compassuol.sp.challenge.msaddress.feign.ViaCepFeign;
import com.compassuol.sp.challenge.msaddress.model.Address;
import com.compassuol.sp.challenge.msaddress.repo.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepFeign viaCepFeign;

    @Transactional
    public Address getAddressIdByCep(String cep) {
        try {
            Optional<Address> existingAddress = addressRepository.findByCep(cep);

            if (existingAddress.isPresent()) {
                return existingAddress.get();
            } else {
                Address address = AddressMapper.toAddress(viaCepFeign.bucarEnderecoCep(cep));
                return addressRepository.save(address);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o endereço pelo CEP: " + cep, e);
        }
    }
}