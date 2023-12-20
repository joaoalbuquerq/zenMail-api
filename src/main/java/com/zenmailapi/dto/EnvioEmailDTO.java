package com.zenmailapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EnvioEmailDTO(
        @Email
        String destinatario,
        String titulo,
        @NotBlank
        String mensagem) {
}
