package com.infinitywordvision.oportunity.exception;

import com.infinitywordvision.oportunity.dto.response.MensajerErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<MensajerErrorDto> badCredentialsException(BadCredentialsException ex) {
        MensajerErrorDto mensajerErrorDto = new MensajerErrorDto(ex.getMessage());
        return new ResponseEntity<>(mensajerErrorDto, HttpStatus.BAD_REQUEST);
    }

}
