package com.infinitywordvision.oportunity.unittest.service;


import com.infinitywordvision.oportunity.dto.request.ClienteRequestDto;
import com.infinitywordvision.oportunity.dto.response.ClienteResponseDto;
import com.infinitywordvision.oportunity.entity.Cliente;
import com.infinitywordvision.oportunity.repository.ClienteRepository;
import com.infinitywordvision.oportunity.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @Mock
    ClienteRepository clienteRepository;
    @InjectMocks
    ClienteService clienteService;

    @Test
    void shouldAddCliente() {

        Cliente cliente = new Cliente("22000000","Carlos");
        when(clienteRepository.findOneByDocumento("22000000")).thenReturn(cliente);

        ClienteRequestDto clienteRequestDto = new ClienteRequestDto("22000000","Carlos");
        ClienteResponseDto clienteResponseDtoObtenido = clienteService.save(clienteRequestDto);

        ClienteResponseDto clienteRequestDtoEsperado = new ClienteResponseDto("22000000","Carlos");

        Assertions.assertEquals(clienteRequestDtoEsperado,clienteResponseDtoObtenido);

    }

    @Test
    void shouldListClientes() {

        List<Cliente> clientes = List.of(new Cliente("22333444","Juan"));
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<ClienteResponseDto> clienteResponseDtosObtenido =
                clienteService.findAll();

        List<ClienteResponseDto> clienteResponseDtosEsperado =
                List.of(new ClienteResponseDto("22333444","Juan"));

        Assertions.assertEquals(clienteResponseDtosEsperado,clienteResponseDtosObtenido);

    }




}
