package businessLayer;

import java.io.Serializable;

/**
 * MenuItem is the main entity we will be using to store information about the items from the menu,
 * like ID, name and price.
 */
public abstract class MenuItem implements Serializable {

    private static final long serialVersionUID = 3827686439975539244L;
    protected int menuItemID;
    protected String name;
    protected double price;

    protected MenuItem() {
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem(int menuItemID, String name, double price) {
        this.menuItemID = menuItemID;
        this.name = name;
        this.price = price;
    }

    /**
     * This method calculates the total price of a specific MenuItem, BaseProduct or CompositeProduct
     * @return the price
     */
    public abstract double computePrice();
}
