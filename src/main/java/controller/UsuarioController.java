/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Usuario;
import model.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController(DatabaseConnector dbConnector) {
        this.usuarioDAO = new UsuarioDAOImpl(dbConnector);
    }

    // Iniciar Sesión
    public Usuario iniciarSesion(String email, String contrasena) throws SQLException {
        return usuarioDAO.iniciarSesion(email, contrasena);
    }

    // Registrar un nuevo usuario
    public void registrarUsuario(String nombre, String email, String contrasena) throws SQLException {
        if (!esEmailUnico(email)) {
            throw new IllegalArgumentException("El email ya está en uso.");
        }
        Usuario usuario = new Usuario(0, nombre, email, contrasena);
        usuarioDAO.registrarUsuario(usuario);
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listarUsuarios();
    }

    // Actualizar un usuario existente
    public void actualizarUsuario(int idUsuario, String nombre, String email, String contrasena) throws SQLException {
        Usuario usuario = new Usuario(idUsuario, nombre, email, contrasena);
        usuarioDAO.actualizarUsuario(usuario);
    }

    // Eliminar un usuario
    public void eliminarUsuario(int idUsuario) throws SQLException {
        usuarioDAO.eliminarUsuario(idUsuario);
    }

    // Buscar un usuario por su ID
    public Usuario buscarUsuarioPorId(int idUsuario) throws SQLException {
        return usuarioDAO.listarUsuarios().stream()
                .filter(usuario -> usuario.getIdUsuario() == idUsuario)
                .findFirst()
                .orElse(null);
    }

    // Validar que el email no esté en uso antes de registrar un nuevo usuario
    public boolean esEmailUnico(String email) throws SQLException {
        return usuarioDAO.listarUsuarios().stream()
                .noneMatch(usuario -> usuario.getEmail().equals(email));
    }

    // Cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        usuarioDAO.closeConnection();
    }

    // Método para cerrar sesión (placeholder)
    public void cerrarSesion() {
        Logger.getLogger(UsuarioController.class.getName()).log(Level.INFO, "Sesión cerrada correctamente");
    }
}
