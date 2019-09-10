package ba.unsa.etf.rpr;

import java.util.Date;

public class Doktor  {
    private int id;
    private String ime;
    private String prezime;
    private String specijalizacija;

    public Doktor(int id, String ime, String prezime, String specijalizacija) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
    }

    @Override
    public String toString(){
        return "dr. " + prezime + " " + ime;
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

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }
}
