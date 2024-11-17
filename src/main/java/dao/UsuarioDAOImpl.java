/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Usuario;
import model.DatabaseConnector;
import model.Venta;
import model.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAOImpl implements UsuarioDAO {
    private DatabaseConnector dbConnector;
    private Connection connection;

  public UsuarioDAOImpl(DatabaseConnector dbConnector) {
    this.dbConnector = dbConnector;
    try {
        this.connection = dbConnector.getConnection();
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, "Error al obtener la conexión", ex);
    }
}

    @Override
    public void registrarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (nombre, email, contrasena) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContrasena());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Usuario iniciarSesion(String email, String contrasena) throws SQLException {
    Usuario usuario = null;
    String query = "SELECT * FROM usuario WHERE email = ? AND contrasena = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, email);
        stmt.setString(2, contrasena);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            usuario = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("contrasena")
            );
        }
    }
    return usuario; // SQLException se propagará automáticamente si ocurre
}

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("contrasena")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
        public void actualizarUsuario(int idUsuario, String nombre, String email, String contrasena) {
        String query = "UPDATE usuario SET nombre=?, email=?, contrasena=? WHERE idUsuario=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, contrasena);
            stmt.setInt(4, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        String query = "DELETE FROM usuarios WHERE idUsuario=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<Compra> getComprasPorUsuario(int idUsuario) {
    List<Compra> compras = new ArrayList<>();
    String query = "SELECT idCompra, fechaCompra, ticket, cantidad, precioXticket FROM compra WHERE idUsuario = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Compra compra = new Compra(
                    rs.getInt("idCompra"),
                    rs.getDate("fechaCompra"), // Suponiendo que fechaCompra es de tipo Date en la base de datos
                    rs.getString("ticket"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precioXticket")
            );
            compras.add(compra);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return compras;
}

    
    @Override
    public List<Venta> getVentasPorUsuario(int idUsuario) {
          List<Venta> ventas = new ArrayList<>();
            String query = "SELECT idVenta, fechaVenta, ticket, cantidad, precioXticket, idCompra FROM venta WHERE idUsuario = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, idUsuario);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs.getInt("idVenta"));
                    venta.setFechaVenta(rs.getDate("fechaVenta")); // Convertir a java.util.Date si es necesario
                    venta.setTicket(rs.getString("ticket"));
                    venta.setCantidad(rs.getInt("cantidad")); // Convertir de double a int si aplica
                    venta.setPrecioTicket(rs.getDouble("precioXticket"));

                    // Opcional: asignar relaciones si es necesario
                    Compra compra = new Compra();
                    compra.setIdCompra(rs.getInt("idCompra"));
                    venta.setCompra(compra); // Establecer relación con la compra

                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(idUsuario);
                    venta.setUsuario(usuario); // Establecer relación con el usuario

                    ventas.add(venta);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ventas;
    }
    
    
    



    @Override
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}