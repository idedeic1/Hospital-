package ba.unsa.etf.rpr;

import java.util.Date;

public class Doktor extends Osoba {
    private String specijalizacija;

    public Doktor(String ime, String prezime, Date datumRodjenja, String specijalizacija) {
        super(ime, prezime, datumRodjenja);
        this.specijalizacija = specijalizacija;
    }
}
