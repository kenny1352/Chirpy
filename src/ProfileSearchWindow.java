import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Nov 15 19:26:33 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class ProfileSearchWindow extends JDialog {
    public ProfileSearchWindow(Frame owner) {
        super(owner);
        initComponents();
    }

    public ProfileSearchWindow(Dialog owner) {
        super(owner);
        initComponents();
    }

    public void setLabel1(String string) {
        label1.setText(string);
    }

    private void searchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JPanel buttonBar;
    private JButton searchButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
