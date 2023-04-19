package com.infinitywordvision.oportunity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }

    @PreAuthorize("hasAnyRole()")
    @GetMapping("/protegido")
    public String protegido() {
        return "protegido";
    }

}
