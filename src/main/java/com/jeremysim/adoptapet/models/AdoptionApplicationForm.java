package com.jeremysim.adoptapet.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AdoptionApplicationForm {
  @NotBlank
  private String name;
  @NotBlank
  private String phoneNumber;
  @NotBlank
  private String email;
  @NotBlank
  private String homeStatus;
  @NotNull
  private Integer petId;
}
