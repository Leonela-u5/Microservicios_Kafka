package com.leonela.notificaciones_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "pedidos-topic", groupId = "notificaciones-group")
    public void consumirPedido(String mensaje) {

        System.out.println("📩 Pedido recibido correctamente: " + mensaje);
    }
}