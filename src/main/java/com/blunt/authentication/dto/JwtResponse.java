package com.blunt.authentication.dto;

import lombok.Data;

@Data
public class JwtResponse {
  private String jwtToken;
  private String bluntId;
}
