package juegoberserk;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class FXMLDocument2Controller implements Initializable{
    @FXML
    private ImageView iBack, ipPersonaje1, ipPersonaje2, ipPersonaje3, ipPersonaje4, ipPersonaje5, ipPersonaje6, ipPersonaje7, ipPersonaje8, iPersonaje, iPersonaje2;
    @FXML
    private ImageView iEscenario1, iEscenario2, iEscenario3, iJugador, iFight;
    
    @FXML
    private Label lCharacter1, lCharacter2, lPs, lDefensa, lDaño, lCritico, lEvasion, lVs, lEscenario, lPs1, lDefensa1, lDaño1, lCritico1, lEvasion1;
    private ColorAdjust colorAdjust;
    private SepiaTone sepiaTone;
    private String personajeSeleccionado = "";
    private String escenarioSeleccionado = "";
    private boolean control, jugador, control2 = false;
    //private MediaPlayer mediaPlayer;

    @FXML
    void toFirstScreen(MouseEvent event) throws IOException {
        //mediaPlayer.stop();
        JuegoBerserk.setRoot("FXMLDocument");
    }
    
    protected void setEstadisticas(Label character, String nombre, String ps, String defensa, String daño, String evasion, String critico, Label l1, Label l2, Label l3, Label l4, Label l5) {
        character.setText(nombre);
        l1.setText("PS: " + ps);
        l2.setText("Defensa: " + defensa);
        l3.setText("Daño: " + daño);
        l4.setText("Evasión: " + evasion);
        l5.setText("Prob. Daño Crítico: " + critico); 
    }
    
    protected Label getL1() {
        if (!jugador)
            return lPs;
        else
            return lPs1;
    }
    protected Label getL2() {
        if (!jugador)
            return lDefensa;
        else
            return lDefensa1;
    }
    protected Label getL3() {
        if (!jugador)
            return lDaño;
        else
            return lDaño1;
    }
    protected Label getL4() {
        if (!jugador)
            return lEvasion;
        else
            return lEvasion1;
    }
    protected Label getL5() {
        if (!jugador)
            return lCritico;
        else
            return lCritico1;
    }
    
    @FXML
    void setPersonajeHover(MouseEvent event) {
        if (event.getSource().equals(ipPersonaje1)) {
            if (!personajeSeleccionado.equals("Guts"))
                ipPersonaje1.setEffect(colorAdjust); 
            if (!control) {
                setEstadisticas(getJugadorLabel(), "Guts", "600", "70", "150", "1%", "0%", getL1(), getL2(), getL3(), getL4(), getL5());
                getJugadorImagen().setImage(new Image("juegoberserk/Img/guts.jpg"));
            }
        }
        else if (event.getSource().equals(ipPersonaje2)) {
            if (!personajeSeleccionado.equals("Griffith"))
                ipPersonaje2.setEffect(colorAdjust); 
            if (!control) {
                setEstadisticas(getJugadorLabel(), "Griffith", "450", "30", "50", "35%", "30%", getL1(), getL2(), getL3(), getL4(), getL5());
                getJugadorImagen().setImage(new Image("juegoberserk/Img/griffith3.png"));            }
        }
        else if (event.getSource().equals(ipPersonaje3)) {
            if (!personajeSeleccionado.equals("Femto"))
                ipPersonaje3.setEffect(colorAdjust); 
            if (!control) {
                setEstadisticas(getJugadorLabel(), "Femto", "550", "10", "200", "15%", "0%", getL1(), getL2(), getL3(), getL4(), getL5());
                getJugadorImagen().setImage(new Image("juegoberserk/Img/femto.png"));
            }
        }
        else if (event.getSource().equals(ipPersonaje4)) {
            if (!personajeSeleccionado.equals("Nosferatu Zodd"))
                ipPersonaje4.setEffect(colorAdjust);
            if (!control) {
                setEstadisticas(getJugadorLabel(), "Nosferatu Zodd", "700", "70", "120", "0%", "1%", getL1(), getL2(), getL3(), getL4(), getL5());
                getJugadorImagen().setImage(new Image("juegoberserk/Img/zodd.jpg"));
            }
        }
        else if (event.getSource().equals(ipPersonaje5)) {
            if (!personajeSeleccionado.equals("Casca"))
                ipPersonaje5.setEffect(colorAdjust);
            if (!control) {
                getJugadorImagen().setImage(new Image("juegoberserk/Img/casca.jpg"));
                setEstadisticas(getJugadorLabel(), "Casca", "400", "20", "60", "40%", "50%", getL1(), getL2(), getL3(), getL4(), getL5());
            }
        }
        else if (event.getSource().equals(ipPersonaje6)) {
            if (!personajeSeleccionado.equals("Guts - Berserk"))
               ipPersonaje6.setEffect(colorAdjust); 
            if (!control) {
                setEstadisticas(getJugadorLabel(), "Guts - Berserk", "400", "75", "175", "15%", "0%", getL1(), getL2(), getL3(), getL4(), getL5());
                getJugadorImagen().setImage(new Image("juegoberserk/Img/gutsArmor.jpg"));
            }
        }
        else if (event.getSource().equals(ipPersonaje7)) {
            if (!personajeSeleccionado.equals("Void"))
                ipPersonaje7.setEffect(colorAdjust); 
            if (!control) {
                getJugadorImagen().setImage(new Image("juegoberserk/Img/void.jpg"));
                setEstadisticas(getJugadorLabel(), "Void", "500", "0", "100", "50%", "10%", getL1(), getL2(), getL3(), getL4(), getL5());
            }
        }
        else if (event.getSource().equals(ipPersonaje8)) {
            if (!personajeSeleccionado.equals("Skull Knight"))
                ipPersonaje8.setEffect(colorAdjust); 
            if (!control) {
                getJugadorImagen().setImage(new Image("juegoberserk/Img/skullNight.jpg"));
                setEstadisticas(getJugadorLabel(), "Skull Knight", "700", "80", "65", "10%", "60%", getL1(), getL2(), getL3(), getL4(), getL5());
            }
        }
        else if (event.getSource().equals(iEscenario1)) {
            if (!escenarioSeleccionado.equals("escenario1Grande.jpg")) {
                iEscenario1.setEffect(colorAdjust); 
                if (!control2)
                    lEscenario.setText("Eclipse");  
            }
        }
        else if (event.getSource().equals(iEscenario2)) {
            if (!escenarioSeleccionado.equals("shiva2.jpg")) {
                iEscenario2.setEffect(colorAdjust);
                if (!control2)
                    lEscenario.setText("Shiva");
            }
        }
        else if (event.getSource().equals(iEscenario3)) {
            if (!escenarioSeleccionado.equals("prado.jpg")) {
                iEscenario3.setEffect(colorAdjust); 
                if (!control2)
                    lEscenario.setText("Prado"); 
            }
        }
        else if (event.getSource().equals(iBack)) {
            iBack.setImage(new Image("juegoberserk/Img/back2.png"));
        }
        else if (event.getSource().equals(iJugador)) {
           iJugador.setEffect(colorAdjust);  
        }
        else if (event.getSource().equals(iFight)) {
            iFight.setImage(new Image("juegoberserk/Img/fightButtonHover.png"));
        }
    }
    
    @FXML
    void setPersonajeEndHover(MouseEvent event) {  
        if (event.getSource().equals(ipPersonaje1)) {
            if (!ipPersonaje1.getEffect().equals(sepiaTone))
                ipPersonaje1.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje2)) {
            if (!ipPersonaje2.getEffect().equals(sepiaTone))
                ipPersonaje2.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje3)) {
            if (!ipPersonaje3.getEffect().equals(sepiaTone))
                ipPersonaje3.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje4)) {
            if (!ipPersonaje4.getEffect().equals(sepiaTone))
                ipPersonaje4.setEffect(null);
        }
        else if (event.getSource().equals(ipPersonaje5)) {
            if (!ipPersonaje5.getEffect().equals(sepiaTone))
                ipPersonaje5.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje6)) {
            if (!ipPersonaje6.getEffect().equals(sepiaTone))
                ipPersonaje6.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje7)) {
            if (!ipPersonaje7.getEffect().equals(sepiaTone))
                ipPersonaje7.setEffect(null); 
        }
        else if (event.getSource().equals(ipPersonaje8)) {
            if (!ipPersonaje8.getEffect().equals(sepiaTone))
                ipPersonaje8.setEffect(null); 
        }
        else if (event.getSource().equals(iEscenario1)) {
            if (!iEscenario1.getEffect().equals(sepiaTone))
                iEscenario1.setEffect(null); 
        }
        else if (event.getSource().equals(iEscenario2)) {
            if (!iEscenario2.getEffect().equals(sepiaTone))
                iEscenario2.setEffect(null); 
        }
        else if (event.getSource().equals(iEscenario3)) {
            if (!iEscenario3.getEffect().equals(sepiaTone))
                iEscenario3.setEffect(null); 
        }
        else if (event.getSource().equals(iJugador)) {
           iJugador.setEffect(null); 
        }
        else if (event.getSource().equals(iBack)) {
            iBack.setImage(new Image("juegoberserk/Img/back.png"));
        }
        else if (event.getSource().equals(iFight)) {
            iFight.setImage(new Image("juegoberserk/Img/fightButton.png"));
        }
    }
    
    @FXML
    void pelear(MouseEvent event) throws IOException {
        if (!personajeSeleccionado.equals("") && iPersonaje2.getImage() != null && !escenarioSeleccionado.equals("")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument3.fxml"));
            Parent root = fxmlLoader.load();
            FXMLDocument3Controller c = fxmlLoader.getController();
            c.setEscenario(escenarioSeleccionado);
            c.setPersonajes(lCharacter1.getText(), lCharacter2.getText(), getPs(lPs.getText()), getDefensa(lDefensa.getText()), getDaño(lDaño.getText()), getEvasion(lEvasion.getText()), getCritico(lCritico.getText()), getPs(lPs1.getText()), getDefensa(lDefensa1.getText()), getDaño(lDaño1.getText()), getEvasion(lEvasion1.getText()), getCritico(lCritico1.getText()));
            JuegoBerserk.setRoot("FXMLDocument3");
        }           
    }
    
    protected double getPs(String ps) {
       return Double.parseDouble(ps.replace("PS:", ""));  
    }
    
    protected double getDefensa(String ps) {
       return Double.parseDouble(ps.replace("Defensa:", ""));  
    }
     
    protected double getDaño(String ps) {
       return Double.parseDouble(ps.replace("Daño:", ""));  
    }
    
    protected double getEvasion(String ps) {
       String aux = ps.replace("Evasión:", "");
       return Double.parseDouble(aux.replace("%", ""));
    }
     
    protected double getCritico(String ps) {
       String aux = ps.replace("Prob. Daño Crítico:", ""); 
       return Double.parseDouble(aux.replace("%", ""));
    }
    
    protected ImageView getJugadorImagen() {
        if (!jugador)
            return iPersonaje;
        else
            return iPersonaje2;
    }
    
    protected Label getJugadorLabel() {
       if (!jugador)
            return lCharacter1;
        else
            return lCharacter2; 
    }
    
    @FXML void onPersonajeClick(MouseEvent event) {
        ipPersonaje1.setEffect(null);
        ipPersonaje2.setEffect(null);
        ipPersonaje3.setEffect(null);
        ipPersonaje4.setEffect(null);
        ipPersonaje5.setEffect(null);
        ipPersonaje6.setEffect(null);
        ipPersonaje7.setEffect(null);
        ipPersonaje8.setEffect(null);
        
        if (event.getSource().equals(ipPersonaje1)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Guts vs ", "Guts", ipPersonaje1, "juegoberserk/Img/guts.jpg", "Guts", "600", "70", "150", "1%", "0%");
        }
        if (event.getSource().equals(ipPersonaje2)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Griffith vs ", "Griffith", ipPersonaje2, "juegoberserk/Img/griffith3.png", "Griffith", "450", "30", "50", "35%", "30%");
        }
        if (event.getSource().equals(ipPersonaje3)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Femto vs ", "Femto", ipPersonaje3, "juegoberserk/Img/femto.png", "Femto", "550", "10", "200", "15%", "0%");
        }
        if (event.getSource().equals(ipPersonaje4)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Nosferatu Zodd vs ", "Nosferatu Zodd", ipPersonaje4, "juegoberserk/Img/zodd.jpg", "Nosferatu Zodd", "700", "70", "120", "0%", "1%");
        }
        if (event.getSource().equals(ipPersonaje5)) { 
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Casca vs ", "Casca", ipPersonaje5, "juegoberserk/Img/casca.jpg", "Casca", "400", "20", "60", "40%", "50%");
        }
        if (event.getSource().equals(ipPersonaje6)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Guts Berserk vs ", "Guts - Berserk", ipPersonaje6, "juegoberserk/Img/gutsArmor.jpg", "Guts - Berserk", "400", "75", "175", "15%", "0%");
        }
        if (event.getSource().equals(ipPersonaje7)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Void vs ", "Void", ipPersonaje7, "juegoberserk/Img/void.jpg", "Void", "500", "0", "100", "50%", "10%");
        }
        if (event.getSource().equals(ipPersonaje8)) {
            personajeSeleccionado(getJugadorImagen(), getJugadorLabel(), "Skull Knight vs ", "Skull Knight", ipPersonaje8, "juegoberserk/Img/skullNight.jpg", "Skull Knight", "700", "80", "65", "10%", "60%");
        }
         if (event.getSource().equals(iJugador)) {
           if (jugador)
               jugador = false;
           else
               jugador = true;
        }
        control = true;
    }
    
    protected void personajeSeleccionado(ImageView personaje, Label label, String vsText, String pSeleccionado, ImageView image1, String image, String es1, String es2, String es3, String es4, String es5, String es6) {
        personajeSeleccionado = pSeleccionado;
        image1.setEffect(sepiaTone); 
        personaje.setImage(new Image(image));
        setEstadisticas(label, es1, es2, es3, es4, es5, es6, getL1(), getL2(), getL3(), getL4(), getL5());
        lVs.setText(lCharacter1.getText() + " vs " + lCharacter2.getText());
    }
    
    @FXML public void onJugadorClick(MouseEvent event) {
        if (!jugador) {
            iJugador.setImage(new Image("juegoberserk/Img/dobleFlecha2.png"));
            jugador = true;
        }
        else {
            iJugador.setImage(new Image("juegoberserk/Img/dobleFlecha.png"));
            jugador = false;
        }
    }
    
     @FXML
    void onEscenarioClick(MouseEvent event) {
        iEscenario1.setEffect(null);
        iEscenario2.setEffect(null);
        iEscenario3.setEffect(null);
        
        if (event.getSource().equals(iEscenario1)) {
            escenarioSeleccionado = "escenario1Grande.jpg";
            iEscenario1.setEffect(sepiaTone);
            lEscenario.setText("Eclipse");
        }
         if (event.getSource().equals(iEscenario2)) {
            escenarioSeleccionado = "shiva2.jpg";
            iEscenario2.setEffect(sepiaTone);
            lEscenario.setText("Shiva");
        }
          if (event.getSource().equals(iEscenario3)) {
            escenarioSeleccionado = "prado.jpg";
            iEscenario3.setEffect(sepiaTone);
            lEscenario.setText("Prado");
        }
        control2 = true;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*String bip = "src/juegoberserk/Sound/BerserkMixed.wav";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();*/
        
        lCharacter1.setTextFill(Color.WHITE);
        lCharacter2.setTextFill(Color.WHITE);
        lPs.setTextFill(Color.WHITE);
        lDefensa.setTextFill(Color.WHITE);
        lDaño.setTextFill(Color.WHITE);
        lCritico.setTextFill(Color.WHITE);
        lEvasion.setTextFill(Color.WHITE);
        lPs1.setTextFill(Color.WHITE);
        lDefensa1.setTextFill(Color.WHITE);
        lDaño1.setTextFill(Color.WHITE);
        lCritico1.setTextFill(Color.WHITE);
        lEvasion1.setTextFill(Color.WHITE);
        colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        sepiaTone = new SepiaTone();
        sepiaTone.setLevel(100);
        lVs.setTextFill(Color.WHITE);
        lEscenario.setTextFill(Color.WHITE);
    }

}
