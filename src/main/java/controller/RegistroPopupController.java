/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import encriptado.GestionPasswords;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;
import modelo.Usuario.Role;
import util.Validaciones;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class RegistroPopupController implements Initializable {

     @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoNombreCompleto;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private PasswordField campoConfirmarPassword;
    @FXML
    private ComboBox<String> comboRole;
    @FXML
    private Label errorLabel;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnRegistrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboRole.setItems(FXCollections.observableArrayList("USUARIO", "ADMIN"));
        comboRole.getSelectionModel().selectFirst(); 
    }

    @FXML
    private void registrarUsuario(ActionEvent event) {
        String usuario = campoUsuario.getText();
        String email = campoEmail.getText();
        String nombreCompleto = campoNombreCompleto.getText();
        String password = campoPassword.getText();
        String confirmarPassword = campoConfirmarPassword.getText();
        String roleSeleccionado = comboRole.getValue();

        try {
            if (!Validaciones.campoNoVacio(usuario) || 
                !Validaciones.campoNoVacio(email) || 
                !Validaciones.campoNoVacio(nombreCompleto) || 
                !Validaciones.campoNoVacio(password) || 
                !Validaciones.campoNoVacio(confirmarPassword) ||
                roleSeleccionado == null) {
                mostrarError("Por favor, completa todos los campos");
                return;
            }

            if (!Validaciones.usuarioValido(usuario)) {
                mostrarError("Usuario inválido (3-20 caracteres, solo letras, números y _)");
                return;
            }

            if (!Validaciones.emailValido(email)) {
                mostrarError("El formato del email no es válido");
                return;
            }

            if (!Validaciones.nombreCompletoValido(nombreCompleto)) {
                mostrarError("Nombre completo inválido (mínimo nombre y apellido)");
                return;
            }

            if (!Validaciones.passwordLongitudValida(password, 6)) {
                mostrarError("La contraseña debe tener al menos 6 caracteres");
                return;
            }

            if (!Validaciones.passwordsCoinciden(password, confirmarPassword)) {
                mostrarError("Las contraseñas no coinciden");
                return;
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.existeUsuario(usuario)) {
                mostrarError("El usuario ya existe");
                return;
            }

            if (usuarioDAO.existeEmail(email)) {
                mostrarError("El email ya está registrado");
                return;
            }

            String passwordEncriptada = GestionPasswords.hashPassword(password);

            Role role = Role.valueOf(roleSeleccionado);
            Usuario nuevoUsuario = new Usuario(usuario, email, nombreCompleto, passwordEncriptada, role);

            int idGenerado = usuarioDAO.insertar(nuevoUsuario);

            if (idGenerado > 0) {
                System.out.println("Usuario registrado exitosamente con ID: " + idGenerado);
                cerrarVentana();
            } else {
                mostrarError("Error al registrar el usuario");
            }

        } catch (SQLException ex) {
            mostrarError("Error de base de datos: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            mostrarError("Error: Rol no válido");
            ex.printStackTrace();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void mostrarError(String mensaje) {
        errorLabel.setText(mensaje);
        errorLabel.setVisible(true);
        errorLabel.setManaged(true);
    }

    private void cerrarVentana() {
        Stage stage = (Stage) campoUsuario.getScene().getWindow();
        stage.close();
    }
}

