package Gui;

import BackGround.Start;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SingInController {
    @FXML private Button ComplateSingIn;
    @FXML private TextField name;
    @FXML private TextField surName;
    @FXML private TextField ePosta;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private Button returnPage;
    @FXML Label message;


    public void ComplateSingInButton() throws IOException {
        Start start=new Start();
        if(!(name.getText().equals("usr") || surName.getText().equals("usr") || ePosta.getText().equals("usr") ||
                userName.getText().equals("usr") || password.getText().equals("usr"))){
            if(ePosta.getText().contains("@gmail.com") || ePosta.getText().contains("@marun.edu.tr") ||
                    ePosta.getText().contains("@hotmail.com") || ePosta.getText().contains("@yahoo.com")){
                int ctrl=start.singIn(name.getText(),surName.getText(),ePosta.getText(),userName.getText(),password.getText());
                if(ctrl==1){
                    message.setText("Kayıt Başarılı!!");
                }
                else if(ctrl==0){
                    message.setText("Hatalı Giriş Yaptınız!!");
                }
                else{
                    message.setText("Bu kullanıcı adı veya e-posata mevcut!!");
                }
            }
            else{
                message.setText("E-posta hatalı formdadır");
            }

        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("HATALI KAYIT\n(usr) anahtar kelimsei admin kayıdı içindir! ");
            alert.showAndWait();
        }
    }

    public void returnPageButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../main.fxml"));
        Parent root = loader.load();

        Stage stage=(Stage)returnPage.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }


}
