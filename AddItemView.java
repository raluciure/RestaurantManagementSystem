package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.Restaurant;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * AddItemView is the main entity we will be using to create an interface for adding a new item in the menu.
 */
public class AddItemView {
    private Restaurant restaurant;
    public ArrayList<MenuItem> items;
    public BaseProduct baseProduct;

    private JFrame mainFrame;

    private JTextField id;
    private JTextField name;
    private JTextField price;

    private JButton addBtn;

    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel priceLabel;

    private JPanel panel1;
    private JPanel panel0;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel;

    public AddItemView() {
        mainFrame=new JFrame("Menu Item");

        id=new JTextField(5);
        name=new JTextField(20);
        price=new JTextField(20);

        addBtn=new JButton("Add Item");

        idLabel=new JLabel("Id:");
        nameLabel=new JLabel("Name:");
        priceLabel=new JLabel("Price:");

        panel0=new JPanel();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel=new JPanel();

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(500,300);

        panel0.add(idLabel);
        panel0.add(id);
        panel0.setLayout(new FlowLayout());

        panel1.add(nameLabel);
        panel1.add(name);
        panel1.setLayout(new FlowLayout());

        panel2.add(priceLabel);
        panel2.add(price);
        panel2.setLayout(new FlowLayout());

        panel3.add(addBtn);
        panel3.setLayout(new FlowLayout());

        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel0.setBackground(Color.lightGray);
        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel3.setBackground(Color.lightGray);
        panel4.setBackground(Color.lightGray);
        panel.setBackground(Color.lightGray);

        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);

        items = new ArrayList<>();
        restaurant = new Restaurant();

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int auxID;
                double auxPrice;
                String auxName;

                auxPrice= Double.parseDouble(price.getText());
                auxName = name.getText();
                auxID=Integer.parseInt(id.getText());

                baseProduct = new BaseProduct(auxID,auxName,auxPrice);
                restaurant.createNewMenuItem(baseProduct);
                items.add(baseProduct);
            }
        });

    }
}
