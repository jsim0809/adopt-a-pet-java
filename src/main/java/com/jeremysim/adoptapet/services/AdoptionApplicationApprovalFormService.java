package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationApprovalForm;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationApprovalFormService {

  private AdoptionApplicationRepository adoptionApplicationRepo;
  private AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public AdoptionApplicationApprovalFormService(
      AdoptionApplicationRepository adoptionApplicationRepo,
      AdoptablePetRepository adoptablePetRepo) {
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.adoptablePetRepo = adoptablePetRepo;
  }

  public void process(AdoptionApplicationApprovalForm form) {
    AdoptionApplication application = adoptionApplicationRepo.findById(form.getApplicationId()).get();
    AdoptablePet pet = adoptablePetRepo.findById(form.getPetId()).get();
    application.setApplicationStatus(form.getApprovalStatus());
    pet.setAdoptionStatus(form.getApprovalStatus());
    adoptionApplicationRepo.save(application);
    adoptablePetRepo.save(pet);
  }
}
