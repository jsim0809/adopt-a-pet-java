package com.jeremysim.adoptapet.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PetSurrenderApplicationForm {
  @NotBlank
  private String name;
  @NotBlank
  private String phoneNumber;
  @NotBlank
  private String email;
  @NotBlank
  private String petName;

  private Integer petAge;
  @NotNull
  private Integer surrenderedPetType;
  @NotBlank
  private String petImageUrl;

  private Boolean vaccinationStatus;
  @NotBlank
  private String applicationStatus;
}
