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

    public Evento criar(EventoRequestDTO dto) {

        if (repository.existsByLocalAndDataHora(dto.local(), dto.dataHora())) {
            throw new RuntimeException("Já existe um evento agendado para este local e horário!");
        }

        Evento novoEvento = new Evento(null, dto.titulo(), dto.descricao(), dto.dataHora(), dto.local(), dto.capacidade());
        return repository.save(novoEvento);
    }

    public List<Evento> listarTodos() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Evento não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    public Evento atualizar(Long id, EventoRequestDTO dto) {
        Evento eventoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado!"));

        eventoExistente.setTitulo(dto.titulo());
        eventoExistente.setDescricao(dto.descricao());
        eventoExistente.setDataHora(dto.dataHora());
        eventoExistente.setLocal(dto.local());
        eventoExistente.setCapacidade(dto.capacidade());

        return repository.save(eventoExistente);
    }
}
