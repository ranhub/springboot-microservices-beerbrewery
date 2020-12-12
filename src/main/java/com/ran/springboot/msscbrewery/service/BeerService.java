package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}