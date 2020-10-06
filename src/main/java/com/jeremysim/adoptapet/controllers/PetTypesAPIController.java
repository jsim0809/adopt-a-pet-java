package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetTypesAPIController {

  private PetTypeRepository petTypeRepo;

  @Autowired
  public PetTypesAPIController(PetTypeRepository petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }

  @GetMapping("/pet_types")
  public Iterable<PetType> getAllPetTypes() {
    return petTypeRepo.findAll();
  }
}
