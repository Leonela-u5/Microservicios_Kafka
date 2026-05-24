package com.leonela.productos_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @GetMapping("/api/productos")
    public String productos() {
        return "Productos funcionando";
    }
}