package businessLayer;

import java.util.ArrayList;

/**
 * Composite Product is the main entity we will be using to define menu items of composite product type.
 */
public class CompositeProduct extends MenuItem{
    private static final long serialVersionUID = -322364915757097229L;
    private ArrayList<MenuItem> items;

    @Override
    public double computePrice() {
        double price=0;
        for(MenuItem i:items){
            price=price+i.getPrice();
        }
        this.price=price;
        return price;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public CompositeProduct(){
        this.items=new ArrayList<MenuItem>();
    }
}
