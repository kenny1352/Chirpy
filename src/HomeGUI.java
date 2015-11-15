import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Hannah on 11/12/2015.
 */
public class HomeGUI extends JFrame {
    public HomeGUI() {
        initComponents();
        setVisible(false);
    }

    public boolean createConnection(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://73.31.78.202:3306/chirpy", username, password);
            System.out.println("Database Connected");
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

    private void BioActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void NewPostActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void PostedChirpsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void NewsfeedActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ReceivedChirpsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SentChirpsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SearchProfilesActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SearchTopicsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LogoutActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - James Campbell
        //UserGUI = new JFrame()
        label1 = new JLabel();
        Bio = new JButton();
        NewPost = new JButton();
        PostedChirps = new JButton();
        Newsfeed = new JButton();
        ReceivedChirps = new JButton();
        SentChirps = new JButton();
        SearchProfiles = new JButton();
        SearchTopics = new JButton();
        Logout = new JButton();
        Chirp1 = new JTextPane();
        Chirp2 = new JTextPane();
        Chirp3 = new JTextPane();
        Chirp4 = new JTextPane();
        Chirp5 = new JTextPane();

        //======== UserGUI ========
        {
            setBackground(Color.black);
            Container UserGUIContentPane = getContentPane();

            //---- label1 ----
            label1.setText("Chirpy");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 30f));
            label1.setBackground(Color.white);
            label1.setForeground(Color.black);

            //---- Bio ----
            Bio.setText("Bio");
            Bio.setBackground(Color.white);
            Bio.addActionListener(e -> BioActionPerformed(e));

            //---- NewPost ----
            NewPost.setText("New Post");
            NewPost.setBackground(Color.white);
            NewPost.addActionListener(e -> NewPostActionPerformed(e));

            //---- PostedChirps ----
            PostedChirps.setText("Posted Chirps");
            PostedChirps.setBackground(Color.white);
            PostedChirps.addActionListener(e -> PostedChirpsActionPerformed(e));

            //---- Newsfeed ----
            Newsfeed.setText("Newsfeed");
            Newsfeed.setBackground(Color.white);
            Newsfeed.addActionListener(e -> NewsfeedActionPerformed(e));

            //---- ReceivedChirps ----
            ReceivedChirps.setText("Received Chirps");
            ReceivedChirps.setBackground(Color.white);
            ReceivedChirps.addActionListener(e -> ReceivedChirpsActionPerformed(e));

            //---- SentChirps ----
            SentChirps.setText("Sent Chirps");
            SentChirps.setBackground(Color.white);
            SentChirps.addActionListener(e -> SentChirpsActionPerformed(e));

            //---- SearchProfiles ----
            SearchProfiles.setText("Search Profiles");
            SearchProfiles.setBackground(Color.white);
            SearchProfiles.addActionListener(e -> SearchProfilesActionPerformed(e));

            //---- SearchTopics ----
            SearchTopics.setText("Search Topics");
            SearchTopics.setBackground(Color.white);
            SearchTopics.addActionListener(e -> SearchTopicsActionPerformed(e));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.setBackground(Color.white);
            Logout.addActionListener(e -> LogoutActionPerformed(e));

            //---- Chirp1 ----
            Chirp1.setText("TEST");
            Chirp1.setEditable(false);
            Chirp1.setForeground(Color.black);
            Chirp1.setBackground(Color.white);

            //---- Chirp2 ----
            Chirp2.setText("TEST");
            Chirp2.setEditable(false);
            Chirp2.setForeground(Color.black);
            Chirp2.setBackground(Color.white);

            //---- Chirp3 ----
            Chirp3.setText("TEST");
            Chirp3.setForeground(Color.black);
            Chirp3.setBackground(Color.white);

            //---- Chirp4 ----
            Chirp4.setText("TEST");
            Chirp4.setForeground(Color.black);
            Chirp4.setBackground(Color.white);

            //---- Chirp5 ----
            Chirp5.setText("TEST");
            Chirp5.setBackground(Color.white);
            Chirp5.setForeground(Color.black);

            GroupLayout UserGUIContentPaneLayout = new GroupLayout(UserGUIContentPane);
            UserGUIContentPane.setLayout(UserGUIContentPaneLayout);
            UserGUIContentPaneLayout.setHorizontalGroup(
                    UserGUIContentPaneLayout.createParallelGroup()
                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                                                            .addComponent(Bio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(NewPost, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(PostedChirps, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(Chirp1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(0, 259, Short.MAX_VALUE)))
                                                    .addContainerGap())
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                                            .addComponent(Newsfeed, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(ReceivedChirps, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(SearchProfiles, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(SentChirps, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(SearchTopics, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Logout, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                                            .addComponent(Chirp2, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Chirp3, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Chirp4, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Chirp5, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)))))
            );
            UserGUIContentPaneLayout.setVerticalGroup(
                    UserGUIContentPaneLayout.createParallelGroup()
                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addComponent(Bio)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(NewPost)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(PostedChirps))
                                            .addComponent(Chirp1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addComponent(Newsfeed)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(ReceivedChirps)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(SentChirps))
                                            .addComponent(Chirp2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(UserGUIContentPaneLayout.createParallelGroup()
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addComponent(Chirp3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(Chirp4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(Chirp5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(UserGUIContentPaneLayout.createSequentialGroup()
                                                    .addComponent(SearchProfiles)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(SearchTopics)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(Logout)))
                                    .addContainerGap(35, Short.MAX_VALUE))
            );
            pack();
            setLocationRelativeTo(getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - James Campbell
    //private JFrame UserGUI;
    private Connection conn;
    private JLabel label1;
    private JButton Bio;
    private JButton NewPost;
    private JButton PostedChirps;
    private JButton Newsfeed;
    private JButton ReceivedChirps;
    private JButton SentChirps;
    private JButton SearchProfiles;
    private JButton SearchTopics;
    private JButton Logout;
    private JTextPane Chirp1;
    private JTextPane Chirp2;
    private JTextPane Chirp3;
    private JTextPane Chirp4;
    private JTextPane Chirp5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
