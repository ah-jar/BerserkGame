package juegoberserk;

import java.util.Random;

public class Personaje {

    private double ps, constantPs, defensa, daño, evasion, critico;
    protected String nombre, info;

    public Personaje(String nombre, double ps, double defensa, double daño, double evasion, double critico) {
        setNombre(nombre);
        setPs(ps);
        setDefensa(defensa);
        setDaño(daño);
        setEvasion(evasion);
        setCritico(critico);
    }

    protected double atacar() {
        Random rand = new Random();
        int critico = rand.nextInt(100);
        if (critico <= this.critico) {
            info = "Golpe Crítico";
            return (daño * 2);
        }
        info = "Golpe Genérico";
        return daño;
    }

    protected String getInfo() {
        return info;
    }

    protected String recibir(double dañoRecibido, String info) {
        Random rand = new Random();
        int evasion = rand.nextInt(100);
        if (!(evasion <= this.evasion)) {
            ps = ps - dañoRecibido;
            if (defensa < dañoRecibido) {
                ps += defensa;
            }
            return info;
        } else {
            return "Evasión";
        }
    }

    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPs1() {
        return ps;
    }

    public double getPs() {
        return ((ps * 100) / constantPs) / 100;
    }

    protected void setPs(double ps) {
        constantPs = ps;
        this.ps = ps;
    }

    public double getDefensa() {
        return defensa;
    }

    protected void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getDaño() {
        return daño;
    }

    protected void setDaño(double daño) {
        this.daño = daño;
    }

    public double getEvasion() {
        return evasion;
    }

    protected void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public double getCritico() {
        return critico;
    }

    protected void setCritico(double critico) {
        this.critico = critico;
    }

}
