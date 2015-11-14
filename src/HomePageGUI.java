import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.intellij.uiDesigner.core.*;
//import info.clearthought.layout.*;
//import org.jdesktop.swingx.*;
/*
 * Created by JFormDesigner on Thu Nov 12 19:37:36 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class HomePageGUI extends JSplitPane {
    public HomePageGUI(User user) {
        this.user = user;
        initComponents();
    }

    private void bioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        displayField.setText(user.getBio());
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void newChirpButtonActionPerformed(ActionEvent e) {
        new NewChirpWindow(user);
    }

    private void postedChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void receivedChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void sentChirpsButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setBackground(Color.darkGray);
        setForeground(Color.darkGray);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setOrientation(JSplitPane.VERTICAL_SPLIT);
        setContinuousLayout(true);

        //---- headerText ----
        headerText.setText("Chirpy");
        headerText.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        headerText.setHorizontalAlignment(SwingConstants.CENTER);
        headerText.setBackground(new Color(204, 255, 255));
        setTopComponent(headerText);

        //======== splitPane1 ========
        {
            splitPane1.setDividerLocation(180);
            splitPane1.setContinuousLayout(true);
            splitPane1.setDividerSize(1);

            //======== menuPanel ========
            {
                menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                menuPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                menuPanel.setPreferredSize(new Dimension(180, 390));
                menuPanel.setBackground(new Color(153, 204, 255));

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
                bioButton.setBackground(new Color(153, 204, 255));
                bioButton.addActionListener(e -> bioButtonActionPerformed(e));
                menuPanel.add(bioButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- newsfeedButton ----
                newsfeedButton.setText("Newsfeed");
                newsfeedButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                newsfeedButton.setBackground(new Color(153, 204, 255));
                newsfeedButton.addActionListener(e -> newsfeedButtonActionPerformed(e));
                menuPanel.add(newsfeedButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- newChirpButton ----
                newChirpButton.setText("New Chirp");
                newChirpButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                newChirpButton.setBackground(new Color(153, 204, 255));
                newChirpButton.addActionListener(e -> newChirpButtonActionPerformed(e));
                menuPanel.add(newChirpButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- postedChirpsButton ----
                postedChirpsButton.setText("View Posted Chirps");
                postedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                postedChirpsButton.setMaximumSize(new Dimension(164, 38));
                postedChirpsButton.setPreferredSize(new Dimension(170, 38));
                postedChirpsButton.setBackground(new Color(153, 204, 255));
                postedChirpsButton.addActionListener(e -> postedChirpsButtonActionPerformed(e));
                menuPanel.add(postedChirpsButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- receivedChirpsButton ----
                receivedChirpsButton.setText("View Recieved Chirps");
                receivedChirpsButton.setPreferredSize(new Dimension(180, 32));
                receivedChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                receivedChirpsButton.setBackground(new Color(153, 204, 255));
                receivedChirpsButton.addActionListener(e -> receivedChirpsButtonActionPerformed(e));
                menuPanel.add(receivedChirpsButton, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- sentChirpsButton ----
                sentChirpsButton.setText("View Sent Chirps");
                sentChirpsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                sentChirpsButton.setBackground(new Color(153, 204, 255));
                sentChirpsButton.addActionListener(e -> sentChirpsButtonActionPerformed(e));
                menuPanel.add(sentChirpsButton, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- searchProfilesButton ----
                searchProfilesButton.setText("Search Profiles");
                searchProfilesButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                searchProfilesButton.setBackground(new Color(153, 204, 255));
                searchProfilesButton.addActionListener(e -> searchProfilesButtonActionPerformed(e));
                menuPanel.add(searchProfilesButton, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- searchTopicsButton ----
                searchTopicsButton.setText("Search Topics");
                searchTopicsButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                searchTopicsButton.setBackground(new Color(153, 204, 255));
                searchTopicsButton.addActionListener(e -> searchTopicsButtonActionPerformed(e));
                menuPanel.add(searchTopicsButton, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- logoutButton ----
                logoutButton.setText("Logout");
                logoutButton.setPreferredSize(new Dimension(75, 32));
                logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                logoutButton.setBackground(new Color(153, 204, 255));
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
        setBottomComponent(splitPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
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
