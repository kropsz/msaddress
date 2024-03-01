package com.compassuol.sp.challenge.msaddress.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassuol.sp.challenge.msaddress.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
    Optional<Address> findByCep(String cep);

}
