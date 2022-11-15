package juegoberserk;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class FXMLDocument3Controller implements Initializable {

    @FXML
    private ImageView escenario, iAtaqueGif, iAtaqueGif1, iAtaqueGif2, iAtaqueGif3, gifEspecial, iBack;

    @FXML
    private ImageView iPersonaje1, iPersonaje2, iAtaque, iEspecial, iAtaque2, iEspecial2, green, green1;

    @FXML
    private ProgressBar pVida1, pVida2, pHabilidad1, pHabilidad2;

    @FXML
    private TableView tabla;

    @FXML
    private TableColumn columna1, columna2, columna3, columna4;

    private ColorAdjust colorAdjust, colorAdjust2;

    @FXML
    private Label lInfo;

    private boolean turno, especial1, especial2;

    //private MediaPlayer mediaPlayer;

    private String timeStamp, timeStamp2;

    private Date d1, d2;
    
    //private MediaPlayer mediaPlayer2;

    private SimpleDateFormat format = new SimpleDateFormat("HHmmss");

    protected void setEscenario(String path) {
        Escenario.setImagen(path);
    }

    protected void setPersonajes(String nombre, String nombre2, double ps, double defensa, double daño, double evasion, double critico, double ps2, double defensa2, double daño2, double evasion2, double critico2) {
        Escenario.setPersonaje1(nombre);
        Escenario.setPersonaje2(nombre2);
        Escenario.setPersonaje1Object(new Personaje(nombre, ps, defensa, daño, evasion, critico));
        Escenario.setPersonaje2Object(new Personaje(nombre2, ps2, defensa2, daño2, evasion2, critico2));
    }

    protected void setImagenesPesonajes(ImageView image, String method, boolean control) {
        if (method.equals("Guts")) {
            image.setImage(new Image("juegoberserk/Img/gutsPelea.png"));
        } else if (method.equals("Griffith")) {
            image.setImage(new Image("juegoberserk/Img/griffithPelea.png"));
            if (control) {
                image.setX(image.getX() - 50);
            }
        } else if (method.equals("Femto")) {
            image.setImage(new Image("juegoberserk/Img/femtoPelea.png"));
        } else if (method.equals("Void")) {
            image.setImage(new Image("juegoberserk/Img/voidPelea.png"));
        } else if (method.equals("Nosferatu Zodd")) {
            image.setImage(new Image("juegoberserk/Img/zoddPelea.png"));
        } else if (method.equals("Casca")) {
            image.setImage(new Image("juegoberserk/Img/cascaPelea.png"));
        } else if (method.equals("Guts - Berserk")) {
            image.setImage(new Image("juegoberserk/Img/gutsberserkPelea3.png"));
        } else if (method.equals("Skull Knight")) {
            image.setImage(new Image("juegoberserk/Img/skullNightPelea.png"));
            if (control) {
                image.setX(image.getX() - 90);
            }
        }
    }

    @FXML
    void onEndHover(MouseEvent event) {
        if (event.getSource().equals(iAtaque) && turno) {
            iAtaque.setEffect(null);
        } else if (event.getSource().equals(iAtaque2) && !turno) {
            iAtaque2.setEffect(null);
        } else if (event.getSource().equals(iBack)) {
            iBack.setImage(new Image("juegoberserk/Img/back.png"));
        }
    }

    @FXML
    void onHover(MouseEvent event) {
        if (event.getSource().equals(iAtaque) && turno) {
            iAtaque.setEffect(colorAdjust);
        } else if (event.getSource().equals(iAtaque2) && !turno) {
            iAtaque2.setEffect(colorAdjust);
        } else if (event.getSource().equals(iBack)) {
            iBack.setImage(new Image("juegoberserk/Img/back2.png"));
        }
    }

    @FXML
    void onAtacar(MouseEvent event) throws IOException {
        if (event.getSource().equals(iAtaque) && turno) {
            lInfo.setText(Escenario.getPersonaje2Object().recibir(Escenario.getPersonaje1Object().atacar(), Escenario.getPersonaje1Object().getInfo()));
            threadAtaque(iAtaqueGif1, iAtaqueGif2, pHabilidad1);
            pVida2.setProgress(Escenario.getPersonaje2Object().getPs());
            finalizar(Escenario.getPersonaje1(), iAtaque, iAtaque2, iEspecial, pVida2, iPersonaje2, pHabilidad2, false, iEspecial2);
        } else if (event.getSource().equals(iAtaque2) && !turno) {
            lInfo.setText(Escenario.getPersonaje1Object().recibir(Escenario.getPersonaje2Object().atacar(), Escenario.getPersonaje2Object().getInfo()));
            threadAtaque(iAtaqueGif, iAtaqueGif3, pHabilidad2);
            pVida1.setProgress(Escenario.getPersonaje1Object().getPs());
            finalizar(Escenario.getPersonaje2(), iAtaque2, iAtaque, iEspecial2, pVida1, iPersonaje1, pHabilidad1, true, iEspecial);
        } else if (event.getSource().equals(iEspecial) && turno && especial1) {
            ataqueEspecial(pHabilidad1, true);

        } else if (event.getSource().equals(iEspecial2) && !turno && especial2) {
            ataqueEspecial(pHabilidad2, false);

        } else if (event.getSource().equals(iBack)) {
            //mediaPlayer2.stop();
            JuegoBerserk.setRoot("FXMLDocument2");
        }
        green.setVisible(false);
        green1.setVisible(false);
    }

    protected void finalizar(String nombre, ImageView image, ImageView image2, ImageView image3, ProgressBar bar, ImageView image4, ProgressBar bar2, boolean control, ImageView image6) {
        image.setEffect(colorAdjust2);
        image2.setEffect(null);
        image3.setEffect(colorAdjust2);
        turno = control;
        if (bar.getProgress() <= 0) {
            try {
                iAtaque.setDisable(true);
                iEspecial.setDisable(true);
                iAtaque2.setDisable(true);
                iEspecial2.setDisable(true);
                //mediaPlayer.stop();
                image4.setImage(null);
                bar2.setProgress(0);
                timeStamp2 = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
                d2 = format.parse(timeStamp2);
                long diff = d2.getTime() - d1.getTime();//as given
                long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
                ObservableAux.add(new Estadisticas(Escenario.getPersonaje1(), Escenario.getPersonaje2(), nombre, +seconds + " seg"));
                tabla.setItems(ObservableAux.getAux());
                new Thread() {
                    @Override
                    public void run() {
                        
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FXMLDocument3Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        /*String bip = "src/juegoberserk/Sound/gutsTheme.mp3";
                        Media hit = new Media(new File(bip).toURI().toString());
                        mediaPlayer2 = new MediaPlayer(hit);
                        mediaPlayer2.play();*/
                        gifEspecial.setImage(new Image("juegoberserk/Img/pantallaCarga.jpg"));
                        gifEspecial.setDisable(false);
                        iBack.setImage(new Image("juegoberserk/Img/back.png"));
                        iBack.setDisable(false);
                        tabla.setVisible(true);
                        tabla.setDisable(false);
                        
                    }
                }.start();
            } catch (ParseException ex) {
                Logger.getLogger(FXMLDocument3Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (bar2.getProgress() >= 1) {
            image6.setEffect(null);
            if (control) {
                especial1 = true;
            } else {
                especial2 = true;
            }
        } else {
            image6.setEffect(colorAdjust);
        }
    }

    protected void ataqueEspecial(ProgressBar bar, boolean control) {
        if (control) {
            gifEspecial.setImage(new Image("juegoberserk/Img/" + Escenario.getPersonaje1() + ".gif"));
        } else {
            gifEspecial.setImage(new Image("juegoberserk/Img/" + Escenario.getPersonaje2() + ".gif"));
        }
        gifEspecial.setDisable(false);
        new Thread() {
            @Override
            public void run() {
                try {

                    Thread.sleep(2500);
                    gifEspecial.setDisable(true);
                    gifEspecial.setImage(null);

                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocument3Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        if (control) {
            especial1 = false;
            lInfo.setText(Escenario.getPersonaje2Object().recibir(dañoEspecial(Escenario.getPersonaje1(), Escenario.getPersonaje1Object()), Escenario.getPersonaje1Object().getInfo()));

            green.setVisible(true);
        } else {
            especial2 = false;
            lInfo.setText(Escenario.getPersonaje1Object().recibir(dañoEspecial(Escenario.getPersonaje2(), Escenario.getPersonaje2Object()), Escenario.getPersonaje2Object().getInfo()));
            green1.setVisible(true);
        }
        bar.setProgress(0);
        if (control) {
            finalizar(Escenario.getPersonaje1(), iAtaque, iAtaque2, iEspecial, pVida2, iPersonaje2, pHabilidad2, false, iEspecial2);
        } else {
            finalizar(Escenario.getPersonaje2(), iAtaque2, iAtaque, iEspecial2, pVida1, iPersonaje1, pHabilidad1, true, iEspecial);
        }

    }

    protected double dañoEspecial(String personaje, Personaje oPersonaje) {

        if (personaje.equals("Guts")) {
            return 200;
        } else if (personaje.equals("Griffith")) {
            oPersonaje.setPs(oPersonaje.getPs1() + 150);
            return 250;
        } else if (personaje.equals("Femto")) {
            return 220;
        } else if (personaje.equals("Void")) {
            oPersonaje.setPs(oPersonaje.getPs1() + 200);
            return 0;
        } else if (personaje.equals("Nosferatu Zodd")) {
            oPersonaje.setPs(oPersonaje.getPs1() + 50);
            return 250;
        } else if (personaje.equals("Casca")) {
            oPersonaje.setPs(oPersonaje.getPs1() + 150);
            return 200;
        } else if (personaje.equals("Guts - Berserk")) {
            oPersonaje.setPs(oPersonaje.getPs1() + 100);
            return 0;
        } else if (personaje.equals("Skull Knight")) {
            return 150;
        }
        return 0;
    }

    protected void threadAtaque(ImageView image, ImageView image1, ProgressBar bar) {
        new Thread() {
            @Override
            public void run() {
                try {
                    if (!lInfo.getText().equals("Evasión")) {
                        if (lInfo.getText().equals("Golpe Crítico")) {
                            image1.setVisible(true);
                            bar.setProgress(bar.getProgress() + 0.55);
                        } else {
                            bar.setProgress(bar.getProgress() + 0.30);
                        }
                        image.setVisible(true);
                        Thread.sleep(1000);
                        image.setVisible(false);
                        image1.setVisible(false);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocument3Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            /*String bip = "src/juegoberserk/Sound/BerserkMixed.wav";
            Media hit = new Media(new File(bip).toURI().toString());
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();*/

            escenario.setImage(new Image("juegoberserk/Img/" + Escenario.getImagen()));
            setImagenesPesonajes(iPersonaje1, Escenario.getPersonaje1(), false);
            setImagenesPesonajes(iPersonaje2, Escenario.getPersonaje2(), true);

            pVida1.setStyle("-fx-accent: orange");
            pVida2.setStyle("-fx-accent: orange");
            pHabilidad1.setStyle("-fx-accent: red");
            pHabilidad2.setStyle("-fx-accent: red");

            colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.5);
            colorAdjust2 = new ColorAdjust();
            colorAdjust2.setBrightness(-0.9);
            iEspecial.setEffect(colorAdjust);
            iEspecial2.setEffect(colorAdjust);
            especial1 = false;
            especial2 = false;
            gifEspecial.setDisable(true);

            columna1.setCellValueFactory(new PropertyValueFactory("personaje1"));
            columna2.setCellValueFactory(new PropertyValueFactory("personaje2"));
            columna3.setCellValueFactory(new PropertyValueFactory("ganador"));
            columna4.setCellValueFactory(new PropertyValueFactory("duracion"));

            Random rand = new Random();
            if (rand.nextInt(10) <= 5) {
                iAtaque.setEffect(colorAdjust2);
                iEspecial.setEffect(colorAdjust2);
                turno = false;
            } else {
                iAtaque2.setEffect(colorAdjust2);
                iEspecial2.setEffect(colorAdjust2);
                turno = true;
            }
            lInfo.setTextFill(Color.WHITE);
            timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
            d1 = format.parse(timeStamp);

        } catch (Exception e) {
        }
    }
}
