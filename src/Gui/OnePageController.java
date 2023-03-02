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

public class OnePageController {
    @FXML private Label tempUserName;
    @FXML private Label message,title;
    @FXML private Button createBotUser,returnPage,followButton;

    Friend friend=new Friend();
    User user=new User();
    @FXML private ListView<String> liste;
        public void CreateBotUserButton(){
            liste.getItems().clear();
            title.setText("Kullanıcılar:");
            friend.FriendList();
            liste.getItems().addAll(Friend.frList);

        }

    public void FollowButton() throws IOException {
        int botindex= liste.getSelectionModel().getSelectedIndex();
        if(liste.getSelectionModel().getSelectedItem()==null){
            message.setText("Takip için bot seçin");
        }

        else {

            String botUserName=Friend.frList.get(botindex);
            user.OnePage(botUserName,tempUserName.getText());
            message.setText(botUserName+" kişisi takip edildi");
            Friend.frList.remove(botindex);
            liste.getItems().clear();
            liste.getItems().addAll(Friend.frList);
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



    public Label getTempUserName() {
        return tempUserName;
    }


}

