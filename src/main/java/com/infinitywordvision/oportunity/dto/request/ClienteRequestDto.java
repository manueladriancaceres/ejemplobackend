package com.infinitywordvision.oportunity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {

    @NotBlank(message = "El documento no debe estar vacio")
    @NotNull(message = "El documento no debe ser nulo")
    private String documento;
    @NotBlank(message = "El nombre no debe estar vacio")
    @NotNull(message = "El nombre no debe estar vacio")
    private String nombre;

}
