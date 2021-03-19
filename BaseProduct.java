package businessLayer;

/**
 * Base Product is the main entity we will be using to define menu items of base product type.
 */
public class BaseProduct extends MenuItem{
    private static final long serialVersionUID = -2138373228174129847L;

    @Override
    public double computePrice() {
        return super.price;
    }
    public BaseProduct(int id,String name, double price){
        super.setMenuItemID(id);
        super.setName(name);
        super.setPrice(price);
    }
}
