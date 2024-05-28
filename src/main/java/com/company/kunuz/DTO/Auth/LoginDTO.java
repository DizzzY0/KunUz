package com.company.kunuz.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    @NotBlank(message = "email not found")
    private String email;
    @NotBlank(message = "passord not found")
    private String password;

}
