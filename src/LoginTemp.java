import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kenny on 11/12/2015.
 */
public class LoginTemp extends JFrame {
    public LoginTemp() {
        initComponents();
        setVisible(true);
    }

    private void LoginActionPerformed(ActionEvent e) {
        homepage = new HomePageGUI();
        if (!homepage.createConnection(Username.getText(), new String(Password.getPassword()))) {
            System.out.println("CONNECTION ERROR");
            homepage.dispose();
            return;
        }
        homepage.setVisible(true);
    }

    private void RegisterActionPerformed(ActionEvent e) {
        homepage = new HomePageGUI();
        if (!createUser(Username.getText(), new String(Password.getPassword()))) {
            System.out.println("USER CREATION ERROR");
            homepage.dispose();
            return;
        }
        if (!homepage.createConnection(Username.getText(), new String(Password.getPassword()))) {
            System.out.println("CONNECTION ERROR");
            homepage.dispose();
            return;
        }
        homepage.setVisible(true);
    }

    private void GuestLoginActionPerformed(ActionEvent e) {
        homepage = new HomePageGUI();
        if (homepage.createConnection("Guest", "Guest")) {
            System.out.println("CONNECTION ERROR");
            homepage.dispose();
            return;
        }
        homepage.setVisible(true);
    }

    public boolean createUser(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection tempconn = null;
            tempconn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", "addUser", "admin123");
            System.out.println("Database Connected");

            Statement statement = tempconn.createStatement();
            statement.executeUpdate("CREATE USER '" + username + "'@'%' IDENTIFIED BY '" + password + "'");
            Statement statement1 = tempconn.createStatement();
            statement1.executeUpdate("GRANT CREATE, INSERT, SELECT ON chirpy.* TO '" + username + "'@'%'");
            tempconn.close();
            return true;
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
        return false;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - James Campbell
        Username = new JTextField();
        Password = new JPasswordField();
        Title = new JLabel();
        Login = new JButton();
        Register = new JButton();
        GuestLogin = new JButton();
        UsernameTitle = new JLabel();
        PasswordTitle = new JLabel();

        //======== LoginGUI ========
        {
            setBackground(Color.white);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container LoginGUIContentPane = getContentPane();

            //---- Username ----
            Username.setBackground(Color.cyan);
            Username.setForeground(Color.black);

            //---- Password ----
            Password.setColumns(1);
            Password.setBackground(Color.cyan);
            Password.setForeground(Color.black);

            //---- Title ----
            Title.setText("Chirpy Login");
            Title.setFont(Title.getFont().deriveFont(Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 10f));
            Title.setHorizontalAlignment(SwingConstants.CENTER);
            Title.setBackground(Color.cyan);
            Title.setForeground(Color.black);

            //---- Login ----
            Login.setText("Login");
            Login.setBackground(Color.cyan);
            Login.addActionListener(e -> LoginActionPerformed(e));

            //---- Register ----
            Register.setText("Register");
            Register.setBackground(Color.cyan);
            Register.addActionListener(e -> RegisterActionPerformed(e));

            //---- GuestLogin ----
            GuestLogin.setText("Guest Login");
            GuestLogin.setBackground(Color.cyan);
            GuestLogin.addActionListener(e -> GuestLoginActionPerformed(e));

            //---- UsernameTitle ----
            UsernameTitle.setText("Username");
            UsernameTitle.setForeground(Color.black);
            UsernameTitle.setBackground(Color.white);

            //---- PasswordTitle ----
            PasswordTitle.setText("Password");
            PasswordTitle.setForeground(Color.black);
            PasswordTitle.setBackground(Color.white);

            GroupLayout LoginGUIContentPaneLayout = new GroupLayout(LoginGUIContentPane);
            LoginGUIContentPane.setLayout(LoginGUIContentPaneLayout);
            LoginGUIContentPaneLayout.setHorizontalGroup(
                    LoginGUIContentPaneLayout.createParallelGroup()
                            .addGroup(LoginGUIContentPaneLayout.createSequentialGroup()
                                    .addGroup(LoginGUIContentPaneLayout.createParallelGroup()
                                            .addGroup(LoginGUIContentPaneLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(Title, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                                            .addGroup(LoginGUIContentPaneLayout.createSequentialGroup()
                                                    .addGap(50, 50, 50)
                                                    .addGroup(LoginGUIContentPaneLayout.createParallelGroup()
                                                            .addGroup(LoginGUIContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                    .addGroup(GroupLayout.Alignment.TRAILING, LoginGUIContentPaneLayout.createSequentialGroup()
                                                                            .addComponent(Login, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(Register, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(Password, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(Username, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(UsernameTitle, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(PasswordTitle, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 43, Short.MAX_VALUE)))
                                    .addContainerGap())
                            .addGroup(LoginGUIContentPaneLayout.createSequentialGroup()
                                    .addGap(122, 122, 122)
                                    .addComponent(GuestLogin, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(122, Short.MAX_VALUE))
            );
            LoginGUIContentPaneLayout.setVerticalGroup(
                    LoginGUIContentPaneLayout.createParallelGroup()
                            .addGroup(LoginGUIContentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(Title, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(UsernameTitle)
                                    .addGap(2, 2, 2)
                                    .addComponent(Username, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                    .addComponent(PasswordTitle)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Password, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(LoginGUIContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(Register)
                                            .addComponent(Login))
                                    .addGap(18, 18, 18)
                                    .addComponent(GuestLogin)
                                    .addGap(42, 42, 42))
            );
            pack();
            setLocationRelativeTo(getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - James Campbell
    private HomePageGUI homepage;
    private JTextField Username;
    private JPasswordField Password;
    private JLabel Title;
    private JButton Login;
    private JButton Register;
    private JButton GuestLogin;
    private JLabel UsernameTitle;
    private JLabel PasswordTitle;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
