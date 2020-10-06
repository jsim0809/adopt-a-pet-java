package com.jeremysim.adoptapet.seeders;

import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder {
  private PetTypeRepository petTypeRepo;

  @Autowired
  public PetTypeSeeder(PetTypeRepository petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }

  public void seed() {
    if(!petTypeRepo.findAll().iterator().hasNext()) {
      PetType twoLegged = new PetType();
      twoLegged.setType("Two-legged");
      twoLegged.setDescription("animals who stand with two legs");
      twoLegged.setImgUrl("https://images.newscientist.com/wp-content/uploads/2014/07/dn25829-2_800.jpg");
      petTypeRepo.save(twoLegged);

      PetType fourLegged = new PetType();
      fourLegged.setType("Four-legged");
      fourLegged.setDescription("animals who stand on four legs");
      fourLegged.setImgUrl("https://www.ucdavis.edu/sites/default/files/home-site/blogs/one-health/blog-posts/2018/cow-field-one-health-uc-davis.jpg");
      petTypeRepo.save(fourLegged);
    }
  }
}
