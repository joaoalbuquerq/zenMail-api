package com.zenmailapi.controller;

import com.zenmailapi.dto.EnvioEmailDTO;
import com.zenmailapi.model.Email;
import com.zenmailapi.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity enviar(@RequestBody @Valid EnvioEmailDTO dto){
        return service.enviarEmail(dto);
    }

}
