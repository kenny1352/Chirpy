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
public class SearchWindow extends JDialog {
    public SearchWindow(Frame owner) {
        super(owner);
        initComponents();
    }

    public SearchWindow(Dialog owner) {
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

public class ProfileSearchWindow extends JDialog {
    public ProfileSearchWindow(Frame owner) {
        super(owner);
        initComponents();
    }

    public ProfileSearchWindow(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void searchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        buttonBar = new JPanel();
        searchButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setVisible(true);
        setBackground(new Color(102, 255, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(204, 255, 255));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(204, 255, 255));
                contentPanel.setLayout(new BorderLayout(0, 10));

                //---- label1 ----
                label1.setText("New Profile Search");
                label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
                label1.setPreferredSize(new Dimension(102, 40));
                label1.setHorizontalTextPosition(SwingConstants.CENTER);
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setBackground(new Color(204, 255, 255));
                label1.setOpaque(true);
                contentPanel.add(label1, BorderLayout.PAGE_START);

                //---- textField1 ----
                textField1.setPreferredSize(new Dimension(75, 50));
                textField1.setFont(new Font("Monospaced", Font.PLAIN, 16));
                contentPanel.add(textField1, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(204, 255, 255));
                buttonBar.setLayout(new GridLayout(1, 0, 10, 0));

                //---- searchButton ----
                searchButton.setText("Search");
                searchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                searchButton.addActionListener(e -> searchButtonActionPerformed(e));
                buttonBar.add(searchButton);

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
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
}
