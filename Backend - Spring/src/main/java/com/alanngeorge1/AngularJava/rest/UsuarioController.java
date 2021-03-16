package com.alanngeorge1.AngularJava.rest;

import com.alanngeorge1.AngularJava.model.entity.Usuario;
import com.alanngeorge1.AngularJava.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        usuarioRepository.save(usuario);
    }



}
