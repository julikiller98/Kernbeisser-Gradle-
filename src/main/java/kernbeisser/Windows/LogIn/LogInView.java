/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernbeisser.Windows.LogIn;

import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.DBTable.DBTable;
import kernbeisser.CustomComponents.ObjectTable.ObjectTable;
import kernbeisser.DBEntitys.User;
import kernbeisser.Useful.Images;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.Background;
import kernbeisser.Windows.Controller;
import kernbeisser.Windows.UserMenu.UserMenu;
import kernbeisser.Windows.View;
import kernbeisser.Windows.Window;

import javax.swing.*;
import java.awt.*;


public class LogInView extends Window implements View {


    private LogInController controller;
    /**
     * Creates new form LogIn from LogInView.form
     * with all Tables from A-Z
     * and a Table with all Users
     */
    public LogInView(kernbeisser.Windows.Window current) {
        super(current);
        controller=new LogInController(this);
        initComponents();
        setSize(Tools.getScreenWidth()/2, Tools.getScreenHeight()/2);
        Background b = new Background(Images.getImage("basil.png"));
        b.autoSize(this);
        b.setBounds(0,0,500,300);
        add(b);
        setLocationRelativeTo(null);
        for (int i = 97; i < 123; i++) {
            ObjectTable<User> dbTable = new ObjectTable<>(
                    controller.getAllWhichBeginsWith((char) i),
                    Column.create("Username", User::getUsername),
                    Column.create("Vorname", User::getFirstName),
                    Column.create("Nachname", User::getSurname));
            dbTable.getTableHeader().setFont(new Font("arial",Font.BOLD,12));
            dbTable.getSelectionModel().addListSelectionListener(e -> username.setText((String) dbTable.getValueAt(dbTable.getSelectedRow(), 0)));
            jTabbedPane1.addTab(String.valueOf(Character.toUpperCase((char) i)), new JScrollPane(dbTable));
        }
        DBTable allUser = new DBTable<>("select u from User u",
                Column.create("Username", User::getUsername),
                Column.create("Vorname", User::getFirstName),
                Column.create("Nachname", User::getSurname));
        allUser.getTableHeader().setFont(new Font("arial",1,12));
        allUser.getSelectionModel().addListSelectionListener(e -> username.setText((String) allUser.getValueAt(allUser.getSelectedRow(), 0)));
        jTabbedPane1.addTab("Alle",new JScrollPane(allUser));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        logInB = new JButton();
        password = new JPasswordField();
        jLabel1 = new JLabel();
        username = new JTextField();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(100, 100));

        jTabbedPane1.setPreferredSize(new Dimension(32767, 32767));

        logInB.setText("Log In");
        logInB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBActionPerformed(evt);
            }
        });

        jLabel1.setText("Passwort");

        jLabel2.setText("Benutzername");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(username, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(logInB))
                                                        .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                                                .addGap(26, 26, 26))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(162, 162, 162)
                                                .addComponent(jLabel1)
                                                .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logInB)
                                        .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBActionPerformed
        logIn();
    }//GEN-LAST:event_logInBActionPerformed

    /**
     * Check if the password and the username match with a user
     * and open the UserMenu for the user
     * @see UserMenu
     */
    private void logIn(){
        switch (controller.logIn(username.getText(),password.getPassword())) {
            case LogInController.SUCCESS:
                controller.openUserMenu();
                break;
            case LogInController.INCORRECT_USERNAME:
                Tools.ping(username);
                JOptionPane.showMessageDialog(this,"Benutzername Falsch!");
                return;
            case LogInController.INCORRECT_PASSWORD:
                Tools.ping(password);
                JOptionPane.showMessageDialog(this,"Das von ihnen Angegebene Passwort ist nicht Korrekt");
                return;

        }
        back();
    }

    @Override
    public Controller getController() {
        return controller;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTabbedPane jTabbedPane1;
    private JButton logInB;
    private JPasswordField password;
    private JTextField username;

    // End of variables declaration//GEN-END:variables
}
