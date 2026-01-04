/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author hugob
 */
public class Validaciones {

    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static boolean campoNoVacio(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public static boolean emailValido(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean passwordLongitudValida(String password, int longitudMinima) {
        return password != null && password.length() >= longitudMinima;
    }

    public static boolean passwordsCoinciden(String password, String confirmarPassword) {
        return password != null && password.equals(confirmarPassword);
    }

    public static boolean usuarioValido(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }
        return usuario.matches("^[a-zA-Z0-9_]{3,20}$");
    }

    public static boolean nombreCompletoValido(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            return false;
        }
        String[] palabras = nombreCompleto.trim().split("\\s+");
        return palabras.length >= 2 && nombreCompleto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }
}
