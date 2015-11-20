import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Nov 04 19:43:27 EST 2015
 */



/**
 * @author James Campbell
 */
public class LoginGUI extends JFrame {
    public LoginGUI(){
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
        homepage.updateNewsfeed();
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
        guestHomepage = new GuestHomeGUI();
        guestHomepage.updateNewsfeed();
        guestHomepage.setVisible(true);
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

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - James Campbell
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
