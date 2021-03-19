package presentationLayer;

import businessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * ViewMenu is the main entity we will be using to create an interface which shows all the items from the menu.
 */
public class ViewMenu {
    private JFrame mainFrame;

    private JTable table;
    private DefaultTableModel defaultTable;
    private JScrollPane scroll;

    private List<MenuItem> items;

    public ViewMenu(List<MenuItem> itemsList) {
        this.items = itemsList;
        int k=0,s=itemsList.size();
        if (s != 0) {
            Object rows[][] = new Object[s][3];
            Object cols[] = {"ID", "Name", "Price"};

            mainFrame = new JFrame("Menu ");
            mainFrame.setSize(500, 500);
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            for (MenuItem i : itemsList) {
                rows[k][0] = i.getMenuItemID();
                rows[k][1] = i.getName();
                rows[k][2] = i.computePrice() + " RON";
                i.toString();
                k++;
            }

            scroll = new JScrollPane();
            defaultTable = new DefaultTableModel(rows, cols);
            table = new JTable(defaultTable);
            table.setEnabled(false);

            scroll = new JScrollPane(table);
            mainFrame.add(scroll);
        }
    }
}