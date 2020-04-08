package Menu;

import Conexion.datosP;
import Registro_Vehiculos.facturaSalida;
import Reportes.Reporte1;
import Reportes.Reporte_2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Menu_Principal extends javax.swing.JFrame {

    String CantidV;

    public Menu_Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

  public  void mostrardatosVL(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantliv.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='1' and fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantliv.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantliv.setVisible(true);
    }

    //cantidad vehiculo Pesado
   public void mostrardatosVP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantp.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='2' and fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantp.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantp.setVisible(true);
    }

    //cantidad Moto
   public void mostrardatosM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantm.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='3' and fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantm.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantm.setVisible(true);

    }

   public void mostrardatosTotalVehiculosDia(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Placa de vehículos");

        tbtotal.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT númeroPlaca FROM registro WHERE fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbtotal.setModel(modelo);

            txtCantiTotal.setText("" + tbtotal.getRowCount());

            //Bloquear la opcion a los 15
            CantidV = txtCantiTotal.getText();

            if (Integer.parseInt(CantidV) == 15) {

                Vehiculo.setVisible(false);
            }
            //-----------------------

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbtotal.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbcantliv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbcantp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtotal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcantm = new javax.swing.JTable();
        btnActualizar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantiTotal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        EmpleadoR = new javax.swing.JMenu();
        Vehiculo = new javax.swing.JMenu();
        Factura = new javax.swing.JMenu();
        Reporte1Menu = new javax.swing.JMenu();
        Reporte2Menu = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Motos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        tbcantliv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantliv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantliv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tbcantliv);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 90, 50));

        jLabel1.setText("Livianos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        tbcantp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbcantp);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 90, 50));

        jLabel2.setText("Pesados");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbtotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbtotal);

        tbcantm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbcantm);

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        jLabel4.setText("Total de vehículos en el momento");

        txtCantiTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(249, 249, 249)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCantiTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(250, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnActualizar)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(txtCantiTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 370));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));

        EmpleadoR.setBackground(new java.awt.Color(255, 255, 255));
        EmpleadoR.setText("Registrar Empleado");
        EmpleadoR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpleadoR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadoRMouseClicked(evt);
            }
        });
        jMenuBar1.add(EmpleadoR);

        Vehiculo.setText("Registrar Vehículo");
        Vehiculo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VehiculoMouseClicked(evt);
            }
        });
        jMenuBar1.add(Vehiculo);

        Factura.setText("Facturar");
        Factura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturaMouseClicked(evt);
            }
        });
        jMenuBar1.add(Factura);

        Reporte1Menu.setText("Reporte 1");
        Reporte1Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Reporte1Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte1MenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(Reporte1Menu);

        Reporte2Menu.setText("Reporte 2");
        Reporte2Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Reporte2Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte2MenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(Reporte2Menu);

        CerrarSesion.setForeground(new java.awt.Color(255, 0, 0));
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarSesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(CerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpleadoRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadoRMouseClicked
        Registro_Empleado.Registro_Empleados m = new Registro_Empleado.Registro_Empleados();
        m.setVisible(true);

    }//GEN-LAST:event_EmpleadoRMouseClicked

    private void VehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehiculoMouseClicked
        Registro_Vehiculos.Registro_Vehiculos m = new Registro_Vehiculos.Registro_Vehiculos();
        m.setVisible(true);
    }//GEN-LAST:event_VehiculoMouseClicked

    private void FacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturaMouseClicked
        facturaSalida m = new facturaSalida();
        m.setVisible(true);
    }//GEN-LAST:event_FacturaMouseClicked

    private void Reporte1MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte1MenuMouseClicked
        Reporte1 m = new Reporte1();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte1MenuMouseClicked

    private void Reporte2MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte2MenuMouseClicked
        Reporte_2 m = new Reporte_2();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte2MenuMouseClicked

    private void CerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        mostrardatosVL("");
        mostrardatosVP("");
        mostrardatosM("");
        mostrardatosTotalVehiculosDia("");


    }//GEN-LAST:event_btnActualizarMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CerrarSesion;
    public javax.swing.JMenu EmpleadoR;
    private javax.swing.JMenu Factura;
    public javax.swing.JMenu Reporte1Menu;
    public javax.swing.JMenu Reporte2Menu;
    private javax.swing.JMenu Vehiculo;
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tbcantliv;
    private javax.swing.JTable tbcantm;
    private javax.swing.JTable tbcantp;
    private javax.swing.JTable tbtotal;
    private javax.swing.JTextField txtCantiTotal;
    // End of variables declaration//GEN-END:variables
   datosP cc = new datosP();
    Connection cn = cc.conexion();
}
