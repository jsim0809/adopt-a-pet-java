package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {

}
