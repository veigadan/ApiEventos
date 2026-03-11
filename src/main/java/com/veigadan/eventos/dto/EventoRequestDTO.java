package com.veigadan.eventos.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "A data é obrigatória")
        @Future(message = "A data do evento deve ser no futuro")
        LocalDateTime dataHora,

        @NotBlank(message = "O local é obrigatório")
        String local,

        @NotNull
        @Min(value = 1, message = "A capacidade deve ser de pelo menos 1 pessoa")
        Integer capacidade
) { }
