package Reportes;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Reporte_2 extends javax.swing.JFrame {

    public Reporte_2() {
        initComponents();
        setLocationRelativeTo(null);
    }

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto Total");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT númeroPlaca , horaEntrada , horaSalida, montoTotal "
                    + "FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo";

        }
        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrarFiltro(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto total");

        tbDatos.setModel(modelo);
        String sql = "";

        if (valor.equals("")) {

            sql = "Select númeroPlaca , horaEntrada , horaSalida, montoTotal "
                    + "From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + " AND fecha='" + txtFecha1.getText() + "'";

        }

        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarFiltro2Fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto total");

        tbDatos.setModel(modelo);
        String sql = "";

        if (valor.equals("")) {

            sql = "Select númeroPlaca , horaEntrada , horaSalida, montoTotal "
                    + "From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + " AND fecha between'" + txtFecha1.getText() + "' and '" + txtFecha2.getText() + "'  ";

        }

        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMonto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total de montos de datos filtados");

        tbmontoT.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo "
                    + "WHERE fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + "  AND fecha='" + txtFecha1.getText() + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmontoT.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMonto2Fecha(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total de montos de datos filtados");

        tbmontoT.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo "
                    + "WHERE fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + "  AND fecha between'" + txtFecha1.getText() + "' and '" + txtFecha2.getText() + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmontoT.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMontoTotal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total");

        tbMontoR.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbMontoR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarDatosPorPlaca(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Fecha");
        modelo.addColumn("Monto total");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "Select númeroPlaca , horaEntrada , horaSalida, fecha, montoTotal "
                    + "From registro a INNER JOIN factura b  on b.fk_registro = a.id_registo "
                    + "where númeroPlaca ='" + txtPlaca.getText() + "'";

        }

        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JLabel();
        cmbTipoVehiculo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbmontoT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtVerAll = new javax.swing.JLabel();
        btnTotalR = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMontoR = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnPlaca = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha2 = new javax.swing.JTextField();
        btnFitrar2Fechas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tipo de vehículo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        txtFecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecha1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 139, -1));

        btnFiltrar.setText("Filtrar por 1 fecha");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        cmbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jPanel1.add(cmbTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 123, -1));

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 610, 190));

        tbmontoT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbmontoT);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 250, 50));

        jLabel4.setText("1 Liviano");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel6.setText("2 Pesado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel7.setText("3 Motos");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        txtVerAll.setText("Ver todos los registros facturados");
        txtVerAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVerAllMouseClicked(evt);
            }
        });
        jPanel1.add(txtVerAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        btnTotalR.setText("Monto total registrado");
        btnTotalR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTotalRMouseClicked(evt);
            }
        });
        jPanel1.add(btnTotalR, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        tbMontoR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbMontoR);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 220, 50));

        jLabel2.setText("Placa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 30));

        btnPlaca.setText("Filtrar por placa");
        btnPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel8.setText("Fecha 2");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        jLabel9.setText("Fecha 1");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        txtFecha2.setEnabled(false);
        txtFecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecha2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 139, -1));

        btnFitrar2Fechas.setText("Filtrar por 2 fechas");
        btnFitrar2Fechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFitrar2FechasMouseClicked(evt);
            }
        });
        jPanel1.add(btnFitrar2Fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        jLabel10.setText("Monto de consulta");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked
        mostrarFiltro("");
        txtFecha2.setEnabled(false);
        txtFecha2.setText("");
        mostrarMonto("");

        DefaultTableModel tb = (DefaultTableModel) tbMontoR.getModel();
        int a = tbMontoR.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);

        }

    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void txtVerAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVerAllMouseClicked
        mostrardatos("");
        mostrarMontoTotal("");
        txtFecha1.setText("");
        txtFecha2.setText("");

        DefaultTableModel tb = (DefaultTableModel) tbmontoT.getModel();
        int a = tbmontoT.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);

        }

    }//GEN-LAST:event_txtVerAllMouseClicked

    private void btnTotalRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalRMouseClicked
        mostrarMontoTotal("");
    }//GEN-LAST:event_btnTotalRMouseClicked

    private void btnPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacaActionPerformed
        mostrarDatosPorPlaca("");
        txtPlaca.setText("");
        txtFecha1.setText("");
        txtFecha2.setText("");

        DefaultTableModel tb = (DefaultTableModel) tbmontoT.getModel();
        int a = tbmontoT.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);

        }

        DefaultTableModel tb1 = (DefaultTableModel) tbMontoR.getModel();
        int b = tbMontoR.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb1.removeRow(tb1.getRowCount() - 1);

        }

    }//GEN-LAST:event_btnPlacaActionPerformed

    private void txtFecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecha1ActionPerformed

    }//GEN-LAST:event_txtFecha1ActionPerformed

    private void txtFecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecha2ActionPerformed

    }//GEN-LAST:event_txtFecha2ActionPerformed

    private void btnFitrar2FechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFitrar2FechasMouseClicked

        txtFecha2.setEnabled(true);
        mostrarFiltro2Fechas("");
        mostrarMonto2Fecha("");
        DefaultTableModel tb = (DefaultTableModel) tbMontoR.getModel();
        int a = tbMontoR.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);

        }


    }//GEN-LAST:event_btnFitrar2FechasMouseClicked

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
            java.util.logging.Logger.getLogger(Reporte_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFiltrar;
    private javax.swing.JLabel btnFitrar2Fechas;
    private javax.swing.JButton btnPlaca;
    private javax.swing.JLabel btnTotalR;
    private javax.swing.JComboBox cmbTipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTable tbMontoR;
    private javax.swing.JTable tbmontoT;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JLabel txtVerAll;
    // End of variables declaration//GEN-END:variables
    datosP cc = new datosP();
    Connection cn = cc.conexion();
}
