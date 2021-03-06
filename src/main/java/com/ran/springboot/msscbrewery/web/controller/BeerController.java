package com.ran.springboot.msscbrewery.web.controller;

import com.ran.springboot.msscbrewery.service.BeerService;
import com.ran.springboot.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

  public BeerService beerService;

  public BeerController(BeerService beerService) {
      this.beerService = beerService;
   }

   @GetMapping("/{beerId}")
   public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
   }

    @PostMapping() // create new beer entity
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto) {

        BeerDto savedBeerDto = beerService.saveBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/" + savedBeerDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer (@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
      beerService.updateBeer(beerId,beerDto);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
      beerService.deleteBeerById(beerId);
    }


}
