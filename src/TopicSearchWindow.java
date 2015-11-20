import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Nov 15 20:36:04 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class TopicSearchWindow extends JDialog {
    public TopicSearchWindow(Frame owner) {
        super(owner);
        initComponents();
    }

    public TopicSearchWindow(Dialog owner) {
        super(owner);
        initComponents();
    }

    private String okButtonActionPerformed(ActionEvent e) {
        return textField1.getText();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setVisible(true);
        setAlwaysOnTop(true);
        setMinimumSize(new Dimension(300, 39));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(0, 10));

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
                label1.setText("New Topic Search");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setPreferredSize(new Dimension(19, 40));
                label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
                label1.setBackground(new Color(204, 255, 255));
                label1.setOpaque(true);
                contentPanel.add(label1, BorderLayout.NORTH);

                //---- textField1 ----
                textField1.setMargin(new Insets(15, 15, 15, 5));
                textField1.setMinimumSize(new Dimension(14, 50));
                contentPanel.add(textField1, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(204, 255, 255));
                buttonBar.setLayout(new GridLayout(1, 0, 10, 0));

                //---- okButton ----
                okButton.setText("Search");
                okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton);

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
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection conn;
}
