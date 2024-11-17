/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.Usuario;
import model.Compra;
import model.Venta;
import java.util.List;
import java.sql.*;


/**
 * Define las operaciones de acceso a datos para la entidad Usuario.
 */
public interface UsuarioDAO {

    /**
     * Verifica las credenciales del usuario para iniciar sesión.
     * @param email El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @return Un objeto Usuario si las credenciales son correctas; de lo contrario, null.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    Usuario iniciarSesion(String email, String contrasena) throws SQLException;

    /**
     * Registra un nuevo usuario en la base de datos.
     * @param usuario El objeto Usuario a registrar.
     * @throws SQLException Si ocurre un error al insertar el usuario.
     */
    void registrarUsuario(Usuario usuario) throws SQLException;

    /**
     * Lista todos los usuarios registrados.
     * @return Una lista de objetos Usuario.
     */
    List<Usuario> listarUsuarios()throws SQLException;

    /**
     * Actualiza la información de un usuario existente.
     * @param usuario El objeto Usuario con los datos actualizados.
     */
    void actualizarUsuario(int idUsuario, String nombre, String email, String contrasena) throws SQLException;


    /**
     * Elimina un usuario por su ID.
     * @param idUsuario El ID del usuario a eliminar.
     */
    void eliminarUsuario(int idUsuario)throws SQLException;

    /**
     * Obtiene todas las compras realizadas por un usuario.
     * @param idUsuario El ID del usuario.
     * @return Una lista de objetos Compra asociados al usuario.
     */
    List<Compra> getComprasPorUsuario(int idUsuario)throws SQLException;;

    /**
     * Obtiene todas las ventas realizadas por un usuario.
     * @param idUsuario El ID del usuario.
     * @return Una lista de objetos Venta asociados al usuario.
     */
    List<Venta> getVentasPorUsuario(int idUsuario)throws SQLException;

    /**
     * Cierra la conexión con la base de datos.
     */
    void closeConnection()throws SQLException;
}
