package ba.unsa.etf.rpr;

public class Bolest {
    private int id;
    private String nazivBolesti;
    private String simptomiBolesti;

    public Bolest(int id, String nazivBolesti, String simptomiBolesti) {
        this.id = id;
        this.nazivBolesti = nazivBolesti;
        this.simptomiBolesti = simptomiBolesti;
    }

    @Override
    public String toString(){
        return nazivBolesti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
