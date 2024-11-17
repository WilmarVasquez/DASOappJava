/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Venta;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaDAOImpl implements VentaDAO {
    private Connection connection;

    // Constructor con inyección de dependencia para el DatabaseConnector
    public VentaDAOImpl(DatabaseConnector dbConnector) {
        try {
            this.connection = dbConnector.getConnection();
        } catch (SQLException e) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, "Error al establecer conexión", e);
        }
    }

    @Override
    public void agregarVenta(Venta venta) throws SQLException {
        String query = "INSERT INTO venta (fechaVenta, ticket, cantidad, precioXticket, totalInversion, idUsuario, idCompra) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setString(2, venta.getTicket());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDouble(4, venta.getPrecioTicket());
            stmt.setDouble(5, venta.getTotalVenta());
            stmt.setInt(6, venta.getUsuarioId());
            stmt.setInt(7, venta.getCompraId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Venta obtenerVentaPorId(int idVenta) throws SQLException {
        String query = "SELECT * FROM venta WHERE idVenta = ?";
        Venta venta = null;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                venta = mapearVenta(rs);
            }
        }
        return venta;
    }

    @Override
    public List<Venta> listarVentas() throws SQLException {
        String query = "SELECT * FROM venta";
        List<Venta> ventas = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ventas.add(mapearVenta(rs));
            }
        }
        return ventas;
    }

    @Override
    public void actualizarVenta(Venta venta) throws SQLException {
        String query = "UPDATE venta SET fechaVenta = ?, ticket = ?, cantidad = ?, precioXticket = ?, totalInversion = ?, idUsuario = ?, idCompra = ? WHERE idVenta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setString(2, venta.getTicket());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDouble(4, venta.getPrecioTicket());
            stmt.setDouble(5, venta.getTotalVenta());
            stmt.setInt(6, venta.getUsuarioId());
            stmt.setInt(7, venta.getCompraId());
            stmt.setInt(8, venta.getIdVenta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarVenta(int idVenta) throws SQLException {
        String query = "DELETE FROM venta WHERE idVenta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVenta);
            stmt.executeUpdate();
        }
    }

    // Método privado para mapear un ResultSet a un objeto Venta
    private Venta mapearVenta(ResultSet rs) throws SQLException {
        Venta venta = new Venta();
        venta.setIdVenta(rs.getInt("idVenta"));
        venta.setFechaVenta(rs.getDate("fechaVenta"));
        venta.setTicket(rs.getString("ticket"));
        venta.setCantidad(rs.getInt("cantidad"));
        venta.setPrecioTicket(rs.getDouble("precioXticket"));
        venta.setTotalVenta(rs.getDouble("totalInversion"));
        // Puedes agregar la lógica para mapear Usuario y Compra aquí si es necesario
        return venta;
    }
}

