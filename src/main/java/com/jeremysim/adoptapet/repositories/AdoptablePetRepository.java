package com.jeremysim.adoptapet.repositories;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetType;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetRepository extends CrudRepository<AdoptablePet, Integer> {
  Optional<AdoptablePet> findByName(String name);
  Iterable<AdoptablePet> findByAdoptablePetType(PetType type);
}
