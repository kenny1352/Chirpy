import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
/*
 * Created by JFormDesigner on Sat Nov 14 15:13:42 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class NewChirpWindow extends JFrame {
    public NewChirpWindow(User author) {
        initComponents();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMenuItem1);
        buttonGroup.add(radioButtonMenuItem2);
        authorUser = author;
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        Message chirp = new Message(authorUser.getUsername(), textPane1.getText(), radioButtonMenuItem1.isSelected());
        //System.out.println(chirp.toString());
        // TODO add new Chirp to database
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        menu1 = new JMenuBar();
        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setTitle("New Chirp");
        setMinimumSize(new Dimension(200, 200));
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(102, 255, 204));
            dialogPane.setMinimumSize(new Dimension(300, 200));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(102, 255, 204));
                contentPanel.setLayout(new BorderLayout(5, 5));

                //======== scrollPane1 ========
                {
                    scrollPane1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                    scrollPane1.setPreferredSize(new Dimension(50, 25));

                    //---- textPane1 ----
                    textPane1.setFont(new Font("Serif", Font.PLAIN, 16));
                    textPane1.setText("Write Chirp message here...");
                    textPane1.setPreferredSize(new Dimension(175, 50));
                    textPane1.setMinimumSize(new Dimension(57, 50));
                    textPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    scrollPane1.setViewportView(textPane1);
                }
                contentPanel.add(scrollPane1, BorderLayout.CENTER);

                //======== menu1 ========
                {
                    menu1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    menu1.setPreferredSize(new Dimension(306, 35));
                    menu1.setBackground(new Color(153, 204, 255));
                    menu1.setBorder(LineBorder.createBlackLineBorder());
                    menu1.setOpaque(true);
                    menu1.setInheritsPopupMenu(true);
                    menu1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                    //---- radioButtonMenuItem1 ----
                    radioButtonMenuItem1.setText("Post Publicly");
                    radioButtonMenuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    radioButtonMenuItem1.setFocusable(true);
                    radioButtonMenuItem1.setSelected(true);
                    radioButtonMenuItem1.setFocusPainted(true);
                    radioButtonMenuItem1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    menu1.add(radioButtonMenuItem1);

                    //---- radioButtonMenuItem2 ----
                    radioButtonMenuItem2.setText("Subscribers Only");
                    radioButtonMenuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    radioButtonMenuItem2.setFocusPainted(true);
                    radioButtonMenuItem2.setFocusable(true);
                    radioButtonMenuItem2.setRolloverEnabled(true);
                    radioButtonMenuItem2.setBorder(new EmptyBorder(5, 5, 5, 5));
                    menu1.add(radioButtonMenuItem2);
                }
                contentPanel.add(menu1, BorderLayout.SOUTH);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(102, 255, 204));
                buttonBar.setLayout(new GridLayout(1, 2, 10, 0));

                //---- okButton ----
                okButton.setText("Post New Chirp");
                okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                okButton.setBackground(new Color(238, 238, 238));
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton);

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                cancelButton.setBackground(new Color(238, 238, 238));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JMenuBar menu1;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User authorUser;
}
