package kernbeisser.Windows.UserMenu;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kernbeisser.Windows.Finishable;
import kernbeisser.DBEntitys.SaleSession;
import kernbeisser.DBEntitys.User;
import kernbeisser.Windows.CashierMenu.CashierMenuView;
import kernbeisser.Windows.Finisher;
import kernbeisser.Windows.InventoryMenu.InventoryMenu;
import kernbeisser.Windows.LogIn.LogIn;
import kernbeisser.Windows.Options.Options;
import kernbeisser.Windows.ShoppingMask.ShoppingMask;
import kernbeisser.Windows.Stats.Stats;
import kernbeisser.Windows.Window;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author julik
 */
public abstract class UserMenu extends JFrame implements Finishable {
    private User user;
    /**
     * Creates new form UserMenu
     */
    public UserMenu(User user) {
        this.user=user;
        initComponents();
        username.setText(user.getUsername()+"!");
        setSize(1070,678);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new Finisher(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startInventory = new javax.swing.JButton();
        startOptions = new javax.swing.JButton();
        startStats = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        startShopping = new javax.swing.JButton();
        startCashier = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu - Home");

        jPanel1.setBackground(new java.awt.Color(155, 228, 125));

        startInventory.setBackground(new java.awt.Color(93, 173, 226));
        startInventory.setText("Inventurprogramm");
        startInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startInventoryActionPerformed(evt);
            }
        });

        startOptions.setBackground(new java.awt.Color(93, 173, 226));
        startOptions.setText("Einstellungen");
        startOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startOptionsActionPerformed(evt);
            }
        });

        startStats.setBackground(new java.awt.Color(93, 173, 226));
        startStats.setText("Statistik");
        startStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStatsActionPerformed(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(93, 173, 226));
        logOut.setText("Log out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        startShopping.setBackground(new java.awt.Color(93, 173, 226));
        startShopping.setText("Einkauf beginnen");
        startShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startShoppingActionPerformed(evt);
            }
        });

        startCashier.setText("Ladendienst beginnen");
        startCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCashierActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(198, 125, 228));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(198, 125, 228));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Willkommen zurueck");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startCashier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startInventory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logOut, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(startShopping, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(startCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(startStats, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(startOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(startInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(574, Short.MAX_VALUE)
                    .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(244, Short.MAX_VALUE)
                    .addComponent(startShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(341, 341, 341)))
        );

        jPanel2.setBackground(new java.awt.Color(125, 206, 228));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(228, 147, 125));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Neuigkeiten");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(346, 346, 346))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startCashierActionPerformed
        new CashierMenuView(user, null);
        setVisible(false);
    }//GEN-LAST:event_startCashierActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        new LogIn();
        dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void startInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startInventoryActionPerformed
        new InventoryMenu(){
            @Override
            public void finish() {
                dispose();
                UserMenu.this.setVisible(true);
            }
        };
        setVisible(false);
    }//GEN-LAST:event_startInventoryActionPerformed

    private void startOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startOptionsActionPerformed
        new Options(){
            @Override
            public void finish() {
                dispose();
                UserMenu.this.setVisible(true);
            }
        };
        setVisible(false);
    }//GEN-LAST:event_startOptionsActionPerformed
    private void startStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStatsActionPerformed
        new Stats(){
            @Override
            public void finish() {
                dispose();
                UserMenu.this.setVisible(true);
            }
        };
        setVisible(false);
    }//GEN-LAST:event_startStatsActionPerformed

    private void startShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startShoppingActionPerformed
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(1,1));
        SaleSession saleSession = new SaleSession();
        saleSession.setCustomer(user);
        saleSession.setSeller(user);
        jFrame.add(new ShoppingMask(saleSession));
        jFrame.addWindowListener(new Finisher(() -> {
            dispose();
            UserMenu.this.setVisible(true);
        }));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_startShoppingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logOut;
    private javax.swing.JButton startCashier;
    private javax.swing.JButton startInventory;
    private javax.swing.JButton startOptions;
    private javax.swing.JButton startShopping;
    private javax.swing.JButton startStats;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
