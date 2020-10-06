package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.PetSurrenderApplicationForm;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationFormRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet_surrender_applications")
public class PetSurrenderApplicationFormsAPIController {

  private PetSurrenderApplicationFormRepository petSurrenderApplicationFormRepo;

  @Autowired
  public PetSurrenderApplicationFormsAPIController(
      PetSurrenderApplicationFormRepository petSurrenderApplicationRepo) {
    this.petSurrenderApplicationFormRepo = petSurrenderApplicationRepo;
  }

  @PostMapping
  public ResponseEntity postForm(@Valid @RequestBody PetSurrenderApplicationForm form,
      BindingResult binding) {

  }

}
