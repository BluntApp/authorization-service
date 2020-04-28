package com.blunt.authentication.proxy;

import com.blunt.authentication.dto.ValidateDto;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "onboard-service")
public interface OnboardServiceProxyClient {

  @PostMapping(value = "/api/v1/onboard/signin")
  public String signIn(@Valid @RequestBody ValidateDto validateDto);
}
