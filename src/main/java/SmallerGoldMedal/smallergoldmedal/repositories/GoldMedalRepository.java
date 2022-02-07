package SmallerGoldMedal.smallergoldmedal.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import SmallerGoldMedal.smallergoldmedal.model.GoldMedal;

public interface GoldMedalRepository extends PagingAndSortingRepository<GoldMedal, Integer> {

    List<GoldMedal> findByCountry(String country, Sort sort);

    List<GoldMedal> findByCountryAndSeason(String country, String season, Sort sort);
    
    long countByCountry(String country);

    long countBySeason(String season);

    long countByCountryAndGender(String country, String gender);
}
