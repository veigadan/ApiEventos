package com.veigadan.eventos.service;


import com.veigadan.eventos.dto.EventoRequestDTO;
import com.veigadan.eventos.model.Evento;
import com.veigadan.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public Evento criar(EventoRequestDTO dto){
        Evento novoEvento = new Evento(null, dto.titulo(), dto.descricao(), dto.dataHora(), dto.local(), dto.capacidade());
        return repository.save(novoEvento);
    }

    public List<Evento> listarTodos(){
        return repository.findAll();
    }
}
