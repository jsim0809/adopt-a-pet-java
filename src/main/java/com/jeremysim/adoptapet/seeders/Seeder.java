package com.jeremysim.adoptapet.seeders;

import com.jeremysim.adoptapet.models.AdoptablePet;
import com.jeremysim.adoptapet.models.AdoptionApplication;
import com.jeremysim.adoptapet.models.PetType;
import com.jeremysim.adoptapet.repositories.AdoptablePetRepository;
import com.jeremysim.adoptapet.repositories.AdoptionApplicationRepository;
import com.jeremysim.adoptapet.repositories.PetSurrenderApplicationRepository;
import com.jeremysim.adoptapet.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

  private PetTypeRepository petTypeRepo;
  private AdoptablePetRepository adoptablePetRepo;
  private AdoptionApplicationRepository adoptionApplicationRepo;
  private PetSurrenderApplicationRepository petSurrenderApplicationRepo;

  @Autowired
  public Seeder(PetTypeRepository petTypeRepo,
      AdoptablePetRepository adoptablePetRepo,
      AdoptionApplicationRepository adoptionApplicationRepo,
      PetSurrenderApplicationRepository petSurrenderApplicationRepo) {
    this.petTypeRepo = petTypeRepo;
    this.adoptablePetRepo = adoptablePetRepo;
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.petSurrenderApplicationRepo = petSurrenderApplicationRepo;
  }

  @Override
  public void run(String... args) throws Exception {
    if (!petTypeRepo.findAll().iterator().hasNext()) {
      PetType twoLegged = new PetType();
      twoLegged.setType("Two-legged");
      twoLegged.setDescription("animals who stand with two legs");
      twoLegged.setImgUrlRandomAnimal("https://images.newscientist.com/wp-content/uploads/2014/07/dn25829-2_800.jpg");
      petTypeRepo.save(twoLegged);

      PetType fourLegged = new PetType();
      fourLegged.setType("Four-legged");
      fourLegged.setDescription("animals who stand on four legs");
      fourLegged.setImgUrlRandomAnimal("https://www.ucdavis.edu/sites/default/files/home-site/blogs/one-health/blog-posts/2018/cow-field-one-health-uc-davis.jpg");
      petTypeRepo.save(fourLegged);

      AdoptablePet clifford = new AdoptablePet();
      clifford.setName("Clifford");
      clifford.setImgUrl("https://images2.minutemediacdn.com/image/upload/c_crop,h_1181,w_2100,x_0,y_328/f_auto,q_auto,w_1100/v1554923476/shape/mentalfloss/24523-pbs_scholastic.jpg");
      clifford.setAge(5);
      clifford.setVaccinationStatus(true);
      clifford.setAdoptionStory("The big red dog, he loves dinosaur bones");
      clifford.setAdoptionStatus("null");
      clifford.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(clifford);

      AdoptablePet scoobyDoo = new AdoptablePet();
      scoobyDoo.setName("Scooby Doo");
      scoobyDoo.setImgUrl("https://i.ebayimg.com/images/i/131484627379-0-1/s-l1000.jpg");
      scoobyDoo.setAge(4);
      scoobyDoo.setVaccinationStatus(true);
      scoobyDoo.setAdoptionStory("Retired Crime Solving pooch, loves scooby snacks");
      scoobyDoo.setAdoptionStatus("null");
      scoobyDoo.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(scoobyDoo);

      AdoptablePet courage = new AdoptablePet();
      courage.setName("Courage");
      courage.setImgUrl("https://1.bp.blogspot.com/-fSbsOaTu73Y/T3wz22zl-xI/AAAAAAAAEyM/9TJXzGPT_iE/s1600/coragem+1.jpg");
      courage.setAge(4);
      courage.setVaccinationStatus(true);
      courage.setAdoptionStory("Courage the cowardly dog, is pink and has a hole in his teeth");
      courage.setAdoptionStatus("null");
      courage.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(courage);

      AdoptablePet snoopy = new AdoptablePet();
      snoopy.setName("Snoopy");
      snoopy.setImgUrl("https://4.bp.blogspot.com/-5I3DW0YllQ0/WiDS_A8GcHI/AAAAAAAAJJo/ZlUjubpGPiotafVMg2VUPcvGRt2BI-LoACLcBGAs/s1600/snoopy.png");
      snoopy.setAge(6);
      snoopy.setVaccinationStatus(true);
      snoopy.setAdoptionStory("He loves to dance and his best friend is a yellow bird");
      snoopy.setAdoptionStatus("null");
      snoopy.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(snoopy);

      AdoptablePet odieGarfield = new AdoptablePet();
      odieGarfield.setName("Odie Garfield");
      odieGarfield.setImgUrl("https://4.bp.blogspot.com/-qPRrHfld2vA/Us4j2ZCsdqI/AAAAAAAADYg/SlvDwfnOSZ4/s1600/odie_bd.jpg");
      odieGarfield.setAge(2);
      odieGarfield.setVaccinationStatus(true);
      odieGarfield.setAdoptionStory("loving goofy doggo who licks everything!");
      odieGarfield.setAdoptionStatus("null");
      odieGarfield.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(odieGarfield);

      AdoptablePet pluto = new AdoptablePet();
      pluto.setName("Pluto");
      pluto.setImgUrl("http://images6.fanpop.com/image/photos/38600000/Pluto-classic-disney-38684898-1600-900.jpg");
      pluto.setAge(4);
      pluto.setVaccinationStatus(true);
      pluto.setAdoptionStory("Ran away from Mickey");
      pluto.setAdoptionStatus("null");
      pluto.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(pluto);

      AdoptablePet spike = new AdoptablePet();
      spike.setName("Spike");
      spike.setImgUrl("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fhobbydb-production.s3.amazonaws.com%2Fprocessed_uploads%2Fsubject_photo%2Fsubject_photo%2Fimage%2F34894%2F1513307715-29010-4102%2FSpike_20Bulldog.jpg&f=1&nofb=1");
      spike.setAge(4);
      spike.setVaccinationStatus(true);
      spike.setAdoptionStory("He loves a juicy steak");
      spike.setAdoptionStatus("null");
      spike.setAdoptablePetType(fourLegged);
      adoptablePetRepo.save(spike);

      AdoptablePet tweety = new AdoptablePet();
      tweety.setName("Tweety");
      tweety.setImgUrl("https://i.pinimg.com/736x/84/25/eb/8425eb206150472144136b4132e6f719.jpg");
      tweety.setAge(4);
      tweety.setVaccinationStatus(true);
      tweety.setAdoptionStory("Aka Tweety Bird or Tweety Pie, is a male yellow canary. He likes to foil cats attempts to catch him, sometimes quite aggressively. Tweety Pie is perhaps the cutest cartoon animal of all time.");
      tweety.setAdoptionStatus("null");
      tweety.setAdoptablePetType(twoLegged);
      adoptablePetRepo.save(tweety);

      AdoptablePet donaldDuck = new AdoptablePet();
      donaldDuck.setName("Donald Duck");
      donaldDuck.setImgUrl("https://www.wikihow.com/images/f/fe/Final-Colored-Intro-2.jpg");
      donaldDuck.setAge(4);
      donaldDuck.setVaccinationStatus(true);
      donaldDuck.setAdoptionStory("The one and only Donald, his face is on orange juice containers");
      donaldDuck.setAdoptionStatus("null");
      donaldDuck.setAdoptablePetType(twoLegged);
      adoptablePetRepo.save(donaldDuck);

      AdoptablePet bugsBunny = new AdoptablePet();
      bugsBunny.setName("Bugs Bunny");
      bugsBunny.setImgUrl("https://1.bp.blogspot.com/-0c1rJ3UPQUU/UI65xo49QHI/AAAAAAAAIdc/BKLbVcSm2DE/s1600/Bugs+Bunny+Gets+the+Boid+%289%29.jpg");
      bugsBunny.setAge(7);
      bugsBunny.setVaccinationStatus(true);
      bugsBunny.setAdoptionStory("His favorite activity is digging and munching on a carrot");
      bugsBunny.setAdoptionStatus("null");
      bugsBunny.setAdoptablePetType(twoLegged);
      adoptablePetRepo.save(bugsBunny);

      AdoptablePet po = new AdoptablePet();
      po.setName("Po the Giant Panda");
      po.setImgUrl("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fae01.alicdn.com%2Fkf%2FHTB15x5aRVXXXXbkXVXXq6xXFXXXj%2F2017-New-Hot-Kung-fu-Panda-Po-3-Sitting-Plush-Toys-Large-Dolls-Furnishing-Articles-Figures.jpg_640x640.jpg&f=1&nofb=1");
      po.setAge(12);
      po.setVaccinationStatus(true);
      po.setAdoptionStory("Po is famously known for being a kung fu master");
      po.setAdoptionStatus("null");
      po.setAdoptablePetType(twoLegged);
      adoptablePetRepo.save(po);

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
