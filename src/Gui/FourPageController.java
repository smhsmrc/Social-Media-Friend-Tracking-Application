package Gui;

import BackGround.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FourPageController {

    @FXML
    private Label tempUserName,title,message;
    @FXML private Button unFollowers,showFollowers,returnPage;
    @FXML private ListView<String> liste;
    User user = new User();

    public void ShowFollowersButton() throws FileNotFoundException {
        title.setText("Takipçi Listeniz");
        liste.getItems().clear();
        user.FourPageShowFollowers(tempUserName.getText());

        if(User.Followers.size()==0){
            title.setText("Takipçiniz yok");
        }
        else{

            liste.getItems().addAll(User.Followers);
            User.Followers.clear();
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

    public void UpDateList() throws IOException {


        if(liste.getSelectionModel().getSelectedItem()==null){
            message.setText("Bir kullanıcı seçin");
        }
        else {
            liste.getItems().clear();

            user.FourPageShowFollowers(tempUserName.getText());
            ArrayList<String> temp=User.Followers;
            liste.getItems().addAll(temp);
            User.Followers.clear();
        }

    }
    public void UnFollowersButton() throws IOException {

        user.FourPageShowFollowers(tempUserName.getText());
        int botindex= liste.getSelectionModel().getSelectedIndex();
        if(botindex==-1){
            message.setText("Bir kullanıcı seçin");
        }
        else {
            String botUserName=User.Followers.get(botindex);
            user.FourPageUnFollowers(botUserName);
            UpDateList();
            message.setText(botUserName+" takipçiden çıkarıldı");
        }

    }



    public Label getTempUserName() {
        return tempUserName;
    }

}
