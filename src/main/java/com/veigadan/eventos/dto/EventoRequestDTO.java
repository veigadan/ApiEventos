package com.veigadan.eventos.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotNull @Future LocalDateTime dataHora,
        @NotBlank String local,
        @NotNull @Positive Integer capacidade
) { }
