import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class homepageGuestController {

    @FXML
    private Button btnLogOff;

    @FXML
    private ImageView imgImage;

    @FXML
    private Tab tabLiveStream;

    @FXML
    private ListView<String> lstvwEvents;

    //Set the images for the events... Needs to be automated when taken from the database
    private Image Paaspop = new Image("https://cdn.pastemagazine.com/www/system/images/photo_albums/every-2017-festival-poster-so-far-/large/paaspop-2017-lineup-poster.jpg?1384968217", 100, 150, false, false);
    private Image Bospop = new Image("http://www.livemusicandstuff.com/Resources/bospop2012bandli.jpeg", 100, 150, false, false);
    private Image Fools_Paradise = new Image("https://cdn.pastemagazine.com/www/system/images/photo_albums/every-2017-festival-poster-so-far-/large/fools-paradise-2017-lineup-poster.jpg?1384968217", 100, 150, false, false);
    private Image Mysteryland = new Image("https://i.pinimg.com/originals/6e/15/98/6e159841b835be2b1d8909a962ab2a20.jpg", 100, 150, false, false);

    private Image[] listOfEvents = {Paaspop, Bospop, Fools_Paradise, Mysteryland};

    @FXML
    private void initialize() {
        imgImage.setPreserveRatio(false);

        ObservableList<String> events = FXCollections.observableArrayList(
                "Paaspop", "Bospop", "Fools_Paradise", "Mysteryland");

        lstvwEvents.setItems(events);

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

        //Checking how to add buttons to the LiveStreamTab depending on the amount of events
        for (Object event:
             events) {
            System.out.println("Test " + event.toString());
        }
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
