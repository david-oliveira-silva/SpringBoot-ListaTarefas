package com.tarefas.listaTarefas.DTO;

import jakarta.validation.constraints.NotBlank;

public record TarefasDTO(
        @NotBlank
        String nome,
        @NotBlank
        String dia,
        @NotBlank
        String horario
) {
}
