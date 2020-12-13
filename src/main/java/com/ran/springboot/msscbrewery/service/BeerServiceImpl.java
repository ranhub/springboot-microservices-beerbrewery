package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements  BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Carlsberg").beerStyle("Greek Style").build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug(" In to updated beer with ID" + beerId);
        // add implementation for update beer
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug(" In to delete beer with ID" + beerId);
        // add implementation for delete beer
    }
}
