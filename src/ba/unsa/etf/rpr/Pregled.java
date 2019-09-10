package ba.unsa.etf.rpr;

public class Pregled {
    private Doktor doktor;
    private MedicinskaSestra sestra;
    private int cijena;
    private Bolest dijagnoza;
    private String opisPregleda;

    public Pregled(Doktor doktor, MedicinskaSestra sestra, int cijena, Bolest dijagnoza, String opisPregleda) {
        this.doktor = doktor;
        this.sestra = sestra;
        this.cijena = cijena;
        this.dijagnoza = dijagnoza;
        this.opisPregleda = opisPregleda;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public MedicinskaSestra getSestra() {
        return sestra;
    }

    public void setSestra(MedicinskaSestra sestra) {
        this.sestra = sestra;
    }

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    public Bolest getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(Bolest dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public String getOpisPregleda() {
        return opisPregleda;
    }

    public void setOpisPregleda(String opisPregleda) {
        this.opisPregleda = opisPregleda;
    }
}
