package com.jeremysim.adoptapet.controllers;

import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationApprovalForm;
import com.jeremysim.adoptapet.models.AdoptionApplicationForm;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import com.jeremysim.adoptapet.services.AdoptionApplicationApprovalFormService;
import com.jeremysim.adoptapet.services.AdoptionApplicationFormService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adoption_applications")
public class AdoptionApplicationsAPIController {

  private AdoptionApplicationRepository adoptionApplicationRepo;
  private AdoptionApplicationFormService adoptionApplicationFormService;
  private AdoptionApplicationApprovalFormService adoptionApplicationApprovalFormService;

  @Autowired
  public AdoptionApplicationsAPIController(
      AdoptionApplicationRepository adoptionApplicationRepo,
      AdoptionApplicationFormService adoptionApplicationFormService,
      AdoptionApplicationApprovalFormService adoptionApplicationApprovalFormService) {
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.adoptionApplicationFormService = adoptionApplicationFormService;
    this.adoptionApplicationApprovalFormService = adoptionApplicationApprovalFormService;
  }

  @PostMapping
  public ResponseEntity postApplication(@Valid @RequestBody AdoptionApplicationForm form,
      BindingResult binding) {
    if(binding.hasErrors()) {
      return new ResponseEntity<List>(binding.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      return new ResponseEntity<AdoptionApplication>(
          adoptionApplicationRepo.save(adoptionApplicationFormService.toApplication(form)),
          HttpStatus.CREATED);
    }
  }

  @GetMapping
  public Iterable<AdoptionApplication> getAll() {
    return adoptionApplicationRepo.findAll();
  }

  @PostMapping("/approve")
  public ResponseEntity approveApplication(@Valid @RequestBody AdoptionApplicationApprovalForm form,
      BindingResult binding) {
    if(binding.hasErrors()) {
      return new ResponseEntity<List>(binding.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      adoptionApplicationApprovalFormService.process(form);
      return new ResponseEntity<AdoptionApplication>(HttpStatus.OK);
    }
  }
}
