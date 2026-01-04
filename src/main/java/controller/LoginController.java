/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import encriptado.GestionPasswords;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Usuario;
import util.SesionDeUsuario;

/**
 * FXML Controller class
 *
 * @author hugob
 */
public class LoginController implements Initializable {

    @FXML
    private TextField campoUsuario;
    @FXML
    private PasswordField campoPass;
    @FXML
    private TextField campoPassVisible;
    @FXML
    private Button btnVerPass;
    @FXML
    private Label errorLabel;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Hyperlink linkRegistrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void iniciarSesion(ActionEvent event) {

        String usuario = campoUsuario.getText();
        String password = campoPass.isVisible() ? campoPass.getText() : campoPassVisible.getText();
        try {
            if (usuario.isEmpty() || password.isEmpty()) {
                mostrarError("Por favor, completa todos los campos");
                return;
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioEncontrado = usuarioDAO.buscarPorUsuario(usuario);
            if (usuarioEncontrado == null) {
                mostrarError("Usuario no encontrado");
                return;
            }
            boolean passwordCorrecta = GestionPasswords.verificarPassword(password, usuarioEncontrado.getPassword());

            if (!passwordCorrecta) {
                mostrarError("Contraseña incorrecta");
                return;
            }
            SesionDeUsuario.setUsuarioActual(usuarioEncontrado);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/PaneldeControl.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) btnIniciarSesion.getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                mostrarError("Error al cargar el Panel de Control");
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            mostrarError("Error al conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private void mostrarError(String mensaje) {
        errorLabel.setVisible(true);
        errorLabel.setText(mensaje);
        errorLabel.setManaged(true);
    }

    @FXML
    private void abrirVentanaRegistro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/RegistroPopup.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.initStyle(StageStyle.TRANSPARENT);

            popupStage.initModality(Modality.APPLICATION_MODAL);
            Stage loginStage = (Stage) linkRegistrar.getScene().getWindow();
            popupStage.initOwner(loginStage);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            popupStage.setScene(scene);

            popupStage.setTitle("Registro de Usuario");
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            mostrarError("Error al abrir ventana de registro");
            e.printStackTrace();
        }
    }

    @FXML
    private void verContraseña(ActionEvent event) {
        if (campoPass.isVisible()) {
            campoPassVisible.setText(campoPass.getText());
            campoPass.setVisible(false);
            campoPass.setManaged(false);
            campoPassVisible.setVisible(true);
            campoPassVisible.setManaged(true);
        } else {
            campoPass.setText(campoPassVisible.getText());
            campoPassVisible.setVisible(false);
            campoPassVisible.setManaged(false);
            campoPass.setVisible(true);
            campoPass.setManaged(true);
        }
    }
}
