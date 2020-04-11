package Login;


import com.mysql.jdbc.Connection;
import com.sun.mail.handlers.multipart_mixed;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Correo extends javax.swing.JFrame {
DefaultTableModel modelo = new DefaultTableModel();
    
    public Correo() {
        initComponents();
          setLocationRelativeTo(null);
    }
    
    void mostrarusu(String valor) {

        
        modelo.addColumn("User");
        modelo.addColumn("Pass");
        
        tbusu.setModel(modelo); 
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT nombreUsuario, contraseña FROM `usuario` WHERE email ='"+txtCorreo.getText()+"'";

        }
        String[] datos = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                txtusu.setText(datos[0] = rs.getString(1));
                txtpass.setText(datos[1] = rs.getString(2));

                modelo.addRow(datos);
            }
            tbusu.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbusu = new javax.swing.JTable();
        txtpass = new javax.swing.JTextField();
        txtusu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jcorreo = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tbusu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbusu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbusuKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbusu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Correo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 31, -1, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 28, 187, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 27, -1, -1));

        jcorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcorreo.setForeground(new java.awt.Color(51, 255, 0));
        jcorreo.setText("Correo enviado exitosamente. Porfavor revise cu correo electronico");
        getContentPane().add(jcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
          mostrarusu("");
        
          try {
         
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "parqueoguapiles@gmail.com";
            String passwordRemitente = "guapiles123";
            String correoReceptor = txtCorreo.getText();
            String asunto = "Mi primero correo en Java";
            String mensaje = "Su Usuario es: "+txtusu.getText() + "Su Contraseña es: "+txtpass.getText();

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            jcorreo.setVisible(true);

        } catch (AddressException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void tbusuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbusuKeyPressed

    }//GEN-LAST:event_tbusuKeyPressed
    
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
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Correo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jcorreo;
    private javax.swing.JTable tbusu;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
Conexion.datosP cc = new Conexion.datosP();
    java.sql.Connection cn = cc.conexion();
}
