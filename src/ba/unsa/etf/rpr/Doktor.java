package ba.unsa.etf.rpr;

import java.util.Date;

public class Doktor extends Osoba {
    private String specijalizacija;

    public Doktor(String ime, String prezime, Date datumRodjenja, String adresa, String specijalizacija) {
        super(ime, prezime, datumRodjenja, adresa);
        this.specijalizacija = specijalizacija;
    }
}
