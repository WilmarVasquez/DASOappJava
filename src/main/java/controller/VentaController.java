/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VentaDAO;
import dao.VentaDAOImpl;
import model.Compra;
import model.DatabaseConnector;
import model.Venta;

import java.sql.SQLException;
import java.util.List;

public class VentaController {

    private VentaDAO ventaDAO;
    private CompraController compraController; // Atributo para manejar el controlador de compras

    // Constructor con inyección de dependencia para DatabaseConnector
    public VentaController(DatabaseConnector dbConnector) {
        this.ventaDAO = new VentaDAOImpl(dbConnector);
        this.compraController = new CompraController(dbConnector); // Inicializamos el CompraController
    }

    // Método para acceder al CompraController
    public CompraController getCompraController() {
        return compraController;
    }

    // Métodos para gestionar ventas
    public void agregarVenta(Venta venta) throws SQLException {
        if (venta == null) {
            throw new IllegalArgumentException("La venta no puede ser nula.");
        }
        if (venta.getCantidad() <= 0 || venta.getPrecioTicket() <= 0) {
            throw new IllegalArgumentException("La cantidad y el precio deben ser mayores a 0.");
        }
        ventaDAO.agregarVenta(venta);
    }

    public Venta leerVenta(int idVenta) throws SQLException {
        if (idVenta <= 0) {
            throw new IllegalArgumentException("El ID de la venta debe ser mayor a 0.");
        }
        return ventaDAO.obtenerVentaPorId(idVenta);
    }

    public void actualizarVenta(Venta venta) throws SQLException {
        if (venta == null || venta.getIdVenta() <= 0) {
            throw new IllegalArgumentException("La venta o su ID no son válidos.");
        }
        ventaDAO.actualizarVenta(venta);
    }

    public void eliminarVenta(int idVenta) throws SQLException {
        if (idVenta <= 0) {
            throw new IllegalArgumentException("El ID de la venta debe ser mayor a 0.");
        }
        ventaDAO.eliminarVenta(idVenta);
    }

    public List<Venta> listarVentas() throws SQLException {
        return ventaDAO.listarVentas();
    }

    // Método para cerrar conexiones (opcional, si manejas conexiones manualmente)
    public void cerrarConexion() {
        // Si el DAO administra conexiones, puedes cerrarlas aquí
    }
}
