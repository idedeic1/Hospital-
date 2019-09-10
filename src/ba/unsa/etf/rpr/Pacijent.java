package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Date;

public class Pacijent extends Osoba {
    private ArrayList<Bolest> bolesti = new ArrayList<>();
    private ArrayList<Pregled> pregledi = new ArrayList<>();
    private ArrayList<Lijek> lijekovi = new ArrayList<>();

    public Pacijent(String ime, String prezime, Date datumRodjenja, String adresa, ArrayList<Bolest> bolesti, ArrayList<Pregled> pregledi, ArrayList<Lijek> lijekovi) {
        super(ime, prezime, datumRodjenja, adresa);
        this.bolesti = bolesti;
        this.pregledi = pregledi;
        this.lijekovi = lijekovi;
    }

    public ArrayList<Bolest> getBolesti() {
        return bolesti;
    }

    public void setBolesti(ArrayList<Bolest> bolesti) {
        this.bolesti = bolesti;
    }

    public ArrayList<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(ArrayList<Pregled> pregledi) {
        this.pregledi = pregledi;
    }

    public ArrayList<Lijek> getLijekovi() {
        return lijekovi;
    }

    public void setLijekovi(ArrayList<Lijek> lijekovi) {
        this.lijekovi = lijekovi;
    }
}
