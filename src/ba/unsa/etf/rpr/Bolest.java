package ba.unsa.etf.rpr;

public class Bolest {
    private String nazivBolesti;
    private String simptomiBolesti;

    public Bolest(String nazivBolesti, String simptomiBolesti) {
        this.nazivBolesti = nazivBolesti;
        this.simptomiBolesti = simptomiBolesti;
    }

    public String getNazivBolesti() {
        return nazivBolesti;
    }

    public void setNazivBolesti(String nazivBolesti) {
        this.nazivBolesti = nazivBolesti;
    }

    public String getSimptomiBolesti() {
        return simptomiBolesti;
    }

    public void setSimptomiBolesti(String simptomiBolesti) {
        this.simptomiBolesti = simptomiBolesti;
    }
}
