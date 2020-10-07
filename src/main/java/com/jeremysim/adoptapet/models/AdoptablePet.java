package com.jeremysim.adoptapet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adoptable_pets")
@Getter
@Setter
@NoArgsConstructor
public class AdoptablePet {
  @Id
  @SequenceGenerator(name="adoptable_pet_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adoptable_pet_generator")
  @Column(nullable = false, unique = true)
  private Integer id;
  @Column(nullable = false)
  private String name;
  @Column(name = "img_url", nullable = false)
  private String imgUrl;
  @Column
  private Integer age;
  @Column(name = "vaccination_status")
  private Boolean vaccinationStatus;
  @Column(name = "adoption_story", nullable = false)
  private String adoptionStory;
  @Column(name = "adoption_status", nullable = false)
  private String adoptionStatus;
  @ManyToOne
  @JoinColumn(name="type_id", nullable=false)
  @JsonIgnoreProperties("adoptablePets")
  private PetType adoptablePetType;
  @OneToMany(mappedBy = "pet")
  private Set<AdoptionApplication> adoptionApplications;

  public AdoptablePet(String name, String imgUrl, Integer age, Boolean vaccinationStatus,
      String adoptionStory, String adoptionStatus,
      PetType adoptablePetType) {
    this.name = name;
    this.imgUrl = imgUrl;
    this.age = age;
    this.vaccinationStatus = vaccinationStatus;
    this.adoptionStory = adoptionStory;
    this.adoptionStatus = adoptionStatus;
    this.adoptablePetType = adoptablePetType;
  }
}
