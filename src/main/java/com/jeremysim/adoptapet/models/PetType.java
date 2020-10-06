package com.jeremysim.adoptapet.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
public class PetType {
  @Id
  @SequenceGenerator(name="pet_type_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pet_type_generator")
  @Column(nullable = false, unique = true)
  private Integer id;
  @Column(nullable = false)
  private String type;
  @Column
  private String description;
  @Column(name = "img_url", nullable = false)
  private String imgUrl;
  @OneToMany(mappedBy = "adoptablePetType")
  private Set<AdoptablePet> adoptablePets;
  @OneToMany(mappedBy = "surrenderedPetType")
  private Set<PetSurrenderApplication> petSurrenderApplications;

}
