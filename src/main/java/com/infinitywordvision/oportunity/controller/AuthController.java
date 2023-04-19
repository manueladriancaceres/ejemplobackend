package com.infinitywordvision.oportunity.controller;

import com.infinitywordvision.oportunity.dto.request.UserLoginRequestDto;
import com.infinitywordvision.oportunity.dto.response.MensajeLoginResponseDto;
import com.infinitywordvision.oportunity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<MensajeLoginResponseDto> signin(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        return new ResponseEntity<>(authService.login(userLoginRequestDto),HttpStatus.OK);
    }

}
