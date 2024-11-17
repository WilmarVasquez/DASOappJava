/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.sql.SQLException;


/**
 *
 * @author alberto
 */
public class Eperfil extends javax.swing.JFrame {
    private int idUsuario; // ID del usuario
    private UsuarioController usuarioController; // Controlador de usuario

    /**
     * Constructor de la clase
     * @param idUsuario ID del usuario actual
     * @param usuarioController Instancia del controlador de usuario
     */
    
    /**
     * Creates new form Eperfil
     */
    public Eperfil(int idUsuario, UsuarioController usuarioController) {
        initComponents();
        this.idUsuario = idUsuario;
        this.usuarioController = usuarioController;
        setLocationRelativeTo(null); // Centrar la ventana
        cargarDatosUsuario(); // Cargar los datos del usuario al abrir la ventana
    }
    
     private void cargarDatosUsuario() {
        try {
            Usuario usuario = usuarioController.buscarUsuarioPorId(idUsuario);
            if (usuario != null) {
                enombretxt.setText(usuario.getNombre());
                ecorreotxt.setText(usuario.getEmail());
                econtrasenatxt.setText(usuario.getContrasena());
            } else {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                dispose(); // Cierra la ventana si no se pueden cargar los datos
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        enombretxt = new javax.swing.JTextField();
        ecorreotxt = new javax.swing.JTextField();
        econtrasenatxt = new javax.swing.JTextField();
        editarbtn = new javax.swing.JButton();
        cancelarbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("EDITAR PERFIL");

        enombretxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        enombretxt.setText("NOMBRE");

        ecorreotxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ecorreotxt.setText("CORREO");

        econtrasenatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        econtrasenatxt.setText("CONTRASEÑA");

        editarbtn.setText("EDITAR");
        editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarbtnActionPerformed(evt);
            }
        });

        cancelarbtn.setText("CANCELAR");
        cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(econtrasenatxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(ecorreotxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enombretxt, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ecorreotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(econtrasenatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarbtn)
                .addGap(18, 18, 18)
                .addComponent(cancelarbtn)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
        // Cerrar el formulario actual
        dispose();
    }//GEN-LAST:event_cancelarbtnActionPerformed

    private void editarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarbtnActionPerformed
        // TODO add your handling code here:
           try {
        // Validar que los campos no estén vacíos
        if (enombretxt.getText().isEmpty() || ecorreotxt.getText().isEmpty() || econtrasenatxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener los valores del formulario
        String nombre = enombretxt.getText();
        String email = ecorreotxt.getText();
        String contrasena = econtrasenatxt.getText();

        // Usar el método `actualizarUsuario` del controlador
        usuarioController.actualizarUsuario(idUsuario, nombre, email, contrasena);

        JOptionPane.showMessageDialog(this, "Perfil actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Cerrar el formulario
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar el perfil: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_editarbtnActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarbtn;
    private javax.swing.JTextField econtrasenatxt;
    private javax.swing.JTextField ecorreotxt;
    private javax.swing.JButton editarbtn;
    private javax.swing.JTextField enombretxt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
