package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationApprovalForm;
import com.jeremysim.adoptapet.models.AdoptionApplicationForm;
import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationApprovalForm;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationForm;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import com.jeremysim.adoptapet.services.PetSurrenderApplicationApprovalFormService;
import com.jeremysim.adoptapet.services.PetSurrenderApplicationFormService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet_surrender_applications")
public class PetSurrenderApplicationsAPIController {

  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;
  private PetSurrenderApplicationFormService petSurrenderApplicationFormService;
  private PetSurrenderApplicationApprovalFormService petSurrenderApplicationApprovalFormService;

  @Autowired
  public PetSurrenderApplicationsAPIController(
      PetSurrenderApplicationRepository petSurrenderApplicationRepo,
      PetSurrenderApplicationFormService petSurrenderApplicationFormService,
      PetSurrenderApplicationApprovalFormService petSurrenderApplicationApprovalFormService) {
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
    this.petSurrenderApplicationFormService = petSurrenderApplicationFormService;
    this.petSurrenderApplicationApprovalFormService = petSurrenderApplicationApprovalFormService;
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

  @PutMapping
  public ResponseEntity editApplication(@Valid @RequestBody PetSurrenderApplicationForm form,
      BindingResult binding, @RequestParam Integer id) {
    if(binding.hasErrors()) {
      return new ResponseEntity<List>(binding.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      petSurrenderApplicationFormService.update(id, form);
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  @GetMapping
  public Iterable<PetSurrenderApplication> getAll() {
    return petSurrenderApplicationRepo.findAll();
  }

  @PostMapping("/approve")
  public ResponseEntity approveApplication(@Valid @RequestBody PetSurrenderApplicationApprovalForm form,
      BindingResult binding) {
    if(binding.hasErrors()) {
      return new ResponseEntity<List>(binding.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      petSurrenderApplicationApprovalFormService.process(form);
      return new ResponseEntity<AdoptionApplication>(HttpStatus.OK);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteApplication(@PathVariable Integer id) {
    petSurrenderApplicationRepo.deleteById(id);
    return new ResponseEntity(HttpStatus.OK);
  }
}
