package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Date;

public class Pacijent {
    private int id;
    private String ime;
    private String prezime;
    private Bolest bolest;
    private Lijek lijek;

    public Pacijent(){}

    public Pacijent(int id, String ime, String prezime, Bolest bolest, Lijek lijek) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;

        this.bolest = bolest;
        this.lijek = lijek;
    }

    @Override
    public String toString(){
        return  prezime + " " + ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }




    public Bolest getBolest() {
        return bolest;
    }

    public void setBolest(Bolest bolest) {
        this.bolest = bolest;
    }

    public Lijek getLijek() {
        return lijek;
    }

    public void setLijek(Lijek lijek) {
        this.lijek = lijek;
    }
}
