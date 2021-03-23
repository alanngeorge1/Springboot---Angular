package com.alanngeorge1.AngularJava.model.repository;


import com.alanngeorge1.AngularJava.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

}
