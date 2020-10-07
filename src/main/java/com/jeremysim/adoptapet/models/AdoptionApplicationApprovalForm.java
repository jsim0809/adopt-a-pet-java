package com.jeremysim.adoptapet.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AdoptionApplicationApprovalForm {
  @NotNull
  private Integer petId;
  @NotNull
  private Integer applicationId;
  @NotBlank
  private String approvalStatus;
}
