package Gui;

import BackGround.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class FivePageController{
    @FXML private Label tempUserName,name,surName,ePosta,userName,password,message;
    @FXML private Button showInfo,save,returnPage;
    @FXML private TextField nameField,surNameField,ePostaField,userNameField;
    @FXML private PasswordField passwordField,newPasswordField;


    public void ShowInfoButton(){

        userName.setText(tempUserName.getText());
        for (int i =0;i<User.dosya.size();i++){
            if(User.dosya.get(i).equals(tempUserName.getText())){
                name.setText(User.dosya.get(i-3));
                surName.setText(User.dosya.get(i-2));
                ePosta.setText(User.dosya.get(i-1));
                password.setText(User.dosya.get(i+1));
            }
        }
    }

    public void SaveButton() throws IOException {
        User user=new User();
        if(!nameField.getText().isEmpty()){
            user.Settings(tempUserName.getText(),nameField.getText(),-3);
            nameField.clear();
            message.setText("Kaydedildi");
        }
        else if(!surNameField.getText().isEmpty()){
            user.Settings(tempUserName.getText(),surNameField.getText(),-2);
            surNameField.clear();
            message.setText("Kaydedildi");
        }
        else if(!ePostaField.getText().isEmpty()){
            if(ePostaField.getText().contains("@gmail.com") || ePostaField.getText().contains("@marun.edu.tr") ||
                    ePostaField.getText().contains("@hotmail.com")){
                user.Settings(tempUserName.getText(),ePostaField.getText(),-1);
                ePostaField.clear();
                message.setText("Kaydedildi");
            }
            else {
                message.setText("Yeni E-Posta hatalı formdadır");
            }

        }
        else if(!userNameField.getText().isEmpty()){
            boolean ctrl = true;
            for(int i=0;i<User.dosya.size();i++){
                if(User.dosya.get(i).equals("usr")){
                    if(User.dosya.get(i).equals(userNameField.getText())){
                        System.out.println("asd");
                        ctrl=false;
                        break;
                    }
                }

            }
            if(ctrl){
                user.Settings(tempUserName.getText(),userNameField.getText(),0);
                user.ChangeFollowers(tempUserName.getText(),userNameField.getText());
                user.ChangeFollowing(tempUserName.getText(),userNameField.getText());
                tempUserName.setText(userNameField.getText());
                userNameField.clear();
                message.setText("Kaydedildi");
            }
            else{
                message.setText("Bu isimde bir kullanıcı adı mevcuttur!");
            }

        }
        else if(!passwordField.getText().isEmpty()){
            if(!newPasswordField.getText().isEmpty()){
                if(!passwordField.getText().equals(newPasswordField.getText())){
                    if(passwordField.getText().equals(password.getText())){
                        user.Settings(tempUserName.getText(),newPasswordField.getText(),1);
                        passwordField.clear();
                        newPasswordField.clear();
                        message.setText("Kaydedildi");
                    }
                    else{
                        message.setText("Mevcut şifreyi hatalı girdiniz!");
                    }
                }
                else {
                    message.setText("Yeni şifre eskisiyle aynı olamaz!");
                }

            }
            else{
                message.setText("Yen şifreyi giriniz");
            }

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
