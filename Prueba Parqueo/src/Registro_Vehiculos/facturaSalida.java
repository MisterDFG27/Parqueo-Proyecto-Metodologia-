package Registro_Vehiculos;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class facturaSalida extends javax.swing.JFrame {

    //----------------En proceso----------------//
    String date;
    datosP cc = new datosP();
    Connection cn = cc.conexion();
    String fechacalendario;

    public facturaSalida() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        fechacalendario = dateFormat.format(txtFecha.getDate());

    }

    public void mostrarVehiculoFacturar(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Registro");
        modelo.addColumn("Placa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Tipo de vehiculo");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Estado");

        tbFactura.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_registo, númeroPlaca, fecha, horaEntrada, fk_tipoVehiculo, horaSalida, fk_estado FROM registro "
                    + "WHERE númeroPlaca ='" + txtPlaca.getText() + "' and fecha = '" + fechacalendario + "'";

        }
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setVisible(true);

    }

    public void CalcularHoras() {

        int horaE = Integer.parseInt(txtHEntrada.getText());
        int minE = Integer.parseInt(txtMEntrada.getText());
        int horaS = Integer.parseInt(txtHSalida.getText());
        int minS = Integer.parseInt(txtMSalida.getText());

        int th = horaS - horaE;
        int tm = (minS + minE) / 60;

        int tt = th + tm;

        txtTotHoras.setText("" + tt);
        txtCantHoras.setText("" + tt);

    }

    public void CalcularMontoXHora() {

        String tipoVehiculo = cbVehiculos.getSelectedItem().toString();
        String tipoHorario = cbHorario.getSelectedItem().toString();

        if (tipoHorario == "Diurno") {
            if (tipoVehiculo == "1") {
                txtMT.setText("600");
            }
            if (tipoVehiculo == "2") {
                txtMT.setText("750");
            }
            if (tipoVehiculo == "3") {
                txtMT.setText("500");
            }
        } else {
            if (tipoVehiculo == "1") {
                txtMT.setText("650");
            }
            if (tipoVehiculo == "2") {
                txtMT.setText("800");
            }
            if (tipoVehiculo == "3") {
                txtMT.setText("550");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new javax.swing.JButton();
        btnInsertarF = new javax.swing.JButton();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMontoExtra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalHoras = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtIDregistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarRegistro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtIDRegistroBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEstadoSalida = new javax.swing.JTextField();
        BtnSalidaregistro = new javax.swing.JButton();
        txtCantHoras = new javax.swing.JTextField();
        txtMT = new javax.swing.JTextField();
        txtMTX = new javax.swing.JTextField();
        txtTP = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtHEntrada = new javax.swing.JTextField();
        txtMEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtHSalida = new javax.swing.JTextField();
        txtMSalida = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnCarlcularHoras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbVehiculos = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cbHorario = new javax.swing.JComboBox<String>();
        txtTotHoras = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        btnInsertarF.setText("Guardar pago");
        btnInsertarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarFActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));
        getContentPane().add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, -1));

        jLabel9.setText("Total a Pagar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 82, 20));
        getContentPane().add(txtMontoExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 90, -1));

        jLabel8.setText("Monto Extra:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 90, -1));

        jLabel7.setText("Monto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel6.setText("Total de tiempo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));
        getContentPane().add(txtTotalHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 90, -1));

        jLabel14.setText("ID registro");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));
        getContentPane().add(txtIDregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 90, -1));

        jLabel11.setText("Guardar el pago");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel2.setText("Numero de Placa:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));
        getContentPane().add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 80, -1));

        jLabel1.setText("Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        btnBuscarRegistro.setText("Buscar");
        btnBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 350, -1));

        jLabel12.setText("Buscar el vehiculo");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel18.setText("Calcular montos");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Salida del vehiculo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 276, -1, -1));

        jLabel19.setText("ID registro");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 319, -1, -1));
        jPanel1.add(txtIDRegistroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 316, 90, -1));

        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFactura.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 90, 774, 110));
        jPanel1.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 90, -1));

        jLabel5.setText("Hora de Salida:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        jLabel10.setText("Estado");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        txtEstadoSalida.setText("F");
        txtEstadoSalida.setEnabled(false);
        jPanel1.add(txtEstadoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 82, -1));

        BtnSalidaregistro.setText("Sacar registro");
        BtnSalidaregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalidaregistroActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalidaregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));
        jPanel1.add(txtCantHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 100, -1));
        jPanel1.add(txtMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 100, -1));
        jPanel1.add(txtMTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 100, -1));
        jPanel1.add(txtTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 510, 107, -1));

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });
        jPanel1.add(Calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 560, -1, -1));

        jLabel17.setText("Total a pagar");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, -1, -1));

        jLabel16.setText("Montro extra");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        jLabel15.setText("Monto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, -1, -1));

        jLabel4.setText("Cantidad de horas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, -1, -1));

        jLabel20.setText("Entrada:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, -1, -1));

        jLabel21.setText("Salida:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, -1, -1));
        jPanel1.add(txtHEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 40, -1));
        jPanel1.add(txtMEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 40, -1));

        jLabel22.setText(":");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 10, -1));

        jLabel23.setText("Calcular Horas");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, -1, -1));
        jPanel1.add(txtHSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 40, -1));
        jPanel1.add(txtMSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 40, -1));

        jLabel24.setText(":");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 10, -1));

        btnCarlcularHoras.setText("Calcular");
        btnCarlcularHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarlcularHorasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarlcularHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, -1, -1));

        jLabel3.setText("Tipo Vehiculo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        cbVehiculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jPanel1.add(cbVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 270, 100, -1));

        jLabel25.setText("Horario:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, -1, -1));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diurno", "Nocturno" }));
        jPanel1.add(cbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 100, -1));
        jPanel1.add(txtTotHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 70, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarFActionPerformed

        try {

            PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(monto,montoextra,montoTotal,fk_registro,totalHoras) VALUES (?,?,?,?,?)");

            pst.setString(1, txtMonto.getText());
            pst.setString(2, txtMontoExtra.getText());
            pst.setString(3, txtTotalPagar.getText());
            pst.setString(4, txtIDregistro.getText());
            pst.setString(5, txtTotalHoras.getText());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
        }

        txtMonto.setText("");
        txtMontoExtra.setText("");
        txtTotalPagar.setText("");
        txtIDregistro.setText("");
        txtTotalHoras.setText("");

        JOptionPane.showMessageDialog(this, "Factura guardada");


    }//GEN-LAST:event_btnInsertarFActionPerformed

    private void BtnSalidaregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalidaregistroActionPerformed

        txtIDregistro.setText(txtIDRegistroBusqueda.getText());

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE registro SET horaSalida='" + txtHoraSalida.getText() + "',"
                    + "fk_estado='" + txtEstadoSalida.getText() + "' WHERE id_registo='" + txtIDRegistroBusqueda.getText() + "'");
            pst.executeUpdate();
            mostrarVehiculoFacturar("");
            JOptionPane.showMessageDialog(this, "Seguir con la factura");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_BtnSalidaregistroActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistroActionPerformed

        mostrarVehiculoFacturar("");

    }//GEN-LAST:event_btnBuscarRegistroActionPerformed

    private void btnCarlcularHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarlcularHorasActionPerformed

        txtTotalHoras.setText(txtTotHoras.getText());
        
        
        CalcularHoras();
        CalcularMontoXHora();


    }//GEN-LAST:event_btnCarlcularHorasActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed

        txtMonto.setText(txtMT.getText());
        txtMontoExtra.setText(txtMTX.getText());
        txtTotalPagar.setText(txtTP.getText());

    }//GEN-LAST:event_CalcularActionPerformed

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
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalidaregistro;
    private javax.swing.JButton Calcular;
    private javax.swing.JButton btnBuscarRegistro;
    private javax.swing.JButton btnCarlcularHoras;
    private javax.swing.JButton btnInsertarF;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox cbVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtCantHoras;
    private javax.swing.JTextField txtEstadoSalida;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtHEntrada;
    private javax.swing.JTextField txtHSalida;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIDRegistroBusqueda;
    private javax.swing.JTextField txtIDregistro;
    private javax.swing.JTextField txtMEntrada;
    private javax.swing.JTextField txtMSalida;
    private javax.swing.JTextField txtMT;
    private javax.swing.JTextField txtMTX;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoExtra;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTP;
    private javax.swing.JTextField txtTotHoras;
    private javax.swing.JTextField txtTotalHoras;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
