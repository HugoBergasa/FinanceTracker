/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import modelo.Usuario;

/**
 *
 * @author hugob
 */
public class SesionDeUsuario {
    private static Usuario usuarioActual;
    
    /**
     * Guarda el usuario que acaba de hacer login
     * @param usuario Usuario logueado
     */
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    /**
     * Obtiene el usuario logueado
     * @return Usuario actual o null si no hay sesión
     */
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    /**
     * Obtiene el ID del usuario logueado
     * @return ID del usuario o -1 si no hay sesión
     */
    public static int getIdUsuario() {
        return usuarioActual != null ? usuarioActual.getIdUsuario() : -1;
    }
    
    /**
     * Cierra la sesión (limpia los datos del usuario)
     */
    public static void cerrarSesion() {
        usuarioActual = null;
    }
}

