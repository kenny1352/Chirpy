import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Nov 15 18:47:33 EST 2015
 */



/**
 * @author Catherine Merz
 */
public class ViewProfile extends JFrame {
    public ViewProfile(User user, User profileSearched, Boolean guestUser/*, ArrayList<String> subscriptions*/) {
        initComponents();
        this.user=user;
        this.profileSearched = profileSearched;
        label1.setText(profileSearched + "'s Chirps");
        if (guestUser) {
            //buttonBar.setVisible(false);
            subscribeButton.setVisible(false);
        }
        else if (user.isSubscribedTo(profileSearched.getUsername())){
            subscribeButton.setText("Unsubscribe");
        }
        // TODO set up Newsfeed
        //draw user info about posted messages from database
        //profileSearched.downloadPosted(conn); -- borrowed from the HomePageGUI code for newsfeed
        //textArea1.setText(profileSearched.getPostedChirps());
    }

    private void viewBioButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        //textArea1.setText(profileSearched.getBio());
    }

    private void subscribeButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (subscribeButton.getText()=="Unsubscribe"){
            user.unsubscribe(profileSearched.getUsername());
        }
        else if (subscribeButton.getText()=="Subscribe"){
            user.newSubscrip(profileSearched.getUsername());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        label1 = new JLabel();
        panel1 = new JPanel();
        buttonBar = new JPanel();
        viewBioButton = new JButton();
        subscribeButton = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setVisible(true);
        setMinimumSize(new Dimension(650, 600));
        setTitle("Chirpy");
        setBackground(new Color(102, 255, 204));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("[Username]'s Chirps");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(new Color(204, 255, 255));
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(106, 50));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 255, 204));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBackground(new Color(102, 255, 204));
                buttonBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                buttonBar.setBorder(new EmptyBorder(5, 5, 5, 5));
                buttonBar.setLayout(new GridLayout(1, 2, 10, 10));

                //---- viewBioButton ----
                viewBioButton.setText("View Bio");
                viewBioButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                viewBioButton.addActionListener(e -> viewBioButtonActionPerformed(e));
                buttonBar.add(viewBioButton);

                //---- subscribeButton ----
                subscribeButton.setText("Subscribe");
                subscribeButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                subscribeButton.addActionListener(e -> subscribeButtonActionPerformed(e));
                buttonBar.add(subscribeButton);
            }
            panel1.add(buttonBar, BorderLayout.NORTH);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                textArea1.setMargin(new Insets(15, 15, 15, 5));
                textArea1.setText("fjsvhkdnkdvnjkbjskbnv");
                scrollPane1.setViewportView(textArea1);
            }
            panel1.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JLabel label1;
    private JPanel panel1;
    private JPanel buttonBar;
    private JButton viewBioButton;
    private JButton subscribeButton;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
    private User profileSearched;
}
