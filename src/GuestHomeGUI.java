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
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        panel3 = new JPanel();
        title = new JLabel();
        panel4 = new JSplitPane();
        panel1 = new JPanel();
        newsfeedButton = new JButton();
        profileSearchButton = new JButton();
        topicSearchButton = new JButton();
        logoutButton = new JButton();
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

        //======== panel3 ========
        {

            // JFormDesigner evaluation mark
            panel3.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel3.setLayout(new BorderLayout());

            //---- title ----
            title.setText("Guest Newsfeed");
            title.setFont(new Font("Segoe UI", Font.BOLD, 22));
            title.setOpaque(true);
            title.setPreferredSize(new Dimension(42, 50));
            title.setHorizontalTextPosition(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setBackground(new Color(204, 255, 255));
            panel3.add(title, BorderLayout.NORTH);

            //======== panel4 ========
            {
                panel4.setBackground(new Color(102, 255, 204));
                panel4.setDividerSize(2);

                //======== panel1 ========
                {
                    panel1.setPreferredSize(new Dimension(180, 40));
                    panel1.setBackground(new Color(102, 255, 204));
                    panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel1.setLayout(new GridLayout(9, 1, 10, 10));

                    //---- newsfeedButton ----
                    newsfeedButton.setText("Newsfeed");
                    newsfeedButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newsfeedButton.addActionListener(e -> newsfeedButtonActionPerformed(e));
                    panel1.add(newsfeedButton);

                    //---- profileSearchButton ----
                    profileSearchButton.setText("Search Profiles");
                    profileSearchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    profileSearchButton.addActionListener(e -> profileSearchButtonActionPerformed(e));
                    panel1.add(profileSearchButton);

                    //---- topicSearchButton ----
                    topicSearchButton.setText("Search Topics");
                    topicSearchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    topicSearchButton.addActionListener(e -> topicSearchButtonActionPerformed(e));
                    panel1.add(topicSearchButton);

                    //---- logoutButton ----
                    logoutButton.setText("Logout");
                    logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));
                    panel1.add(logoutButton);
                }
                panel4.setLeftComponent(panel1);

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                    textArea1.setMargin(new Insets(15, 15, 15, 5));
                    textArea1.setEditable(false);
                    textArea1.setText("Welcome!");
                    scrollPane1.setViewportView(textArea1);
                }
                panel4.setRightComponent(scrollPane1);
            }
            panel3.add(panel4, BorderLayout.CENTER);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JPanel panel3;
    private JLabel title;
    private JSplitPane panel4;
    private JPanel panel1;
    private JButton newsfeedButton;
    private JButton profileSearchButton;
    private JButton topicSearchButton;
    private JButton logoutButton;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection conn;
    private User user;
}
