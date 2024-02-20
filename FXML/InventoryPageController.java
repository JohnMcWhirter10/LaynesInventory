package FXML;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Connection.ConnectionManager;
import TableObject.ItemInformation;
import TableObject.CustomerOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryPageController implements Initializable{

    ObservableList<ItemInformation> oblist = FXCollections.observableArrayList();
    ObservableList<CustomerOrders> cus_oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ConnectionManager myManager = new ConnectionManager();
        
        ItemInformation Inventory_History = new ItemInformation();
        ResultSet result = myManager.selectStar(Inventory_History);

        try {
            while(result.next()){
                
                ItemInformation toAdd = new ItemInformation();
                toAdd.setSKU(result.getString(toAdd.attributes()[0]));
                toAdd.setItemName(result.getString(toAdd.attributes()[1]));
                toAdd.setCategory(result.getString(toAdd.attributes()[2]));
                toAdd.setMultiplier(Integer.parseInt(result.getString(toAdd.attributes()[3])));
                toAdd.setSaleUnit(result.getString(toAdd.attributes()[4]));
                toAdd.setDeliveryMethod(result.getString(toAdd.attributes()[5]));
                toAdd.setPrice(Double.parseDouble(result.getString(toAdd.attributes()[6])));
                toAdd.setStorageCategory(result.getString(toAdd.attributes()[7]));
                toAdd.setDescription(result.getString(toAdd.attributes()[8]));
                toAdd.setCurrent_Inventory(Integer.parseInt(result.getString(toAdd.attributes()[9])));

                oblist.add(toAdd);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            myManager.endConnection();
            System.exit(0);
        }


        SKUCol.setCellValueFactory(new PropertyValueFactory<>("SKU"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("Current_Inventory"));

        Inventory.setItems(oblist);
        CustomerOrders CustomerOrderHistory = new CustomerOrders();
        result = myManager.selectStar(CustomerOrderHistory);

        try {
            while(result.next()){
                CustomerOrders toAdd = new CustomerOrders();

                toAdd.setDate(result.getString(toAdd.attributes()[0]));
                toAdd.setOrderNumber(result.getInt(toAdd.attributes()[1]));
                toAdd.setPrice(result.getFloat(toAdd.attributes()[2]));
                toAdd.setIsCompleted(result.getBoolean(toAdd.attributes()[3]));
                cus_oblist.add(toAdd);

            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            
            e.printStackTrace();
            myManager.endConnection();
            System.exit(0);
        }

        OrderNumCol.setCellValueFactory(new PropertyValueFactory<>("OrderNumber"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));

        CustomerOrders.setItems(cus_oblist);

        myManager.endConnection();
    }



    @FXML
    private TextField CategoryEntry;

    @FXML
    private TableView<?> CustomerOrderToInventory;

    @FXML
    private TableView<CustomerOrders> CustomerOrders;

    @FXML
    private TableColumn<CustomerOrders, String> DateCol;

    @FXML
    private TableColumn<CustomerOrders, Integer> OrderNumCol;

    @FXML
    private TableColumn<CustomerOrders, Float> PriceCol;
    
    @FXML
    private TableView<ItemInformation> Inventory;

    
    @FXML
    private TableColumn<?, ?> ConvAmountCol;

    @FXML
    private TableColumn<?, ?> ConvNameCol;

    @FXML
    private TableColumn<?, ?> ConvSKUCol;
    
    @FXML
    private TableColumn<ItemInformation,String> SKUCol;
    
    @FXML
    private TableColumn<ItemInformation,String> NameCol;

    @FXML
    private TableColumn<ItemInformation,Integer> AmountCol;

    @FXML
    private TextField DeliveryMethodEntry;

    @FXML
    private TextArea DescriptionEntry;

    @FXML
    private TextField ItemNameEntry;

    @FXML
    private TextField MultiplierEntry;

    @FXML
    private TextField StorageMethodEntry;

    @FXML
    private TextField PriceEntry;

    @FXML
    private TextField SKUentry;

    @FXML
    private TextField SaleUnitEntry;

    @FXML
    private TextField AmountEntry;

    @FXML
    private Button btnAddItem;

    @FXML
    private Button btnClearEntry;

    @FXML
    private Button btnRemoveItem;

    @FXML
    private Button btnUpdate;

    @FXML
    void AddItem(ActionEvent event) {
        ItemInformation toAdd = new ItemInformation();
        String ErrorMessage = "";
        boolean isError = false;
        if(!SKUentry.getText().isEmpty()){
            toAdd.setSKU(SKUentry.getText());
        } else{
            ErrorMessage += "SKU needs a value\n";
            isError = true;
        }
        if(!ItemNameEntry.getText().isEmpty()){
            toAdd.setItemName(ItemNameEntry.getText());
        } else{
            ErrorMessage += "Item Name needs a value\n";
            isError = true;
        }
        if(!CategoryEntry.getText().isEmpty()){
            toAdd.setCategory(CategoryEntry.getText());
        } else{
            ErrorMessage += "Category needs a value\n";
            isError = true;
        }
        if(!DeliveryMethodEntry.getText().isEmpty()){
            toAdd.setDeliveryMethod(DeliveryMethodEntry.getText());
        } else{
            ErrorMessage += "Delivery Method needs a value\n";
            isError = true;
        }
        
        if(!MultiplierEntry.getText().isEmpty()){
            try{
                toAdd.setMultiplier(Integer.parseInt(MultiplierEntry.getText()));
            }
            catch(Exception e){
                System.out.println(e.getClass() + ": " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Quantity Multiplyer can only be an integer");
                return;
            }
        } else{
            ErrorMessage += "Quantity Multiplyer needs a value\n";
            isError = true;
        }
        if(!PriceEntry.getText().isEmpty()){
            try{
                toAdd.setPrice(Double.parseDouble(PriceEntry.getText()));
            } 
            catch(Exception e){
                System.out.println(e.getClass() + ": " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Price can only be a number!");
                return;
            }
        } else{
            ErrorMessage += "Price needs a value\n";
            isError = true;
        }
        if(!SaleUnitEntry.getText().isEmpty()){
            toAdd.setSaleUnit(SaleUnitEntry.getText());
        } else{
            ErrorMessage += "Sold By needs a value\n";
            isError = true;
        }
        if(!StorageMethodEntry.getText().isEmpty()){
            toAdd.setStorageCategory(StorageMethodEntry.getText());
        } else{
            ErrorMessage += "Stored By needs a value\n";
            isError = true;
        }
        if(!DescriptionEntry.getText().isEmpty()){
            toAdd.setDescription(DescriptionEntry.getText());
        } else{
            ErrorMessage += "Description needs a value\n";
            isError = true;
        }
        if(!AmountEntry.getText().isEmpty()){
            try{
                toAdd.setCurrent_Inventory(Integer.parseInt(AmountEntry.getText()));
            }
            catch(Exception e){
                System.out.println(e.getClass() + ": " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Amount can only be an Integer!");
                return;
            }
        } else {
            ErrorMessage += "Amount needs a value\n";
            isError = true;
        }
        if(!isError){
            int i = 0;
            for(; i < oblist.size();i++){
                if(oblist.get(i).getSKU().equals(toAdd.getSKU())){
                    toAdd.setCurrent_Inventory(toAdd.getCurrent_Inventory() + oblist.get(i).getCurrent_Inventory());
                    oblist.set(i, toAdd);
                    return;
                }
            } 

            oblist.add(toAdd);
        }else
        {
            JOptionPane.showMessageDialog(null, ErrorMessage);
        }
        System.out.println("toAdd Attributes: " + toAdd.allAttributes());
        System.out.println("toAdd SQL:        " + toAdd.toString());

    }

    @FXML
    void ClearEntry(ActionEvent event) {
        SKUentry.setText("");
        DeliveryMethodEntry.setText("");
        CategoryEntry.setText("");
        DescriptionEntry.setText("");
        ItemNameEntry.setText("");
        MultiplierEntry.setText("");
        StorageMethodEntry.setText("");
        PriceEntry.setText("");
        SaleUnitEntry.setText("");
        AmountEntry.setText("");
    }

    @FXML
    void RemoveItem(ActionEvent event) {
        
        String Message  =   "SKU: " + Inventory.getSelectionModel().getSelectedItems().get(0).getSKU();
               Message += "\nItem Name: " + Inventory.getSelectionModel().getSelectedItems().get(0).getItemName();
               Message += "\nCategory: " + Inventory.getSelectionModel().getSelectedItems().get(0).getCategory();
               Message += "\nMultiplier: " + Inventory.getSelectionModel().getSelectedItems().get(0).getMultiplier();
               Message += "\nSold By: " + Inventory.getSelectionModel().getSelectedItems().get(0).getSaleUnit();
               Message += "\nDelivery Method: " + Inventory.getSelectionModel().getSelectedItems().get(0).getDeliveryMethod();
               Message += "\nPrice: " + Inventory.getSelectionModel().getSelectedItems().get(0).getPrice();
               Message += "\nStorage Category: " + Inventory.getSelectionModel().getSelectedItems().get(0).getStorageCategory();
               Message += "\nDescription: " + Inventory.getSelectionModel().getSelectedItems().get(0).getDescription();
        int choice = JOptionPane.showConfirmDialog(null, Message, "Press OK to Confirm Deletion", JOptionPane.OK_CANCEL_OPTION);
        if(choice == 0){
            ConnectionManager myManager = new ConnectionManager();
            myManager.DELETE(Inventory.getSelectionModel().getSelectedItem());


            Inventory.getItems().removeAll(Inventory.getSelectionModel().getSelectedItems());
            myManager.endConnection();
        } 
    }

    @FXML
    void FillEntriesOnClick(MouseEvent event) {
        ItemInformation toFill = Inventory.getSelectionModel().getSelectedItems().get(0);
        SKUentry.setText(toFill.getSKU());
        DeliveryMethodEntry.setText(toFill.getDeliveryMethod());
        CategoryEntry.setText(toFill.getCategory());
        DescriptionEntry.setText(toFill.getDescription());
        ItemNameEntry.setText(toFill.getItemName());
        MultiplierEntry.setText(Integer.toString(toFill.getMultiplier()));
        StorageMethodEntry.setText(toFill.getStorageCategory());
        PriceEntry.setText(Double.toString(toFill.getPrice()));
        SaleUnitEntry.setText(toFill.getSaleUnit());
        AmountEntry.setText(Integer.toString(toFill.getCurrent_Inventory()));

    }

    @FXML
    void UpdateCurrentInventory(ActionEvent event) {
        ConnectionManager myManager = new ConnectionManager();
        for(int i = 0; i < oblist.size(); i++){
            myManager.updateEntryOnSelectedKey(oblist.get(i));
        }
        myManager.endConnection();
    }


}
