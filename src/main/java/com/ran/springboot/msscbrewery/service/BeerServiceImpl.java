package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements  BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Carlsberg").beerStyle("Greek Style").build();
    }
}
