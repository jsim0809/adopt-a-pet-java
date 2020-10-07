package com.jeremysim.adoptapet.services;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.PetSurrenderApplication;
import com.jeremysim.adoptapet.models.PetSurrenderApplicationApprovalForm;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import org.springframework.stereotype.Component;

@Component
public class PetSurrenderApplicationApprovalFormService {

  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;
  private AdoptablePetRepository adoptablePetRepo;



  public void process(PetSurrenderApplicationApprovalForm form) {
    PetSurrenderApplication application = petSurrenderApplicationRepo.findById(form.getApplicationId()).get();
    application.setApplicationStatus(form.getApprovalStatus());
    adoptablePetRepo.save(
        new AdoptablePet(
            application.getName(),
            application.getPetImageUrl(),
            application.getPetAge(),
            application.getVaccinationStatus(),
            "Adopt " + application.getName() + "!",
            "pending",
            application.getSurrenderedPetType()));
    petSurrenderApplicationRepo.save(application);
  }

}
