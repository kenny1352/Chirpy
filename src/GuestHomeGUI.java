import java.awt.*;
import java.awt.event.*;
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
    }

    private void newsfeedButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void profileSearchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void topicSearchButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void logoutButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        panel3 = new JPanel();
        title = new JLabel();
        panel4 = new JPanel();
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
                panel4.setLayout(new BorderLayout());

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
                panel4.add(panel1, BorderLayout.WEST);

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setPreferredSize(new Dimension(0, 50));
                    textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                    textArea1.setMargin(new Insets(15, 15, 15, 5));
                    scrollPane1.setViewportView(textArea1);
                }
                panel4.add(scrollPane1, BorderLayout.CENTER);
            }
            panel3.add(panel4, BorderLayout.CENTER);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JPanel panel3;
    private JLabel title;
    private JPanel panel4;
    private JPanel panel1;
    private JButton newsfeedButton;
    private JButton profileSearchButton;
    private JButton topicSearchButton;
    private JButton logoutButton;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
