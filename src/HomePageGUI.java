import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
        displayField.setVisible(true);
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void newChirpButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        headerText = new JTextField();
        splitPane1 = new JSplitPane();
        splitPane2 = new JSplitPane();
        splitPane3 = new JSplitPane();
        splitPane5 = new JSplitPane();
        bioButton = new JButton();
        newsfeedButton = new JButton();
        splitPane6 = new JSplitPane();
        newChirpButton = new JButton();
        splitPane9 = new JSplitPane();
        postedChirpsButton = new JButton();
        receivedChirpsButton = new JButton();
        splitPane4 = new JSplitPane();
        splitPane7 = new JSplitPane();
        sentChirpsButton = new JButton();
        searchProfilesButton = new JButton();
        splitPane8 = new JSplitPane();
        searchTopicsButton = new JButton();
        logoutButton = new JButton();
        scrollPane1 = new JScrollPane();
        displayField = new JTextArea();

        //======== this ========
        setResizeWeight(0.1);
        setOrientation(JSplitPane.VERTICAL_SPLIT);

        //---- headerText ----
        headerText.setText("Chirpy");
        headerText.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        headerText.setHorizontalAlignment(SwingConstants.CENTER);
        setTopComponent(headerText);

        //======== splitPane1 ========
        {
            splitPane1.setResizeWeight(0.2);

            //======== splitPane2 ========
            {
                splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
                splitPane2.setResizeWeight(0.5);

                //======== splitPane3 ========
                {
                    splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    splitPane3.setResizeWeight(0.55);

                    //======== splitPane5 ========
                    {
                        splitPane5.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane5.setResizeWeight(0.5);

                        //---- bioButton ----
                        bioButton.setText("Bio");
                        bioButton.addActionListener(e -> button1ActionPerformed(e));
                        splitPane5.setTopComponent(bioButton);

                        //---- newsfeedButton ----
                        newsfeedButton.setText("Newsfeed");
                        newsfeedButton.addActionListener(e -> button2ActionPerformed(e));
                        splitPane5.setBottomComponent(newsfeedButton);
                    }
                    splitPane3.setTopComponent(splitPane5);

                    //======== splitPane6 ========
                    {
                        splitPane6.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane6.setResizeWeight(0.3);

                        //---- newChirpButton ----
                        newChirpButton.setText("New Chirp");
                        newChirpButton.addActionListener(e -> button3ActionPerformed(e));
                        splitPane6.setTopComponent(newChirpButton);

                        //======== splitPane9 ========
                        {
                            splitPane9.setOrientation(JSplitPane.VERTICAL_SPLIT);
                            splitPane9.setResizeWeight(0.5);

                            //---- postedChirpsButton ----
                            postedChirpsButton.setText("Posted Chirps");
                            splitPane9.setTopComponent(postedChirpsButton);

                            //---- receivedChirpsButton ----
                            receivedChirpsButton.setText("Recieved Chirps");
                            splitPane9.setBottomComponent(receivedChirpsButton);
                        }
                        splitPane6.setBottomComponent(splitPane9);
                    }
                    splitPane3.setBottomComponent(splitPane6);
                }
                splitPane2.setTopComponent(splitPane3);

                //======== splitPane4 ========
                {
                    splitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);
                    splitPane4.setResizeWeight(0.5);

                    //======== splitPane7 ========
                    {
                        splitPane7.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane7.setResizeWeight(0.5);

                        //---- sentChirpsButton ----
                        sentChirpsButton.setText("Sent Chirps");
                        splitPane7.setTopComponent(sentChirpsButton);

                        //---- searchProfilesButton ----
                        searchProfilesButton.setText("Search Profiles");
                        splitPane7.setBottomComponent(searchProfilesButton);
                    }
                    splitPane4.setTopComponent(splitPane7);

                    //======== splitPane8 ========
                    {
                        splitPane8.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane8.setResizeWeight(0.5);

                        //---- searchTopicsButton ----
                        searchTopicsButton.setText("Search Topics");
                        splitPane8.setTopComponent(searchTopicsButton);

                        //---- logoutButton ----
                        logoutButton.setText("Logout");
                        splitPane8.setBottomComponent(logoutButton);
                    }
                    splitPane4.setBottomComponent(splitPane8);
                }
                splitPane2.setBottomComponent(splitPane4);
            }
            splitPane1.setLeftComponent(splitPane2);

            //======== scrollPane1 ========
            {

                //---- displayField ----
                displayField.setEditable(false);
                displayField.setText("hjgfkgf");
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
    private JSplitPane splitPane2;
    private JSplitPane splitPane3;
    private JSplitPane splitPane5;
    private JButton bioButton;
    private JButton newsfeedButton;
    private JSplitPane splitPane6;
    private JButton newChirpButton;
    private JSplitPane splitPane9;
    private JButton postedChirpsButton;
    private JButton receivedChirpsButton;
    private JSplitPane splitPane4;
    private JSplitPane splitPane7;
    private JButton sentChirpsButton;
    private JButton searchProfilesButton;
    private JSplitPane splitPane8;
    private JButton searchTopicsButton;
    private JButton logoutButton;
    private JScrollPane scrollPane1;
    private JTextArea displayField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
}
