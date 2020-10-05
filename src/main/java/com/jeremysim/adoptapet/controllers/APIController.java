package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class APIController {

  private PetTypeRepository petTypeRepo;
  private AdoptablePetRepository adoptablePetRepo;
  private AdoptionApplicationRepository adoptionApplicationRepo;
  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;

  @Autowired
  public APIController(PetTypeRepository petTypeRepo,
      AdoptablePetRepository adoptablePetRepo,
      AdoptionApplicationRepository adoptionApplicationRepo,
      PetSurrenderApplicationRepository petSurrenderApplicationRepo) {
    this.petTypeRepo = petTypeRepo;
    this.adoptablePetRepo = adoptablePetRepo;
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
  }

  @GetMapping("/pet_types")
  public Iterable<PetType> getAllPetTypes() {
    return petTypeRepo.findAll();
  }
}
