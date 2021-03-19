package presentationLayer;

import businessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AdministratorGraphicalUI is the main entity we will be using to create an interface for the administrator, containing
 * all the possible operations he can perform.
 */
public class AdministratorGraphicalUI {

    private JFrame mainFrame;

    private JTextField id;
    private JTextField price;

    private JButton addMenuItemBtn;
    private JButton editMenuItemBtn;
    private JButton deleteMenuItemBtn;
    private JButton deleteMenuItemsBtn;
    private JButton viewAllBtn;

    private JLabel idLabel;
    private JLabel label;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel;

    public AdministratorGraphicalUI(Restaurant restaurant) {
        mainFrame=new JFrame("Administrator");
        id=new JTextField(5);

        addMenuItemBtn=new JButton("Add menu item");
        editMenuItemBtn=new JButton("Edit menu item");
        deleteMenuItemBtn=new JButton("Delete menu item");
        deleteMenuItemsBtn=new JButton("Delete all menu items");
        viewAllBtn=new JButton("View all menu items");

        idLabel=new JLabel("ID:");
        label=new JLabel("If you want to delete or edit an item, introduce its ID down below! ");

        panel1=new JPanel();
        panel2=new JPanel();
        panel4=new JPanel();
        panel=new JPanel();

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(680,250);

        panel1.add(idLabel);
        panel1.add(id);
        panel1.setLayout(new FlowLayout());

        panel2.add(label);
        panel2.setLayout(new FlowLayout());

        panel4.add(addMenuItemBtn);
        panel4.add(editMenuItemBtn);
        panel4.add(deleteMenuItemBtn);
        panel4.add(deleteMenuItemsBtn);
        panel4.add(viewAllBtn);
        panel4.setLayout(new FlowLayout());

        panel.add(panel2);
        panel.add(panel1);
        panel.add(panel4);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel4.setBackground(Color.lightGray);
        panel.setBackground(Color.lightGray);

        mainFrame.setContentPane(panel);
        mainFrame.setVisible(true);

        addMenuItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemView addItemView = new AddItemView();
            }
        });

        editMenuItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();
                int auxID;
                double auxPrice;
                auxID= Integer.parseInt(id.getText());
                auxPrice= Double.parseDouble(price.getText());
                restaurant.editMenuItem(auxID, auxPrice);
            }
        });

        deleteMenuItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();
                int auxID;
                auxID= Integer.parseInt(id.getText());
                restaurant.deleteMenuItem(auxID);
            }
        });

        deleteMenuItemsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();
                restaurant.deleteAll();
            }
        });

        viewAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant restaurant = new Restaurant();
                ViewMenu viewMenu = new ViewMenu(restaurant.getMenuItems());
            }
        });

    }

}
