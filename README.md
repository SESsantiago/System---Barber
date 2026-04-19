# Barbería System

Sistema de gestión para barbería desarrollado con Spring Boot (backend) y HTML + Tailwind + JS (frontend).

## Estructura
- `backend/` — Spring Boot + JPA + SQL Server
- `frontend/` — HTML, Tailwind CSS, JavaScript vanilla

## Cómo correr el proyecto

### Backend
1. Abre `backend/` en IntelliJ IDEA o VS Code con extensión Java.
2. Edita `src/main/resources/application.properties` con tu contraseña de SQL Server.
3. Ejecuta `BarberiApplication.java`.
4. El API queda disponible en `http://localhost:8080/api/`.

### Frontend
1. Abre `frontend/views/index.html` en tu navegador.
2. Opcional: ejecuta `npm install && npm run dev` para compilar Tailwind en local.

## Endpoints disponibles
| Método | URL                  | Acción          |
|--------|----------------------|-----------------|
| GET    | /api/clientes        | Listar todos    |
| GET    | /api/clientes/{id}   | Buscar por ID   |
| POST   | /api/clientes        | Crear nuevo     |
| PUT    | /api/clientes/{id}   | Actualizar      |
| DELETE | /api/clientes/{id}   | Eliminar        |

*Los mismos endpoints aplican para: empleados, servicios, citas, productos, facturas.*
