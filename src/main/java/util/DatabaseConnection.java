/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author hugob
 */
public class DatabaseConnection {

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String DRIVER;
    private static String PARAMS;
    private static String FULL_URL;

    private static DatabaseConnection instance;
    private Connection connection;

    //PATRÓN SINGLETON PARA QUE HAYA UNA ÚNICA CONEXIÓN ABIERTA EN TODO MOMENTO
    private DatabaseConnection() {
        cargarProperties();

        try {
            Class.forName(DRIVER);
            System.out.println("Driver MySQL cargado correctamente");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver MySQL");
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void cargarProperties() {
        Properties properties = new Properties();

        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró database.properties");
            }

            properties.load(input);

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
            DRIVER = properties.getProperty("db.driver");
            PARAMS = properties.getProperty("db.params");

            FULL_URL = (URL + PARAMS);

            System.out.println("Configuración cargada correctamente");

        } catch (IOException e) {
            System.err.println("Error al cargar database.properties");
            e.printStackTrace();
        }
    }

    // MÉTODO PARA ABRIR LA CONEXIÓN DE LA BASE DE DATOS
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(FULL_URL, USER, PASSWORD);
        }
        return connection;
    }

    //MÉTODO PARA CERRAR LA CONEXIÓN A LA BASE DE DATOS
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error al cerrar la conexión");
            ex.printStackTrace();
        }
    }
}
