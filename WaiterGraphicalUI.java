package presentationLayer;

import businessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * WaiterGraphicalUI is the main entity we will be using to create an interface for the waiter, containing all the
 * possible operations he can perform.
 */
public class WaiterGraphicalUI {
    private JFrame mainFrame;

    private JTextField table;
    private JLabel tableLabel;

    private JButton addOrderBtn;
    private JButton viewOrdersBtn;
    private JButton billBtn;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel;

    public WaiterGraphicalUI(final Restaurant restaurant) {
        mainFrame=new JFrame("Waiter");

        table=new JTextField(5);
        tableLabel=new JLabel("Introduce the table number to compute the bill:");

        addOrderBtn=new JButton("Add Order");
        viewOrdersBtn=new JButton("View Orders");
        billBtn=new JButton("Compute Bill");

        panel1=new JPanel();
        panel2=new JPanel();
        panel=new JPanel();

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(500,200);

        panel1.add(tableLabel);
        panel1.add(table);
        panel1.setLayout(new FlowLayout());

        panel2.add(addOrderBtn);
        panel2.add(viewOrdersBtn);
        panel2.add(billBtn);
        panel2.setLayout(new FlowLayout());

        panel.add(panel1);
        panel.add(panel2);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel.setBackground(Color.lightGray);

        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);

        addOrderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddOrderView addOrderView = new AddOrderView(restaurant);
            }
        });

        viewOrdersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewOrder viewOrder = new ViewOrder(restaurant.getOrders(), restaurant);
            }
        });

        billBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number=Integer.parseInt(table.getText());
                try {
                    restaurant.generateBill(number);
                } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
