package com.jeremysim.petAdoption.repositories;

import com.jeremysim.petAdoption.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {

}
