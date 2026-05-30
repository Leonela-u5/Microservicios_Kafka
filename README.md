# 🚀 Microservicios con Kafka - Sistema de Gestión de Pedidos

## 📋 Descripción

Microservicios_Kafka es un proyecto académico desarrollado con Spring Boot, Spring Cloud Eureka, Spring Cloud Gateway y Apache Kafka. Implementa una arquitectura distribuida basada en microservicios para la gestión de clientes, productos, pedidos y notificaciones.

El sistema demuestra la integración de comunicación síncrona mediante servicios REST y comunicación asíncrona basada en eventos utilizando Apache Kafka, simulando el funcionamiento de una plataforma de comercio electrónico.

## 🏗️ Arquitectura

El proyecto está compuesto por los siguientes servicios:

* **Eureka Server:** Registro y descubrimiento de microservicios.
* **Gateway Service:** Punto de entrada único para las peticiones del sistema.
* **Clientes Service:** Gestión de clientes.
* **Productos Service:** Gestión de productos e inventario.
* **Pedidos Service:** Registro de pedidos y publicación de eventos en Kafka.
* **Notificaciones Service:** Consumo de eventos Kafka y generación de notificaciones.

## 🔄 Flujo de funcionamiento

1. El cliente realiza una petición al Gateway.
2. El Gateway redirige la solicitud al microservicio correspondiente.
3. Pedidos Service registra el pedido.
4. Se publica un evento en el topic `pedidos-topic`.
5. Kafka distribuye el evento a los servicios suscritos.
6. Notificaciones Service recibe el evento y muestra una confirmación.
7. Productos Service consume el evento para simular la actualización de stock.

## 🛠️ Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Cloud Eureka
* Spring Cloud Gateway
* Apache Kafka
* Docker
* Gradle
* H2 Database

## ▶️ Ejecución del proyecto

### 1. Levantar Kafka y Zookeeper

```bash
docker compose up -d
```

### 2. Ejecutar los microservicios

Iniciar los servicios en el siguiente orden:

1. Eureka Server
2. Gateway Service
3. Clientes Service
4. Productos Service
5. Pedidos Service
6. Notificaciones Service

```bash
./gradlew bootRun
```

### 3. Verificar Eureka

Acceder a:

http://localhost:8761

Todos los microservicios deben aparecer con estado **UP**.

## 🌐 Endpoints principales

### Clientes

GET

http://localhost:8080/api/clientes/clientes

### Productos

GET

http://localhost:8080/api/productos/productos

### Pedidos

POST

http://localhost:8080/api/pedidos

Ejemplo de solicitud:

```json
{
  "id": 1,
  "clienteId": 5,
  "productoId": 10,
  "cantidad": 3
}
```

## 📨 Comunicación con Kafka

Topic utilizado:

```text
pedidos-topic
```

Ejemplo de evento publicado:

```text
Pedido ID: 1, Cliente ID: 5, Producto ID: 10, Cantidad: 3
```

El evento es consumido por:

* Notificaciones Service
* Productos Service

## 🎯 Objetivos alcanzados

* Arquitectura basada en microservicios.
* Descubrimiento de servicios con Eureka.
* Enrutamiento mediante Gateway.
* Comunicación REST.
* Comunicación asíncrona con Apache Kafka.
* Integración con Docker.
* Simulación de actualización de inventario mediante eventos.
