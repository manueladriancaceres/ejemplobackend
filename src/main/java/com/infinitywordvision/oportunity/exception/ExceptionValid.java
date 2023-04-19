package com.infinitywordvision.oportunity.exception;

import com.infinitywordvision.oportunity.dto.response.MensajeErrorValidDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionValid {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeErrorValidDto> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        MensajeErrorValidDto mensajeErrorValidDto = new MensajeErrorValidDto();

        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = bindingResult.getAllErrors().stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        mensajeErrorValidDto.setMensaje("Error de ingreso de datos");
        mensajeErrorValidDto.setErrores(errorMessages);

        return new ResponseEntity<>(mensajeErrorValidDto, HttpStatus.BAD_REQUEST);
    }

}
