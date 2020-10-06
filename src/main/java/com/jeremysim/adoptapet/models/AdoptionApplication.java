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
@Table(name = "adoption_applications")
@Getter
@Setter
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name="adoption_application_generator", sequenceName = "adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adoption_application_generator")
  @Column(nullable = false, unique = true)
  private Integer id;
  @Column(nullable = false)
  private String name;
  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;
  @Column(nullable = false)
  private String email;
  @Column(name = "home_status", nullable = false)
  private String homeStatus;
  @Column(name = "application_status", nullable = false)
  private String applicationStatus;
  @ManyToOne
  @JoinColumn(name = "pet_id", nullable = false)
  @JsonIgnoreProperties("adoptionApplications")
  private AdoptablePet pet;
}
