package com.infinitywordvision.oportunity.controller;

import com.infinitywordvision.oportunity.dto.request.ClienteRequestDto;
import com.infinitywordvision.oportunity.dto.response.ClienteResponseDto;
import com.infinitywordvision.oportunity.service.IServiceClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    IServiceClienteDao iServiceClienteDao;

    @PreAuthorize("hasAnyRole()")
    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponseDto> save(@Valid @RequestBody ClienteRequestDto clienteRequestDto) {
        return new ResponseEntity<>(iServiceClienteDao.save(clienteRequestDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole()")
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponseDto>> findAll() {
        return new ResponseEntity<List<ClienteResponseDto>>(iServiceClienteDao.findAll(),HttpStatus.OK);
    }

}
