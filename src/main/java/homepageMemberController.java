import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.input.KeyCode.F;
import static javafx.scene.input.KeyCode.N;

public class homepageMemberController {
    @FXML
    private ListView<String> lstvwChatContacts;

    @FXML
    private Button btnLogOff;

    @FXML
    private Button btnSend;

    @FXML
    private TextField txtfldTextEntry;

    @FXML
    //Set the listview
    private ListView<String> lstvwChatText;

    //Set the images... Needs to be automated when taken from the database
    private Image Loek_Vogels = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Stefan_Bergh = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Kevin_De_Wit = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Hans_Lousberg = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Daphne_Van_De_Laar = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Dennis_Aspers = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);

    //Put all the images in a Image array
    private Image[] listOfImages = {Loek_Vogels, Stefan_Bergh, Kevin_De_Wit, Hans_Lousberg, Daphne_Van_De_Laar, Dennis_Aspers};

    @FXML
    private void initialize() {

        ObservableList<String> items = FXCollections.observableArrayList(
                "Loek", "Stefan", "Kevin", "Hans", "Daphne", "Dennis");
        lstvwChatContacts.setItems(items);

        lstvwChatContacts.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    int i = 0;
                    for (String item :
                            items) {
                        name.equals(item);
                        imageView.setImage(listOfImages[i]);
                        setText(name);
                        setGraphic(imageView);
                        i++;
                    }
                }
            }
        });

        //Selects the first item in de listview
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                lstvwChatContacts.scrollTo(0);
                lstvwChatContacts.getSelectionModel().select(0);
            }
        });

        lstvwChatContacts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lstvwChatText.getItems().clear();
            }
        });

        lstvwChatText.getItems().addAll("Loek: Hallo", "Stefan: Hallo", "Loek: Hoe gaat het?", "Stefan: Goed hoor en met jou?");
    }

    public void onbtnLogOffClicked() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSendClicked() {
        lstvwChatText.getItems().add(txtfldTextEntry.getText());
        txtfldTextEntry.setText(null);
    }
}
