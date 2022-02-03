package SmallerGoldMedal.smallergoldmedal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SmallerGoldMedal.smallergoldmedal.repositories.CountryRepository;
import SmallerGoldMedal.smallergoldmedal.repositories.GoldMedalRepository;

import SmallerGoldMedal.smallergoldmedal.model.Country;
import SmallerGoldMedal.smallergoldmedal.model.GoldMedal;

@RestController
public class SmallergoldmedalController {

    private final CountryRepository countryRepository;
    private final GoldMedalRepository goldmedalRepository;
    
    public SmallergoldmedalController(final CountryRepository countryRepository, final GoldMedalRepository goldmedalRepository) {
        this.countryRepository = countryRepository;
        this.goldmedalRepository = goldmedalRepository;
    }

    @GetMapping("/countries")
    public Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }

}
