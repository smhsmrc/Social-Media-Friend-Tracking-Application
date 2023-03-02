package Gui;

import BackGround.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TwoPageController  {
    @FXML private Label tempUserName;
    @FXML private Button showFollowingList,returnPage,unfollow,updateList;
    @FXML private Label title,message;
   @FXML private ListView<String> liste;
    User user=new User();


   public void ShowFollowingListButton() {
       title.setText("Takip Ettiğiniz Kişiler");
       liste.getItems().clear();

       user.TwoPageShowFollowing(tempUserName.getText());


       if(User.Following.size()==0){
           title.setText("Takip Ettiğiniz bir hesap yok");
       }
       else{
           title.setText("Takip Ettiğiniz Kişiler");
           liste.getItems().addAll(User.Following);
           User.Following.clear();
       }

   }
   public void UpDateList() throws IOException {
       title.setText("Takip Ettiğiniz Kişiler");

       if(liste.getSelectionModel().getSelectedItem()==null){
        message.setText("Bir kullanıcı seçin");
       }
       else {
           liste.getItems().clear();


           user.TwoPageShowFollowing(tempUserName.getText());

           ArrayList<String> temp=User.Following;
           liste.getItems().addAll(temp);
           User.Following.clear();
       }

   }
   public void UnfollowButton() throws IOException {

       user.TwoPageShowFollowing(tempUserName.getText());
       int botindex= liste.getSelectionModel().getSelectedIndex();
       if(botindex==-1){
           message.setText("Lütfen bir kişi seçiniz");
       }
       else {
           message.setText(User.Following.get(botindex)+" Kişisi Takipten Çıkarıldı");
           String botUserName=User.Following.get(botindex);
           user.TwoPageUnfollow(botUserName);
           UpDateList();
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
