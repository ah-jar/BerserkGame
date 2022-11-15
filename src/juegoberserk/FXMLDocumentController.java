package juegoberserk;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView iStart;
    
    //private MediaPlayer mediaPlayer;

    @FXML
    void onStartHover(MouseEvent event) {
        iStart.setImage(new Image("juegoberserk/Img/startButton2.png"));
    }  
    
    @FXML
    void onEndHover(MouseEvent event) {
        iStart.setImage(new Image("juegoberserk/Img/startButton.png"));
    } 
    
    @FXML
    void toSecondScreen(MouseEvent event) throws IOException {
       //mediaPlayer.stop();
       JuegoBerserk.setRoot("FXMLDocument2");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*String bip = "src/juegoberserk/Sound/BerserkMixed.wav";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();*/
        ObservableAux.inicializar();
    }
    
}
