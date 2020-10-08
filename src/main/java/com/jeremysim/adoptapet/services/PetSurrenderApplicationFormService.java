package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.AdoptionApplicationForm;
import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationForm;
import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetSurrenderApplicationFormService {

  private PetTypeRepository petTypeRepo;
  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;

  @Autowired
  public PetSurrenderApplicationFormService(
      PetTypeRepository petTypeRepo,
      PetSurrenderApplicationRepository petSurrenderApplicationRepo) {
    this.petTypeRepo = petTypeRepo;
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
  }

  public PetSurrenderApplication toApplication(PetSurrenderApplicationForm form) {
    PetType type = petTypeRepo.findById(form.getSurrenderedPetType()).get();
    return new PetSurrenderApplication(form.getName(),
        form.getPhoneNumber(),
        form.getEmail(),
        form.getPetName(),
        form.getPetAge(),
        type,
        form.getPetImageUrl(),
        form.getVaccinationStatus(),
        "pending");
  }

  public void update(Integer formId, PetSurrenderApplicationForm form) {
    PetSurrenderApplication currentApp = petSurrenderApplicationRepo.findById(formId).get();
    PetSurrenderApplication newApp = toApplication(form);
    currentApp.setName(newApp.getName());
    currentApp.setPhoneNumber(newApp.getPhoneNumber());
    currentApp.setEmail(newApp.getEmail());
    currentApp.setPetName(newApp.getPetName());
    currentApp.setPetAge(newApp.getPetAge());
    currentApp.setSurrenderedPetType(newApp.getSurrenderedPetType());
    currentApp.setPetImageUrl(newApp.getPetImageUrl());
    currentApp.setVaccinationStatus(newApp.getVaccinationStatus());
    petSurrenderApplicationRepo.save(currentApp);
  }
}
