package SmallerGoldMedal.smallergoldmedal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

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

    @GetMapping("/countries")
    public String getCountries(Model model) {
        Iterable<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        
        return "countries";
    }

}
