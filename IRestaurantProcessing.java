package businessLayer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface IRestaurantProcessing {
    void createNewMenuItem(MenuItem menuItem)throws AssertionError;
    void deleteMenuItem(int menuItemID)throws AssertionError;
    void editMenuItem(int menuItemID, double price)throws AssertionError;
    void createNewOrder(Order order, ArrayList<MenuItem> menuItems) throws AssertionError;
    double computeOrderPrice(int orderID);
    void generateBill(int orderID) throws FileNotFoundException, UnsupportedEncodingException;
}
