package com.leonela.pedidos_service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PedidoController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/test")
    public String test() {
        return "FUNCIONA";
    }

    @PostMapping("/api/pedidos")
    public String crearPedido(@RequestBody Pedido pedido) {

        String mensaje =
                "Pedido ID: " + pedido.getId()
                + ", Cliente ID: " + pedido.getClienteId()
                + ", Producto ID: " + pedido.getProductoId()
                + ", Cantidad: " + pedido.getCantidad();

        kafkaTemplate.send("pedidos-topic", mensaje);

        return "Pedido enviado a Kafka";
    }
}