package com.veigadan.eventos.repository;

import com.veigadan.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
