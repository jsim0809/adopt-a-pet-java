package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.AdoptablePet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetRepository extends CrudRepository<AdoptablePet, Integer> {

}
