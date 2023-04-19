package com.infinitywordvision.oportunity.service;

import com.infinitywordvision.oportunity.dto.request.ClienteRequestDto;
import com.infinitywordvision.oportunity.dto.response.ClienteResponseDto;
import com.infinitywordvision.oportunity.entity.Cliente;
import com.infinitywordvision.oportunity.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IServiceClienteDao {
    @Autowired
    ClienteRepository clienteRepository;
    public ClienteResponseDto save(ClienteRequestDto clienteRequestDto) {
        Cliente cliente = new Cliente();
        cliente.setDocumento(clienteRequestDto.getDocumento());
        cliente.setNombre(clienteRequestDto.getNombre());
        clienteRepository.save(cliente);
        Cliente clienteBase = clienteRepository.findOneByDocumento(clienteRequestDto.getDocumento());
        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
        clienteResponseDto.setDocumento(clienteBase.getDocumento());
        clienteResponseDto.setNombre(clienteBase.getNombre());
        return clienteResponseDto;
    }

    @Override
    public List<ClienteResponseDto> findAll() {
        return clienteRepository.findAll().stream().map(
                e-> new ClienteResponseDto(e.getDocumento(), e.getNombre())
        ).collect(Collectors.toList());
    }


}
