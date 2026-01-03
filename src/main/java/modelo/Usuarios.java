/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author hugob
 */
public class Usuarios {
    
    public enum Role{
        USUARIO, ADMIN
    }
    
    private int idUsuario;
    private String usuario;
    private String email;
    private String nombreCompleto;
    private String password;
    private Role role;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Usuarios(int idUsuario, String usuario, String email, String nombreCompleto, String password, Role role, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.role = role;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Usuarios(String usuario, String email, String nombreCompleto, String password, Role role) {
        this.usuario = usuario;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.role = role;
    }
    
    

    public Usuarios() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    
    
}
