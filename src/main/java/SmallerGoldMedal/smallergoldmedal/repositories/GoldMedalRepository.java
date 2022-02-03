package SmallerGoldMedal.smallergoldmedal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import SmallerGoldMedal.smallergoldmedal.model.GoldMedal;

public interface GoldMedalRepository extends CrudRepository<GoldMedal, Integer> {
    
}
