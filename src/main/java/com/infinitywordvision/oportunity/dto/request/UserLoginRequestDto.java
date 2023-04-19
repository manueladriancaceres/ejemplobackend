package com.infinitywordvision.oportunity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto implements Serializable {

    @NotEmpty(message = "username no debe estar vacio")
    @NotBlank(message = "username no debe ser espacios en blanco")
    @NotNull(message = "username no debe ser nulo")
    private String username;
    @NotEmpty(message = "password no debe estar vacio")
    @NotBlank(message = "password no debe ser espacios en blanco")
    @NotNull(message = "password no debe ser nulo")
    private String password;
}
