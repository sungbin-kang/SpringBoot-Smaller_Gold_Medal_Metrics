package SmallerGoldMedal.smallergoldmedal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import SmallerGoldMedal.smallergoldmedal.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    
}
