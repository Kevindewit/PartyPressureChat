import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;


public class loginController {
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLoginAsGuest;

    @FXML
    private TextField txtfldUsername;

    @FXML
    private PasswordField psswrdfldPassword;

    @FXML
    private Label lblForgotPassword;

    @FXML
    private ImageView imgImage;


    public void btnLoginClicked() {
        try {
            //Open and show the new homepageMember window
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("homepageMemberUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Homepage for Members");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

            //Close the current window
            Stage thisStage = (Stage) btnLogin.getScene().getWindow();
            thisStage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnLoginAsGuestClicked() {
        try {
            //Open and show the new homepageGuest window
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("homepageGuestUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Homepage for Guests");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

            //Close the current window
            Stage thisStage = (Stage) btnLoginAsGuest.getScene().getWindow();
            thisStage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lblForgotPasswordClicked() {

    }
}
