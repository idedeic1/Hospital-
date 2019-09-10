package ba.unsa.etf.rpr;

public class Lijek {
    private int id;
    private String nazivLijeka;
    private String proizvodjacLijeka;

    public Lijek(int id, String nazivLijeka, String proizvodjacLijeka) {
        this.id = id;
        this.nazivLijeka = nazivLijeka;
        this.proizvodjacLijeka = proizvodjacLijeka;
    }

    @Override
    public String toString(){
        return nazivLijeka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
