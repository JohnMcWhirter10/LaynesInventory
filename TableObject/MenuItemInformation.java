/**
 * @author Arya Rahmanian
 * Menu Item Information class to relate to Menu Item Information Table
 */

package TableObject;

public class MenuItemInformation implements TableObject{
/**
 * Class container for Menu Item Information
 *  MenuID             The menu item number uniquely assigned to every menu item
 *  MenuItemName       The name of the menu item listed on the menu 
 *  Price              Price of Menu item
 *  Ingredient         Ingredient in the Menu item
 */
    private int MenuID;
    private String MenuItemName;
    private double Price;
    private String Ingredient;

    /** 
    * Menu Item Information Class Constructor
    */
    public MenuItemInformation(){
        setMenuID(-1);
        setMenuItemName("-1");
        setPrice(-1);
        setIngredient("-1");
    }

    /**
    * Function which sets this object's Menu ID to the argument
    * @param MenuID
    */ 
    public void setMenuID(int MenuID){
        this.MenuID = MenuID;
    }

    /**
    * Function which sets this object's Menu Item Name to the argument
    * @param MenuItemName
    */
    public void setMenuItemName(String MenuItemName){
        this.MenuItemName = MenuItemName;
    }

    /**
    * Function which sets this object's Price to the argument
    * @param Price
    */
    public void setPrice(double Price){
        this.Price = Price;
    }

    /**
    * Function which sets this object's Ingredient to the argument
    * @param Ingredient
    */
    public void setIngredient(String Ingredient){
        this.Ingredient = Ingredient;
    }


    /**
    * Function which returns this object's Menu ID member
    * @return int
    */    
    public int getMenuID(){
        return MenuID;
    }

    /**
    * Function which returns this object's Menu Item Name
    * @return string
    */  
    public String getMenuItemName(){
        return MenuItemName;
    }

    /**
    * Function which returns this object's Price member
    * @return double
    */  
    public double getPrice(){
        return Price;
    }

    /**
    * Function which returns this object's Ingredient member
    * @return string
    */  
    public String getIngredient(){
        return Ingredient;
    }

    /**
    * Function implemented from superclass Table Object which returns
    *      the name of this class for SQL Table
    * @return String
    */   
    public String getName(){
        return "Menu_Item_Information";
    }


    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return " Menu_Item_Number int, Name_Of_Menu_Item text, Price float, Ingredient text";
    }
    
    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[]  {"Menu_Item_Number", "Name_Of_Menu_Item", "Price", "Ingredient"}
     */   
    public String[] attributes(){
        String[] toRet = {"Menu_Item_Number", "Name_Of_Menu_Item", "Price", "Ingredient"};
        return toRet;
    }

    public String getSelectedKey(){
        return "Menu_Item_Number = \'" + getMenuID() + "\'";
    }

    public String values(){
        return "Menu_Item_Number = \'" + getMenuID() +  "\', Name_Of_Menu_Item = \'" + getName() + 
        "\' , Price = " + getPrice() + ", Ingredient = \'" + getIngredient() + "\'";
    }
    
    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(" + String.valueOf(getMenuID()) + ", \'" + getMenuItemName() + "\', " + String.valueOf(getPrice()) + ", \'" + getIngredient() + "\')";
    }
}