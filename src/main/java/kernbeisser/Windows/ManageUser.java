/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernbeisser.Windows;

import at.favre.lib.crypto.bcrypt.BCrypt;
import kernbeisser.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julik
 */
public abstract class ManageUser extends JFrame implements Finishable {
    private List<Boolean> jobs = new ArrayList<>(20);
    private JTable userSelector;
    private Translator t = new Translator();
    /**
     * Creates new form ManageUser
     */
    public ManageUser(Permission permission) {
        initComponents();
        addWindowListener(new Finisher(this,this));
        try {
            userSelector = Tools.createDBTable(
                    "select u from User u",
                    User.class.getDeclaredField("username"),
                    User.class.getDeclaredField("firstName"),
                    User.class.getDeclaredField("surname")
            );
            userSelector.addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            EntityManager em = DBConnection.getEntityManager();
                            paste(em.createQuery(
                                    "select u from User u where u.username like '"
                                            +userSelector.getValueAt(userSelector.getSelectedRow(),0)+
                                            "'",User.class)
                                    .getSingleResult());
                        }
                    }
            );
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        JScrollPane jScrollPane = new JScrollPane(userSelector);
        jScrollPane.setBounds(0,0,getWidth(),getHeight());
        tableContainer.addTab("All",jScrollPane);
        setLocationRelativeTo(null);
        switch (permission){
            case ADMIN:
                this.permission.addItem(t.translate(Permission.ADMIN));
            case MONEY_MANAGER:
                this.permission.addItem(t.translate(Permission.MONEY_MANAGER));
            case MANAGER:
                this.permission.addItem(t.translate(Permission.MANAGER));
                editUser.setEnabled(true);
            case STANDARD:
                this.permission.addItem(t.translate(Permission.STANDARD));
                this.permission.addItem(t.translate(Permission.BEGINNER));
        }
        setVisible(true);
        addWindowListener(new Finisher(this,this));

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        fistName = new JTextField();
        jLabel2 = new JLabel();
        surname = new JTextField();
        jLabel3 = new JLabel();
        phoneNumber1 = new JTextField();
        phoneNumber2 = new JTextField();
        jLabel4 = new JLabel();
        jobsSelector = new JButton();
        extraJobs = new JTextField();
        jLabel7 = new JLabel();
        address = new JTextField();
        email = new JTextField();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        back = new JButton();
        jLabel10 = new JLabel();
        street = new JTextField();
        shares = new JSpinner();
        solidaritySurcharge = new JSpinner();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        permission = new JComboBox<>();
        kernbeisserKey = new JCheckBox();
        jLabel13 = new JLabel();
        employee = new JCheckBox();
        addUser = new JButton();
        editUser = new JButton();
        password = new JPasswordField();
        username = new JTextField();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        tableContainer = new JTabbedPane();
        jCheckBox1 = new JCheckBox();
        jLabel5 = new JLabel();
        enterUserGroup = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Vorname");

        jLabel2.setText("Nachname");

        jLabel3.setText("Telefonnummer 1");

        jLabel4.setText("Telefonummer 2");

        jobsSelector.setText("Dienste");
        jobsSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsSelectorActionPerformed(evt);
            }
        });

        jLabel7.setText("Zusatzdienste");

        jLabel8.setText("Addresse");

        jLabel9.setText("Email");

        back.setText("<-Zurück");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel10.setText("Straße");

        jLabel11.setText("Anteile");

        jLabel12.setText("Solidarzuschlag");

        kernbeisserKey.setText("Schlüssel");

        jLabel13.setText("Berechtigung");

        employee.setText("Mitarbeiter");

        addUser.setText("Nutzer Erstellen");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        editUser.setText("Nutzer Bearbeiten");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });

        jLabel14.setText("Nutzername");

        jLabel15.setText("Password");

        jCheckBox1.setText("Alleine");

        jLabel5.setText("Gemeinschaft");

        enterUserGroup.setText("Beiteten");
        enterUserGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterUserGroupActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(username)
                                    .addGap(32, 32, 32))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jobsSelector, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(permission, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(addUser, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password)
                                    .addComponent(extraJobs)
                                    .addComponent(jLabel7)
                                    .addComponent(editUser, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fistName)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(phoneNumber1, GroupLayout.Alignment.LEADING)
                                        .addComponent(email, GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8))
                                        .addComponent(shares, GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, GroupLayout.Alignment.LEADING)
                                        .addComponent(street, GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(92, 92, 92)))))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(address, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(35, 35, 35)
                                                    .addComponent(jLabel8)))
                                            .addComponent(phoneNumber2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(enterUserGroup))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(solidaritySurcharge, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(kernbeisserKey)
                                            .addComponent(employee)))
                                    .addComponent(jLabel2))
                                .addComponent(surname, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel5))
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addComponent(tableContainer, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(back)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(fistName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(surname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumber1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10)
                                .addGap(3, 3, 3)
                                .addComponent(street, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enterUserGroup)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumber2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(7, 7, 7)
                                        .addComponent(solidaritySurcharge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(kernbeisserKey))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(permission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employee))
                                .addGap(18, 18, 18)
                                .addComponent(jobsSelector, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(extraJobs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addUser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(editUser, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(tableContainer)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobsSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobsSelectorActionPerformed
        new JobSelector(jobs) {
            @Override
            void finish(List<Boolean> x) {
                jobsSelector.setEnabled(true);
                jobs=x;
            }
        };
        jobsSelector.setEnabled(false);
    }//GEN-LAST:event_jobsSelectorActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        EntityManager em = DBConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        User user = collectData();
        if(user.getUsername().length()<3){
            JOptionPane.showMessageDialog(this,"Der gewählte Benutzername ist zu kurz!");
            Tools.ping(username);
            return;
        }else
        if(JOptionPane.showConfirmDialog(this,"Wollen sie diesen Benutzer wirklich erstellen?")==0){
            try {
                em.persist(user);
            }catch (PersistenceException e){
                JOptionPane.showMessageDialog(this,"Der Benutzername ist bereits vergeben!");
            }
            em.flush();
            et.commit();
            JOptionPane.showMessageDialog(this,"Nutzer erfolgreich erstellt!","Erfolg",JOptionPane.INFORMATION_MESSAGE);
            em.close();
            refreshTable();
        }else {
            em.close();
            return;
        }
    }//GEN-LAST:event_addUserActionPerformed
    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        EntityManager em = DBConnection.getEntityManager();
        EntityTransaction et = em.getTransaction();
        User dbContent= em.createQuery(
                "select u from User u where username like '"+ userSelector.getValueAt(userSelector.getSelectedRow(),0)+ "'",
                User.class).getSingleResult();
        String dbPassword = dbContent.getPassword();
        User newContent = collectData(dbContent);
        if(password.getPassword().length==0)
            newContent.setPassword(dbPassword);
        et.begin();
        em.persist(newContent);
        em.flush();
        et.commit();
        em.close();
        refreshTable();
    }//GEN-LAST:event_editUserActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        finish(this);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void enterUserGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterUserGroupActionPerformed

    }//GEN-LAST:event_enterUserGroupActionPerformed

    private User collectData(){
        return collectData(new User());
    }
    private User collectData(User user){
        user.setCreateDate(Date.valueOf(LocalDate.now()));
        user.setFirstName(fistName.getText());
        user.setSurname(surname.getText());
        user.setPhoneNumber1(phoneNumber1.getText());
        user.setPhoneNumber2(phoneNumber2.getText());
        user.setAddress(address.getText()+" ; "+street.getText());
        user.setEmail(email.getText());
        user.setShares((Integer) shares.getValue());
        user.setSolidaritySurcharge((Integer) solidaritySurcharge.getValue());
        user.setPermission(t.translate(Permission.class,permission.getSelectedItem().toString()));
        user.setKernbeisserKey(kernbeisserKey.isSelected());
        user.setEmployee(employee.isSelected());
        user.getJobs().clear();
        user.getJobs().addAll(jobs);
        user.setExtraJobs(extraJobs.getText());
        user.setUsername(username.getText());
        user.setPassword(BCrypt.withDefaults().hashToString(12,password.getPassword()));
        return user;
    }
    private void refreshTable(){
        try {
            userSelector.setModel(Tools.createDBTable(
                    "select u from User u",
                    User.class.getDeclaredField("username"),
                    User.class.getDeclaredField("firstName"),
                    User.class.getDeclaredField("surname")
            ).getModel());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    private void paste(User user){
        fistName.setText(user.getFirstName());
        surname.setText(user.getSurname());
        phoneNumber1.setText(user.getPhoneNumber1());
        phoneNumber2.setText(user.getPhoneNumber2());
        String[] a = user.getAddress().split(";");
        address.setText(a[0]);
        street.setText(a[1]);
        email.setText(user.getEmail());
        shares.setValue(user.getShares());
        solidaritySurcharge.setValue(user.getSolidaritySurcharge());
        permission.setSelectedItem(t.translate(user.getPermission()));
        kernbeisserKey.setSelected(user.isKernbeisserKey());
        employee.setSelected(user.isEmployee());
        jobs=user.getJobs();
        extraJobs.setText(user.getExtraJobs());
        username.setText(user.getUsername());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addUser;
    private JTextField address;
    private JButton back;
    private JButton editUser;
    private JTextField email;
    private JCheckBox employee;
    private JButton enterUserGroup;
    private JTextField extraJobs;
    private JTextField fistName;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JButton jobsSelector;
    private JCheckBox kernbeisserKey;
    private JPasswordField password;
    private JComboBox<String> permission;
    private JTextField phoneNumber1;
    private JTextField phoneNumber2;
    private JSpinner shares;
    private JSpinner solidaritySurcharge;
    private JTextField street;
    private JTextField surname;
    private JTabbedPane tableContainer;
    private JTextField username;
    // End of variables declaration//GEN-END:variables
}
