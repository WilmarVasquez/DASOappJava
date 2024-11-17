/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author alberto
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String email;
    private String contrasena;

    // Constructor
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int idUsuario, String nombre, String email, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters and Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Métodos de la clase
    public void registrarUsuario() {
        // Lógica para registrar el usuario
        System.out.println("Usuario registrado.");
    }

    public void editarPerfil() {
        // Lógica para editar el perfil del usuario
        System.out.println("Perfil de usuario editado.");
    }

    public void eliminarPerfil() {
        // Lógica para eliminar el perfil del usuario
        System.out.println("Perfil de usuario eliminado.");
    }

    // toString para facilitar la impresión de la información del usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
    
    
    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}