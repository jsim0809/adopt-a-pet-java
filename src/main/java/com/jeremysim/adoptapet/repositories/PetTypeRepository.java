package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.PetType;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
  Optional<PetType> findByTypeIgnoreCase(String type);
}
