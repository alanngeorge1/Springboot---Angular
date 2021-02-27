package com.alanngeorge1.AngularJava.rest.exeception;

import com.alanngeorge1.AngularJava.model.entity.Cliente;
import com.alanngeorge1.AngularJava.model.entity.ServicoPrestado;
import com.alanngeorge1.AngularJava.model.repository.ClienteRepository;
import com.alanngeorge1.AngularJava.model.repository.ServicoPrestadoRepository;
import com.alanngeorge1.AngularJava.rest.dto.ServicoPrestadoDTO;
import com.alanngeorge1.AngularJava.rest.exeception.util.BigdecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicos-prestados")

public class ServicoPrestadoController {
    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigdecimalConverter bigdecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
        Integer idCliente = dto.getIdCliente();
        Cliente cliente =  clienteRepository
                .findById(idCliente)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigdecimalConverter.converter(dto.getPreco()));
        return  servicoPrestadoRepository.save(servicoPrestado);

    }

    @GetMapping
    public List<ServicoPrestado> pesquisarServicos(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);

    }



}
