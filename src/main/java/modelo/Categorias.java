/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hugob
 */
public class Categorias {
    
    public enum TipoCategoria{
        INGRESO,GASTO
    }
    
    private int idCategoria;
    private String nombreCategoria;
    private TipoCategoria tipoCategoria;
    private String palabrasClave;

    public Categorias(int idCategoria, String nombreCategoria, TipoCategoria tipoCategoria, String palabrasClave) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.tipoCategoria = tipoCategoria;
        this.palabrasClave = palabrasClave;
    }

    public Categorias(String nombreCategoria, TipoCategoria tipoCategoria, String palabrasClave) {
        this.nombreCategoria = nombreCategoria;
        this.tipoCategoria = tipoCategoria;
        this.palabrasClave = palabrasClave;
    }

    public Categorias() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
}

