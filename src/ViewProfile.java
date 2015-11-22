import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author Catherine Merz, Kenny Campbell, Hannah Morgan
 * @summary This class is GUI for displaying the information about a certain user such as username, bio, messages, and
 * allows a user to subscribe to the person's profile
 */
public class ViewProfile extends JFrame {

    /**
     * Creates a new ViewProfile object.
     * @param user the user that generated the search.
     * @param profileSearched the user being searched for.
     * @param connection the connection currently being used by the user.
     */
    public ViewProfile(User user, User profileSearched, Connection connection) {
        initComponents();
        this.user=user;
        this.profileSearched = profileSearched;
        if (user.getUsername().equals("Guest")) {
            subscribeButton.setEnabled(false);
        }
        else if (user.isSubscribedTo(profileSearched.getUsername())){
            subscribeButton.setText("Unsubscribe");
        }
        //draw user info about posted messages from database
        conn = connection;
        updateViewChirps();
    }

    /**
     * Updates the list of Chirps authored by the profileSearched user.
     */
    private void updateViewChirps() {
        label1.setText(profileSearched.getUsername() + "'s Chirps");
        user.downloadNews(conn);
        profileSearched.setPostedChirps(user);
        textArea1.setText(profileSearched.getPostedChirps());
        textArea1.setSelectionStart(0);
        textArea1.setSelectionEnd(0);
    }

    /**
     *
     * @param e
     */
    private void viewChirpsActionPerformed(ActionEvent e) {
        label1.setText(profileSearched.getUsername() + "'s Chirps");
        updateViewChirps();
    }

    /**
     *
     * @param e
     */
    private void viewBioButtonActionPerformed(ActionEvent e) {
        label1.setText(profileSearched.getUsername() + "'s Bio");
        textArea1.setText(profileSearched.getBio());
        textArea1.setSelectionStart(0);
        textArea1.setSelectionEnd(0);
    }

    /**
     *
     * @param e
     */
    private void subscribeButtonActionPerformed(ActionEvent e) {
        if (subscribeButton.getText().equals("Unsubscribe")){
            user.unsubscribe(profileSearched.getUsername());
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("DELETE FROM " + user.getUsername() + "_subscribe WHERE users LIKE '" +
                        profileSearched.getUsername() + "'");
                subscribeButton.setText("Subscribe");
            }
            catch (SQLException SQLex) {
                handleSQLException(SQLex);
            }
        }
        else if (subscribeButton.getText().equals("Subscribe")){
            user.newSubscrip(profileSearched.getUsername());
            try {
                String sql = "INSERT INTO " + user.getUsername() + "_subscribe(users) VALUES(?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, profileSearched.getUsername());
                statement.execute();
                subscribeButton.setText("Unsubscribe");
            }
            catch (SQLException SQLex) {
                handleSQLException(SQLex);
            }
        }
    }

    /**
     *
     * @param e
     */
    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(this, "SQLException: " + e.getMessage() +
                "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode());
    }

    /**
     *
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        label1 = new JLabel();
        panel1 = new JPanel();
        buttonBar = new JPanel();
        button1 = new JButton();
        viewBioButton = new JButton();
        subscribeButton = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setVisible(true);
        setMinimumSize(new Dimension(650, 600));
        setTitle("Chirpy");
        setBackground(new Color(102, 255, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("[Username]'s Chirps");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(new Color(204, 255, 255));
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(106, 50));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        label1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 255, 204));
            panel1.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBackground(new Color(102, 255, 204));
                buttonBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                buttonBar.setBorder(new EmptyBorder(5, 5, 5, 5));
                buttonBar.setLayout(new GridLayout(1, 3, 10, 10));

                //---- button1 ----
                button1.setText("View Chirps");
                button1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                button1.addActionListener(e -> viewChirpsActionPerformed(e));
                buttonBar.add(button1);

                //---- viewBioButton ----
                viewBioButton.setText("View Bio");
                viewBioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                viewBioButton.addActionListener(e -> viewBioButtonActionPerformed(e));
                buttonBar.add(viewBioButton);

                //---- subscribeButton ----
                subscribeButton.setText("Subscribe");
                subscribeButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                subscribeButton.addActionListener(e -> subscribeButtonActionPerformed(e));
                buttonBar.add(subscribeButton);
            }
            panel1.add(buttonBar, BorderLayout.NORTH);

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(new Color(102, 255, 204));
                scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

                //---- textArea1 ----
                textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                textArea1.setMargin(new Insets(15, 15, 15, 5));
                textArea1.setText("fjsvhkdnkdvnjkbjskbnv");
                textArea1.setEditable(false);
                scrollPane1.setViewportView(textArea1);
            }
            panel1.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JLabel label1;
    private JPanel panel1;
    private JPanel buttonBar;
    private JButton button1;
    private JButton viewBioButton;
    private JButton subscribeButton;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private User user;
    private User profileSearched;
    private Connection conn;
}
