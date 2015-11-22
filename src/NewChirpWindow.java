import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;

/**
 * @author Catherine Merz, Kenny Campbell, Hannah Morgan
 */
public class NewChirpWindow extends JFrame {

    /**
     *
     * @param author
     * @param connection
     */
    public NewChirpWindow(User author, Connection connection) {
        initComponents();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMenuItem1);
        buttonGroup.add(radioButtonMenuItem2);
        authorUser = author;
        conn = connection;
    }

    /**
     *
     * @param e
     */
    private void cancelButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    /**
     *
     * @param e
     */
    private void okButtonActionPerformed(ActionEvent e) {
        if(textPane1.getText().length()<=140) {
            Message chirp = new Message(authorUser.getUsername(), textPane1.getText(), radioButtonMenuItem1.isSelected());
            //System.out.println(chirp.toString());
            // TODO add new Chirp to database
            try {
                String sql = "INSERT INTO messages (username, messageText, tags, recipient, timeStamp, publicSetting)" + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, chirp.getAuthor());
                statement.setString(2, chirp.getContent());
                statement.setString(3, chirp.getHashtag());
                statement.setString(4, chirp.getRecipient());
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(chirp.getTimestamp());
                statement.setString(5, date);
                statement.setInt(6, chirp.getPublicSetting());
                statement.executeUpdate();
            } catch (SQLException SQLex) {
                JOptionPane.showMessageDialog(this, "SQLException: " + SQLex.getMessage() +
                        "\nSQLState: " + SQLex.getSQLState() + "\nVendorError: " + SQLex.getErrorCode());
            }
            dispose();
        } else{
            setTitle("New Chirp - 140 char max");
        }
    }

    /**
     *
     */
    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        menu1 = new JMenuBar();
        radioButtonMenuItem1 = new JRadioButtonMenuItem();
        radioButtonMenuItem2 = new JRadioButtonMenuItem();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setTitle("New Chirp");
        setMinimumSize(new Dimension(200, 200));
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(102, 255, 204));
            dialogPane.setMinimumSize(new Dimension(300, 200));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(102, 255, 204));
                contentPanel.setLayout(new BorderLayout(5, 5));

                //======== scrollPane1 ========
                {
                    scrollPane1.setFont(new Font("Monospaced", Font.PLAIN, 14));
                    scrollPane1.setPreferredSize(new Dimension(50, 25));

                    //---- textPane1 ----
                    textPane1.setFont(new Font("Serif", Font.PLAIN, 16));
                    textPane1.setText("Write Chirp message here...");
                    textPane1.setPreferredSize(new Dimension(175, 50));
                    textPane1.setMinimumSize(new Dimension(57, 50));
                    textPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    scrollPane1.setViewportView(textPane1);
                }
                contentPanel.add(scrollPane1, BorderLayout.CENTER);

                //======== menu1 ========
                {
                    menu1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    menu1.setPreferredSize(new Dimension(306, 35));
                    menu1.setBackground(new Color(153, 204, 255));
                    menu1.setBorder(LineBorder.createBlackLineBorder());
                    menu1.setOpaque(true);
                    menu1.setInheritsPopupMenu(true);
                    menu1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                    //---- radioButtonMenuItem1 ----
                    radioButtonMenuItem1.setText("Post Publicly");
                    radioButtonMenuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    radioButtonMenuItem1.setFocusable(true);
                    radioButtonMenuItem1.setSelected(true);
                    radioButtonMenuItem1.setFocusPainted(true);
                    radioButtonMenuItem1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    menu1.add(radioButtonMenuItem1);

                    //---- radioButtonMenuItem2 ----
                    radioButtonMenuItem2.setText("Subscribers Only");
                    radioButtonMenuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    radioButtonMenuItem2.setFocusPainted(true);
                    radioButtonMenuItem2.setFocusable(true);
                    radioButtonMenuItem2.setRolloverEnabled(true);
                    radioButtonMenuItem2.setBorder(new EmptyBorder(5, 5, 5, 5));
                    menu1.add(radioButtonMenuItem2);
                }
                contentPanel.add(menu1, BorderLayout.SOUTH);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(102, 255, 204));
                buttonBar.setLayout(new GridLayout(1, 2, 10, 0));

                //---- okButton ----
                okButton.setText("Post New Chirp");
                okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                okButton.setBackground(new Color(238, 238, 238));
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton);

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                cancelButton.setBackground(new Color(238, 238, 238));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JMenuBar menu1;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private User authorUser;
    private Connection conn;
}
