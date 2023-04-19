package com.infinitywordvision.oportunity.repository;

import com.infinitywordvision.oportunity.entity.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem,String> {
    Optional<UserSystem> findByUsername(String username);
}
