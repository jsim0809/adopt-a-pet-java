package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSurrenderApplicationRepository extends CrudRepository<PetSurrenderApplication, Integer> {

}
