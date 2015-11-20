import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Nov 15 17:29:33 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class GuestHomeGUI extends JFrame {
    public GuestHomeGUI() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", "Guest", "Guest");
            System.out.println("Database Connected");
            user = new User("Guest");
        }
        catch (SQLException SQLex) {
            System.out.println("SQLException: " + SQLex.getMessage());
            System.out.println("SQLState: " + SQLex.getSQLState());
            System.out.println("VendorError: " + SQLex.getErrorCode());
        }
        catch (ClassNotFoundException ex1) {
            System.out.println("ClassNotFoundException: " + ex1.getMessage());
        }
        catch (InstantiationException ex2) {
            System.out.println("InstantiationException: " + ex2.getMessage());
        }
        catch (IllegalAccessException ex3) {
            System.out.println("IllegalAccessException: " + ex3.getMessage());
        }
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        updateNewsfeed();
    }

    public void updateNewsfeed() {
        title.setText("Guest Newsfeed");
        user.downloadNews(conn);
        textArea1.setText(user.getNewsfeed());
        textArea1.setSelectionStart(0);
        textArea1.setSelectionEnd(0);
    }

    private void profileSearchButtonActionPerformed(ActionEvent e) {
        //new ProfileSearchWindow(this);
    }

    private void topicSearchButtonActionPerformed(ActionEvent e) {
        //new TopicSearchWindow(this);
        String searchTopic = textField1.getText();
        title.setText("Newsfeed Chirps containing #"+searchTopic);
        user.downloadNews(conn);
        textArea1.setText(user.searchNews(searchTopic));
        textArea1.setSelectionStart(0);
        textArea1.setSelectionEnd(0);
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        title = new JLabel();
        panel4 = new JPanel();
        panel2 = new JPanel();
        panel1 = new JPanel();
        newsfeedButton = new JButton();
        logoutButton = new JButton();
        panel5 = new JPanel();
        textField1 = new JTextField();
        profileSearchButton = new JButton();
        topicSearchButton = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Chirpy");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setMinimumSize(new Dimension(650, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- title ----
        title.setText("Guest Newsfeed");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setOpaque(true);
        title.setPreferredSize(new Dimension(42, 50));
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(204, 255, 255));
        contentPane.add(title, BorderLayout.PAGE_START);

        //======== panel4 ========
        {
            panel4.setBackground(new Color(102, 255, 204));

            // JFormDesigner evaluation mark
            panel4.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel4.setLayout(new BorderLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setPreferredSize(new Dimension(180, 40));
                    panel1.setBackground(new Color(102, 255, 204));
                    panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel1.setLayout(new GridLayout(6, 1, 10, 10));

                    //---- newsfeedButton ----
                    newsfeedButton.setText("Newsfeed");
                    newsfeedButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newsfeedButton.addActionListener(e -> newsfeedButtonActionPerformed(e));
                    panel1.add(newsfeedButton);

                    //---- logoutButton ----
                    logoutButton.setText("Logout");
                    logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));
                    panel1.add(logoutButton);
                }
                panel2.add(panel1, BorderLayout.CENTER);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(102, 255, 204));
                    panel5.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel5.setLayout(new GridLayout(3, 1, 0, 8));

                    //---- textField1 ----
                    textField1.setMargin(new Insets(5, 5, 5, 5));
                    textField1.setFont(new Font("Segoe UI", Font.ITALIC, 16));
                    textField1.setText("Enter search term here...");
                    panel5.add(textField1);

                    //---- profileSearchButton ----
                    profileSearchButton.setText("Search Profiles");
                    profileSearchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    profileSearchButton.addActionListener(e -> profileSearchButtonActionPerformed(e));
                    panel5.add(profileSearchButton);

                    //---- topicSearchButton ----
                    topicSearchButton.setText("Search Topics");
                    topicSearchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    topicSearchButton.addActionListener(e -> topicSearchButtonActionPerformed(e));
                    panel5.add(topicSearchButton);
                }
                panel2.add(panel5, BorderLayout.PAGE_END);
            }
            panel4.add(panel2, BorderLayout.WEST);

            //======== scrollPane1 ========
            {
                scrollPane1.setPreferredSize(new Dimension(86, 52));

                //---- textArea1 ----
                textArea1.setEditable(false);
                textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                textArea1.setMargin(new Insets(15, 15, 15, 5));
                textArea1.setText("Welcome!");
                scrollPane1.setViewportView(textArea1);
            }
            panel4.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(panel4, BorderLayout.CENTER);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JLabel title;
    private JPanel panel4;
    private JPanel panel2;
    private JPanel panel1;
    private JButton newsfeedButton;
    private JButton logoutButton;
    private JPanel panel5;
    private JTextField textField1;
    private JButton profileSearchButton;
    private JButton topicSearchButton;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection conn;
    private User user;
}
