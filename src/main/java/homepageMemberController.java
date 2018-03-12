import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class homepageMemberController {
    @FXML
    private ListView<String> lstvwChatContacts;

    @FXML
    private Button btnLogOff;

    @FXML
    private ListView<String> lstvwChatText;

    @FXML
    private void initialize() {
        lstvwChatContacts.getItems().addAll("Loek Vogels", "Stefan Bergh", "Daphne van de Laar", "Kevin de Wit", "Hans Lousberg");
        lstvwChatText.getItems().addAll("Loek: Hallo", "Stefan: Hallo", "Loek: Hoe gaat het?", "Stefan: Goed hoor en met jou?");
    }

    public void onbtnLogOffClicked(){
        try {
            //Open and show the new homepageMember window
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();

            //Close the current window
            Stage thisStage = (Stage) btnLogOff.getScene().getWindow();
            thisStage.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
