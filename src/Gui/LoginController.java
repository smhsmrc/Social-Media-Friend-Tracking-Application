package Gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController  {
    @FXML private Button one;
    @FXML private Button two;
    @FXML private Button three;
    @FXML private Button four;
    @FXML private Button five;
    @FXML private Button returnPage;
    @FXML private Label userName;
    @FXML private Label tempUserName;
    @FXML private ImageView foto;


  //  Image image = new Image(getClass().getResourceAsStream("marmaralogo.png"));


    public void oneButton() throws IOException {
        tempUserName.setText(userName.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../onePage.fxml"));
        Parent root=loader.load();
        OnePageController controller=loader.getController();
        controller.getTempUserName().setText(tempUserName.getText());
        Stage stage=(Stage)one.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }

    public void twoButton() throws IOException {

        tempUserName.setText(userName.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../twoPage.fxml"));
        Parent root = loader.load();
        TwoPageController controller=loader.getController();
        controller.getTempUserName().setText(tempUserName.getText());
        Stage stage=(Stage)two.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();

    }
    public void threeButton() throws IOException {
        tempUserName.setText(userName.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../threePage.fxml"));
        Parent root = loader.load();
        ThreePageController controller=loader.getController();
        controller.getTempUserName().setText(tempUserName.getText());
        Stage stage=(Stage)three.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }
    public void fourButton() throws IOException {
        tempUserName.setText(userName.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fourPage.fxml"));
        Parent root = loader.load();
        FourPageController controller=loader.getController();
        controller.getTempUserName().setText(tempUserName.getText());
        Stage stage=(Stage)four.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }
    public void fiveButton() throws IOException {
        tempUserName.setText(userName.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fivePage.fxml"));
        Parent root = loader.load();
        FivePageController controller=loader.getController();
        controller.getTempUserName().setText(tempUserName.getText());
        Stage stage=(Stage)five.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }
    public void returnPageButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../main.fxml"));
        Parent root = loader.load();

        Stage stage=(Stage)returnPage.getScene().getWindow();
        Scene scene=new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
    }

    public Label getUserName() {
        return userName;
    }

    public void setUserName(Label userName) {
        this.userName = userName;
    }



}