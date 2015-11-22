import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Hannah Morgan, Kenny Campbell, Catherine Merz
 * @summary This class is a GUI for editing the bio of the user
 */
public class EditBioGUI extends JFrame {

    /**
     * Creates an instance of the EditBioGUI object, automatically displaying the user bio as loaded from the database.
     * @param user the user currently logged into the program
     * @param connection the connection made with the database
     */
    public EditBioGUI(User user, Connection connection) {
        this.user=user;
        conn = connection;
        initComponents();
        displayBio();
    }

    /**
     * Loads user bio information from the database and displays the info in the EditBioGUI text field.
     */
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

    /**
     * Uploads the new user bio to the database, and handles errors if any.
     * @param e user ActionEvent in which user selects Save
     */
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

    /**
     * Ignores any bio changes made in the EditBioGUI and closes the window.
     * @param e user ActionEvent in which user selects Cancel
     */
    private void cancelActionPerformed(ActionEvent e) {
        dispose();
    }

    /**
     * Initializes all GUI components and produces the EditBioGUI window.
     */
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
    }

    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private User user;
    private String thisuserbio;
    private Connection conn;
}
