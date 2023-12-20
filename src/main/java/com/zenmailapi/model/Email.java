package com.zenmailapi.model;

import com.zenmailapi.dto.EnvioEmailDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String destinatario;
    private String titulo;
    private String mensagem;

    public Email(EnvioEmailDTO dto) {
            this.mensagem = dto.mensagem();
            this.titulo = dto.titulo();
            this.destinatario = dto.destinatario();
        }
}
