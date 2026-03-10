package com.veigadan.eventos.controller;

import com.veigadan.eventos.dto.EventoRequestDTO;
import com.veigadan.eventos.model.Evento;
import com.veigadan.eventos.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public Evento criar(@RequestBody @Valid EventoRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<Evento> listar(){
        return service.listarTodos();
    }


}
