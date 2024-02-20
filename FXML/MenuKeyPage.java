package FXML;

import java.net.ConnectException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Connection.ConnectionManager;
import TableObject.MenuItemInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuKeyPage implements Initializable{

    ObservableList<MenuItemInformation> MenuKeyList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        ConnectionManager myManager = new ConnectionManager();

        MenuItemInformation MenuKeyRow = new MenuItemInformation();
        ResultSet result = myManager.selectStar(MenuKeyRow);

        try {
            while(result.next()){
                MenuItemInformation toAdd = new MenuItemInformation();
                toAdd.setMenuID(result.getInt(MenuKeyRow.attributes()[0]));
                toAdd.setMenuItemName(result.getString(MenuKeyRow.attributes()[1]));
                toAdd.setPrice(result.getDouble(MenuKeyRow.attributes()[2]));
                toAdd.setIngredient(result.getString(MenuKeyRow.attributes()[3]));

                System.out.println("toAdd: " + toAdd.toString());
                MenuKeyList.add(toAdd);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            myManager.endConnection();
            System.exit(0);
        }

        MenuIDCol.setCellValueFactory(new PropertyValueFactory<>("MenuID"));
        DescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Ingredient"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("MenuItemName"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        MenuKeyTable.setItems(MenuKeyList);
    }

    @FXML
    private TableColumn<MenuItemInformation, String> DescriptionCol;

    @FXML
    private TableColumn<MenuItemInformation, Integer> MenuIDCol;

    @FXML
    private TextField MenuIDEntry;

    @FXML
    private TableView<MenuItemInformation> MenuKeyTable;

    @FXML
    private TableColumn<MenuItemInformation, String> NameCol;

    @FXML
    private TextField NameEntry;

    @FXML
    private TableColumn<Menu, Double> PriceCol;

    @FXML
    private TextField PriceEntry;

    @FXML
    private Button btnUpdate;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    void UpdateMenuKey(ActionEvent event) {

    }


}
