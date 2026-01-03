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
public class ConexionesBancarias {

    public enum EstadoConexion {
        ACTIVA, EXPIRADA, REVOCADA
    }

    private int idConexion;
    private int idUsuario;
    private String nombreBanco;
    private String requisitionId;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime fechaExpiracion;
    private EstadoConexion estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaSincronizacion;

    public ConexionesBancarias(int idConexion, int idUsuario, String nombreBanco, String requisitionId, String accessToken, String refreshToken, LocalDateTime fechaExpiracion, EstadoConexion estado, LocalDateTime fechaCreacion, LocalDateTime ultimaSincronizacion) {
        this.idConexion = idConexion;
        this.idUsuario = idUsuario;
        this.nombreBanco = nombreBanco;
        this.requisitionId = requisitionId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.ultimaSincronizacion = ultimaSincronizacion;
    }

    //CONSTRUCTOR PARA NUEVAS CONEXIONES DE NORDIGEN
    public ConexionesBancarias(int idUsuario, String nombreBanco, String requisitionId, String accessToken, String refreshToken) {
        this.idUsuario = idUsuario;
        this.nombreBanco = nombreBanco;
        this.requisitionId = requisitionId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.fechaExpiracion = LocalDateTime.now().plusDays(90);  
        this.estado = EstadoConexion.ACTIVA;                    
        this.ultimaSincronizacion = null;              
    }

    public ConexionesBancarias() {
    }

    public int getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(int idConexion) {
        this.idConexion = idConexion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EstadoConexion getEstado() {
        return estado;
    }

    public void setEstado(EstadoConexion estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getUltimaSincronizacion() {
        return ultimaSincronizacion;
    }

    public void setUltimaSincronizacion(LocalDateTime ultimaSincronizacion) {
        this.ultimaSincronizacion = ultimaSincronizacion;
    }
    
    
}
