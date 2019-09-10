package ba.unsa.etf.rpr;

public class Pregled {
    private int id;
    private Doktor doktor;
    private MedicinskaSestra sestra;
    private Pacijent pacijent;
    private int cijena;
    private Bolest dijagnoza;
    private String opisPregleda;

    public Pregled (){}

    public Pregled(int id, Doktor doktor, MedicinskaSestra sestra, Pacijent pacijent, int cijena, Bolest dijagnoza, String opisPregleda) {
        this.id = id;
        this.doktor = doktor;
        this.sestra = sestra;
        this.pacijent = pacijent;
        this.cijena = cijena;
        this.dijagnoza = dijagnoza;
        this.opisPregleda = opisPregleda;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
