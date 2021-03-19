package presentationLayer;

import businessLayer.Order;
import businessLayer.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewOrder is the main entity we will be using to create an interface to show all the orders from the restarurant.
 */
public class ViewOrder {
    private JFrame mainFrame;

    private JTable table;
    private DefaultTableModel defaultTable;
    private JScrollPane scroll;

    private List<Order> orders;

    public ViewOrder(List<Order> orderList, Restaurant restaurant){
        this.orders=new ArrayList<>();
        this.orders=orderList;
        int s=orders.size(),k=0;
        if(s!=0){
            mainFrame=new JFrame("Order");
            scroll=new JScrollPane();

            Object rows[][] = new Object[s][3];
            Object cols[] = {"Price", "Date", "Table"};
            for(Order o:orders) {
                rows[k][0] = restaurant.computeOrderPrice(o.getTable()) + " RON";
                rows[k][1] = o.getDate();
                rows[k][2] = o.getTable();
                o.toString();
                k++;
            }
            defaultTable = new DefaultTableModel(rows, cols);
            table = new JTable(defaultTable);
            table.setEnabled(false);

            mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            mainFrame.setSize(680,300);

            scroll = new JScrollPane(table);

            mainFrame.add(scroll);
            mainFrame.setVisible(true);
        }
    }
}

