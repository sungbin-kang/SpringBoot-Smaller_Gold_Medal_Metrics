package SmallerGoldMedal.smallergoldmedal.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository; // for findAll(Sort sort)

import SmallerGoldMedal.smallergoldmedal.model.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
    
}
