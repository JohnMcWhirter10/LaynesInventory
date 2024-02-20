import TableObject.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

import Connection.ConnectionManager;

public class Driver extends Application{

    /*public static boolean subtractInventoryOnOrder(ConnectionManager manager, int menuNumber) {
        ResultSet res= manager.selectBlank(new ItemInformation(), Integer.toString(menuNumber));

    }*/

    public static boolean createTables(ConnectionManager manager){
        try{
            manager.createTable(new CustomerOrderBreakdown());
            manager.createTable(new CustomerOrders());
            manager.createTable(new DaySales());
            manager.createTable(new ItemInformation());
            manager.createTable(new MenuItemInformation());
            manager.createTable(new ShipmentItems());
            manager.createTable(new Shipments());
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            manager.endConnection();
            System.exit(0);
        }
        return true;
    }

    public static boolean dropTables(ConnectionManager manager){
        try{
            manager.DROPTABLE(new CustomerOrderBreakdown());
            manager.DROPTABLE(new CustomerOrders());
            manager.DROPTABLE(new DaySales());
            manager.DROPTABLE(new ItemInformation());
            manager.DROPTABLE(new MenuItemInformation());
            manager.DROPTABLE(new ShipmentItems());
            manager.DROPTABLE(new Shipments());
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            manager.endConnection();
            System.exit(0);
        }
        return true;
    }

    public static void readMenuKey(ConnectionManager manager) throws Exception {
        Scanner sc = new Scanner(new File("CSV/MenuKey.csv"));
        while(sc.hasNext()){
            MenuItemInformation toAdd = new MenuItemInformation();
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            if(parts.length > 1){
                String[] beforeDes = parts[0].split(",");
                toAdd.setMenuID(Integer.parseInt(beforeDes[1]));
                toAdd.setMenuItemName(beforeDes[2]);
                toAdd.setIngredient(parts[1]);
                String[] afterDes = parts[2].split(",");
                toAdd.setPrice(Double.parseDouble(afterDes[1].substring(1)));
                manager.INSERT(toAdd);
            }
        }
        sc.close();
    }

    public static void readWeekSales(ConnectionManager manager, String fullFileName, int count) throws Exception{
        Scanner sc = new Scanner(new File(fullFileName));
        String line = sc.nextLine();
        DaySales toAdd = new DaySales();
        
        while(sc.hasNext()){
            line = sc.nextLine();
            if(line.equals(",,,,")){
                continue;
            }
            String[] parts = line.split(",");
            if(parts.length == 0){
                continue;
            }
            if(!parts[0].equals("")){
                toAdd = new DaySales();
                String total = parts[4].substring(parts[4].indexOf("\"")+1) +
                parts[5].substring(0, parts[5].indexOf("\""));
                total = total.replaceAll("$", "");
                total = total.replaceAll("\\s", "");
                total = total.substring(1);
                toAdd.setDay(parts[0]);
                
                count++;
                toAdd.setTotalPrice(Double.parseDouble(total));
            } else {
                toAdd.setMenuItemNumber(Integer.parseInt(parts[1]));
                toAdd.setQuantity(Integer.parseInt(parts[2]));
                toAdd.setItemPrice(Double.parseDouble(parts[3].substring(1)));
                toAdd.setDate(count + "");
                manager.INSERT(toAdd);
            }

        }
        sc.close();
    }

