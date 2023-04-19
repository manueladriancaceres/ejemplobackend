package com.infinitywordvision.oportunity.service;

import com.infinitywordvision.oportunity.config.JwtTokenProvider;
import com.infinitywordvision.oportunity.dto.request.UserLoginRequestDto;
import com.infinitywordvision.oportunity.dto.response.MensajeLoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public MensajeLoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        try {
            var authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword()));
            String token = jwtTokenProvider.createToken(authentication);
            return MensajeLoginResponseDto.builder()
                    .mensaje("Alta ok")
                    .token(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Usuario o password inválido");
        }

    }
}
