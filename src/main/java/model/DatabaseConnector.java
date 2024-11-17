/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {
    private static final Dotenv dotenv = Dotenv.load(); // Cargar las variables de entorno

    // Leer las credenciales desde el archivo .env
    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    // Singleton: conexión única
    private static Connection connection;

    /**
     * Obtiene la conexión única a la base de datos.
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al conectar.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.INFO, "Conexión establecida exitosamente");
            } catch (SQLException e) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, "Error al conectar con la base de datos", e);
                throw e; // Relanza la excepción para que sea manejada por el cliente
            }
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.INFO, "Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
        }
    }
}
