package businessLayer;

import dataLayer.RestaurantSerializator;

import java.io.*;
import java.util.*;

/**
 * Restaurant is the main entity we will be using to perform all the operations done in a restaurant, either done by
 * the administrator or the waiter.
 */
public class Restaurant extends Observable implements IRestaurantProcessing, Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    public Observer observer=null;
    public RestaurantSerializator restaurantSer;
    public HashMap<Order, Collection<MenuItem>> orders;
    public HashSet<MenuItem> menu;

    /**
     * @invariant for our Restaurant class: it should always return true.
     * @return true or false
     */
    private boolean isWellFormed()
    {
        Set<Order> ordersSet = orders.keySet();
        for(Order o : ordersSet) {
            if (orders.get(o)==null) {
                return false;
            }
        }
        return true;
    }

    /**
     * This is the method used to select the observer: administrator, or waiter
     * @param observer
     */
    public void register(Observer observer) {
        this.observer = observer;
    }

    /**
     * This is the method used to create new items in the menu.
     * @param menuItem the item to be created
     * @throws AssertionError due to the pre and post conditions' verification
     */
    @Override
    public void createNewMenuItem(MenuItem menuItem) throws AssertionError{
        int l=menu.size();
        assert isWellFormed();
        menu.add(menuItem);
        assert isWellFormed();
        assert l+1 == menu.size();

        restaurantSer.objectSerialization(menu);
        menu = restaurantSer.objectDeserialization();
    }

    /**
     * This is the method used to delete an item from the menu by its id.
     * @pre it checks some conditions before performing the operations
     * @post it checks some conditions after performing the operations
     * @param menuItemID id of the item
     * @throws AssertionError due to the pre and post conditions' verification
     */
    @Override
    public void deleteMenuItem(int menuItemID) throws AssertionError {
        int l=menu.size();
        assert isWellFormed();
        for (MenuItem i : menu) {
            if (menuItemID==i.getMenuItemID()) {
                menu.remove(i);
                break;
            }
        }
        assert isWellFormed();
        assert l==menu.size();

        restaurantSer.objectSerialization(menu);
        menu = restaurantSer.objectDeserialization();
    }

    /**
     * This is the method used to edit a menu item
     * @pre it checks some conditions before performing the operations
     * @post it checks some conditions after performing the operations
     * @param menuItemID the id of the item
     * @param price changed price
     * @throws AssertionError due to the pre and post conditions' verification
     */
    @Override
    public void editMenuItem(int menuItemID, double price) throws AssertionError {
        int l=menu.size();
        assert isWellFormed();
        for (MenuItem i :  menu ) {
            if (i instanceof BaseProduct) {
                if (menuItemID==i.getMenuItemID()) {
                    i.setPrice(price);
                    break;
                }
            }
            else {
                System.out.println("Composite products cannot be edited.");
            }
        }
        assert isWellFormed();
        assert l==menu.size()-1;

        restaurantSer.objectSerialization(menu);
        menu = restaurantSer.objectDeserialization();
    }

    /**
     * This is the method used to add an item in a set of orders.
     * @param menuItem item to be added
     * @return the orders set
     */
    public HashSet<MenuItem> addItem(ArrayList<MenuItem> menuItem) {
        HashSet<MenuItem> ord = new HashSet<>();
        for (MenuItem i : menuItem)
            ord.add(i);
        return ord;
    }

    /**
     * This is the method used to notify if a new Order has arrived.
     * @param items items from the menu
     * @param observable the observable
     */
    public void notify(List<MenuItem> items,Observable observable) {
        observer.update(observable, items);
    }

    /**
     * This is the method used to create a new order
     * @pre it checks some conditions before performing the operations
     * @post it checks some conditions after performing the operations.
     * @param order order to be created
     * @param menuItem the items needed to be added
     * @throws AssertionError due to the pre and post conditions' verification
     */
    @Override
    public void createNewOrder(Order order, ArrayList<MenuItem> menuItem) throws AssertionError {
        int l = orders.size();
        assert isWellFormed();
        orders.put(order,addItem(menuItem));
        notify(menuItem,this);
        assert isWellFormed();
        assert l+1== orders.size();
    }

    /**
     * This is the method used to compute the total price of the order.
     * @param orderID the orders's ID
     * @return the price
     */
    @Override
    public double computeOrderPrice(int orderID){
        double computedPrice = 0;
        for (Map.Entry<Order, Collection<MenuItem>> l : orders.entrySet()) {
            for (MenuItem i : l.getValue()) {
                if (i.getMenuItemID() == orderID) {
                    computedPrice = computedPrice + i.computePrice();
                }
            }
        }
        return computedPrice;
    }

    /**
     * This is the method used to generate a .txt bill for an order.
     * @param orderID the order's ID
     * @throws FileNotFoundException exception if the file is not found
     * @throws UnsupportedEncodingException exception for the writer
     */
    @Override
    public void generateBill(int orderID) throws FileNotFoundException, UnsupportedEncodingException{
        File f=new File("bills.txt");
        PrintWriter printWriter=new PrintWriter(f,"UTF-8");

        printWriter.println("Order: " + orderID);
        for (Map.Entry<Order, Collection<MenuItem>> l : orders.entrySet()){
            if(orderID==l.getKey().getTable()){
                printWriter.println("Date: "+l.getKey().getDate());
                printWriter.println("Table: "+l.getKey().getTable());
                printWriter.println("Price: "+computeOrderPrice(orderID));
                for(MenuItem i:l.getValue()){
                    printWriter.print("Name: " +i.getName());
                    printWriter.print(" price: "+i.computePrice());
                    printWriter.println(" RON");
                }
                printWriter.close();
            }
        }
    }

    public Restaurant() {
        restaurantSer = new RestaurantSerializator();
        orders = new HashMap<Order, Collection<MenuItem>>();
        menu = new HashSet<>();
        menu = restaurantSer.objectDeserialization();
    }

    /**
     * This is the method used to delete all the items from the menu.
     */
    public void deleteAll(){
        menu.clear();
        restaurantSer.objectSerialization(menu);
    }

    /**
     * This is the method used to get all the items from the menu.
     * @return menu items
     */
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem i : menu)
            menuItems.add(i);
        return menuItems;
    }

    /**
     * This is the method used to get al the orders from the menu.
     * @return orders
     */
    public ArrayList<Order> getOrders(){
        List<Order> l = new ArrayList<>();
        l.addAll(orders.keySet());
        return (ArrayList<Order>) l;
    }

}
