package com.jeremysim.adoptapet.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

  private PetTypeSeeder petTypeSeeder;
  private AdoptablePetSeeder adoptablePetSeeder;
  private AdoptionApplicationSeeder adoptionApplicationSeeder;

  @Autowired
  public Seeder(PetTypeSeeder petTypeSeeder,
      AdoptablePetSeeder adoptablePetSeeder,
      AdoptionApplicationSeeder adoptionApplicationSeeder) {
    this.petTypeSeeder = petTypeSeeder;
    this.adoptablePetSeeder = adoptablePetSeeder;
    this.adoptionApplicationSeeder = adoptionApplicationSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    petTypeSeeder.seed();
    adoptablePetSeeder.seed();
    adoptionApplicationSeeder.seed();
  }
}
