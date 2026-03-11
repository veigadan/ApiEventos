package com.veigadan.eventos.repository;

import com.veigadan.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    boolean existsByLocalAndDataHora(String local, LocalDateTime dataHora);
}
