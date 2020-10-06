package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.AdoptionApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionApplicationRepository extends CrudRepository<AdoptionApplication, Integer> {

}
