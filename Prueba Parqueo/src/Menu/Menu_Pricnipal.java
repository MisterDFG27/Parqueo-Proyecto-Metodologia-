package Menu;

import Registro_Vehiculos.facturaSalida;
import Reportes.Reporte1;
import Reportes.Reporte_2;

public class Menu_Pricnipal extends javax.swing.JFrame {

    public Menu_Pricnipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Empleado = new javax.swing.JMenu();
        Vehiculo = new javax.swing.JMenu();
        Factura = new javax.swing.JMenu();
        Reporte1 = new javax.swing.JMenu();
        Reporte2 = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));

        Empleado.setText("Registrar Empleado");
        Empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadoMouseClicked(evt);
            }
        });
        Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoActionPerformed(evt);
            }
        });
        jMenuBar1.add(Empleado);

        Vehiculo.setText("Registrar Vehículo");
        Vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VehiculoMouseClicked(evt);
            }
        });
        Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculoActionPerformed(evt);
            }
        });
        jMenuBar1.add(Vehiculo);

        Factura.setText("Facturar");
        Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturaMouseClicked(evt);
            }
        });
        Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturaActionPerformed(evt);
            }
        });
        jMenuBar1.add(Factura);

        Reporte1.setText("Reporte 1");
        Reporte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte1MouseClicked(evt);
            }
        });
        Reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(Reporte1);

        Reporte2.setText("Reporte 2");
        Reporte2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte2MouseClicked(evt);
            }
        });
        Reporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(Reporte2);

        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarSesionMouseClicked(evt);
            }
        });
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jMenuBar1.add(CerrarSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoActionPerformed


    }//GEN-LAST:event_EmpleadoActionPerformed

    private void VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculoActionPerformed


    }//GEN-LAST:event_VehiculoActionPerformed

    private void FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturaActionPerformed


    }//GEN-LAST:event_FacturaActionPerformed

    private void Reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte1ActionPerformed

    }//GEN-LAST:event_Reporte1ActionPerformed

    private void Reporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte2ActionPerformed


    }//GEN-LAST:event_Reporte2ActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed

    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void EmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadoMouseClicked
        Registro_Empleado.Registro_Empleados m = new Registro_Empleado.Registro_Empleados();
        m.setVisible(true);
    }//GEN-LAST:event_EmpleadoMouseClicked

    private void VehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehiculoMouseClicked
        Registro_Vehiculos.Registro_Vehiculos m = new Registro_Vehiculos.Registro_Vehiculos();
        m.setVisible(true);
    }//GEN-LAST:event_VehiculoMouseClicked

    private void FacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturaMouseClicked
         facturaSalida m = new facturaSalida();
        m.setVisible(true);
    }//GEN-LAST:event_FacturaMouseClicked

    private void Reporte1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte1MouseClicked

        Reporte1 m = new Reporte1();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte1MouseClicked

    private void Reporte2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte2MouseClicked
        Reporte_2 m = new Reporte_2();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte2MouseClicked

    private void CerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Pricnipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Pricnipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Pricnipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Pricnipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Pricnipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CerrarSesion;
    private javax.swing.JMenu Empleado;
    private javax.swing.JMenu Factura;
    private javax.swing.JMenu Reporte1;
    private javax.swing.JMenu Reporte2;
    private javax.swing.JMenu Vehiculo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
