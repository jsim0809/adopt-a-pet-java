package com.jeremysim.adoptapet.services;

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
        form.getApplicationStatus());
  }

}
