package presentationLayer;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * AddOrderView is the main entity we will be using to create an interface for adding a new order in the restaurant.
 */
public class AddOrderView {

    public List<JCheckBox> checkBox;
    public Order order;
    public ArrayList<MenuItem> items;

    private JFrame mainFrame;
    private JTextField table;
    private JButton addBtn;
    private JLabel tableLabel;
    private JPanel panel1;
    private JPanel panel;

    public AddOrderView(final Restaurant restaurant) {
        checkBox = new ArrayList<>();
        order=new Order();
        items = new ArrayList<>();

        mainFrame=new JFrame("Order");

        addBtn=new JButton("Add");
        table=new JTextField(5);
        tableLabel=new JLabel("Table:");
        panel1 = new JPanel();
        panel = new JPanel();

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(500,300);

        panel.add(addBtn);

        mainFrame.add(panel1);
        mainFrame.add(panel);

        panel.add(tableLabel);
        panel.add(table);

        panel1.setBackground(Color.lightGray);
        panel.setBackground(Color.lightGray);

        for (MenuItem i : restaurant.getMenuItems()) {
            String string=String.valueOf(i.getName());
            JCheckBox box = new JCheckBox(string);
            panel1.add(box);
            checkBox.add(box);
        }
        mainFrame.setLayout(new GridLayout(2,2));
        mainFrame.setVisible(true);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number;
                number=Integer.parseInt(table.getText());
                for(JCheckBox b:checkBox){
                    if(b.isSelected()){
                        for(MenuItem i:restaurant.getMenuItems()){
                            if(i.getName().equals(b.getText())){
                                items.add(i);
                            }
                        }
                    }
                }
                order.setTable(number);
                for(MenuItem i:items){
                    i.setMenuItemID(number);
                }
                restaurant.createNewOrder(order,items);
            }
        });
    }
}
