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
    public HomePageGUI() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //scrollPane1;
        textField2.setVisible(true);
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
        textField1 = new JTextField();
        splitPane1 = new JSplitPane();
        splitPane2 = new JSplitPane();
        splitPane3 = new JSplitPane();
        splitPane5 = new JSplitPane();
        button1 = new JButton();
        button2 = new JButton();
        splitPane6 = new JSplitPane();
        button3 = new JButton();
        splitPane9 = new JSplitPane();
        button4 = new JButton();
        button5 = new JButton();
        splitPane4 = new JSplitPane();
        splitPane7 = new JSplitPane();
        button6 = new JButton();
        button7 = new JButton();
        splitPane8 = new JSplitPane();
        button8 = new JButton();
        button9 = new JButton();
        scrollPane1 = new JScrollPane();
        textField2 = new JTextField();

        //======== this ========
        setResizeWeight(0.1);
        setOrientation(JSplitPane.VERTICAL_SPLIT);

        //---- textField1 ----
        textField1.setText("Chirpy");
        textField1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        setTopComponent(textField1);

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

                        //---- button1 ----
                        button1.setText("Bio");
                        button1.addActionListener(e -> button1ActionPerformed(e));
                        splitPane5.setTopComponent(button1);

                        //---- button2 ----
                        button2.setText("Newsfeed");
                        button2.addActionListener(e -> button2ActionPerformed(e));
                        splitPane5.setBottomComponent(button2);
                    }
                    splitPane3.setTopComponent(splitPane5);

                    //======== splitPane6 ========
                    {
                        splitPane6.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane6.setResizeWeight(0.3);

                        //---- button3 ----
                        button3.setText("New Chirp");
                        button3.addActionListener(e -> button3ActionPerformed(e));
                        splitPane6.setTopComponent(button3);

                        //======== splitPane9 ========
                        {
                            splitPane9.setOrientation(JSplitPane.VERTICAL_SPLIT);
                            splitPane9.setResizeWeight(0.5);

                            //---- button4 ----
                            button4.setText("Posted Chirps");
                            splitPane9.setTopComponent(button4);

                            //---- button5 ----
                            button5.setText("Recieved Chirps");
                            splitPane9.setBottomComponent(button5);
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

                        //---- button6 ----
                        button6.setText("Sent Chirps");
                        splitPane7.setTopComponent(button6);

                        //---- button7 ----
                        button7.setText("Search Profiles");
                        splitPane7.setBottomComponent(button7);
                    }
                    splitPane4.setTopComponent(splitPane7);

                    //======== splitPane8 ========
                    {
                        splitPane8.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane8.setResizeWeight(0.5);

                        //---- button8 ----
                        button8.setText("Search Topics");
                        splitPane8.setTopComponent(button8);

                        //---- button9 ----
                        button9.setText("Logout");
                        splitPane8.setBottomComponent(button9);
                    }
                    splitPane4.setBottomComponent(splitPane8);
                }
                splitPane2.setBottomComponent(splitPane4);
            }
            splitPane1.setLeftComponent(splitPane2);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textField2);
            }
            splitPane1.setRightComponent(scrollPane1);
        }
        setBottomComponent(splitPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Catherine Merz
    private JTextField textField1;
    private JSplitPane splitPane1;
    private JSplitPane splitPane2;
    private JSplitPane splitPane3;
    private JSplitPane splitPane5;
    private JButton button1;
    private JButton button2;
    private JSplitPane splitPane6;
    private JButton button3;
    private JSplitPane splitPane9;
    private JButton button4;
    private JButton button5;
    private JSplitPane splitPane4;
    private JSplitPane splitPane7;
    private JButton button6;
    private JButton button7;
    private JSplitPane splitPane8;
    private JButton button8;
    private JButton button9;
    private JScrollPane scrollPane1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
