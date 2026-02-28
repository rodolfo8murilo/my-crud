package com.myproject.my_crud.infrastructure.repository;

import com.myproject.my_crud.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Usuario, Long>{
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
