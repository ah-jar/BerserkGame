package juegoberserk;

public class Estadisticas {
    protected String personaje1, personaje2, ganador , duracion;
    
    public Estadisticas(String personaje1, String personaje2, String ganador, String duracion) {
       setPersonaje1(personaje1); 
       setPersonaje2(personaje2);
       setGanador(ganador);
       setDuracion(duracion);
    }

    public String getPersonaje1() {
        return personaje1;
    }

    public void setPersonaje1(String personaje1) {
        this.personaje1 = personaje1;
    }

    public String getPersonaje2() {
        return personaje2;
    }

    public void setPersonaje2(String personaje2) {
        this.personaje2 = personaje2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
}