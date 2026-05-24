package com.leonela.productos_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaPedidoConsumer {

    @KafkaListener(topics = "pedidos-topic", groupId = "productos-group")
    public void consumirPedido(String mensaje) {

        System.out.println("📦 Pedido recibido en productos: " + mensaje);
        System.out.println("📉 Stock actualizado automáticamente");
    }
}