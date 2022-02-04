package SmallerGoldMedal.smallergoldmedal.controller;

import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import SmallerGoldMedal.smallergoldmedal.repositories.CountryRepository;
import SmallerGoldMedal.smallergoldmedal.repositories.GoldMedalRepository;

import SmallerGoldMedal.smallergoldmedal.model.Country;
import SmallerGoldMedal.smallergoldmedal.model.GoldMedal;


@Controller
@RequestMapping("/")
public class SmallergoldmedalController {

    private final CountryRepository countryRepository;
    private final GoldMedalRepository goldmedalRepository;
    
    public SmallergoldmedalController(final CountryRepository countryRepository, final GoldMedalRepository goldmedalRepository) {
        this.countryRepository = countryRepository;
        this.goldmedalRepository = goldmedalRepository;
    }

    // @GetMapping("/countries")
    // public Iterable<Country> getCountries() {
    //     return countryRepository.findAll();
    // }

    @GetMapping("/")
    public String index() {
       return "index";
    }


    // Example:
    // http://localhost:8080/countries?ascending=n&sort_by=population
    @GetMapping("/countries")
    public String getCountries(Model model, @RequestParam(required = false) String sortby, @RequestParam(required = false) String ascending) {

        sortby = sortby == null ? "name" : sortby.toLowerCase();
        
        Sort sort = ascending == null || ascending.toLowerCase().equals("y") ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();

        Iterable<Country> countires = countryRepository.findAll(sort);

        model.addAttribute("countries", countires);
        
        return "countries";
    }

}
