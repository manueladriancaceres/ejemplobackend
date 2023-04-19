package com.infinitywordvision.oportunity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeErrorValidDto {

    private String mensaje;
    private List<String> errores;
}
