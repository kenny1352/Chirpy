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
        // Generated using JFormDesigner Evaluation license - H Morgan
        formattedTextField1 = new JFormattedTextField();

        //======== this ========
        setTitle("Edit Bio");
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "15*(default, $lcgap)",
            "3*(default, $lgap), default"));
        contentPane.add(formattedTextField1, CC.xywh(1, 1, 29, 7));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - H Morgan
    private JFormattedTextField formattedTextField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
