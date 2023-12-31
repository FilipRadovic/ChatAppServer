/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Administrator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import modeli.ModelTabeleKorisnici;
import niti.PokreniServer;

/**
 *
 * @author frado
 */
public class ServerskaForma extends javax.swing.JFrame {
    
    
    Administrator ulogovani;

    public void setUlogovani(Administrator ulogovani) {
        this.ulogovani = ulogovani;
        lbl_admin.setText("Prijavljeni korisnik je: " + ulogovani);
    }
    
    
    /**
     * Creates new form ServerskaForma
     */
    
    private PokreniServer pokreniServer;
    
    
    public ServerskaForma() {
        initComponents();
        setLocationRelativeTo(null);
        lbl_serverStatus.setText("Server je ugasen!");
        btn_pokreniServer.setEnabled(true);
        btn_ugasiServer.setEnabled(false);
        setTitle("Serverska forma");
        Kontroler.getInstance().setSf(this);
        refreshujTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_admin = new javax.swing.JLabel();
        lbl_serverStatus = new javax.swing.JLabel();
        btn_pokreniServer = new javax.swing.JButton();
        btn_ugasiServer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_korisnici = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_NoviKorisnik = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_admin.setText("Prijavljeni administrator:");

        lbl_serverStatus.setText("Server status");

        btn_pokreniServer.setText("Pokreni server");
        btn_pokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pokreniServerActionPerformed(evt);
            }
        });

        btn_ugasiServer.setText("Ugasi server");
        btn_ugasiServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ugasiServerActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Korisnici"));

        tbl_korisnici.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_korisnici);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Novi korisnik");

        mi_NoviKorisnik.setText("Dodaj novog korisnika");
        mi_NoviKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_NoviKorisnikActionPerformed(evt);
            }
        });
        jMenu1.add(mi_NoviKorisnik);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_admin)
                            .addComponent(lbl_serverStatus))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_pokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_ugasiServer, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbl_admin)
                .addGap(18, 18, 18)
                .addComponent(lbl_serverStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pokreniServer)
                    .addComponent(btn_ugasiServer))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Korisnici");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pokreniServerActionPerformed
        
        pokreniServer = new PokreniServer();
        pokreniServer.start();
        lbl_serverStatus.setText("Server je pokrenut!");
        btn_ugasiServer.setEnabled(true);
        btn_pokreniServer.setEnabled(false);
        
    }//GEN-LAST:event_btn_pokreniServerActionPerformed

    private void btn_ugasiServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ugasiServerActionPerformed
        
        try {
            pokreniServer.getServerskiSocket().close();
            
            lbl_serverStatus.setText("Server je ugasen!");
            btn_pokreniServer.setEnabled(true);
            btn_ugasiServer.setEnabled(false);
            
        } catch (IOException ex) {
            Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_ugasiServerActionPerformed

    private void mi_NoviKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_NoviKorisnikActionPerformed
        new FormaNoviKorisnik(this, true).setVisible(true);
    }//GEN-LAST:event_mi_NoviKorisnikActionPerformed

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
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pokreniServer;
    private javax.swing.JButton btn_ugasiServer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JLabel lbl_serverStatus;
    private javax.swing.JMenuItem mi_NoviKorisnik;
    private javax.swing.JTable tbl_korisnici;
    // End of variables declaration//GEN-END:variables

    public void refreshujTabelu() {
        tbl_korisnici.setModel(new ModelTabeleKorisnici());
    }
}
