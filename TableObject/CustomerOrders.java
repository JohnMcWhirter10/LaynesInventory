/**
 * @author Arya Rahmanian
 * Customer Orders class to relate to Customer Orders
 */

package TableObject;
import java.time.LocalDateTime;

public class CustomerOrders implements TableObject{
/**
 * Class container for Customer Orders
 *  OrderNumber             Randomly Generated Order Number for every order
 *  Date                    The Date taken of the order
 *  Price                   The price of the order
 *  isCompleted             A boolean noting whether or not order is completed
 */
    private String Date;
    private int OrderNumber;
    private float Price;
    private boolean isCompleted;

    /** 
    * Customer Orders Class Constructor
    */
    public CustomerOrders(){
        setDate(LocalDateTime.of(2000, 1, 1, 1, 1, 1).toString());
        setOrderNumber(-1);
        setPrice(-1);
        setIsCompleted(false);
    }

/**
 * Setters 
*/

    /**
    * Function which sets this object's  Order Date to the argument
    * @param OrderDate
    */
    public void setDate(String OrderDate){
        this.Date = OrderDate;
    }

    /**
    * Function which sets this object's Order Number to the argument
    * @param orderNumber
    */    
    public void setOrderNumber(int OrderNum){
        this.OrderNumber = OrderNum;
    }

    /**
    * Function which sets this object's Price to the argument
    * @param Price
    */    
    public void setPrice(float Price){
        this.Price = Price;
    }

    /**
    * Function which sets this object's isCompleted to the argument
    * @param isCompleted
    */     
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

/**
 * Getters
*/

    /**
    * Function which returns this object's Date member
    * @return string
    */    
    public String getDate(){
        return Date;
    }

    /**
    * Function which returns this object's Order Number
    * @return int
    */        
    public int getOrderNumber(){
        return OrderNumber;
    }

    /**
    * Function which returns this object's Price member
    * @return float
    */        
    public float getPrice(){
        return Price;
    }

    /**
    * Function which returns this object's isCompleted
    * @return boolean
    */       
    public boolean getIsCompleted(){
        return isCompleted;
    }

    /**
    * Function implemented from superclass Table Object which returns
    *      the name of this class for SQL Table
    * @return String
    */           
    public String getName(){
        return "Customer_Orders";
    }

    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return " Date text, Order_Number int, Total_Price float, Is_Completed bit";
    }

    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[] {"Date", "Order_Number", "Total_Price", "Is_Completed"}
     */     
    public String[] attributes(){
        String[] toRet = {"Date", "Order_Number", "Total_Price", "Is_Completed"};
        return toRet;
    }

    public String getSelectedKey(){
        return "Date = \'" + getDate() + "\'";
    }

    public String values(){
        return "Date = \'" + getDate() +  ", Order_Number =" + getOrderNumber() + 
        " , Total_Price =" + getPrice() + ", Is_Completed =\'" + getIsCompleted() + "\'";
    }


    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override 
    public String toString(){
        return "(\'" + Date + "\', " + String.valueOf(getOrderNumber()) + ", " + String.valueOf(getPrice()) + ", " + String.valueOf(getIsCompleted()) + ")";
    }
}
