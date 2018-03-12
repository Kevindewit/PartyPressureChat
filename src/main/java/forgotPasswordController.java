import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.*;
import javafx.stage.Stage;

import java.io.IOException;

public class forgotPasswordController {
    @FXML
    private Button btnSendPassword;

    @FXML
    private TextField txtfldEmail;

    @FXML
    private ImageView imgImage;

    @FXML
    private Button btnBack;


    public void btnSendPasswordClicked(){

    }

    public void btnBackClicked(){
        try {
            //Open and show the new homepageMember window
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();

            //Close the current window
            Stage thisStage = (Stage) btnBack.getScene().getWindow();
            thisStage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
