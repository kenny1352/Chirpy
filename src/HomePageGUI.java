import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.intellij.ide.ui.laf.darcula.ui.*;
//import com.intellij.uiDesigner.core.*;
//import info.clearthought.layout.*;
//import org.jdesktop.swingx.*;
/*
 * Created by JFormDesigner on Thu Nov 12 19:37:36 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class HomePageGUI extends JFrame {
    public HomePageGUI(User user) {
        initComponents();
        this.user = user;
        headerText.setText(user.getUsername()+"'s Newsfeed");
        setVisible(true);
    }

    private void bioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        headerText.setText(user.getUsername() + "'s Bio");
        displayField.setText(user.getBio());
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        headerText.setText(user.getUsername() + "'s Newsfeed");
    }

    private void newChirpButtonActionPerformed(ActionEvent e) {
        new NewChirpWindow(user);
    }

    private void postedChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        headerText.setText(user.getUsername() + "'s Posted Chirps");
    }

    private void receivedChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        headerText.setText(user.getUsername() + "'s Received Chirps");
    }

    private void sentChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        headerText.setText(user.getUsername() + "'s Sent Chirps");
    }

    private void searchProfilesButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchTopicsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        splitPane = new JSplitPane();
        headerText = new JTextField();
        splitPane1 = new JSplitPane();
        menuPanel = new JPanel();
        bioButton = new JButton();
        newsfeedButton = new JButton();
        newChirpButton = new JButton();
        postedChirpsButton = new JButton();
        receivedChirpsButton = new JButton();
        sentChirpsButton = new JButton();
        searchProfilesButton = new JButton();
        searchTopicsButton = new JButton();
        logoutButton = new JButton();
        scrollPane1 = new JScrollPane();
        displayField = new JTextArea();

        //======== this ========
        setTitle("Chirpy");
        setMinimumSize(new Dimension(300, 300));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== splitPane ========
        {
            splitPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
            splitPane.setBackground(Color.darkGray);
            splitPane.setForeground(Color.darkGray);
            splitPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
            splitPane.setContinuousLayout(true);

            //---- headerText ----
            headerText.setText("Chirpy");
            headerText.setFont(new Font("Segoe UI", Font.PLAIN, 22));
            headerText.setHorizontalAlignment(SwingConstants.CENTER);
            headerText.setBackground(Color.white);
            headerText.setEditable(false);
            headerText.setMargin(new Insets(20, 0, 20, 0));
            headerText.setPreferredSize(new Dimension(77, 45));
            splitPane.setTopComponent(headerText);

            //======== splitPane1 ========
            {
                splitPane1.setDividerLocation(185);
                splitPane1.setContinuousLayout(true);
                splitPane1.setDividerSize(1);

                //======== menuPanel ========
                {
                    menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    menuPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    menuPanel.setPreferredSize(new Dimension(180, 390));
                    menuPanel.setBackground(new Color(153, 204, 255));
                    menuPanel.setMinimumSize(new Dimension(180, 274));

                    // JFormDesigner evaluation mark
                    menuPanel.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), menuPanel.getBorder())); menuPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    menuPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)menuPanel.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)menuPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)menuPanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)menuPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- bioButton ----
                    bioButton.setText("Bio");
                    bioButton.setPreferredSize(new Dimension(50, 40));
                    bioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    bioButton.setBackground(new Color(204, 204, 204));
                    bioButton.addActionListener(e -> bioButtonActionPerformed(e));
                    menuPanel.add(bioButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- newsfeedButton ----
                    newsfeedButton.setText("Newsfeed");
                    newsfeedButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newsfeedButton.setBackground(new Color(204, 204, 204));
                    newsfeedButton.setPreferredSize(new Dimension(99, 40));
                    newsfeedButton.addActionListener(e -> newsfeedButtonActionPerformed(e));
                    menuPanel.add(newsfeedButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- newChirpButton ----
                    newChirpButton.setText("New Chirp");
                    newChirpButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    newChirpButton.setBackground(new Color(204, 204, 204));
                    newChirpButton.setPreferredSize(new Dimension(104, 40));
                    newChirpButton.addActionListener(e -> newChirpButtonActionPerformed(e));
                    menuPanel.add(newChirpButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- postedChirpsButton ----
                    postedChirpsButton.setText("View Posted Chirps");
                    postedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    postedChirpsButton.setMaximumSize(new Dimension(164, 38));
                    postedChirpsButton.setPreferredSize(new Dimension(170, 40));
                    postedChirpsButton.setBackground(new Color(204, 204, 204));
                    postedChirpsButton.addActionListener(e -> postedChirpsButtonActionPerformed(e));
                    menuPanel.add(postedChirpsButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- receivedChirpsButton ----
                    receivedChirpsButton.setText("View Recieved Chirps");
                    receivedChirpsButton.setPreferredSize(new Dimension(180, 40));
                    receivedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    receivedChirpsButton.setBackground(new Color(204, 204, 204));
                    receivedChirpsButton.setMargin(new Insets(4, 14, 4, 14));
                    receivedChirpsButton.setHorizontalTextPosition(SwingConstants.LEFT);
                    receivedChirpsButton.addActionListener(e -> receivedChirpsButtonActionPerformed(e));
                    menuPanel.add(receivedChirpsButton, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- sentChirpsButton ----
                    sentChirpsButton.setText("View Sent Chirps");
                    sentChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    sentChirpsButton.setBackground(new Color(204, 204, 204));
                    sentChirpsButton.setPreferredSize(new Dimension(148, 40));
                    sentChirpsButton.addActionListener(e -> sentChirpsButtonActionPerformed(e));
                    menuPanel.add(sentChirpsButton, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- searchProfilesButton ----
                    searchProfilesButton.setText("Search Profiles");
                    searchProfilesButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    searchProfilesButton.setBackground(new Color(204, 204, 204));
                    searchProfilesButton.setPreferredSize(new Dimension(133, 40));
                    searchProfilesButton.addActionListener(e -> searchProfilesButtonActionPerformed(e));
                    menuPanel.add(searchProfilesButton, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- searchTopicsButton ----
                    searchTopicsButton.setText("Search Topics");
                    searchTopicsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    searchTopicsButton.setBackground(new Color(204, 204, 204));
                    searchTopicsButton.setPreferredSize(new Dimension(125, 40));
                    searchTopicsButton.addActionListener(e -> searchTopicsButtonActionPerformed(e));
                    menuPanel.add(searchTopicsButton, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- logoutButton ----
                    logoutButton.setText("Logout");
                    logoutButton.setPreferredSize(new Dimension(75, 40));
                    logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    logoutButton.setBackground(new Color(204, 204, 204));
                    logoutButton.addActionListener(e -> logoutButtonActionPerformed(e));
                    menuPanel.add(logoutButton, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                splitPane1.setLeftComponent(menuPanel);

                //======== scrollPane1 ========
                {

                    //---- displayField ----
                    displayField.setEditable(false);
                    displayField.setText("hjgfkgf");
                    displayField.setMargin(new Insets(15, 15, 15, 5));
                    displayField.setFont(new Font("Monospaced", Font.PLAIN, 14));
                    scrollPane1.setViewportView(displayField);
                }
                splitPane1.setRightComponent(scrollPane1);
            }
            splitPane.setBottomComponent(splitPane1);
        }
        contentPane.add(splitPane);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JSplitPane splitPane;
    private JTextField headerText;
    private JSplitPane splitPane1;
    private JPanel menuPanel;
    private JButton bioButton;
    private JButton newsfeedButton;
    private JButton newChirpButton;
    private JButton postedChirpsButton;
    private JButton receivedChirpsButton;
    private JButton sentChirpsButton;
    private JButton searchProfilesButton;
    private JButton searchTopicsButton;
    private JButton logoutButton;
    private JScrollPane scrollPane1;
    private JTextArea displayField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
}
