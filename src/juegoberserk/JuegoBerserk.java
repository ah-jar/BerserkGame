package juegoberserk;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class JuegoBerserk extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXMLDocument"), 660, 340);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("BerserkGame - v1.3.0 - by Álvaro (Bl4ckV)");
        stage.getIcons().add(new Image(JuegoBerserk.class.getResourceAsStream("/juegoberserk/Img/berserk.png")));
        stage.show();   
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JuegoBerserk.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    } 
}
