package com.infinitywordvision.oportunity.repository;

import com.infinitywordvision.oportunity.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,String> {

    Cliente findOneByDocumento(String documento);
}
