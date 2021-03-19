package dataLayer;

import businessLayer.MenuItem;

import java.io.*;
import java.util.HashSet;

/**
 * RestaurantSerializator is the main entity we will be using to perform serialization and deserialization on an object.
 */
public class RestaurantSerializator {

    /**
     * This is the method used to perform serialization: convert the state of an object into a byte stream.
     * @param items hashSet of menu items
     */
    public void objectSerialization(HashSet<MenuItem> items){
        try {
            FileOutputStream file=new FileOutputStream("restaurant.ser");
            ObjectOutputStream output=new ObjectOutputStream(file);
            output.writeObject(items);
            output.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is the method used to perform deserialization: the byte stream is used to recreate the actual Java object in
     * memory.
     * @return the items
     */
    public HashSet<MenuItem> objectDeserialization(){
        HashSet<MenuItem> items = new HashSet<>();
        try {
            FileInputStream file=new FileInputStream("restaurant.ser");
            ObjectInputStream input=new ObjectInputStream(file);
            items = (HashSet<MenuItem>)input.readObject();
            input.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }
}
