package dataLayer;

import businessLayer.Restaurant;
import presentationLayer.*;

/**
 * This is the class connecting all the operations from the application.
 */
public class MainClass {
    public static void main(String [] args){

        Restaurant restaurant = new Restaurant();
        LoginUI m = new LoginUI(restaurant);
        ChefGraphicalUI chefUserInterface = new ChefGraphicalUI();
        restaurant.register(chefUserInterface);

    }
}
