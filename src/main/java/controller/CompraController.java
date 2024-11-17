/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DatabaseConnector;
import dao.CompraDAO;
import dao.CompraDAOImpl;
import model.Compra;

import java.sql.SQLException;
import java.util.List;

public class CompraController {

    private CompraDAO compraDAO;

    // Constructor con inyección de dependencia para DatabaseConnector
    public CompraController(DatabaseConnector dbConnector) {
        this.compraDAO = new CompraDAOImpl(dbConnector);
    }

    // Agregar una compra
    public void agregarCompra(Compra compra) throws SQLException {
        if (compra == null) {
            throw new IllegalArgumentException("La compra no puede ser nula.");
        }
        // Validaciones adicionales (opcional)
        if (compra.getCantidad() <= 0 || compra.getPrecioTicket() <= 0) {
            throw new IllegalArgumentException("Cantidad y precio deben ser mayores a 0.");
        }
        compraDAO.agregarCompra(compra);
    }

    // Leer una compra por ID
    public Compra leerCompra(int idCompra) throws SQLException {
        if (idCompra <= 0) {
            throw new IllegalArgumentException("El ID de la compra debe ser mayor a 0.");
        }
        return compraDAO.obtenerCompraPorId(idCompra);
    }

    // Actualizar una compra
    public void actualizarCompra(Compra compra) throws SQLException {
        if (compra == null || compra.getIdCompra() <= 0) {
            throw new IllegalArgumentException("La compra o su ID no son válidos.");
        }
        compraDAO.actualizarCompra(compra);
    }

    // Eliminar una compra
    public void eliminarCompra(int idCompra) throws SQLException {
        if (idCompra <= 0) {
            throw new IllegalArgumentException("El ID de la compra debe ser mayor a 0.");
        }
        compraDAO.eliminarCompra(idCompra);
    }

    // Listar todas las compras
    public List<Compra> listarCompras() throws SQLException {
        return compraDAO.listarCompras();
    }

    // Método para cerrar la conexión a la base de datos (opcional, según tu implementación)
    public void cerrarConexion() {
        // Si `CompraDAOImpl` administra la conexión, puedes cerrarla aquí
        // Si es necesario, implementa lógica de cierre en `CompraDAOImpl`
    }
}
    