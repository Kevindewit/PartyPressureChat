import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class homepageMemberController {
    @FXML
    private ListView<String> lstvwChatContacts;

    @FXML
    private ListView<String> lstvwEvents;

    @FXML
    private Button btnLogOff;

    @FXML
    private Tab tabLiveStream;

    @FXML
    private Button btnSend;

    @FXML
    private TextField txtfldTextEntry;

    @FXML
    private ImageView imgImage;

    @FXML
    //Set the listview
    private ListView<String> lstvwChatText;

    //Set the images for the chatcontacts... Needs to be automated when taken from the database
    private Image Loek_Vogels = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Stefan_Bergh = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Kevin_De_Wit = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Hans_Lousberg = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Daphne_Van_De_Laar = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);
    private Image Dennis_Aspers = new Image("https://c-sf.smule.com/z0/account/icon/v4_defpic.png", 50, 50, false, false);


    //Set the images for the events... Needs to be automated when taken from the database
    private Image Paaspop = new Image("https://cdn.pastemagazine.com/www/system/images/photo_albums/every-2017-festival-poster-so-far-/large/paaspop-2017-lineup-poster.jpg?1384968217", 100, 150, false, false);
    private Image Bospop = new Image("http://www.livemusicandstuff.com/Resources/bospop2012bandli.jpeg", 100, 150, false, false);
    private Image Fools_Paradise = new Image("https://cdn.pastemagazine.com/www/system/images/photo_albums/every-2017-festival-poster-so-far-/large/fools-paradise-2017-lineup-poster.jpg?1384968217", 100, 150, false, false);
    private Image Mysteryland = new Image("https://i.pinimg.com/originals/6e/15/98/6e159841b835be2b1d8909a962ab2a20.jpg", 100, 150, false, false);

    private Image[] listOfEvents = {Paaspop, Bospop, Fools_Paradise, Mysteryland};

    //Put all the images in a Image array
    private Image[] listOfChats = {Loek_Vogels, Stefan_Bergh, Kevin_De_Wit, Hans_Lousberg, Daphne_Van_De_Laar, Dennis_Aspers};

    @FXML
    private void initialize() {


        imgImage.setPreserveRatio(false);

        ObservableList<String> chats = FXCollections.observableArrayList(
                "Loek", "Stefan", "Kevin", "Hans", "Daphne", "Dennis");

        ObservableList<String> events = FXCollections.observableArrayList(
                "Paaspop", "Bospop", "Fools_Paradise", "Mysteryland");

        lstvwChatContacts.setItems(chats);
        lstvwEvents.setItems(events);

        lstvwChatContacts.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("Loek"))
                        imageView.setImage(listOfChats[0]);
                    else if(name.equals("Stefan"))
                        imageView.setImage(listOfChats[1]);
                    else if(name.equals("Kevin"))
                        imageView.setImage(listOfChats[2]);
                    else if(name.equals("Hans"))
                        imageView.setImage(listOfChats[3]);
                    else if(name.equals("Daphne"))
                        imageView.setImage(listOfChats[4]);
                    else if(name.equals("Dennis"))
                        imageView.setImage(listOfChats[5]);
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });

        lstvwEvents.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("Paaspop"))
                        imageView.setImage(listOfEvents[0]);
                    else if(name.equals("Bospop"))
                        imageView.setImage(listOfEvents[1]);
                    else if(name.equals("Fools_Paradise"))
                        imageView.setImage(listOfEvents[2]);
                    else if(name.equals("Mysteryland"))
                        imageView.setImage(listOfEvents[3]);
                    setText(name + " BUY YOUR TICKETS NOW!!!");
                    setGraphic(imageView);
                }
            }
        });

        /**
        Button[] buttons = new Button[0];
        int i = 0;
        for (String event:
             events) {
            i++;
            Button btn = new Button("Button " + i);
            buttons.
        }
         **/

        //Selects the first item in de listview
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                lstvwChatContacts.scrollTo(0);
                lstvwChatContacts.getSelectionModel().select(0);
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
