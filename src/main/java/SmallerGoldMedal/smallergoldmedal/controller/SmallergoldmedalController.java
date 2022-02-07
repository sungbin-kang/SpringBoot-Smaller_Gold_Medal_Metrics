package SmallerGoldMedal.smallergoldmedal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/")
    public String index() {
       return "index";
    }

    // Example:
    // http://localhost:8080/countries?ascending=n&sortby=population
    @GetMapping("/countries")
    public String getCountries(Model model, @RequestParam(required = false) String sortby, @RequestParam(required = false) String ascending) {

        sortby = sortby == null ? "name" : sortby.toLowerCase();
        
        Sort sort = ascending == null || ascending.toLowerCase().equals("y") ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();

        Iterable<Country> countires = countryRepository.findAll(sort);

        model.addAttribute("countries", countires);
        
        return "countries";
    }

    // Example:
    // http://localhost:8080/Australia
    @GetMapping("/{countryName}")
    public String getCountryDetails(Model model, @PathVariable String countryName) {

        Optional<Country> countryOptional = countryRepository.findByName(countryName);

        if (countryOptional.isEmpty()) {
            return countryName + " not found";
        }

        Country country = countryOptional.get();

        var goldMedalCount = goldmedalRepository.countByCountry(countryName); // get the medal count (*of this country)

        Sort sort = Sort.by("year").ascending();

        // --- SUMMER EVENTS DETAILS --- 
        
        var summerWins = goldmedalRepository.findByCountryAndSeason(countryName, "Summer", sort); // get the collection of wins at the Summer Olympics, sorted by year in ascending order

        var numberSummerWins = summerWins.size() > 0 ? summerWins.size() : null;
        var totalSummerEvents = goldmedalRepository.countBySeason("Summer"); // get the total number of events at the Summer Olympics
        var percentageTotalSummerWins = totalSummerEvents != 0 && numberSummerWins != null ? (float) summerWins.size() / totalSummerEvents : null;
        var yearFirstSummerWin = summerWins.size() > 0 ? summerWins.get(0).getYear() : null;

        // --- WINTER EVENTS DETAILS ---

        var winterWins = goldmedalRepository.findByCountryAndSeason(countryName, "Winter", sort); // get the collection of wins at the Winter Olympics

        var numberWinterWins = winterWins.size() > 0 ? winterWins.size() : null; // get the total number of events at the Winter Olympics, sorted by year in ascending order
        var totalWinterEvents = goldmedalRepository.countBySeason("Winter");
        var percentageTotalWinterWins = totalWinterEvents != 0 && numberWinterWins != null ? (float) winterWins.size() / totalWinterEvents : null;
        var yearFirstWinterWin = winterWins.size() > 0 ? winterWins.get(0).getYear() : null;

        // --- GENDER EVENTS DETAILS ---
        var numberEventsWonByFemaleAthletes = goldmedalRepository.countByCountryAndGender(countryName, "Women"); // get the number of wins by female athletes
        var numberEventsWonByMaleAthletes = goldmedalRepository.countByCountryAndGender(countryName, "Men"); // get the number of wins by male athletes


        // --- ADD ATTRIBUTES ---

        model.addAttribute("country", country);
        model.addAttribute("goldMedalCount", goldMedalCount);

        model.addAttribute("numberSummerWins", numberSummerWins);
        model.addAttribute("percentageTotalSummerWins", percentageTotalSummerWins);
        model.addAttribute("yearFirstSummerWin", yearFirstSummerWin);

        model.addAttribute("numberWinterWins", numberWinterWins);
        model.addAttribute("percentageTotalWinterWins", percentageTotalWinterWins);
        model.addAttribute("yearFirstWinterWin", yearFirstWinterWin);

        model.addAttribute("numberEventsWonByFemaleAthletes", numberEventsWonByFemaleAthletes);
        model.addAttribute("numberEventsWonByMaleAthletes", numberEventsWonByMaleAthletes);

        return "countryDetails";
    }

    // Example:
    // http://localhost:8080/Australia/medals
    @GetMapping("{countryName}/medals")
    public String getCountryMedalsList(Model model, @PathVariable String countryName, @RequestParam(required = false) String sortby, @RequestParam(required = false) String ascending) {

        List<GoldMedal> medalList;

        sortby = sortby == null ? "year" : sortby;

        Sort sort = ascending == null || ascending.equals("y") ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();

        medalList = goldmedalRepository.findByCountry(countryName, sort);

        model.addAttribute("medalList", medalList);
        
        return "countryMedalList";
    }

}
