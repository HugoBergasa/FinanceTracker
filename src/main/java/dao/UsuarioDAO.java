/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import encriptado.GestionPasswords;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import util.DatabaseConnection;

/**
 *
 * @author hugob
 */
public class UsuarioDAO {

    private DatabaseConnection dbConnection;

    public UsuarioDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
    }

    //MÉTODO PARA BUSCAR CUENTAS COMPLETAS POR USUARIO
    public Usuario buscarPorUsuario(String usuario) throws SQLException {
        String consulta = "SELECT idUsuario, usuario, email, nombreCompleto, password, role, "
                + "fechaCreacion, fechaActualizacion FROM USUARIOS WHERE usuario = ?";

        Usuario usuarioEncontrado = null;

        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(consulta)) {

            ps.setString(1, usuario);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    usuarioEncontrado = new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getString("usuario"),
                            rs.getString("email"),
                            rs.getString("nombreCompleto"),
                            rs.getString("password"),
                            Usuario.Role.valueOf(rs.getString("role")),
                            rs.getTimestamp("fechaCreacion").toLocalDateTime(),
                            rs.getTimestamp("fechaActualizacion").toLocalDateTime()
                    );
                }
            }
        }

        return usuarioEncontrado;
    }

    //MÉTODO PARA BUSCAR CUENTAS COMPLETAS POR EMAIL
    public Usuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT idUsuario, usuario, email, nombreCompleto, password, role, "
                + "fechaCreacion, fechaActualizacion FROM USUARIOS WHERE email = ?";

        Usuario usuarioEncontrado = null;
        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuarioEncontrado = new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getString("usuario"),
                            rs.getString("email"),
                            rs.getString("nombreCompleto"),
                            rs.getString("password"),
                            Usuario.Role.valueOf(rs.getString("role")),
                            rs.getTimestamp("fechaCreacion").toLocalDateTime(),
                            rs.getTimestamp("fechaActualizacion").toLocalDateTime()
                    );
                }
            }
        }

        return usuarioEncontrado;
    }

    //MÉTODO PARA BUSCAR CUENTAS COMPLETAS POR idUsuario
    public Usuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT idUsuario, usuario, email, nombreCompleto, password, role, "
                + "fechaCreacion, fechaActualizacion FROM USUARIOS WHERE idUsuario = ?";

        Usuario usuarioEncontrado = null;
        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuarioEncontrado = new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getString("usuario"),
                            rs.getString("email"),
                            rs.getString("nombreCompleto"),
                            rs.getString("password"),
                            Usuario.Role.valueOf(rs.getString("role")),
                            rs.getTimestamp("fechaCreacion").toLocalDateTime(),
                            rs.getTimestamp("fechaActualizacion").toLocalDateTime()
                    );
                }
            }
        }

        return usuarioEncontrado;
    }

    //MÉTODO PARA INSERTAR USUARIOS, GUARDAMOS EL ID PARA GUARDAR EL ID DE LA SESION, CONECTARSE CON EL BANCO Y SINCRONIZAR TRANSACCIONES
    public int insertar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIOS (usuario, email, nombreCompleto, password, role) "
                + "VALUES (?, ?, ?, ?, ?)";

        int idGenerado = -1;
        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombreCompleto());

            String passwordEncriptado = GestionPasswords.hashPassword(usuario.getPassword());
            ps.setString(4, passwordEncriptado);

            ps.setString(5, usuario.getRole().toString());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt(1);
                        System.out.println("Usuario insertado con ID: " + idGenerado);
                    }
                }
            }
        }

        return idGenerado;
    }

    //MÉTODO PARA VALIDAR SI EXISTE UN USUARIO GRACIAS AL MÉTODO bucarPorUsuario
    public boolean existeUsuario(String usuario) throws SQLException {
        return buscarPorUsuario(usuario) != null;
    }

    //MÉTODO PARA VALIDAR SI EXISTE UN EMAIL GRACIAS AL MÉTODO bucarPorEmail
    public boolean existeEmail(String email) throws SQLException {
        return buscarPorEmail(email) != null;
    }

    //MÉTODO PARA ACTUALIZAR LOS USUARIOS
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIOS SET usuario = ?, email = ?, nombreCompleto = ?, "
                + "password = ?, role = ? WHERE idUsuario = ?";

        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getNombreCompleto());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getRole().toString());

            ps.setInt(6, usuario.getIdUsuario());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado correctamente");
            } else {
                System.out.println("No se encontró el usuario con ID: " + usuario.getIdUsuario());
            }
        }
    }

    //MÉTODO PARA ELIMINAR USUARIOS,  EN CASO DE QUE HAGA PANEL DE ADMIN
    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE idUsuario = ?";

        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente");
            } else {
                System.out.println("No se encontró el usuario con ID: " + id);
            }
        }
    }

    //MÉTODO PARA OBTENER TODOS LOS USUARIOS, EN CASO DE QUE HAGA PANEL DE ADMIN
    public List<Usuario> obtenerTodos() throws SQLException {
        String sql = "SELECT idUsuario, usuario, email, nombreCompleto, password, role, "
                + "fechaCreacion, fechaActualizacion FROM USUARIOS ORDER BY fechaCreacion DESC";

        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = dbConnection.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("usuario"),
                        rs.getString("email"),
                        rs.getString("nombreCompleto"),
                        rs.getString("password"),
                        Usuario.Role.valueOf(rs.getString("role")),
                        rs.getTimestamp("fechaCreacion").toLocalDateTime(),
                        rs.getTimestamp("fechaActualizacion").toLocalDateTime()
                );

                usuarios.add(usuario);
            }
        }

        return usuarios;
    }
}
