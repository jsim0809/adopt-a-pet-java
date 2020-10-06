package com.jeremysim.adoptapet.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PetSurrenderApplicationForm {
  private String name;
  private String phoneNumber;
  private String email;
  private String petName;
  private Integer petAge;
  private Integer surrenderedPetType;
  private String petImageUrl;
  private Boolean vaccinationStatus;
  private String applicationStatus;
}
