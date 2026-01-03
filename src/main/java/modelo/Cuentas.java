/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author hugob
 */
public class Cuentas {

    private int idCuenta;
    private int idUsuario;
    private Integer idConexion;
    private String idCuentaNordigen;
    private String nombreCuenta;
    private String nombreBanco;
    private String iban;
    private BigDecimal balance;
    private String tipoMoneda;
    private boolean esCuentaReal;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaSincronizacion;

    public Cuentas(int idCuenta, int idUsuario, Integer idConexion, String idCuentaNordigen, String nombreCuenta, String nombreBanco, String iban, BigDecimal balance, String tipoMoneda, boolean esCuentaReal, LocalDateTime fechaCreacion, LocalDateTime ultimaSincronizacion) {
        this.idCuenta = idCuenta;
        this.idUsuario = idUsuario;
        this.idConexion = idConexion;
        this.idCuentaNordigen = idCuentaNordigen;
        this.nombreCuenta = nombreCuenta;
        this.nombreBanco = nombreBanco;
        this.iban = iban;
        this.balance = balance;
        this.tipoMoneda = tipoMoneda;
        this.esCuentaReal = esCuentaReal;
        this.fechaCreacion = fechaCreacion;
        this.ultimaSincronizacion = ultimaSincronizacion;
    }
    
    // CONSTRUCTOR PARA CREACIÓN DE CUENTA MANUAL
    public Cuentas(int idUsuario, String nombreCuenta, String nombreBanco, String iban, BigDecimal balance, String tipoMoneda) {
        this.idUsuario = idUsuario;
        this.idConexion = null; 
        this.nombreCuenta = nombreCuenta;
        this.nombreBanco = nombreBanco;
        this.iban = iban;
        this.balance = balance;
        this.tipoMoneda = tipoMoneda;
        this.esCuentaReal = false; 
    }

    //CONSTRUCTOR PARA CREACIÓN DE CUENTA CON NORDIGEN
    public Cuentas(int idUsuario, Integer idConexion, String idCuentaNordigen, String nombreCuenta, String nombreBanco, String iban, BigDecimal balance, String tipoMoneda) {
        this.idUsuario = idUsuario;
        this.idConexion = idConexion;
        this.idCuentaNordigen = idCuentaNordigen;
        this.nombreCuenta = nombreCuenta;
        this.nombreBanco = nombreBanco;
        this.iban = iban;
        this.balance = balance;
        this.tipoMoneda = tipoMoneda;
        this.esCuentaReal = true; 
    }

    public Cuentas() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(Integer idConexion) {
        this.idConexion = idConexion;
    }

    public String getIdCuentaNordigen() {
        return idCuentaNordigen;
    }

    public void setIdCuentaNordigen(String idCuentaNordigen) {
        this.idCuentaNordigen = idCuentaNordigen;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public boolean isEsCuentaReal() {
        return esCuentaReal;
    }

    public void setEsCuentaReal(boolean esCuentaReal) {
        this.esCuentaReal = esCuentaReal;
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
