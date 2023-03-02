package Gui;

import BackGround.Friend;
import BackGround.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ThreePageController {
    @FXML
    private Label tempUserName,title,botName,message;
    @FXML private Button showFollowRequest,returnPage,confirm,reject;
    @FXML private ListView<String> liste;

    public Label getTempUserName() {
        return tempUserName;
    }

    static Friend friend=new Friend();
    User user=new User();
    public ArrayList<String> tempFrList=friend.frList;
    public void ShowFollowRequestButton() throws IOException {
        message.setText("");
        botName.setText("");
        liste.getItems().clear();
        title.setText("Takip İstekleri");
        friend.FriendList();


        liste.getItems().addAll(friend.frList);
        User.Following.clear();

    }



    public void ConfirmButton() throws IOException {
        if(liste.getSelectionModel().getSelectedItem()==null){
            message.setText("Takip Listesini Görüntüleyin");
        }
        else {
            int botindex= liste.getSelectionModel().getSelectedIndex();
            user.ThreePageConfirm(tempUserName.getText(),botindex,friend.frList);
            botName.setText(friend.frList.get(botindex));
            message.setText("Takip isteği kabul edildi");
            friend.frList.remove(botindex);
            liste.getItems().clear();
            liste.getItems().addAll(friend.frList);
        }


    }

    public void RejectButton() throws IOException {
        if(liste.getSelectionModel().getSelectedItem()==null){
            message.setText("Takip Listesini Görüntüleyin");
        }
        else {
            int botindex= liste.getSelectionModel().getSelectedIndex();
            botName.setText(friend.frList.get(botindex));
            message.setText("Takip isteği reddedildi");
            friend.frList.remove(botindex);
            liste.getItems().clear();
            liste.getItems().addAll(friend.frList);
        }


    }
    public void ReturnPageButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../login.fxml"));
        Parent root = loader.load();
        LoginController controller=loader.getController();
        controller.getUserName().setText(tempUserName.getText());
        Stage stage=(Stage)returnPage.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();

    }


}
