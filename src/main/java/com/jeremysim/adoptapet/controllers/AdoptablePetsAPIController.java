package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdoptablePetsAPIController {

  private PetTypeRepository petTypeRepo;
  private AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public AdoptablePetsAPIController(
      PetTypeRepository petTypeRepo,
      AdoptablePetRepository adoptablePetRepo) {
    this.petTypeRepo = petTypeRepo;
    this.adoptablePetRepo = adoptablePetRepo;
  }

  @GetMapping("/adoptable_pets")
  public Iterable<AdoptablePet> getPetsByType(@RequestParam Integer type) {
    PetType petType = petTypeRepo.findById(type).get();
    return adoptablePetRepo.findByAdoptablePetType(petType);
  }
}
