package businessLayer;

import java.time.LocalDate;

/**
 * Order is the main entity we will be using to store information about orders in the restaurant, like
 * ID, date and table number;
 */
public class Order  {
    public int orderID;
    public LocalDate date;
    public int table;

    public int hashCode(){
        return 31*orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Order() {
        date = LocalDate.now();
    }
}
