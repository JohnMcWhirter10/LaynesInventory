/** 
 * @author John McWhirter
 * Shipments Class to relate to Shipments Table
 * 
**/
package TableObject;

import java.time.LocalDateTime;

/**
 * Class container for Shipments
 * OrderDate     the date at which the shipment was placed
 * invoiceNum    randomly generated number unique to each shipment
 * Status        the delivery status of this shipment (Transit or Delivered)
 */
public class Shipments implements TableObject{
    private String OrderDate;
    private int invoiceNum;
    private String Status;

    /**
     * Shipments Class Constructor
     */
    public Shipments(){
        setOrderDate(LocalDateTime.of(2000,1,1,1,1,1).toString());
        setInvoiceNum(-1);
        setStatus("-");
    }

    /**
     * Function which sets this object's Order Date to the argument
     * @param OrderDate the date at which the shipment was placed
     */
    public void setOrderDate(String OrderDate){
        this.OrderDate = OrderDate;
    }

    /**
     * Function which sets this object's Invoice Number to the argument
     * @param invoiceNum    randomly generated number unique to each shipment
     */
    public void setInvoiceNum(int invoiceNum){
        this.invoiceNum = invoiceNum;
    }

    /**
     * Function which sets this object's Status to the argument
     * @param Status        the delivery status of this shipment (Transit or Delivered)
     */
    public void setStatus(String Status){
        this.Status = Status;
    }

    /**
     * Function which returns this object's Order Date member
     * @return LocalDateTime 
     */
    public String getOrderDate(){
        return OrderDate;
    }

    /**
     * Function which returns this object's Invoice Number member
     * @return int
     */
    public int getInvoiceNum(){
        return invoiceNum;
    }

    /**
     * Function which returns this object's Status member
     * @return String
     */
    public String getStatus(){
        return Status;
    }
    
    /**
     * Function implemented from superclass Table Object which returns
     *      the name of this class for SQL Table
     * @return String
     */
    public String getName(){
        return "Shipments";
    }

    /**
     * Function implemented from superclass TableObject which returns a String
     *      of all Attributes and corresponding data types
     * @return String
     */
    public String allAttributes(){
        return "Date_Of_Order text, Invoice_Line_Number int, Status text";
    }

    /**
     * Function implemented from superclass TableObject which returns a 
     *      String Array containing the Table Attributes
     * @return  {"Date_Of_Order", "Invoice_Line_Number", "Status"}
     */
    public String[] attributes(){
        String[] toRet = {"Date_Of_Order", "Invoice_Line_Number", "Status"};
        return toRet;
    }

    public String getSelectedKey(){
        return "Date_Of_Order = \'" + getOrderDate() + "\'";
    }

    public String values(){
        return "Date_Of_Order = \'" + getOrderDate() +  "\', Invoice_Line_Number = " + getInvoiceNum() + 
        " , Status = \'" + getStatus() + "\'";
    }

    /**
     * Override Function of the toString used to return this object's data as
     *      a string literal
     * @return String
     */
    @Override
    public String toString(){
        return "(\'" + OrderDate + "\'," + String.valueOf(invoiceNum) + ",\'" + Status + "\')";
    }
}
