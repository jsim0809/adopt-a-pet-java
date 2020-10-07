package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adoptable_pets")
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

  @GetMapping
  public Iterable<AdoptablePet> getAllPets() {
    return adoptablePetRepo.findAll();
  }

  @GetMapping("/by_type")
  public Iterable<AdoptablePet> getPetsByType(@RequestParam String type) {
    PetType petType = petTypeRepo.findByTypeIgnoreCase(type).get();
    return adoptablePetRepo.findByAdoptablePetType(petType);
  }

  @GetMapping("/{species}/{id}")
  public ResponseEntity getPetById(@PathVariable String species, @PathVariable Integer id) {
    PetType type = petTypeRepo.findByTypeIgnoreCase(species).get();
    AdoptablePet pet = adoptablePetRepo.findById(id).get();
    if (pet.getAdoptablePetType().equals(type)) {
      return new ResponseEntity(pet, HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
