/**
 * @author Arya Rahmanian
 * Customer Order Breakdown class to relate to Customer Order Breakdown Table
 */

package TableObject;

public class CustomerOrderBreakdown implements TableObject{
/**
 * Class container for Customer Order Breakdown
 *  OrderNumber             Randomly Generated Order Number for every order
 *  MenuItemNumber          The menu item number uniquely assigned to every menu item
 *  QuantityOrdered         The number of the menu item number ordered
 *  SpecialNotes     Any special notes for order
 */
    private int OrderNumber;
    private int MenuItemNumber;
    private int QuantityOrdered;
    private String SpecialNotes;

    /** 
    * Customer Order Breakdown Class Constructor
    */
    public CustomerOrderBreakdown(){
        setOrderNumber(-1);
        setMenuItemNumber(-1);
        setQuantityOrdered(-1);
        setSpecialNotes("-1");
    }

    /**
    * Function which sets this object's  Order Number to the argument
    * @param orderNumber
    */
    public void setOrderNumber(int orderNumber){
        this.OrderNumber = orderNumber;
    }

    
    /**
    * Function which sets this object's Menu Item Number to the argument
    * @param menuItemNumber
    */
    public void setMenuItemNumber(int menuItemNumber){
        this.MenuItemNumber = menuItemNumber;
    }

    /**
    * Function which sets this object's Quantity Ordered to the argument
    * @param quantityOrdered
    */
    public void setQuantityOrdered(int quantityOrdered){
        this.QuantityOrdered = quantityOrdered;
    }

    /**
    * Function which sets this object's Special Notes to the argument
    * @param specialNotes
    */
    public void setSpecialNotes(String specialNotes){
        this.SpecialNotes = specialNotes;
    }

    /**
     * Function which returns this object's Order Number member
     * @return int
     */    
    public int getOrderNumber(){
        return OrderNumber;
    }

    /**
    * Function which returns this object's Menu Item Number member
    * @return int
    */    
    public int getMenuItemNumber(){
        return MenuItemNumber;
    }

    /**
    * Function which returns this object's Quantity Ordered member
    * @return int
    */        
    public int getQuantityOrdered(){
        return QuantityOrdered;
    }

    /**
    * Function which returns this object's Special Notes member
    * @return string
    */     
    public String getSpecialNotes(){
        return SpecialNotes;
    }

    /**
    * Function implemented from superclass Table Object which returns
    *      the name of this class for SQL Table
    * @return String
    */    
    public String getName(){ 
        return "Customer_Order_Breakdown";
    }

    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return " Order_Number int, Menu_Item_Number int, Quantity_Ordered int, Special_Notes text";
    }

    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[] {"Order_Number", "Menu_Item_Number", "Quantity_Ordered", "Special_Notes"}
     */        
    public String[] attributes(){
        String[] toRet = {"Order_Number", "Menu_Item_Number", "Quantity_Ordered", "Special_Notes"};
        return toRet;
    }

    public String getSelectedKey(){
        return "Order_Number = " + getOrderNumber();
    }

    public String values(){
        return "Order_Number = " + getOrderNumber() +  ", Menu_Item_Number =" + getMenuItemNumber() + 
        " , Quantity_Ordered =" + getQuantityOrdered() + ", Special_Notes =\'" + getSpecialNotes() + "\'";
    }

    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(" + String.valueOf(OrderNumber) + ", " + String.valueOf(MenuItemNumber) + ", " + String.valueOf(QuantityOrdered) + ", \'" + getSpecialNotes() + "\')";
    }
}
