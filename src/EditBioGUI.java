import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Nov 15 18:10:58 EST 2015
 */



/**
 * @author H Morgan
 */
public class EditBioGUI extends JFrame {
    public EditBioGUI(User user, Connection connection) {
        this.user=user;
        conn = connection;
        initComponents();
        displayBio();
    }

    private void displayBio() {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username LIKE '" + user.getUsername() + "'");
            resultSet.next();
            user.setBio(resultSet.getString("bio"));
            thisuserbio = user.getBio();
            if (thisuserbio.equals("")) {
                textPane1.setText("Write new Bio here...");
            } else {
                textPane1.setText(thisuserbio);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQLException: " + e.getMessage() +
                    "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode());
        }
    }

    private void saveActionPerformed(ActionEvent e) {
        user.setBio(textPane1.getText());
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE users SET bio='" + textPane1.getText() +"' WHERE username LIKE '" + user.getUsername() + "'");
        } catch (SQLException SQLex) {
            JOptionPane.showMessageDialog(this, "SQLException: " + SQLex.getMessage() +
                    "\nSQLState: " + SQLex.getSQLState() + "\nVendorError: " + SQLex.getErrorCode());
        }
        dispose();
    }

    private void cancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Edit Bio");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizedBounds(new Rectangle(0, 0, 200000, 200000));
        setMinimumSize(new Dimension(200, 80));
        setBackground(new Color(102, 255, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
            scrollPane1.setBackground(new Color(102, 255, 204));

            //---- textPane1 ----
            textPane1.setText("Write new bio here...");
            textPane1.setFont(new Font("Serif", Font.PLAIN, 16));
            textPane1.setPreferredSize(new Dimension(400, 100));
            textPane1.setMinimumSize(new Dimension(200, 80));
            textPane1.setBorder(new EtchedBorder());
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 255, 204));
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));

            // JFormDesigner evaluation mark
            //panel1.setBorder(new javax.swing.border.CompoundBorder(
                //new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    //"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    //javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    //java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridLayout(1, 0, 10, 0));

            //---- button1 ----
            button1.setText("Save");
            button1.addActionListener(e -> saveActionPerformed(e));
            panel1.add(button1);

            //---- button2 ----
            button2.setText("Cancel");
            button2.addActionListener(e -> cancelActionPerformed(e));
            panel1.add(button2);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
    private String thisuserbio;
    private Connection conn;
}
