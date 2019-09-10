package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Date;

public class Pacijent extends Osoba {
    private Bolest bolest;
    private Lijek lijek;
    private ArrayList<Pregled> pregledi = new ArrayList<>();

    public Pacijent(String ime, String prezime, Date datumRodjenja, String adresa, Bolest bolest, Lijek lijek, ArrayList<Pregled> pregledi) {
        super(ime, prezime, datumRodjenja, adresa);
        this.bolest = bolest;
        this.lijek = lijek;
        this.pregledi = pregledi;
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

    public ArrayList<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(ArrayList<Pregled> pregledi) {
        this.pregledi = pregledi;
    }


}
