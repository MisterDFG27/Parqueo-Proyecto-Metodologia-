

import Menu.Menu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
          setLocationRelativeTo(null);
    }

    void acceder(String usuario, String clave) {
        String cap = "";
        String sql = "SELECT * FROM usuario WHERE nombreUsuario='" + usuario + "' && contraseña='" + clave + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("fk_tipoUsuario");
            }
            if (cap.equals("12")) {
                Menu m = new Menu();
                m.setVisible(true);
                dispose();      

            }
            if (cap.equals("23")) {
                Menu m = new Menu();
                m.setVisible(true);
                dispose();
            }
            if ((!cap.equals("12")) && (!cap.equals("23"))) {
                JOptionPane.showMessageDialog(this, "No existe sus datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        btnIngresar = new javax.swing.JButton();
        PwClave = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnIU = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 187, -1, -1));
        getContentPane().add(PwClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 127, 126, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 52, 126, -1));

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 11, -1, -1));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 102, -1, -1));

        BtnIU.setText("Ingresar Usuarios");
        BtnIU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(BtnIU)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(BtnIU)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usu = txtUsuario.getText();
        String cla = new String(PwClave.getPassword());
        acceder(usu, cla);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void BtnIUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIUActionPerformed
     
    }//GEN-LAST:event_BtnIUActionPerformed
    public class conectar {

        Connection conect = null;

        public Connection conexion() {
            try {

                //Cargamos el Driver MySQL
                int x = 0;
                Class.forName("com.mysql.jdbc.Driver");
                conect = DriverManager.getConnection("jdbc:mysql://localhost/parqueo", "root", "");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
            return conect;

        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIU;
    private javax.swing.JPasswordField PwClave;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
     conectar cc = new conectar();
    Connection cn = cc.conexion();
}
