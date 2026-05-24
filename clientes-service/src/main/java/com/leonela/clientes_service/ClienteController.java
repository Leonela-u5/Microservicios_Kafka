package com.leonela.clientes_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/api/clientes")
    public String clientes() {
        return "Clientes funcionando";
    }

}