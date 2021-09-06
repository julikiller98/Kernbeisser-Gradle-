package kernbeisser.StartUp.LogIn;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import kernbeisser.Config.Config;
import kernbeisser.Config.Config.DBAccess;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.MVC.Linked;
import org.jetbrains.annotations.NotNull;

public class DBLogInView implements IView<DBLogInController> {

  private JButton logIn;
  private JTextField url;
  private JTextField username;
  private JPasswordField password;
  private JButton cancel;
  private JPanel main;
  private JTextField encoding;

  @Linked
  private DBLogInController controller;

  @Override
  public void initialize(DBLogInController controller) {
    DBAccess access = Config.getConfig().getDBAccessData();
    url.setText(access.getUrl());
    username.setText(access.getUsername());
    logIn.addActionListener(e -> controller.logIn());
    username.addActionListener(e -> controller.logIn());
    password.addActionListener(e -> controller.logIn());
    password.setText(access.getPassword());
    cancel.addActionListener(e -> cancel());
  }

  private void cancel() {
    if (controller.isStartUp()) {
      System.exit(0);
    } else {
      back();
    }
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  @Override
  public String getTitle() {
    return "Datenbankverbindung";
  }

  void connectionValid() {
    JOptionPane.showMessageDialog(getTopComponent(), "Die Verbindung wurde erfolgreich erstellt!");
  }

  void connectionRefused() {
    JOptionPane.showMessageDialog(
        getTopComponent(),
        "Es kann leider keine Verbindung hergestellt werden,\n bitte \u00fcberpr\u00fcfen sie die Eingaben nach Fehlern");
  }

  public DBAccess getDBAccess() {
    return new DBAccess(
        url.getText(), username.getText(), new String(password.getPassword()), encoding.getText());
  }

  public void setConnectionValid(boolean serviceAvailable) {
    username.setForeground(serviceAvailable ? Color.GREEN : Color.RED);
    password.setForeground(serviceAvailable ? Color.GREEN : Color.RED);
    url.setForeground(serviceAvailable ? Color.GREEN : Color.RED);
    encoding.setForeground(serviceAvailable ? Color.GREEN : Color.RED);
  }

  private void defaultColor() {
    username.setForeground(Color.BLACK);
    password.setForeground(Color.BLACK);
    url.setForeground(Color.BLACK);
    encoding.setForeground(Color.BLACK);
  }

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR
   * call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    main = new JPanel();
    main.setLayout(new GridLayoutManager(11, 3, new Insets(10, 10, 10, 10), -1, -1));
    final Spacer spacer1 = new Spacer();
    main.add(spacer1, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0,
        false));
    final JLabel label1 = new JLabel();
    label1.setText("Datenbank URL");
    main.add(label1,
        new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    url = new JTextField();
    main.add(url, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    final JLabel label2 = new JLabel();
    label2.setText("Nutzername");
    main.add(label2,
        new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    username = new JTextField();
    main.add(username, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    final JLabel label3 = new JLabel();
    label3.setText("Password");
    main.add(label3,
        new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    password = new JPasswordField();
    main.add(password, new GridConstraints(8, 0, 1, 3, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    final JLabel label4 = new JLabel();
    Font label4Font = this.$$$getFont$$$(null, -1, 16, label4.getFont());
    if (label4Font != null) {
      label4.setFont(label4Font);
    }
    label4.setText("Datenbankverbindung");
    main.add(label4,
        new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    logIn = new JButton();
    logIn.setForeground(new Color(-12797137));
    logIn.setText("Anmelden");
    main.add(logIn, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_HORIZONTAL,
        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    cancel = new JButton();
    cancel.setForeground(new Color(-4486589));
    cancel.setText("Abbrechen");
    main.add(cancel, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_HORIZONTAL,
        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final JLabel label5 = new JLabel();
    label5.setText("Datenbank Encoding");
    main.add(label5,
        new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    encoding = new JTextField();
    main.add(encoding, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
    if (currentFont == null) {
      return null;
    }
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
    Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(),
        size >= 0 ? size : currentFont.getSize());
    boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
    Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize())
        : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
    return fontWithFallback instanceof FontUIResource ? fontWithFallback
        : new FontUIResource(fontWithFallback);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }
}
