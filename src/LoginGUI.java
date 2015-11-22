import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Kenny Campbell, Catherine Merz, Hannah Morgan
 */
public class LoginGUI extends JFrame {
    public LoginGUI(){
        initComponents();
        setVisible(true);
    }

    /**
     *
     * @param e
     */
    private void LoginActionPerformed(ActionEvent e) {
        if (Username.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Must enter a username to login.");
            return;
        }
        homepage = new HomePageGUI();
        if (!homepage.createConnection(Username.getText(), new String(Password.getPassword()))) {
            handleConnectionError();
            homepage.dispose();
            return;
        }
        homepage.updateNewsfeed();
        homepage.setVisible(true);
    }

    /**
     *
     * @param e
     */
    private void RegisterActionPerformed(ActionEvent e) {
        if (Username.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Must enter a username to register.");
            return;
        }
        if (!createUser(Username.getText(), new String(Password.getPassword()))) {
            JOptionPane.showMessageDialog(this,"USER CREATION ERROR");
            //homepage.dispose();
            return;
        }
        homepage = new HomePageGUI();
        if (!homepage.createConnection(Username.getText(), new String(Password.getPassword()))) {
            handleConnectionError();
            homepage.dispose();
            return;
        }
        homepage.setVisible(true);
    }

    /**
     *
     * @param e
     */
    private void GuestLoginActionPerformed(ActionEvent e) {
        guestHomepage = new GuestHomeGUI();
        guestHomepage.updateNewsfeed();
        guestHomepage.setVisible(true);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean createUser(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection tempconn = null;
            tempconn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", "addUser", "admin123");
            System.out.println("Database Connected");

            Statement statement = tempconn.createStatement();
            statement.executeUpdate("CREATE USER '" + username + "'@'%' IDENTIFIED BY '" + password + "'");
            Statement statement1 = tempconn.createStatement();
            statement1.executeUpdate("GRANT CREATE, INSERT, SELECT, UPDATE, DELETE ON chirpy.* TO '" + username + "'@'%'");
            Statement statement2 = tempconn.createStatement();
            statement2.executeUpdate("CREATE TABLE " + username + "_subscribe(users VARCHAR(45) PRIMARY KEY)");
            String sql = "INSERT INTO users (username, bio)" + "VALUES (?, ?)";
            PreparedStatement statement3 = tempconn.prepareStatement(sql);
            statement3.setString(1, username);
            statement3.setString(2, "Hello World!");
            statement3.execute();
            tempconn.close();
            return true;
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
        catch (ClassNotFoundException ex1) {handleClassNotFoundException(ex1);}
        catch (InstantiationException ex2) {handleInstantiationException(ex2);}
        catch (IllegalAccessException ex3) {handleIllegalAccessException(ex3);}
        return false;
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
     * @param e
     */
    private void handleClassNotFoundException(ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "ClassNotFoundException: " + e.getMessage());
    }

    /**
     *
     * @param e
     */
    private void handleInstantiationException(InstantiationException e) {
        JOptionPane.showMessageDialog(this, "InstantiationException: " + e.getMessage());
    }

    /**
     *
     * @param e
     */
    private void handleIllegalAccessException(IllegalAccessException e) {
        JOptionPane.showMessageDialog(this, "IllegalAccessException: " + e.getMessage());
    }

    /**
     *
     */
    private void handleConnectionError() {
        JOptionPane.showMessageDialog(this, "CONNECTION ERROR");
    }

    /**
     *
     */
    private void initComponents() {
        panel1 = new JPanel();
        Username = new JTextField();
        Password = new JPasswordField();
        Title = new JLabel();
        Login = new JButton();
        Register = new JButton();
        GuestLogin = new JButton();
        UsernameTitle = new JLabel();
        PasswordTitle = new JLabel();

        //======== loginGUI ========
        {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(375, 400));
            setBackground(Color.white);
            setVisible(true);
            Container loginGUIContentPane = getContentPane();
            loginGUIContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setBackground(new Color(204, 255, 255));

                //---- Username ----
                Username.setBackground(Color.white);
                Username.setForeground(Color.black);

                //---- Password ----
                Password.setColumns(1);
                Password.setBackground(Color.white);
                Password.setForeground(Color.black);

                //---- Title ----
                Title.setText("Chirpy Login");
                Title.setFont(Title.getFont().deriveFont(Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 10f));
                Title.setHorizontalAlignment(SwingConstants.CENTER);
                Title.setBackground(Color.white);
                Title.setForeground(Color.black);
                Title.setOpaque(true);
                Title.setBorder(new MatteBorder(2, 2, 2, 2, Color.darkGray));
                Title.setPreferredSize(new Dimension(135, 50));

                //---- Login ----
                Login.setText("Login");
                Login.setBackground(Color.lightGray);
                Login.addActionListener(e -> LoginActionPerformed(e));

                //---- Register ----
                Register.setText("Register");
                Register.setBackground(Color.lightGray);
                Register.addActionListener(e -> RegisterActionPerformed(e));

                //---- GuestLogin ----
                GuestLogin.setText("Guest Login");
                GuestLogin.setBackground(Color.lightGray);
                GuestLogin.addActionListener(e -> GuestLoginActionPerformed(e));

                //---- UsernameTitle ----
                UsernameTitle.setText("Username");
                UsernameTitle.setForeground(Color.black);
                UsernameTitle.setBackground(Color.white);

                //---- PasswordTitle ----
                PasswordTitle.setText("Password");
                PasswordTitle.setForeground(Color.black);
                PasswordTitle.setBackground(Color.white);

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(Title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                .addComponent(Login, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Register, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Password, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PasswordTitle, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UsernameTitle, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 43, Short.MAX_VALUE)))
                            .addContainerGap())
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(GuestLogin, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Title, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                            .addComponent(UsernameTitle)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Username, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PasswordTitle)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Password, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Register)
                                .addComponent(Login))
                            .addGap(18, 18, 18)
                            .addComponent(GuestLogin)
                            .addGap(42, 42, 42))
                );
            }
            loginGUIContentPane.add(panel1, BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(getOwner());
        }
    }

    private GuestHomeGUI guestHomepage;
    private HomePageGUI homepage;
    private JPanel panel1;
    private JTextField Username;
    private JPasswordField Password;
    private JLabel Title;
    private JButton Login;
    private JButton Register;
    private JButton GuestLogin;
    private JLabel UsernameTitle;
    private JLabel PasswordTitle;
}
