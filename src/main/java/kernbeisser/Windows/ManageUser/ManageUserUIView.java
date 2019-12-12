package kernbeisser.Windows.ManageUser;

import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.ObjectTable.ObjectTable;
import kernbeisser.DBEntitys.User;
import kernbeisser.Enums.Permission;
import kernbeisser.Enums.UserPersistFeedback;
import kernbeisser.Windows.Controller;
import kernbeisser.Windows.View;
import kernbeisser.Windows.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class ManageUserUIView extends Window implements View {
    private JPanel mainPanel;
    private ObjectTable<User> userTable;
    private JButton addUser;
    private JButton editUser;
    private JButton deleteUser;
    private JButton close;

    private ManageUserUIController controller;

    public ManageUserUIView(Window current, Permission permission) {
        super(current);
        $$$setupUI$$$();
        add(mainPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        controller = new ManageUserUIController(this);
        deleteUser.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Wollen sie diesen Benutzer wirklich entfernen?") == 0)
                controller.remove();
        });
        editUser.addActionListener(e -> controller.edit());
        addUser.addActionListener(e -> controller.add());
        close.addActionListener(e -> back());
    }

    void applyFeedback(UserPersistFeedback feedback) {
        System.out.println(feedback);
    }

    void setUsers(Collection<User> users) {
        userTable.setObjects(users);
    }

    User getSelectedUser() {
        return userTable.getSelectedObject();
    }

    private void createUIComponents() {
        userTable = new ObjectTable<>(
                Column.create("Username", User::getUsername),
                Column.create("Vorname", User::getFirstName),
                Column.create("Nachname", User::getSurname)
        );
    }

    @Override
    public Controller getController() {
        return controller;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 0));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setText("Benutzerliste");
        label1.setVerticalAlignment(0);
        mainPanel.add(label1, BorderLayout.NORTH);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        mainPanel.add(panel1, BorderLayout.SOUTH);
        close = new JButton();
        close.setHorizontalAlignment(0);
        close.setText("Schließen");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel1.add(close, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        addUser = new JButton();
        addUser.setText("Neu...");
        panel2.add(addUser);
        editUser = new JButton();
        editUser.setText("Berbeiten");
        panel2.add(editUser);
        deleteUser = new JButton();
        deleteUser.setText("Löschen");
        panel2.add(deleteUser);
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, BorderLayout.CENTER);
        scrollPane1.setViewportView(userTable);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
