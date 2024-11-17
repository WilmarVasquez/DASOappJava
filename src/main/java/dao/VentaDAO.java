/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.Venta;
import java.sql.SQLException;
import java.util.List;

public interface VentaDAO {
    // Crear una nueva venta en la base de datos
    void agregarVenta(Venta venta) throws SQLException;

    // Obtener una venta específica por su ID
    Venta obtenerVentaPorId(int idVenta) throws SQLException;

    // Listar todas las ventas en la base de datos
    List<Venta> listarVentas() throws SQLException;

    // Actualizar los datos de una venta existente
    void actualizarVenta(Venta venta) throws SQLException;

    // Eliminar una venta por su ID
    void eliminarVenta(int idVenta) throws SQLException;
}
