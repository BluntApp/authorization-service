package com.blunt.authentication.controller;

import com.blunt.authentication.dto.ValidateDto;
import com.blunt.authentication.service.AuthenticationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authenticate")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @GetMapping("test")
  public ResponseEntity<String> testPublish() {
    return new ResponseEntity<>("success", HttpStatus.OK);
  }

  @PostMapping("blunt")
  public ResponseEntity<Object> getToken(@Valid @RequestBody ValidateDto validateDto) {
    return authenticationService.authenticate(validateDto);
  }

}
