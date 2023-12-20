package com.zenmailapi.model;

import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

public record Email(
        String destinatario,
        String titulo,
        String mensagem) {

}
