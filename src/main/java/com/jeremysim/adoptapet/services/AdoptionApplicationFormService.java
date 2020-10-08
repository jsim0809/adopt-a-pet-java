package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationForm;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationFormService {

  private AdoptablePetRepository adoptablePetRepo;
  private AdoptionApplicationRepository adoptionApplicationRepo;

  @Autowired
  public AdoptionApplicationFormService(
      AdoptablePetRepository adoptablePetRepo,
      AdoptionApplicationRepository adoptionApplicationRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
    this.adoptionApplicationRepo = adoptionApplicationRepo;
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

  public void update(Integer formId, AdoptionApplicationForm form) {
    AdoptionApplication currentApp = adoptionApplicationRepo.findById(formId).get();
    AdoptionApplication newApp = toApplication(form);
    currentApp.setName(newApp.getName());
    currentApp.setPhoneNumber(newApp.getPhoneNumber());
    currentApp.setEmail(newApp.getEmail());
    currentApp.setHomeStatus(newApp.getHomeStatus());
    adoptionApplicationRepo.save(currentApp);
  }
}
