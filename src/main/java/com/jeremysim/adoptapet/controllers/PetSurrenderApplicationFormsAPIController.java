package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationForm;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import com.jeremysim.adoptapet.services.PetSurrenderApplicationFormService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet_surrender_applications")
public class PetSurrenderApplicationFormsAPIController {

  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;
  private PetSurrenderApplicationFormService petSurrenderApplicationFormService;

  @Autowired
  public PetSurrenderApplicationFormsAPIController(
      PetSurrenderApplicationRepository petSurrenderApplicationRepo,
      PetSurrenderApplicationFormService petSurrenderApplicationFormService) {
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
    this.petSurrenderApplicationFormService = petSurrenderApplicationFormService;
  }

  @PostMapping
  public ResponseEntity postForm(@Valid @RequestBody PetSurrenderApplicationForm form,
      BindingResult binding) {
    if(binding.hasErrors()) {
      return new ResponseEntity<List>(binding.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      return new ResponseEntity<PetSurrenderApplication>(
          petSurrenderApplicationRepo.save(petSurrenderApplicationFormService.toApplication(form)),
          HttpStatus.CREATED);
    }
  }

}
