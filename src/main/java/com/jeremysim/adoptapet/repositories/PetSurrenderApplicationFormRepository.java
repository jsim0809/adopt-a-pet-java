package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.PetSurrenderApplicationForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSurrenderApplicationFormRepository extends CrudRepository<PetSurrenderApplicationForm, Integer> {

}