    public static void readDayOrder(ConnectionManager manager, String fullFileName) throws Exception{
        Scanner sc = new Scanner(new File(fullFileName));
        String line = sc.nextLine();
        Shipments shipment = new Shipments();
        ShipmentItems ShipItem = new ShipmentItems();
        ItemInformation item = new ItemInformation();

        String[] parts = line.split(",");
        shipment.setStatus(parts[1].substring(0,parts[1].length()-1));
        shipment.setOrderDate(parts[6]);
        sc.nextLine();
        while(sc.hasNext()){
            line = sc.nextLine();
            parts = line.split(",");
            if (parts.length==1){
                item.setCategory(parts[0]);
            } else if (parts.length > 1){
                if(parts[2].equals("")){
                    continue;
                }
                if (parts[10].contains("00")){
                    parts[9] = parts[9].substring(1) + parts[10].substring(0,parts[10].length()-2);
                    parts[9] = parts[9].replaceAll("\\s+","");
                    for (int i = 10; i < parts.length-1; i++){
                        parts[i] = parts[i+1];
                    }
                }
                item.setItemName(parts[1]);
                item.setSKU(parts[2]);
                ShipItem.setSKU(parts[2]);
                ShipItem.setQuantityOrdered(Integer.parseInt(parts[3]));
                ShipItem.setQuantityDelivered(Integer.parseInt(parts[4]));
                item.setSaleUnit(parts[5]);
                item.setDeliveryMethod(parts[6]);
                item.setMultiplier(Integer.parseInt(parts[7]));
                item.setPrice(Double.parseDouble(parts[8].substring(1)));
                ShipItem.setExtendedPrice(Double.parseDouble(parts[9].substring(1)));
                item.setStorageCategory(parts[10]);
                ShipItem.setInvoiceNum(Integer.parseInt(parts[11]));
                shipment.setInvoiceNum(Integer.parseInt(parts[11]));
                String desc = new String();
                for (int i = 12; i < parts.length;i++){
                    desc += parts[i].replaceAll("\"","");
                }
                desc = desc.replaceAll("\'","`");
                item.setDescription(desc);
                item.setCurrent_Inventory(item.getMultiplier()*ShipItem.getQuantityDelivered());
                manager.INSERT(shipment);
                manager.INSERT(ShipItem);
                manager.INSERT(item);
            } else {
                continue;
            }
        }
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){

        try{
        //Parent root = FXMLLoader.load(getClass().getResource("FXML/OrderPage.fxml"));
        /**
         * When an Order is placed, it appears in the Order Summary. When the Submit Order is pressed,
         *      The Order must store itself onto the database and change pages to Calculator page. Then,
         *      Calculator Page must pull that order information back into the Order Summary Column.
         * 
         *      Future Functionality, Add Item should take you back to OrderPage with Order Summary and update
         *      the item list
         */
        //Parent root = FXMLLoader.load(getClass().getResource("FXML/CalculatorPage.fxml"));
        /*         
        ConnectionManager myManager = new ConnectionManager(); 
        dropTables(myManager);
        System.out.println("\n\nSucsessfully DROPPED ALL TABLES\n\n");
        createTables(myManager);
        System.out.println("\n\nSucsessfully CREATED ALL TABLES\n\n");
        readMenuKey(myManager);
        System.out.println("\n\nSucsessfully added MenuKey.csv data to tables\n\n");
        readWeekSales(myManager,"CSV/FirstWeekSales.csv", -1);
        System.out.println("\n\nSucsessfully added FirstWeekSales.csv data to tables\n\n");
        readDayOrder(myManager,"CSV/FirstDayOrder.csv");
        System.out.println("\n\nSucsessfully added FirstDayOrder.csv data to tables\n\n");
        readWeekSales(myManager, "CSV/SecondWeekSales.csv", 6);
        System.out.println("\n\nSuccessfully added SecondWeekSales.csv data to tables\n\n");
        readWeekSales(myManager, "CSV/ThirdWeekSales.csv", 13);
        System.out.println("\n\nSuccessfully added ThirdWeekSales.csv data to tables\n\n");
        readWeekSales(myManager,"CSV/FourthWeekSales.csv", 20);
        System.out.println("\n\nSuccessfully added FourthWeekSales.csv data to tables\n\n"); 
            
        myManager.endConnection(); */
/*         ConnectionManager myManager = new ConnectionManager();
        myManager.DROPTABLE(new ItemInformation());
        myManager.createTable(new ItemInformation());
        readDayOrder(myManager,"CSV/FirstDayOrder.csv");
        System.out.println("\n\nSucsessfully added FirstDayOrder.csv data to tables\n\n");

        myManager.endConnection(); */

        Parent root = FXMLLoader.load(getClass().getResource("FXML/InventoryPage.fxml"));
        primaryStage.setTitle("Inventory Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
/*
        Stage SecondStage = new Stage();
        Parent Order = FXMLLoader.load(getClass().getResource("FXML/OrderPage.fxml"));
        SecondStage.setTitle("Order page");
        SecondStage.setScene(new Scene(Order));
        SecondStage.show();

        Stage ThirdStage = new Stage();
        Parent Calc = FXMLLoader.load(getClass().getResource("FXML/CalculatorPage.fxml"));
        ThirdStage.setTitle("Calculator Page");
        ThirdStage.setScene(new Scene(Calc));
        ThirdStage.show();
         
        Stage FourthStage = new Stage();
        Parent Calc = FXMLLoader.load(getClass().getResource("FXML/MenuKeyPage.fxml"));
        FourthStage.setTitle("Calculator Page");
        FourthStage.setScene(new Scene(Calc));
        FourthStage.show();*/

        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        
    }
}
