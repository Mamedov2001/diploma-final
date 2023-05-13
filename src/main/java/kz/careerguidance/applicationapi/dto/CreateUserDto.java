package kz.careerguidance.applicationapi.dto;


import kz.careerguidance.applicationapi.entity.History;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Set;

import static kz.careerguidance.applicationapi.utils.AuthoritiesConstants.USER;


@Data
@AllArgsConstructor
public class CreateUserDto {

  @NotEmpty(message = "Username should not be empty")
  @NotNull(message = "Username should not be empty")
  @Size(min = 3, max = 20, message = "Username should contain between 3 and 20 characters")
  private String username;

  @NotEmpty(message = "Email should not be empty")
  @NotNull(message = "Email should not be empty")
  @Email(message = "Invalid email address")
  private String email;

  @NotEmpty(message = "Password should not be empty")
  @NotNull(message = "Password should not be empty")
  @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%^&*]).{6,}$", message = "Password should contain 1 Uppercase letter 1 digit and 1 special symbol and more than 6 characters")
  @Size(min = 5, max = 32, message = "Password should contain between 6 and 32 characters")
  private String password;

  @NotEmpty(message = "Location should not be empty")
  @NotNull(message = "Location should not be empty")
  private String location;

  private String role = USER;

  private Set<History> history;

}
