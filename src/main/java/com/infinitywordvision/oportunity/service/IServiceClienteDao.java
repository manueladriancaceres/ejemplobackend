package com.infinitywordvision.oportunity.service;

import com.infinitywordvision.oportunity.dto.request.ClienteRequestDto;
import com.infinitywordvision.oportunity.dto.response.ClienteResponseDto;

import java.util.List;

public interface IServiceClienteDao {

    ClienteResponseDto save(ClienteRequestDto clienteRequestDto);
    List<ClienteResponseDto> findAll();
}
