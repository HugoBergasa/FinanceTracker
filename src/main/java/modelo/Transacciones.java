/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author hugob
 */
public class Transacciones {

    public enum TipoTransaccion {
        INGRESO, GASTO
    }

    private int idTransaccion;
    private int idCuenta;
    private Integer idCategoria;
    private String idTransaccionNordigen;
    private BigDecimal cantidad;
    private LocalDate fechaTransaccion;
    private TipoTransaccion tipoTransaccion;
    private String descripcion;
    private String conceptoOriginal;
    private String beneficiario;
    private boolean esRecurrente;
    private boolean clasificadaAutomaticamente;
    private boolean esDesdeBanco;
    private LocalDateTime fechaCreacion;

    public Transacciones(int idTransaccion, int idCuenta, int idCategoria, String idTransaccionNordigen, BigDecimal cantidad, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion, String descripcion, String conceptoOriginal, String beneficiario, boolean esRecurrente, boolean clasificadaAutomaticamente, boolean esDesdeBanco, LocalDateTime fechaCreacion) {
        this.idTransaccion = idTransaccion;
        this.idCuenta = idCuenta;
        this.idCategoria = idCategoria;
        this.idTransaccionNordigen = idTransaccionNordigen;
        this.cantidad = cantidad;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
        this.conceptoOriginal = conceptoOriginal;
        this.beneficiario = beneficiario;
        this.esRecurrente = esRecurrente;
        this.clasificadaAutomaticamente = clasificadaAutomaticamente;
        this.esDesdeBanco = esDesdeBanco;
        this.fechaCreacion = fechaCreacion;
    }

    //CONSTRUCTOR PARA TRANSACCIONES DE NORDIGEN
    public Transacciones(int idCuenta, String idTransaccionNordigen, BigDecimal cantidad, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion, String conceptoOriginal, String beneficiario) {
        this.idCuenta = idCuenta;
        this.idCategoria = null;
        this.idTransaccionNordigen = idTransaccionNordigen;
        this.cantidad = cantidad;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = conceptoOriginal;
        this.conceptoOriginal = conceptoOriginal;
        this.beneficiario = beneficiario;
        this.esRecurrente = false;
        this.clasificadaAutomaticamente = false;
        this.esDesdeBanco = true;
    }

    //CONSTRUCTOR PARA TRANSACCIONES MANUALES
    public Transacciones(int idCuenta, BigDecimal cantidad, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion, String descripcion, String beneficiario) {
        this.idCuenta = idCuenta;
        this.idCategoria = null;
        this.idTransaccionNordigen = null;
        this.cantidad = cantidad;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
        this.conceptoOriginal = descripcion;
        this.beneficiario = beneficiario;
        this.esRecurrente = false;
        this.clasificadaAutomaticamente = false;
        this.esDesdeBanco = false;
    }

    public Transacciones(int idCuenta, Integer idCategoria, BigDecimal cantidad, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion, String descripcion, String beneficiario, boolean esDesdeBanco) {
        this.idCuenta = idCuenta;
        this.idCategoria = idCategoria;
        this.cantidad = cantidad;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
        this.conceptoOriginal = descripcion;
        this.beneficiario = beneficiario;
        this.esRecurrente = false;
        this.clasificadaAutomaticamente = (idCategoria != null);
        this.esDesdeBanco = esDesdeBanco;
    }

    public Transacciones() {
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getIdTransaccionNordigen() {
        return idTransaccionNordigen;
    }

    public void setIdTransaccionNordigen(String idTransaccionNordigen) {
        this.idTransaccionNordigen = idTransaccionNordigen;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConceptoOriginal() {
        return conceptoOriginal;
    }

    public void setConceptoOriginal(String conceptoOriginal) {
        this.conceptoOriginal = conceptoOriginal;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public boolean isEsRecurrente() {
        return esRecurrente;
    }

    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }

    public boolean isClasificadaAutomaticamente() {
        return clasificadaAutomaticamente;
    }

    public void setClasificadaAutomaticamente(boolean clasificadaAutomaticamente) {
        this.clasificadaAutomaticamente = clasificadaAutomaticamente;
    }

    public boolean isEsDesdeBanco() {
        return esDesdeBanco;
    }

    public void setEsDesdeBanco(boolean esDesdeBanco) {
        this.esDesdeBanco = esDesdeBanco;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
