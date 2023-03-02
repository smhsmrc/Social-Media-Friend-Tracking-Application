package Gui;
import BackGround.Start;
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

public class MainController  {

    @FXML private Button logIn,singIn;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private Label message;
    @FXML private Label tempUserName;

    public void LoginButton() throws IOException {
        Start start = new Start();
        tempUserName.setText(userName.getText());
        boolean ctrl = start.login(userName.getText(), password.getText());
        if (ctrl) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../login.fxml"));
            Parent root = loader.load();
            LoginController controller = loader.getController();
            controller.getUserName().setText(tempUserName.getText());
            Stage stage = (Stage) logIn.getScene().getWindow();
            Scene scene = new Scene(root, 700, 500);
            stage.setScene(scene);
            stage.show();
        } else {
            message.setText("Kullanıcı adı veya şifre hatalı!!");
        }

    }

    public void SingInButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../singin.fxml"));
        Parent root = loader.load();
        Stage stage=(Stage)singIn.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();

    }

}