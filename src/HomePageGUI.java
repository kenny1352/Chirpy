import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author Catherine Merz, Kenny Campbell, Hannah Morgan
 */
public class HomePageGUI extends JFrame {

    /**
     * Creates a new HomePageGUI object.
     */
    public HomePageGUI() {
        initComponents();
    }

    /**
     * Establishes a connection with the server.
     * @param username the username associated with the profile to be opened.
     * @param password the password associated with the profile to be opened.
     * @return a Boolean describing whether a connection was successfully established.
     */
    public boolean createConnection(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", username, password);
            System.out.println("Database Connected");
            user = new User(username, conn);
            return true;
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
        catch (ClassNotFoundException ex1) {handleClassNotFoundException(ex1);}
        catch (InstantiationException ex2) {handleInstantiationException(ex2);}
        catch (IllegalAccessException ex3) {handleIllegalAccessException(ex3);}
        return false;
    }

    /**
     * Downloads the user's Newsfeed Chirps and updates the GUI to display them.
     */
    public void updateNewsfeed() {
        headerText.setText(user.getUsername() + "'s Newsfeed");
        user.downloadNews(conn);
        displayField.setText(user.getNewsfeed());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    /**
     * Makes and displays an EditBioGUI object.
     * @param e user clicks on bioButton.
     */
    private void bioButtonActionPerformed(ActionEvent e) {
        new EditBioGUI(user, conn);
    }

    /**
     * Updates user's Newsfeed and refreshes GUI to display updated Newsfeed.
     * @param e user clicks on newsfeedButton.
     */
    private void newsfeedButtonActionPerformed(ActionEvent e) {
        updateNewsfeed();
    }

    /**
     * Makes and opens a NewChirpWindow object.
     * @param e user clicks on newChirpButton.
     */
    private void newChirpButtonActionPerformed(ActionEvent e) {
        new NewChirpWindow(user, conn);
    }

    /**
     * Updates GUI to display all Chirps authored by the user from most to least recent Chirp.
     * @param e user clicks on postedChirpsButton.
     */
    private void postedChirpsButtonActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername() + "'s Posted Chirps");
        user.downloadPosted(conn);
        displayField.setText(user.getPostedChirps());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    /**
     * Updates GUI to display all Chirps that have tagged the user as a recipient using the '@' in the content.
     * @param e user clicks on receivedChirpsButton.
     */
    private void receivedChirpsButtonActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername() + "'s Received Chirps");
        user.downloadreceivedChirps(conn);
        displayField.setText(user.getReceivedChirps());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    /**
     * In a new ViewProfile object, displays any profile whose username matches the String found in TextField1.
     * @param e user clicks on searchProfilesButton.
     */
    private void searchProfilesButtonActionPerformed(ActionEvent e) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username LIKE '" + textField1.getText() + "'");
            resultSet.next();
            User searchUser = new User(resultSet.getString("username"));
            searchUser.setBio(resultSet.getString("bio"));
            new ViewProfile(user, searchUser, conn);
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
    }

    /**
     * Updates GUI to display all Chirps that have been tagged using a # with the String found in TextField1.
     * @param e user clicks searchTopicsButton.
     */
    private void searchTopicsButtonActionPerformed(ActionEvent e) {
        String searchTopic = textField1.getText();
        headerText.setText("Newsfeed Chirps containing #"+searchTopic);
        user.downloadNews(conn);
        displayField.setText(user.searchNews(searchTopic));
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    /**
     * GUI updates to display a list of the profiles that the user has subscribed to.
     * @param e user clicks viewSubscriptionsButton.
     */
    private void viewSubscriptionsActionPerformed(ActionEvent e) {
        headerText.setText(user.getUsername()+"'s Subscriptions");
        displayField.setText(user.getSubscriptions());
        displayField.setSelectionStart(0);
        displayField.setSelectionEnd(0);
    }

    /**
     * GUI window closes.
     * @param e user clicks logoutButton.
     */
    private void logoutButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    /**
     * Displays popup window with error message.
     * @param e the SQLException thrown.
     */
    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(this, "SQLException: " + e.getMessage() +
                "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode());
    }

    /**
     * Displays popup window with error message.
     * @param e the ClassNotFoundException thrown.
     */
    private void handleClassNotFoundException(ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "ClassNotFoundException: " + e.getMessage());
    }

    /**
     * Displays popup window with error message.
     * @param e the InstantiationException thrown.
     */
    private void handleInstantiationException(InstantiationException e) {
        JOptionPane.showMessageDialog(this, "InstantiationException: " + e.getMessage());
    }

    /**
     * Displays popup window with error message.
     * @param e the IllegalAccessException thrown.
     */
    private void handleIllegalAccessException(IllegalAccessException e) {
        JOptionPane.showMessageDialog(this, "IllegalAccessException: " + e.getMessage());
    }

    /**
     * Makes the GUI.
     */
    private void initComponents() {
        headerText = new JLabel();
        splitPane1 = new JPanel();
        panel1 = new JPanel();
        menuPanel = new JPanel();
        bioButton = new JButton();
        newsfeedButton = new JButton();
        newChirpButton = new JButton();
        postedChirpsButton = new JButton();
        receivedChirpsButton = new JButton();
        viewSubscriptionsButton = new JButton();
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

                    //---- viewSubscriptionsButton ----
                    viewSubscriptionsButton.setText("View Subscriptions");
                    viewSubscriptionsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    viewSubscriptionsButton.addActionListener(e -> viewSubscriptionsActionPerformed(e));
                    menuPanel.add(viewSubscriptionsButton);

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
                scrollPane1.setBackground(new Color(102, 255, 204));
                scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

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
    }

    private JLabel headerText;
    private JPanel splitPane1;
    private JPanel panel1;
    private JPanel menuPanel;
    private JButton bioButton;
    private JButton newsfeedButton;
    private JButton newChirpButton;
    private JButton postedChirpsButton;
    private JButton receivedChirpsButton;
    private JButton viewSubscriptionsButton;
    private JButton logoutButton;
    private JPanel panel2;
    private JTextField textField1;
    private JButton searchProfilesButton;
    private JButton searchTopicsButton;
    private JScrollPane scrollPane1;
    private JTextArea displayField;
    private User user;
    private Connection conn;
}
