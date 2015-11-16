import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Sun Nov 15 18:10:58 EST 2015
 */



/**
 * @author H Morgan
 */
public class EditBio extends JFrame {
    public EditBio() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Catherine Merz
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Edit Bio");
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "14*(default, $lcgap), default",
            "4*(default, $lgap), default"));

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setText("Write new bio here...");
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, CC.xywh(1, 1, 29, 7));

        //---- button1 ----
        button1.setText("Save");
        contentPane.add(button1, CC.xywh(3, 9, 9, 1));

        //---- button2 ----
        button2.setText("Cancel");
        contentPane.add(button2, CC.xywh(19, 9, 9, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
