import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Nov 12 19:37:36 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class HomePageGUI extends JFrame {
    public HomePageGUI() {
        initComponents();
    }

    public boolean createConnection(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", username, password);
            System.out.println("Database Connected");
            user = new User(username);
            return true;
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
        catch (ClassNotFoundException ex1) {handleClassNotFoundException(ex1);}
        catch (InstantiationException ex2) {handleInstantiationException(ex2);}
        catch (IllegalAccessException ex3) {handleIllegalAccessException(ex3);}
        return false;
    }

    private void bioButtonActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername() + "'s Bio");
        EditBioGUI editBioGUI = new EditBioGUI(user, conn);
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        updateNewsfeed();
    }

    public void updateNewsfeed() {
        headerText.setText(user.getUsername() + "'s Newsfeed");
        user.downloadNews(conn);
        displayField.setText(user.getNewsfeed());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    private void newChirpButtonActionPerformed(ActionEvent e) {
        new NewChirpWindow(user, conn);
    }

    private void postedChirpsButtonActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername() + "'s Posted Chirps");
        user.downloadPosted(conn);
        displayField.setText(user.getPostedChirps());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    private void receivedChirpsButtonActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername() + "'s Received Chirps");
        user.downloadreceivedChirps(conn);
        displayField.setText(user.getRecievedChirps());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    private void searchProfilesButtonActionPerformed(ActionEvent e) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username LIKE '" + textField1.getText() + "'");
            resultSet.next();
            User searchUser = new User(resultSet.getString("username"));
            searchUser.setBio(resultSet.getString("bio"));
            new ViewProfile(user, searchUser, false, conn);
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
    }

    private void searchTopicsButtonActionPerformed(ActionEvent e) {
        String searchTopic = textField1.getText();
        headerText.setText("Newsfeed Chirps containing #"+searchTopic);
        user.downloadNews(conn);
        displayField.setText(user.searchNews(searchTopic));
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        dispose();
    }


    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(this, "SQLException: " + e.getMessage() +
                "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode());
    }

    private void handleClassNotFoundException(ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "ClassNotFoundException: " + e.getMessage());
    }

    private void handleInstantiationException(InstantiationException e) {
        JOptionPane.showMessageDialog(this, "InstantiationException: " + e.getMessage());
    }

    private void handleIllegalAccessException(IllegalAccessException e) {
        JOptionPane.showMessageDialog(this, "IllegalAccessException: " + e.getMessage());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        headerText = new JLabel();
        splitPane1 = new JPanel();
        panel1 = new JPanel();
        menuPanel = new JPanel();
        bioButton = new JButton();
        newsfeedButton = new JButton();
        newChirpButton = new JButton();
        postedChirpsButton = new JButton();
        receivedChirpsButton = new JButton();
        logoutButton = new JButton();
        panel2 = new JPanel();
        textField1 = new JTextField();
        searchProfilesButton = new JButton();
        searchTopicsButton = new JButton();
        scrollPane1 = new JScrollPane();
        displayField = new JTextArea();

        //======== this ========
        setTitle("Chirpy");
        setMinimumSize(new Dimension(670, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(102, 255, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- headerText ----
        headerText.setText("Chirpy");
        headerText.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerText.setHorizontalAlignment(SwingConstants.CENTER);
        headerText.setBackground(new Color(204, 255, 255));
        headerText.setPreferredSize(new Dimension(77, 50));
        headerText.setOpaque(true);
        contentPane.add(headerText, BorderLayout.NORTH);

        //======== splitPane1 ========
        {
            splitPane1.setBackground(new Color(102, 255, 204));

            // JFormDesigner evaluation mark
            splitPane1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), splitPane1.getBorder())); splitPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            splitPane1.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== menuPanel ========
                {
                    menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    menuPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    menuPanel.setPreferredSize(new Dimension(195, 275));
                    menuPanel.setBackground(new Color(102, 255, 204));
                    menuPanel.setMinimumSize(new Dimension(185, 274));
                    menuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    menuPanel.setLayout(new GridLayout(7, 1, 0, 8));

                    //---- bioButton ----
                    bioButton.setText("Bio");
                    bioButton.setPreferredSize(new Dimension(50, 40));
                    bioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    bioButton.setBackground(UIManager.getColor("Button.background"));
                    bioButton.addActionListener(e -> bioButtonActionPerformed(e));
                    menuPanel.add(bioButton);

                    //---- newsfeedButton ----
                    newsfeedButton.setText("Newsfeed");
                    newsfeedButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newsfeedButton.setBackground(UIManager.getColor("Button.background"));
                    newsfeedButton.setPreferredSize(new Dimension(99, 40));
                    newsfeedButton.addActionListener(e -> newsfeedButtonActionPerformed(e));
                    menuPanel.add(newsfeedButton);

                    //---- newChirpButton ----
                    newChirpButton.setText("New Chirp");
                    newChirpButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newChirpButton.setBackground(UIManager.getColor("Button.background"));
                    newChirpButton.setPreferredSize(new Dimension(104, 40));
                    newChirpButton.addActionListener(e -> newChirpButtonActionPerformed(e));
                    menuPanel.add(newChirpButton);

                    //---- postedChirpsButton ----
                    postedChirpsButton.setText("View Posted Chirps");
                    postedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    postedChirpsButton.setMaximumSize(new Dimension(164, 38));
                    postedChirpsButton.setPreferredSize(new Dimension(170, 40));
                    postedChirpsButton.setBackground(UIManager.getColor("Button.background"));
                    postedChirpsButton.addActionListener(e -> postedChirpsButtonActionPerformed(e));
                    menuPanel.add(postedChirpsButton);

                    //---- receivedChirpsButton ----
                    receivedChirpsButton.setText("View Recieved Chirps");
                    receivedChirpsButton.setPreferredSize(new Dimension(180, 40));
                    receivedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    receivedChirpsButton.setBackground(UIManager.getColor("Button.background"));
                    receivedChirpsButton.setMargin(new Insets(4, 14, 4, 14));
                    receivedChirpsButton.setHorizontalTextPosition(SwingConstants.LEFT);
                    receivedChirpsButton.addActionListener(e -> receivedChirpsButtonActionPerformed(e));
                    menuPanel.add(receivedChirpsButton);

                    //---- logoutButton ----
                    logoutButton.setText("Logout");
                    logoutButton.setPreferredSize(new Dimension(75, 40));
                    logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    logoutButton.setBackground(UIManager.getColor("Button.background"));
                    logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));
                    menuPanel.add(logoutButton);
                }
                panel1.add(menuPanel, BorderLayout.CENTER);

                //======== panel2 ========
                {
                    panel2.setPreferredSize(new Dimension(195, 150));
                    panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel2.setBackground(new Color(102, 255, 204));
                    panel2.setLayout(new GridLayout(3, 1, 0, 8));

                    //---- textField1 ----
                    textField1.setMargin(new Insets(5, 5, 5, 5));
                    textField1.setText("Enter search term here...");
                    textField1.setFont(new Font("Segoe UI", Font.ITALIC, 14));
                    panel2.add(textField1);

                    //---- searchProfilesButton ----
                    searchProfilesButton.setText("Search Profiles");
                    searchProfilesButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    searchProfilesButton.setBackground(UIManager.getColor("Button.background"));
                    searchProfilesButton.setPreferredSize(new Dimension(133, 40));
                    searchProfilesButton.addActionListener(e -> searchProfilesButtonActionPerformed(e));
                    panel2.add(searchProfilesButton);

                    //---- searchTopicsButton ----
                    searchTopicsButton.setText("Search Topics");
                    searchTopicsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    searchTopicsButton.setBackground(UIManager.getColor("Button.background"));
                    searchTopicsButton.setPreferredSize(new Dimension(125, 40));
                    searchTopicsButton.addActionListener(e -> searchTopicsButtonActionPerformed(e));
                    panel2.add(searchTopicsButton);
                }
                panel1.add(panel2, BorderLayout.PAGE_END);
            }
            splitPane1.add(panel1, BorderLayout.WEST);

            //======== scrollPane1 ========
            {

                //---- displayField ----
                displayField.setEditable(false);
                displayField.setText("Welcome!");
                displayField.setMargin(new Insets(15, 15, 15, 5));
                displayField.setFont(new Font("Monospaced", Font.PLAIN, 14));
                scrollPane1.setViewportView(displayField);
            }
            splitPane1.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(splitPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JLabel headerText;
    private JPanel splitPane1;
    private JPanel panel1;
    private JPanel menuPanel;
    private JButton bioButton;
    private JButton newsfeedButton;
    private JButton newChirpButton;
    private JButton postedChirpsButton;
    private JButton receivedChirpsButton;
    private JButton logoutButton;
    private JPanel panel2;
    private JTextField textField1;
    private JButton searchProfilesButton;
    private JButton searchTopicsButton;
    private JScrollPane scrollPane1;
    private JTextArea displayField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
    private Connection conn;
}
