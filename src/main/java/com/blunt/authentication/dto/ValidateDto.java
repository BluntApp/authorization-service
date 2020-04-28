package com.blunt.authentication.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ValidateDto {
  @NotNull(message = "Blunt Mobile Number is mandatory")
  private String mobile;
  private String password;
}
