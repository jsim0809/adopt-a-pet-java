package com.jeremysim.petAdoption.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Column(name="id", nullable = false, unique = true)
  private Integer id;
  @Column(nullable = false)
  private String type;
  @Column
  private String description;
  @Column(name = "img_url_random_animal", nullable = false)
  private String imgUrlRandomAnimal;
}
