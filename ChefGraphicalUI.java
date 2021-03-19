package presentationLayer;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * ChefGraphicalUI is the main entity we will be using to create an interface for the chef, to be noticed when a new
 * order has arrived.
 */
public class ChefGraphicalUI implements Observer {
    protected JFrame jFrame;

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(this.jFrame,"A new order has arrived!");
    }
}
