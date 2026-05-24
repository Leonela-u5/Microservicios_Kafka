package com.leonela.pedidos_service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PedidoController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/api/pedidos")
    public String crearPedido() {

        kafkaTemplate.send(
                "pedidos-topic",
                "Nuevo pedido registrado"
        );

        return "Pedido enviado a Kafka";
    }
}