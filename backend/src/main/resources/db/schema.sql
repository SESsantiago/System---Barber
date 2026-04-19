-- ══════════════════════════════════════════════
--  Barbería System — Schema SQL Server (T-SQL)
-- ══════════════════════════════════════════════

CREATE TABLE CLIENTES (
    id_cliente      INT IDENTITY(1,1) PRIMARY KEY,
    nombre          VARCHAR(50)  NOT NULL,
    apellido        VARCHAR(50)  NOT NULL,
    telefono        VARCHAR(20),
    email           VARCHAR(100),
    fecha_nacimiento DATE,
    fecha_creacion  DATETIME     DEFAULT GETDATE()
);

CREATE TABLE EMPLEADOS (
    id_empleado     INT IDENTITY(1,1) PRIMARY KEY,
    nombre          VARCHAR(50)  NOT NULL,
    apellido        VARCHAR(50)  NOT NULL,
    cargo           VARCHAR(50)  NOT NULL,
    especialidad    VARCHAR(100),
    salario         DECIMAL(10,2),
    fecha_creacion  DATETIME     DEFAULT GETDATE()
);

CREATE TABLE SERVICIOS (
    id_servicio     INT IDENTITY(1,1) PRIMARY KEY,
    nombre          VARCHAR(100) NOT NULL,
    descripcion     VARCHAR(255),
    precio          DECIMAL(10,2) NOT NULL,
    duracion_min    INT           NOT NULL
);

CREATE TABLE CITAS (
    id_cita         INT IDENTITY(1,1) PRIMARY KEY,
    id_cliente      INT          NOT NULL,
    id_empleado     INT          NOT NULL,
    id_servicio     INT          NOT NULL,
    fecha_hora      DATETIME     NOT NULL,
    estado          VARCHAR(20)  NOT NULL DEFAULT 'Pendiente',
    observaciones   TEXT,
    fecha_creacion  DATETIME     DEFAULT GETDATE(),
    CONSTRAINT FK_Cita_Cliente   FOREIGN KEY (id_cliente)  REFERENCES CLIENTES(id_cliente),
    CONSTRAINT FK_Cita_Empleado  FOREIGN KEY (id_empleado) REFERENCES EMPLEADOS(id_empleado),
    CONSTRAINT FK_Cita_Servicio  FOREIGN KEY (id_servicio) REFERENCES SERVICIOS(id_servicio)
);

CREATE TABLE PRODUCTOS (
    id_producto     INT IDENTITY(1,1) PRIMARY KEY,
    nombre          VARCHAR(100) NOT NULL,
    marca           VARCHAR(50),
    stock_actual    INT          NOT NULL DEFAULT 0,
    stock_minimo    INT          NOT NULL DEFAULT 5,
    precio_venta    DECIMAL(10,2),
    fecha_creacion  DATETIME     DEFAULT GETDATE()
);

CREATE TABLE FACTURAS (
    id_factura      INT IDENTITY(1,1) PRIMARY KEY,
    id_cliente      INT          NOT NULL,
    id_cita         INT,
    total           DECIMAL(10,2) NOT NULL,
    metodo_pago     VARCHAR(30)  NOT NULL,
    fecha_pago      DATETIME     DEFAULT GETDATE(),
    fecha_creacion  DATETIME     DEFAULT GETDATE(),
    CONSTRAINT FK_Factura_Cliente FOREIGN KEY (id_cliente) REFERENCES CLIENTES(id_cliente),
    CONSTRAINT FK_Factura_Cita    FOREIGN KEY (id_cita)    REFERENCES CITAS(id_cita)
);

CREATE TABLE DETALLE_FACTURA (
    id_detalle      INT IDENTITY(1,1) PRIMARY KEY,
    id_factura      INT           NOT NULL,
    id_producto     INT           NOT NULL,
    cantidad        INT           NOT NULL DEFAULT 1,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal        AS (cantidad * precio_unitario),
    CONSTRAINT FK_Detalle_Factura  FOREIGN KEY (id_factura)  REFERENCES FACTURAS(id_factura),
    CONSTRAINT FK_Detalle_Producto FOREIGN KEY (id_producto) REFERENCES PRODUCTOS(id_producto)
);
