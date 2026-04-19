-- ══════════════════════════════════════
--  Datos de prueba — Barbería System
-- ══════════════════════════════════════

INSERT INTO CLIENTES (nombre, apellido, telefono, email, fecha_nacimiento) VALUES
('Carlos',   'Ramírez',  '3001234567', 'carlos@email.com',  '1990-05-14'),
('Andrés',   'Gómez',    '3119876543', 'andres@email.com',  '1985-08-22'),
('Luis',     'Herrera',  '3204567890', 'luis@email.com',    '1998-03-10'),
('Santiago', 'Torres',   '3157654321', 'santi@email.com',   '2000-11-01'),
('Felipe',   'Morales',  '3006543210', 'felipe@email.com',  '1993-07-30');

INSERT INTO EMPLEADOS (nombre, apellido, cargo, especialidad, salario) VALUES
('Miguel',  'Sánchez', 'Barbero', 'Cortes clásicos y afeitado',   2500000),
('Julián',  'Castro',  'Barbero', 'Degradados y diseño de barba', 2500000),
('Camilo',  'Vargas',  'Barbero', 'Cortes modernos y coloración', 2200000),
('Daniela', 'Reyes',   'Cajero',  NULL,                           1800000),
('Tomás',   'López',   'Barbero', 'Cortes infantiles y clásicos', 2000000);

INSERT INTO SERVICIOS (nombre, descripcion, precio, duracion_min) VALUES
('Corte clásico',     'Corte con tijera y máquina',            25000, 30),
('Corte + barba',     'Corte completo más arreglo de barba',   40000, 50),
('Afeitado clásico',  'Afeitado con navaja y toalla caliente', 20000, 25),
('Degradado moderno', 'Fade + diseño personalizado',           35000, 45),
('Corte infantil',    'Corte para niños hasta 12 años',        18000, 20);

INSERT INTO CITAS (id_cliente, id_empleado, id_servicio, fecha_hora, estado) VALUES
(1, 1, 1, '2025-06-10 09:00:00', 'Completada'),
(2, 2, 2, '2025-06-10 10:00:00', 'Completada'),
(3, 3, 4, '2025-06-11 11:30:00', 'Confirmada'),
(4, 5, 5, '2025-06-11 14:00:00', 'Pendiente'),
(5, 1, 3, '2025-06-12 09:30:00', 'Pendiente');

INSERT INTO PRODUCTOS (nombre, marca, stock_actual, stock_minimo, precio_venta) VALUES
('Cera mate',          'American Crew', 20, 5, 35000),
('Aceite para barba',  'Beardilizer',   15, 5, 45000),
('Crema de afeitar',   'Proraso',       10, 3, 28000),
('Shampoo para barba', 'Bulldog',       12, 5, 32000),
('Pomada fijadora',    'Layrite',        8, 3, 40000);

INSERT INTO FACTURAS (id_cliente, id_cita, total, metodo_pago) VALUES
(1, 1, 25000, 'Efectivo'),
(2, 2, 40000, 'Nequi'),
(3, 3, 35000, 'Tarjeta'),
(4, 4, 18000, 'Efectivo'),
(5, 5, 20000, 'Transferencia');

INSERT INTO DETALLE_FACTURA (id_factura, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 1, 35000),
(2, 2, 1, 45000),
(3, 3, 2, 28000),
(4, 4, 1, 32000),
(5, 5, 1, 40000);
