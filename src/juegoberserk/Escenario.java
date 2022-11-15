package juegoberserk;

public class Escenario {

    protected static String imagen, personaje1, personaje2;
    protected static Personaje personaje1Object, personaje2Object;

    public Escenario() {

    }

    public static String getImagen() {
        return imagen;
    }

    public static void setImagen(String imagen) {
        Escenario.imagen = imagen;
    }

    public static String getPersonaje1() {
        return personaje1;
    }

    public static void setPersonaje1(String personaje1) {
        Escenario.personaje1 = personaje1;
    }

    public static String getPersonaje2() {
        return personaje2;
    }

    public static void setPersonaje2(String personaje2) {
        Escenario.personaje2 = personaje2;
    }

    public static Personaje getPersonaje1Object() {
        return personaje1Object;
    }

    public static void setPersonaje1Object(Personaje personaje) {
        personaje1Object = personaje;
    }

    public static Personaje getPersonaje2Object() {
        return personaje2Object;
    }

    public static void setPersonaje2Object(Personaje personaje) {
        personaje2Object = personaje;
    }

}
