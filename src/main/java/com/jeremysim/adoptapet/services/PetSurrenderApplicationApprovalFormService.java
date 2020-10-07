package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationApprovalForm;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetSurrenderApplicationApprovalFormService {

  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;
  private AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public PetSurrenderApplicationApprovalFormService(
      PetSurrenderApplicationRepository petSurrenderApplicationRepo,
      AdoptablePetRepository adoptablePetRepo) {
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
    this.adoptablePetRepo = adoptablePetRepo;
  }

  public void process(PetSurrenderApplicationApprovalForm form) {
    PetSurrenderApplication application = petSurrenderApplicationRepo.findById(form.getApplicationId()).get();
    application.setApplicationStatus(form.getApprovalStatus());
    adoptablePetRepo.save(
        new AdoptablePet(
            application.getPetName(),
            application.getPetImageUrl(),
            application.getPetAge(),
            application.getVaccinationStatus(),
            "Adopt " + application.getPetName() + "!",
            "null",
            application.getSurrenderedPetType()));
    petSurrenderApplicationRepo.save(application);
  }

}
