package ba.unsa.etf.rpr;

public class Lijek {
    private String nazivLijeka;
    private String proizvodjacLijeka;

    public Lijek(String nazivLijeka, String proizvodjacLijeka) {
        this.nazivLijeka = nazivLijeka;
        this.proizvodjacLijeka = proizvodjacLijeka;
    }

    public String getNazivLijeka() {
        return nazivLijeka;
    }

    public void setNazivLijeka(String nazivLijeka) {
        this.nazivLijeka = nazivLijeka;
    }

    public String getProizvodjacLijeka() {
        return proizvodjacLijeka;
    }

    public void setProizvodjacLijeka(String proizvodjacLijeka) {
        this.proizvodjacLijeka = proizvodjacLijeka;
    }
}
