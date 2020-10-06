package com.jeremysim.adoptapet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_surrender_applications")
@Getter
@Setter
public class PetSurrenderApplication {
  @Id
  @SequenceGenerator(name="pet_surrender_application_generator", sequenceName = "pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pet_surrender_application_generator")
  @Column(nullable = false, unique = true)
  private Integer id;
  @Column(nullable = false)
  private String name;
  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;
  @Column(nullable = false)
  private String email;
  @Column(name = "pet_name", nullable = false)
  private Integer petName;
  @Column(name = "pet_age")
  private Integer petAge;
  @ManyToOne
  @JoinColumn(name = "pet_type_id", nullable = false)
  @JsonIgnoreProperties("petSurrenderApplications")
  private PetType surrenderedPetType;
  @Column(name = "pet_image_url", nullable = false)
  private String petImageUrl;
  @Column(name = "vaccination_status")
  private Boolean vaccinationStatus;
  @Column(name = "application_status", nullable = false)
  private String applicationStatus;
}
