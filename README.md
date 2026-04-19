# Barbería System

Sistema de gestión para barbería desarrollado con Spring Boot (backend) y HTML + Tailwind + JS (frontend).

## Estructura
- `backend/` — Spring Boot + JPA + SQL Server
- `frontend/` — HTML, Tailwind CSS, JavaScript vanilla

## Cómo correr el proyecto

## ¿Cómo se mapea MVC aquí?

Model — model/, service/, repository/
En Spring Boot el Model se divide en tres subcapas, cada una con su responsabilidad:
model/ contiene las clases Java que representan tus tablas SQL. Por ejemplo, Cliente.java tendrá los mismos atributos que la tabla CLIENTES (nombre, apellido, telefono...). Son los objetos con los que trabaja toda la app.
repository/ es quien habla con la base de datos. Con Spring Boot usas JpaRepository y casi no necesitas escribir SQL a mano — Spring lo genera solo.
service/ contiene la lógica del negocio. Por ejemplo: "antes de guardar una cita, verificar que el barbero no tenga otra cita en esa hora". Esta lógica no va ni en el controller ni en el repository — va aquí.

Controller — controller/
Recibe las peticiones HTTP que llegan desde el frontend (GET, POST, PUT, DELETE), llama al service correspondiente, y devuelve la respuesta en JSON. Es el puente entre la vista y el modelo.

View — frontend/views/, frontend/components/
Tus archivos HTML con Tailwind. Cada vista corresponde a un módulo del sistema (clientes, citas, etc.). Los components/ son partes reutilizables como el navbar o los modales.

Extras importantes
dto/ — Los DTO (Data Transfer Object) son clases que definen exactamente qué datos envías al frontend, evitando exponer toda la entidad de la base de datos. Es una buena práctica de seguridad.
js/api.js — Archivo central que maneja todas las llamadas fetch() o $.ajax() al backend Spring Boot. Todos los demás .js lo usan para no repetir código.
resources/db/ — Aquí van tus scripts SQL (schema.sql para crear tablas, data.sql para los datos de prueba que ya escribimos).

### Frontend
1. Abre `frontend/views/index.html` en tu navegador.

## Endpoints disponibles
| Método | URL                  | Acción          |
|--------|----------------------|-----------------|
| GET    | /api/clientes        | Listar todos    |
| GET    | /api/clientes/{id}   | Buscar por ID   |
| POST   | /api/clientes        | Crear nuevo     |
| PUT    | /api/clientes/{id}   | Actualizar      |
| DELETE | /api/clientes/{id}   | Eliminar        |

*Los mismos endpoints aplican para: empleados, servicios, citas, productos, facturas.*
