package com.alanngeorge1.AngularJava.model.repository;

import com.alanngeorge1.AngularJava.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository  <Servico, Integer> {

}
