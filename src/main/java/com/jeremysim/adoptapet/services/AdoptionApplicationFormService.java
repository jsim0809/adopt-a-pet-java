package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationForm;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationFormService {

  private AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public AdoptionApplicationFormService(
      AdoptablePetRepository adoptablePetRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
  }

  public AdoptionApplication toApplication(AdoptionApplicationForm form) {
    AdoptablePet pet = adoptablePetRepo.findById(form.getPetId()).get();
    return new AdoptionApplication(form.getName(),
        form.getPhoneNumber(),
        form.getEmail(),
        form.getHomeStatus(),
        "pending",
        pet);
  }
}
