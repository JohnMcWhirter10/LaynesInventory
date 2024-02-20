/**
 * @author John McWhirter
 * Item Information Class to relate to Item Information Table
 */
package TableObject;

/**
 * Class container for Item Information
 * SKU               Given String unique to the item ordered in the shipment
 * MenuItemName;     The Corresponding Menu Item Name
 * Category;
 * Multiplier;       The quantity in which the Item was purchased
 * SaleUnit;         The Unit in which the Item is sold
 * DeliveryMethod;   The Method in which each Item is Delivered (case, bag, container, each, bucket)
 * Price;            The total value of the Purchase
 * StorageCategory;  The method in which each Item is Stored (Cold, Dry, Frozen)
 * Description;      A Detailed Description of the item in Delivery Method
 */
public class ItemInformation implements TableObject{
    private String SKU;
    private String ItemName;
    private String Category;
    private int Multiplier;
    private String SaleUnit;
    private String DeliveryMethod;
    private double Price;
    private String StorageCategory;
    private String Description;
    private int Current_Inventory;

    /**
     * Item Information Class Constructor
     */
    public ItemInformation(){
        setSKU("-1");
        setItemName("-1");
        setCategory("-1");
        setMultiplier(-1);
        setSaleUnit("-1");
        setDeliveryMethod("-1");
        setPrice(-1);
        setStorageCategory("-1");
        setDescription("-1");
        Current_Inventory = -1;
    }

    /**
     * Function which sets this object's SKU to the argument
     * @param SKU
     */
    public void setSKU(String SKU){
        this.SKU = SKU;
    }
    /**
     * Function which sets this object's Item Name to the argument
     * @param ItemName
     */
    public void setItemName(String ItemName){
        this.ItemName = ItemName;
    }
    /**
     * Function which sets this object's Category to the argument
     * @param Category
     */
    public void setCategory(String Category){
        this.Category = Category;
    }
    /**
     * Function which sets this object's Multiplier to the argument
     * @param Multiplier
     */
    public void setMultiplier(int Multiplier){
        this.Multiplier = Multiplier;
    }
    /**
     * Function which sets this object's Sale Unit to the argument
     * @param SaleUnit
     */
    public void setSaleUnit(String SaleUnit){
        this.SaleUnit = SaleUnit;
    }
    /**
     * Function which sets this object's Delivery Method to the argument
     * @param DeliveryMethod
     */
    public void setDeliveryMethod(String DeliveryMethod){
        this.DeliveryMethod = DeliveryMethod;
    }
    /**
     * Function which sets this object's Price to the argument
     * @param Price
     */
    public void setPrice(double Price){
        this.Price = Price;
    }
    /**
     * Function which sets this object's Storage Category to the argument
     * @param StorageCategory
     */
    public void setStorageCategory(String StorageCategory){
        this.StorageCategory = StorageCategory;
    }
    /**
     * Function which sets this object's Description to the argument
     * @param Description
     */
    public void setDescription(String Description){
        this.Description = Description;
    }
    /**
     * Function which sets this object's Description to the argument
     * @param Count
     */
    public void setCurrent_Inventory(int Count){
        this.Current_Inventory = Count;
    }
    /**
     * Function which returns this object's SKU member
     * @return String
     */
    public String getSKU(){
        return SKU;
    }

    /**
     * Function which returns this object's Item Name member
     * @return String
     */
    public String getItemName(){
        return ItemName;
    }

    /**
     * Function which returns this object's Category member
     * @return String
     */
    public String getCategory(){
        return Category;
    }
    /**
     * Function which returns this object's Multiplier member
     * @return int
     */
    public int getMultiplier(){
        return Multiplier;
    }

    /**
     * Function which returns this object's Sale Unit member
     * @return String
     */
    public String getSaleUnit(){
        return SaleUnit;
    }

    /**
     * Function which returns this object's Delivery Method member
     * @return String
     */
    public String getDeliveryMethod(){
        return DeliveryMethod;
    }

    /**
     * Function which returns this object's Price member
     * @return float
     */
    public double getPrice(){
        return Price;
    }

    /**
     * Function which returns this object's Storage Category member
     * @return String
     */
    public String getStorageCategory(){
        return StorageCategory;
    }

    /**
     * Function which returns this object's Description member
     * @return String
     */
    public String getDescription(){
        return Description;
    }
    /**
     * Function which returns this object's Multiplier member
     * @return int
     */
    public int getCurrent_Inventory(){
        return Current_Inventory;
    }
    /**
     * Function implemented from superclass Table Object which returns
     *      the name of this class for SQL Table
     * @return String
     */
    public String getName() {
        return "Item_Information";
    }
    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return "SKU text, Name text, Category text, Quantity_Multiplyer int, Sold_By_Unit text, Delivery_Method text, Price float, Storage_Category text, Description text, Current_Inventory int";
    }
    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[] {"SKU", "Name", "Category", "Quantity_Multiplyer", "Sold_By_Unit", "Delivery_Method", "Price", "Storage_Category" , "Description", "Current_Inventory"}
     */
    public String[] attributes(){
        String[] toRet = {"SKU", "Name", "Category", "Quantity_Multiplyer", "Sold_By_Unit", "Delivery_Method", "Price", "Storage_Category" , "Description", "Current_Inventory"};
        return toRet;
    }
    public String getSelectedKey(){
        return "SKU = \'" + getSKU() + "\'";
    }

    public String values(){
        return "SKU = \'" + getSKU() +  "\', Name = \'" + getItemName() + 
        "\' , Category = \'" + getCategory() + "\', Sold_By_Unit = \'" + getSaleUnit() + "\', Price = " +
        getPrice() + ", Description = \'" + getDescription() + "\', Current_Inventory = " + getCurrent_Inventory();
    }
    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(\'" + getSKU() + "\', \'" + getItemName() + "\', \'" + getCategory() + "\', " + String.valueOf(getMultiplier()) + ", \'" + getSaleUnit() + "\', \'" + getDeliveryMethod() + "\', " + String.valueOf(getPrice()) + ", \'" + getStorageCategory() + "\', \'" + getDescription() + "\', "+ String.valueOf(getCurrent_Inventory()) +")";
    }

}
