/** 
 * @author Ryan Sih
 * DaySales Class to relate to Day_Sales Table
 * 
**/

package TableObject;

/**
 * Class container for DaySales
 * Day     string that references all orders placed on this day
 * MenuItemNumber    references the items ordered by all customers
 * Quantity        references the number of items ordered
 * TotalPrice   total price of all items in a day
 * ItemPrice    total price of each item in a day
 */

public class DaySales implements TableObject{
    private String Day;
    private int MenuItemNumber;
    private int Quantity;
    private double TotalPrice;
    private double ItemPrice;
    private String Date;
    
    /**
     * DaySales Class Constructor
     */
    public DaySales(){
        //initialize
        setDay("-1");
        setMenuItemNumber(-1);
        setQuantity(-1);
        setTotalPrice(-1);
        setItemPrice(-1);
        setDate("0");
    }

    //setters
    /**
     * Function which sets this object's Day to the argument
     * @param Day   string that represents all orders placed on this specific day 
     */
    public void setDay(String Day){
        this.Day = Day;
    }

    /**
     * Function which sets this object's Menu Item Number to the argument
     * @param MenuItemNumber    integer that represents a menu item description/name
     */
    public void setMenuItemNumber(int MenuItemNumber){
        this.MenuItemNumber = MenuItemNumber;
    }

    /**
     * Function which sets this object's item Quantity to the argument
     * @param Quantity  integer that represents the amount of menu item ordered in a day
     */
    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }

    /**
     * Function which sets this object's Total Price to the argument
     * @param ItemPrice float that represents the total cost of items ordered in a day
     */
    public void setItemPrice(double ItemPrice){
        this.ItemPrice = ItemPrice;
    }

    /**
     * Function which sets this object's Total Price to the argument
     * @param TotalPrice float that represents the total cost of items ordered in a day
     */
    public void setTotalPrice(double TotalPrice){
        this.TotalPrice = TotalPrice;
    }

    /**
     * Function which sets this object's Date
     * @param Date String that represents the date of the order
     */
    public void setDate(String Date){
        this.Date = Date;
    }

    //getters

    /**
     * Function which returns this object's Day member
     * @return String
     */
    public String getDay(){
        return Day;
    }

    /**
     * Function which returns this object's MenuItemNumber member
     * @return int
     */
    public int getMenuItemNumber(){
        return MenuItemNumber;
    }

    /**
     * Function which returns this object's Quantity member
     * @return int
     */
    public int getQuantity(){
        return Quantity;
    }

    /**
     * Function which returns this object's TotalPrice member
     * @return float
     */
    public double getTotalPrice(){
        return TotalPrice;
    }
    /**
     * Function which returns this object's ItemPrice member
     * @return float
     */
    public double getItemPrice(){
        return ItemPrice;
    }
    /**
     * Function which returns this object's Date as String
     * @return String
     */
    public String getDate(){
        return Date;
    }

    /**
     * Function implemented from superclass Table Object which returns
     *      the name of this class for SQL Table
     * @return String
     */
    public String getName() {
        return "day_sales";
    }

    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return " Day text, Menu_Item_Number int, Quantity int, total_price float, item_Price float, date text";
    }
    
    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[]
     */
    public String[] attributes(){
        String[] toRet = {"Day", "Menu_Item_Number", "Quantity","Total_Price", "item_Price", "Date"};
        return toRet;
    }

    public String getSelectedKey(){
        return "NULL";
    }

    public String values(){
        return "Day = \'" + getDay() +  "\', Menu_Item_Number = " + getMenuItemNumber() + 
        " , Quantity = " + getQuantity() + ", Total_Price = " + getTotalPrice() + ", Item_Price = " +
        getItemPrice() + ", Date = \'" + getDate() + "\'";
    }
    
    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(\'" + getDay() + "\', " + String.valueOf(getMenuItemNumber()) + ", " + String.valueOf(getQuantity()) + ", " + String.valueOf(getTotalPrice()) + ", " + String.valueOf(getItemPrice()) + ", " + String.valueOf(getDate()) + ")";
    }
}