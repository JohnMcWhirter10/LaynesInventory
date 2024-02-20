package FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CalculatorPageController implements Initializable {

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @FXML
    private Label CashTendered;

    @FXML
    private ListView<String> ListOfOrders;

    @FXML
    private Label Total;

    @FXML
    private Button btn;

    @FXML
    private Button btnFIVE;

    @FXML
    private Button btnFOUR;

    @FXML
    private Button btnONE;

    @FXML
    private Button btnPERIOD;

    @FXML
    private Button btnSEVEN;

    @FXML
    private Button btnSIX;

    @FXML
    private Button btnTHREE;

    @FXML
    private Button btnTWO;

    @FXML
    private Button btnZERO;

    @FXML
    void sendEIGHT(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "8";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendFIVE(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "5";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendFOUR(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "4";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendNINE(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "9";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendONE(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "1";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendCLEAR(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        CashTendered.setText("$0.00");
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendSEVEN(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "7";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendSIX(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "6";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendTHREE(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "3";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendTWO(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "2";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }

    @FXML
    void sendZERO(ActionEvent event) {
        System.out.println("Current Cash Tendered: " + CashTendered.getText());
        String Cash = CashTendered.getText().substring(1);
        String[] parts = {Cash.substring(0, Cash.length()-3), Cash.substring(Cash.length()-2)};
        String toSend;
        if(parts[0].equals("0")){
            toSend = "$" + parts[1].substring(0,1) + ".";
        }
        else{
            toSend = "$" + parts[0] + parts[1].substring(0,1) + ".";
        }
        toSend += parts[1].substring(1) + "0";
        CashTendered.setText(toSend);
        System.out.println("New Cash Tendered: " + CashTendered.getText());
    }


}
