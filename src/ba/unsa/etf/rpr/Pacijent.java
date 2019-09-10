package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Date;

public class Pacijent extends Osoba {
    private ArrayList<Bolest> bolesti = new ArrayList<>();
    private ArrayList<Pregled> pregledi = new ArrayList<>();
    private ArrayList<Lijek> lijekovi = new ArrayList<>();

    public Pacijent(String ime, String prezime, Date datumRodjenja, ArrayList<Bolest> bolesti, ArrayList<Pregled> pregledi, ArrayList<Lijek> lijekovi) {
        super(ime, prezime, datumRodjenja);
        this.bolesti = bolesti;
        this.pregledi = pregledi;
        this.lijekovi = lijekovi;
    }
}
