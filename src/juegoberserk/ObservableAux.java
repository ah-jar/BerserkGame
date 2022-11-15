package juegoberserk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableAux {
    protected static ObservableList<Estadisticas> aux;
    
    protected static void inicializar() {
        aux = FXCollections.observableArrayList();
    }
    
    protected static void add(Estadisticas estadisticas) {
        aux.add(estadisticas);
    }
    
    protected static ObservableList getAux() {
        return aux;
    }
}

