package com.blunt.authentication.service;

import com.blunt.authentication.dto.JwtResponse;
import com.blunt.authentication.util.BluntConstant;
import com.blunt.authentication.dto.ValidateDto;
import com.blunt.authentication.error.BluntException;
import com.blunt.authentication.proxy.OnboardServiceProxyClient;
import com.blunt.authentication.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final OnboardServiceProxyClient onboardServiceProxyClient;
  private final JwtTokenUtil jwtTokenUtil;

  public ResponseEntity<Object> authenticate(ValidateDto validateDto) {
    JwtResponse jwtResponse = new JwtResponse();
    try{
      jwtResponse.setBluntId(onboardServiceProxyClient.signIn(validateDto));
    } catch(Exception e){
      throw new BluntException(BluntConstant.INVALID_CREDENTIAL, HttpStatus.UNAUTHORIZED.value(),
          HttpStatus.UNAUTHORIZED);
    }
    jwtResponse.setJwtToken(jwtTokenUtil.generateToken(jwtResponse.getBluntId()));
    return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
  }

}
