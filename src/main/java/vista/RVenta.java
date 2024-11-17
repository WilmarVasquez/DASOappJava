/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import model.Venta;
import model.Usuario;
import model.Compra;
import controller.VentaController;

import javax.swing.*;
import java.sql.SQLException;
/**

/**
 *
 * @author alberto
 */
public class RVenta extends javax.swing.JFrame {
    private int idUsuario; // ID del usuario
    private VentaController ventaController; // Controlador de compras
    /**
     * Creates new form RCompra
     */
   public RVenta(int idUsuario, VentaController ventaController) {
        initComponents();
        this.idUsuario = idUsuario; // Asignar ID del usuario
        this.ventaController = ventaController; // Asignar controlador
        setLocationRelativeTo(null); // Centrar la ventana
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
        vtickettxt = new javax.swing.JTextField();
        vcantidadtxt = new javax.swing.JTextField();
        vpreciotxt = new javax.swing.JTextField();
        vinversiontxt = new javax.swing.JTextField();
        idventatxt = new javax.swing.JTextField();
        ventabtn = new javax.swing.JButton();
        vbuscarbtn = new javax.swing.JButton();
        veditarbtn = new javax.swing.JButton();
        veliminarbtn = new javax.swing.JButton();
        vcancelartbtn = new javax.swing.JButton();
        idCompraTxt = new javax.swing.JTextField();
        buscarcomprabtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO VENTA");

        vtickettxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vtickettxt.setText("TICKET");

        vcantidadtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vcantidadtxt.setText("CANTIDAD");

        vpreciotxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vpreciotxt.setText("PRECIO X TICKET");

        vinversiontxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vinversiontxt.setText("TOTAL INVERSION");

        idventatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idventatxt.setText("ID VENTA");

        ventabtn.setText("INGRESAR VENTA");
        ventabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventabtnActionPerformed(evt);
            }
        });

        vbuscarbtn.setText("BUSCAR");
        vbuscarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbuscarbtnActionPerformed(evt);
            }
        });

        veditarbtn.setText("EDITAR");
        veditarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veditarbtnActionPerformed(evt);
            }
        });

        veliminarbtn.setText("ELIMINAR");
        veliminarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veliminarbtnActionPerformed(evt);
            }
        });

        vcancelartbtn.setText("CANCELAR");
        vcancelartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vcancelartbtnActionPerformed(evt);
            }
        });

        idCompraTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idCompraTxt.setText("ID COMPRA");
        idCompraTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCompraTxtActionPerformed(evt);
            }
        });

        buscarcomprabtn.setText("BUSCAR COMPRA");
        buscarcomprabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarcomprabtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(idCompraTxt)
                    .addComponent(idventatxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vinversiontxt, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(vpreciotxt)
                    .addComponent(vcantidadtxt)
                    .addComponent(vtickettxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ventabtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vbuscarbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(veditarbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(veliminarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vcancelartbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarcomprabtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vtickettxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ventabtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vcantidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vbuscarbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vpreciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(veditarbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vinversiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(veliminarbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vcancelartbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCompraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarcomprabtn))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ventabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventabtnActionPerformed
                // TODO add your handling code here:
            try {
        // Validar que el ID de la compra sea válido
        String idCompraStr = idCompraTxt.getText();
        if (idCompraStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, busque una compra válida antes de registrar la venta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idCompra = Integer.parseInt(idCompraStr);

        // Validar que los demás campos no estén vacíos
        if (vtickettxt.getText().isEmpty() || vcantidadtxt.getText().isEmpty() || vpreciotxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recoger los valores del formulario
        String ticket = vtickettxt.getText();
        int cantidad = Integer.parseInt(vcantidadtxt.getText());
        double precioTicket = Double.parseDouble(vpreciotxt.getText());

        // Crear la venta
        Venta venta = new Venta();
        venta.setFechaVenta(new java.util.Date());
        venta.setTicket(ticket);
        venta.setCantidad(cantidad);
        venta.setPrecioTicket(precioTicket);
        venta.setTotalVenta(cantidad * precioTicket);

        // Relacionar la venta con la compra
        Compra compra = ventaController.getCompraController().leerCompra(idCompra);
        if (compra == null) {
            JOptionPane.showMessageDialog(this, "La compra asociada no existe. Por favor, verifique el ID de compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        venta.setCompra(compra);

        // Relacionar la venta con el usuario
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        venta.setUsuario(usuario);

        // Registrar la venta
        ventaController.agregarVenta(venta);

        JOptionPane.showMessageDialog(this, "Venta registrada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos
        vtickettxt.setText("");
        vcantidadtxt.setText("");
        vpreciotxt.setText("");
        vinversiontxt.setText("");
        idCompraTxt.setText("");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la venta en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ventabtnActionPerformed

    private void buscarcomprabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarcomprabtnActionPerformed
        // TODO add your handling code here:
          try {
        // Obtener el valor del campo "idCompraTxt"
        String idCompraStr = idCompraTxt.getText();

        // Validar que no esté vacío
        if (idCompraStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de compra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir el valor a entero
        int idCompra = Integer.parseInt(idCompraStr);

        // Usar el controlador de compras para buscar la compra
        Compra compra = ventaController.getCompraController().leerCompra(idCompra);

        if (compra != null) {
            // Mostrar los datos de la compra en los campos correspondientes
            vtickettxt.setText(compra.getTicket());
            vcantidadtxt.setText(String.valueOf(compra.getCantidad()));
            vpreciotxt.setText(String.valueOf(compra.getPrecioTicket()));
            vinversiontxt.setText(String.valueOf(compra.getTotalInversion()));
            JOptionPane.showMessageDialog(this, "Datos de la compra encontrados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar mensaje si no se encuentra la compra
            JOptionPane.showMessageDialog(this, "No se encontró una compra con el ID proporcionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Manejar error de formato en el ID de compra
        JOptionPane.showMessageDialog(this, "El ID de compra debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Manejar errores de SQL
        JOptionPane.showMessageDialog(this, "Error al buscar la compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_buscarcomprabtnActionPerformed

    private void idCompraTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCompraTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCompraTxtActionPerformed

    private void vbuscarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbuscarbtnActionPerformed
        // TODO add your handling code here:
        
         try {
        // Obtener el valor del campo "idventatxt"
        String idVentaStr = idventatxt.getText();

        // Validar que no esté vacío
        if (idVentaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de venta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir el valor a entero
        int idVenta = Integer.parseInt(idVentaStr);

        // Usar el controlador para buscar la venta
        Venta venta = ventaController.leerVenta(idVenta);

        if (venta != null) {
            // Mostrar los datos de la venta en los campos correspondientes
            vtickettxt.setText(venta.getTicket());
            vcantidadtxt.setText(String.valueOf(venta.getCantidad()));
            vpreciotxt.setText(String.valueOf(venta.getPrecioTicket()));
            vinversiontxt.setText(String.valueOf(venta.getTotalVenta()));
            idCompraTxt.setText(String.valueOf(venta.getCompraId()));
            JOptionPane.showMessageDialog(this, "Datos de la venta encontrados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar mensaje si no se encuentra la venta
            JOptionPane.showMessageDialog(this, "No se encontró una venta con el ID proporcionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Manejar error de formato en el ID de venta
        JOptionPane.showMessageDialog(this, "El ID de venta debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Manejar errores de SQL
        JOptionPane.showMessageDialog(this, "Error al buscar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_vbuscarbtnActionPerformed

    private void veditarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veditarbtnActionPerformed
        // TODO add your handling code here:
         try {
        // Validar que el campo "idventatxt" no esté vacío
        String idVentaStr = idventatxt.getText();
        if (idVentaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID de la venta a editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir el ID a entero
        int idVenta = Integer.parseInt(idVentaStr);

        // Validar que los demás campos no estén vacíos
        if (vtickettxt.getText().isEmpty() || vcantidadtxt.getText().isEmpty() ||
            vpreciotxt.getText().isEmpty() || vinversiontxt.getText().isEmpty() || idCompraTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recoger los valores de los campos del formulario
        String ticket = vtickettxt.getText();
        int cantidad = Integer.parseInt(vcantidadtxt.getText());
        double precioTicket = Double.parseDouble(vpreciotxt.getText());
        int idCompra = Integer.parseInt(idCompraTxt.getText());

        // Crear una instancia de Venta con los nuevos valores
        Venta venta = new Venta();
        venta.setIdVenta(idVenta);
        venta.setFechaVenta(new java.util.Date()); // Fecha actual para la venta
        venta.setTicket(ticket);
        venta.setCantidad(cantidad);
        venta.setPrecioTicket(precioTicket);
        venta.setTotalVenta(cantidad * precioTicket); // Calcular el total de la venta

        // Relacionar la venta con el usuario
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario); // Utilizar el ID del usuario existente
        venta.setUsuario(usuario);

        // Relacionar la venta con la compra
        Compra compra = ventaController.getCompraController().leerCompra(idCompra); // Buscar la compra por ID
        if (compra == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la compra con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        venta.setCompra(compra);

        // Usar el controlador para actualizar la venta
        ventaController.actualizarVenta(venta);

        JOptionPane.showMessageDialog(this, "Venta actualizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos después de actualizar
        vtickettxt.setText("");
        vcantidadtxt.setText("");
        vpreciotxt.setText("");
        vinversiontxt.setText("");
        idventatxt.setText("");
        idCompraTxt.setText("");

    } catch (NumberFormatException e) {
        // Manejar errores de formato
        JOptionPane.showMessageDialog(this, "Error en el formato de los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Manejar errores de SQL
        JOptionPane.showMessageDialog(this, "Error al actualizar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_veditarbtnActionPerformed

    private void vcancelartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcancelartbtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_vcancelartbtnActionPerformed

    private void veliminarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veliminarbtnActionPerformed
        // TODO add your handling code here:
        try {
        // Validar que el campo "idventatxt" no esté vacío
        String idVentaStr = idventatxt.getText();
        if (idVentaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID de la venta a eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir el ID de la venta a entero
        int idVenta = Integer.parseInt(idVentaStr);

        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar la venta con ID " + idVenta + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Usar el controlador para eliminar la venta
            ventaController.eliminarVenta(idVenta);

            JOptionPane.showMessageDialog(this, "Venta eliminada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar campos después de eliminar
            vtickettxt.setText("");
            vcantidadtxt.setText("");
            vpreciotxt.setText("");
            vinversiontxt.setText("");
            idventatxt.setText("");
            idCompraTxt.setText("");
        }
    } catch (NumberFormatException e) {
        // Manejar errores de formato en el ID de la venta
        JOptionPane.showMessageDialog(this, "El ID de la venta debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Manejar errores de SQL
        JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_veliminarbtnActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarcomprabtn;
    private javax.swing.JTextField idCompraTxt;
    private javax.swing.JTextField idventatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton vbuscarbtn;
    private javax.swing.JButton vcancelartbtn;
    private javax.swing.JTextField vcantidadtxt;
    private javax.swing.JButton veditarbtn;
    private javax.swing.JButton veliminarbtn;
    private javax.swing.JButton ventabtn;
    private javax.swing.JTextField vinversiontxt;
    private javax.swing.JTextField vpreciotxt;
    private javax.swing.JTextField vtickettxt;
    // End of variables declaration//GEN-END:variables
}