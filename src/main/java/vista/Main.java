/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import model.Usuario;
import controller.UsuarioController;
import model.DatabaseConnector;
import javax.swing.JOptionPane; 
import java.sql.*;

/**
 *
 * @author alberto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
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
        emailtxt = new javax.swing.JTextField();
        contrasenatxt = new javax.swing.JTextField();
        recuperarlink = new javax.swing.JLabel();
        registrarbtn = new javax.swing.JButton();
        ingresarbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LLEVA CUENTAS");

        emailtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailtxt.setText("USUARIO");

        contrasenatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contrasenatxt.setText("CONTRASEÑA");

        recuperarlink.setText("¿Olvidó la Contraseña?");

        registrarbtn.setText("REGISTRAR");
        registrarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarbtnActionPerformed(evt);
            }
        });

        ingresarbtn.setText("INGRESAR");
        ingresarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarbtnActionPerformed(evt);
            }
        });

        jLabel3.setText("ADSO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(recuperarlink))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(registrarbtn)
                        .addGap(52, 52, 52)
                        .addComponent(ingresarbtn)))
                .addGap(0, 77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(emailtxt)
                            .addComponent(contrasenatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contrasenatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recuperarlink)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarbtn)
                    .addComponent(ingresarbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarbtnActionPerformed
       // Cerrar la ventana de inicio de sesión
    this.dispose();
    
    // Crear y mostrar el formulario de registro
    RegistroU registro = new RegistroU();
    registro.setVisible(true);
    }//GEN-LAST:event_registrarbtnActionPerformed

    private void ingresarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarbtnActionPerformed
    
    String email = emailtxt.getText(); 
    String contrasena = contrasenatxt.getText(); 

    try {
        DatabaseConnector dbConnector = new DatabaseConnector();
        UsuarioController usuarioController = new UsuarioController(dbConnector);

        Usuario usuario = usuarioController.iniciarSesion(email, contrasena);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario.getNombre(), "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
            
            // Cerrar la ventana de inicio de sesión
            this.dispose();
            
            // Crear y mostrar el Dashboard, pasando el idUsuario
            DashboardJF dashboard = new DashboardJF(usuario.getIdUsuario());
            dashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Email o contraseña incorrectos", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ingresarbtnActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contrasenatxt;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JButton ingresarbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel recuperarlink;
    private javax.swing.JButton registrarbtn;
    // End of variables declaration//GEN-END:variables
}
