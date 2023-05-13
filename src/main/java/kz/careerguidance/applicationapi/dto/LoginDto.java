package kz.careerguidance.applicationapi.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {

  @NotEmpty(message = "Username should not be empty")
  @NotNull(message = "Username should not be empty")
  private String username;

  @NotEmpty(message = "Password should not be empty")
  @NotNull(message = "Password should not be empty")
  private String password;

}
