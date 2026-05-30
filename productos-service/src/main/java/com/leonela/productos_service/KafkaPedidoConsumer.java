package com.leonela.productos_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaPedidoConsumer {

    private final ProductoRepository productoRepository;

    public KafkaPedidoConsumer(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @KafkaListener(topics = "pedidos-topic")
    public void actualizarStock(String mensaje) {

        Producto producto = productoRepository.findById(1L).orElse(null);

        if (producto != null) {

            producto.setStock(producto.getStock() - 1);

            productoRepository.save(producto);

            System.out.println("📉 Stock actualizado automáticamente");
            System.out.println("Stock actual: " + producto.getStock());
        }
    }
}