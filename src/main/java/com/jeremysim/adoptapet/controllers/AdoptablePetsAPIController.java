package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public Iterable<AdoptablePet> getPetsByType(@RequestParam String type) {
    PetType petType = petTypeRepo.findByTypeIgnoreCase(type).get();
    return adoptablePetRepo.findByAdoptablePetType(petType);
  }

  @GetMapping("/adoptable_pets/{id}")
  public AdoptablePet getPetById(@PathVariable Integer id) {
    return adoptablePetRepo.findById(id).get();
  }
}
