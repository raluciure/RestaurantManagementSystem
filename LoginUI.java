package presentationLayer;

import businessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginUI is the main entity we will be using to create a login interface to select our position: waiter or
 * administrator.
 */
public class LoginUI {
    private JFrame mainFrame;

    private JButton administatorBtn;
    private JButton waiterBtn;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel;

    private JLabel welcomeLabel;

    public LoginUI(final Restaurant restaurant){
        mainFrame=new JFrame("Restaurant");

        welcomeLabel=new JLabel("Welcome to the restaurant! Choose your position!");
        administatorBtn=new JButton("Administrator");
        waiterBtn=new JButton("Waiter");

        panel1=new JPanel();
        panel2=new JPanel();
        panel=new JPanel();

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(680,250);

        panel1.add(welcomeLabel);
        panel1.setLayout(new FlowLayout());

        panel2.add(administatorBtn);
        panel2.add(waiterBtn);
        panel2.setLayout(new FlowLayout());

        panel.add(panel1);
        panel.add(panel2);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel.setBackground(Color.lightGray);

        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);

        administatorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministratorGraphicalUI administratorGraphicalUI=new AdministratorGraphicalUI(restaurant);
            }
        });

        waiterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaiterGraphicalUI waiterGraphicalUI=new WaiterGraphicalUI(restaurant);
            }
        });
    }

}
