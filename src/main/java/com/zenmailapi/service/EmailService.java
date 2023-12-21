package com.zenmailapi.service;

import com.zenmailapi.dto.EnvioEmailDTO;
import com.zenmailapi.model.Email;
import com.zenmailapi.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    @Autowired
    private EmailRepository repository;

    public EmailService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }

    public ResponseEntity enviarEmail(EnvioEmailDTO dto){
        var mensagem = new SimpleMailMessage();

        mensagem.setFrom("joaopealbuquerque1@gmail.com");
        mensagem.setTo(dto.destinatario());
        mensagem.setSubject(dto.titulo());
        mensagem.setText(dto.mensagem());

        try{
            mailSender.send(mensagem);

            var email = new Email(dto);
            repository.save(email);
            return ResponseEntity.ok("Email enviado com sucesso");
        }catch(MailException exception){
            System.out.println("Erro ao enviar email" + exception.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
