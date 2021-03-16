package com.alanngeorge1.AngularJava.model.repository;


import com.alanngeorge1.AngularJava.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

}
