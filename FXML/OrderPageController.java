package FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class OrderPageController {

    @FXML
    private ListView<String> ListOfOrders;

    @FXML
    private Label Total;

    @FXML
    private Button btn501;
    private Integer num501 = 2;

    @FXML
    private Button btn502;
    private Integer num502 = 2;

    @FXML
    private Button btn503;
    private Integer num503 = 2;

    @FXML
    private Button btn504;
    private Integer num504 = 2;

    @FXML
    private Button btn505;
    private Integer num505 = 2;

    @FXML
    private Button btn506;
    private Integer num506 = 2;

    @FXML
    private Button btn507;
    private Integer num507 = 2;

    @FXML
    private Button btn508;
    private Integer num508 = 2;

    @FXML
    private Button btn509;
    private Integer num509 = 2;

    @FXML
    private Button btn510;
    private Integer num510 = 2;

    @FXML
    private Button btn511;
    private Integer num511 = 2;

    @FXML
    private Button btn512;
    private Integer num512 = 2;

    @FXML
    private Button btn513;
    private Integer num513 = 2;
    
    @FXML
    private Button btn514;
    private Integer num514 = 2;

    @FXML
    private Button btn515;
    private Integer num515 = 2;

    @FXML
    private Button btn516;
    private Integer num516 = 2;

    @FXML
    private Button btn517;
    private Integer num517 = 2;

    @FXML
    private Button btn518;
    private Integer num518 = 2;

    @FXML
    private Button btn519;
    private Integer num519 = 2;

    @FXML
    private Button btnCLEAR;

    @FXML
    private Button btnSubmit;

    @FXML
    void ClearSummary(ActionEvent event) {
        ListOfOrders.getItems().clear();
    }

    @FXML
    void SubmitOrder(ActionEvent event) {
        /*
            SOMEHOW SEND THIS TO THE DATABASE...

        */
    }

    @FXML
    void send501(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn501.getText());
        }
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn501.getText())){
                    ListOfOrders.getItems().set(index, btn501.getText() + " x" + num501.toString() /*+ "  " + price of item * num501f*/);
                    num501++;
                    /**
                     * Update Total Price Total = Price of Item * num501;
                     * Total.setItem(Total.getText() + Price of Item * num501)
                     */
                    return;
                }
           }
           ListOfOrders.getItems().add(btn501.getText());
        } 

    }

    @FXML
    void send502(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn502.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn502.getText())){
                    ListOfOrders.getItems().set(index, btn502.getText() + " x" + num502.toString());
                    num502++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn502.getText());
        }
    }

    @FXML
    void send503(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn503.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn503.getText())){
                    ListOfOrders.getItems().set(index, btn503.getText() + " x" + num503.toString());
                    num503++;
                    return;
                }

           }
           ListOfOrders.getItems().add(btn503.getText());
        }
    }

    @FXML
    void send504(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn504.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn504.getText())){
                    ListOfOrders.getItems().set(index, btn504.getText() + " x" + num504.toString());
                    num504++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn504.getText());
        }
    }

    @FXML
    void send505(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn505.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn505.getText())){
                    ListOfOrders.getItems().set(index, btn505.getText() + " x" + num505.toString());
                    num505++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn505.getText());
        }
    }

    @FXML
    void send506(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn506.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn506.getText())){
                    ListOfOrders.getItems().set(index, btn506.getText() + " x" + num506.toString());
                    num506++;
                    return;
                }
                
           }
           ListOfOrders.getItems().add(btn506.getText());
        }
    }

    @FXML
    void send507(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn507.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn507.getText())){
                    ListOfOrders.getItems().set(index, btn507.getText() + " x" + num507.toString());
                    num507++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn507.getText());
        }
    }

    @FXML
    void send508(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn508.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn508.getText())){
                    ListOfOrders.getItems().set(index, btn508.getText() + " x" + num508.toString());
                    num508++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn508.getText());
        }
    }

    @FXML
    void send509(ActionEvent event){
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn509.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn509.getText())){
                    ListOfOrders.getItems().set(index, btn509.getText() + " x" + num509.toString());
                    num509++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn509.getText());
        }
    }

    @FXML
    void send510(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn510.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn510.getText())){
                    ListOfOrders.getItems().set(index, btn510.getText() + " x" + num510.toString());
                    num510++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn510.getText());
        }
    }

    @FXML
    void send511(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn511.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn511.getText())){
                    ListOfOrders.getItems().set(index, btn511.getText() + " x" + num511.toString());
                    num511++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn511.getText());
        }
    }

    @FXML
    void send512(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn512.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn512.getText())){
                    ListOfOrders.getItems().set(index, btn512.getText() + " x" + num512.toString());
                    num512++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn512.getText());
        }
    }

    @FXML
    void send513(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn513.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn513.getText())){
                    ListOfOrders.getItems().set(index, btn513.getText() + " x" + num513.toString());
                    num513++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn513.getText());
        }
    }

    @FXML
    void send514(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn514.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn514.getText())){
                    ListOfOrders.getItems().set(index, btn514.getText() + " x" + num514.toString());
                    num514++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn514.getText());
        }
    }

    @FXML
    void send515(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn515.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn515.getText())){
                    ListOfOrders.getItems().set(index, btn515.getText() + " x" + num515.toString());
                    num515++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn515.getText());
        }
    }

    @FXML
    void send516(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn516.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn516.getText())){
                    ListOfOrders.getItems().set(index, btn516.getText() + " x" + num516.toString());
                    num516++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn516.getText());
        }
    }

    @FXML
    void send517(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn517.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn517.getText())){
                    ListOfOrders.getItems().set(index, btn517.getText() + " x" + num517.toString());
                    num517++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn517.getText());
        }
    }

    @FXML
    void send518(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn518.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn518.getText())){
                    ListOfOrders.getItems().set(index, btn518.getText() + " x" + num518.toString());
                    num518++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn518.getText());
        }
    }

    @FXML
    void send519(ActionEvent event) {
        if(ListOfOrders.getItems().isEmpty()){
            ListOfOrders.getItems().add(btn519.getText());
        } 
        else{
            int index = -1;
            for(String item : ListOfOrders.getItems()){
                index++;
                if(item.contains(btn519.getText())){
                    ListOfOrders.getItems().set(index, btn519.getText() + " x" + num519.toString());
                    num519++;
                    return;
                }
           }
           ListOfOrders.getItems().add(btn519.getText());
        }
    }

}
