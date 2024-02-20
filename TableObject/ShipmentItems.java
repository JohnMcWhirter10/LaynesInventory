/**
 * @author John McWhirter
 * Shipment Items Class to relate to Shipment Items Table
 */

package TableObject;

/**
 * Class container for Shipment Items
 * invoiceNum        Randomly Generated number unique to this class object
 * SKU               Given String unique to the item ordered in the shipment
 * QuantityOrdered   The integer number for the amount of the item ordered
 * QuantityDelivered The integer number for the amount of the item Delivered
 * ExtendedPrice     A total price value of the shipment
 */
public class ShipmentItems implements TableObject{
    private int invoiceNum;
    private String SKU;
    private int QuantityOrdered;
    private int QuantityDelivered;
    private double ExtendedPrice;

    /**
     * Shipment Items Class Constructor
     */
    public ShipmentItems(){
        setInvoiceNum(-1);
        setSKU("-1");
        setQuantityOrdered(-1);
        setQuantityDelivered(-1);
        setExtendedPrice(-1);
    }

    /**
     * Function which sets this object's Invoice Number to the argument
     * @param invoiceNum
     */
    public void setInvoiceNum(int invoiceNum){
        this.invoiceNum = invoiceNum;
    }

    /**
     * Function which sets this object's SKU to the argument
     * @param SKU
     */
    public void setSKU(String SKU){
        this.SKU = SKU;
    }

    /**
     * Function which sets this object's Quantity Ordered to this argument
     * @param QuantityOrdered
     */
    public void setQuantityOrdered(int QuantityOrdered){
        this.QuantityOrdered = QuantityOrdered;
    }
    /**
     * Function which sets this object's Quantity Delivered to this argument
     * @param QuantityDelivered
     */
    public void setQuantityDelivered(int QuantityDelivered){
        this.QuantityDelivered = QuantityDelivered;
    }
    /**
     * Function which sets this object's Extended Price to this argument
     * @param ExtendedPrice
     */
    public void setExtendedPrice(double ExtendedPrice){
        this.ExtendedPrice = ExtendedPrice;
    }

    /**
     * Function which returns this object's Invoice Number member
     * @return int
     */
    public int getInvoiceNum(){
        return invoiceNum;
    }

    /**
     * Function which returns this object's SKU member
     * @return String
     */
    public String getSKU(){
        return SKU;
    }

    /**
     * Function which returns this object's Quantity Ordered member
     * @return int
     */
    public int getQuantityOrdered(){
        return QuantityOrdered;
    }

    /**
     * Function which returns this object's Quantity Delivered member
     * @return int
     */
    public int getQuantityDelivered(){
        return QuantityDelivered;
    }

    /**
     * Function which returns this object's Extended Price member
     * @return float
     */
    public double getExtendedPrice(){
        return ExtendedPrice;
    }

    /**
     * Function implemented from superclass Table Object which returns
     *      the name of this class for SQL Table
     * @return String
     */
    public String getName(){ 
        return "Shipment_Items";
    }

    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return "Invoice_Line_Number int, SKU text, Quantity_Ordered int, Quantity_Delivered int, Extended_Price float";
    }

    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return String[] {"Invoice_Line_Number", "SKU", "Quantity_Ordered", "Quantity_Delivered", "Extended_Price"}
     */
    public String[] attributes(){
        String[] toRet = {"Invoice_Line_Number", "SKU", "Quantity_Ordered", "Quantity_Delivered", "Extended_Price"};
        return toRet;
    }

    public String getSelectedKey(){
        return "SKU = \'" + getSKU() + "\'";
    }

    public String values(){
        return "Invoice_Line_Number = \'" + getInvoiceNum() +  "\', SKU = \'" + getSKU() + 
        "\' , Quantity_Ordered = " + getQuantityOrdered() + ", Quantity_Delivered = " + getQuantityDelivered() +
         ", Extended_Price = " + getExtendedPrice();
    }

    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(" + String.valueOf(getInvoiceNum()) + ", \'" + getSKU() + "\', " + String.valueOf(getQuantityOrdered()) + ", "+ String.valueOf(getQuantityDelivered()) + ", " + String.valueOf(getExtendedPrice()) + ")";
    }

}
