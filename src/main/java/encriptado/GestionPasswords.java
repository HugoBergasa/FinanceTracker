/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptado;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author hugob
 */
public class GestionPasswords {
    
    //EL WORKLOAD EVITA ATAQUES DE FUERZA BRUTA CON UN TIEMPO DE ESPERA DE 0.3 SEGS APROX
    private static final int WORKLOAD = 12;
    

    public static String hashPassword(String passwordTextoPlano) {
        //El salt es una serie de caracteres aleatorios que se añaden a la contraseña para que cada una sea única.
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(passwordTextoPlano, salt);
    }
    

    public static boolean verificarPassword(String passwordTextoPlano, String hashAlmacenado) {
        try {
            return BCrypt.checkpw(passwordTextoPlano, hashAlmacenado);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
