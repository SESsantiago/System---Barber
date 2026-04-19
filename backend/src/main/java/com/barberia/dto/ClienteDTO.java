package com.barberia.dto;

// DTO: solo exponemos los datos necesarios al frontend (sin campos internos)
public class ClienteDTO {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public ClienteDTO() {}

    public ClienteDTO(Integer idCliente, String nombre, String apellido, String telefono, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
}
