package com.compassuol.sp.challenge.msaddress.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.compassuol.sp.challenge.msaddress.dto.ViaCepDto;

@FeignClient(name = "ViaCep", url = "viacep.com.br/ws")
public interface ViaCepFeign {

    @GetMapping("/{postalCode}/json")
    ViaCepDto bucarEnderecoCep(@PathVariable("postalCode") String postalCode);
}