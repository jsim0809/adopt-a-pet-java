package com.jeremysim.adoptapet.seeders;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptionApplicationSeeder {
  private AdoptablePetRepository adoptablePetRepo;
  private AdoptionApplicationRepository adoptionApplicationRepo;

  @Autowired
  public AdoptionApplicationSeeder(
      AdoptablePetRepository adoptablePetRepo,
      AdoptionApplicationRepository adoptionApplicationRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
    this.adoptionApplicationRepo = adoptionApplicationRepo;
  }

  public void seed() {
    if(!adoptionApplicationRepo.findAll().iterator().hasNext()) {
      AdoptablePet tweety = adoptablePetRepo.findByName("Tweety").get();

      AdoptionApplication grandmaApp = new AdoptionApplication();
      grandmaApp.setName("grandma");
      grandmaApp.setPhoneNumber("5551234567");
      grandmaApp.setEmail("grandma@looneytunes.com");
      grandmaApp.setHomeStatus("own");
      grandmaApp.setApplicationStatus("pending");
      grandmaApp.setPet(tweety);
    }
  }
}
