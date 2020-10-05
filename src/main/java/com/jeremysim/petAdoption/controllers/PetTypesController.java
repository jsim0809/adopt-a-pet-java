package com.jeremysim.petAdoption.controllers;

import com.jeremysim.petAdoption.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetTypesController {

  private PetTypeRepository petTypeRepo;

  @Autowired
  public PetTypesController(PetTypeRepository petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }


}
