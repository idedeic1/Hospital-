package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;

public class OrdinacijaDAO {
    private static OrdinacijaDAO instance;
    private Connection conn;

    private PreparedStatement dajPacijentaUpit, dajDoktoraUpit, dajMedicinskuSestruUpit, dajLijekUpit, dajBolestUpit, dajPregledUpit, dajPacijenteUpit, dajPregledeUpit,
                               dajLijekoveUpit, dajBolestiUpit, dajDoktoreUpit, dajSestreUpit, obrisiPacijentaUpit, obrisiDoktoraUpit, obrisiMedicinskuSestruUpit,
                              obrisiLijekUpit, obrisiBolestUpit, obrisiPregledUpit, dodajPacijentaUpit, dodajDoktoraUpit, dodajMedicinskuSestruUpit, dodajLijekUpit, dodajBolestUpit,
                              dodajPregledUpit, promijeniPacijentaUpit, odrediIDPacijentaUpit, odrediIDPregledaUpit, odrediIDLijekaUpit, odrediIDBolestiUpit;



    public static OrdinacijaDAO getInstance() {
        if (instance == null) instance = new OrdinacijaDAO();
        return instance;
    }
    private OrdinacijaDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            dajPacijentaUpit = conn.prepareStatement("SELECT * FROM pacijent WHERE id=?");
            dajDoktoraUpit = conn.prepareStatement("SELECT * FROM doktor WHERE id=?");
            dajMedicinskuSestruUpit = conn.prepareStatement("SELECT * FROM medicinskaSestra WHERE id=?");
            dajLijekUpit = conn.prepareStatement("SELECT * FROM lijek WHERE id=?");
            dajBolestUpit = conn.prepareStatement("SELECT * FROM bolest WHERE id=?");
            dajPregledUpit = conn.prepareStatement("SELECT * FROM pregled WHERE id=?");

            obrisiPacijentaUpit = conn.prepareStatement("DELETE FROM pacijent WHERE id=?");
            obrisiDoktoraUpit = conn.prepareStatement("DELETE FROM doktor WHERE id=?");
            obrisiMedicinskuSestruUpit = conn.prepareStatement("DELETE FROM medicinskaSestra WHERE id=?");
            obrisiLijekUpit = conn.prepareStatement("DELETE FROM lijek WHERE id=?");
            obrisiBolestUpit = conn.prepareStatement("DELETE FROM bolest WHERE id=?");
            obrisiPregledUpit = conn.prepareStatement("DELETE FROM pregled WHERE id=?");

            dodajPacijentaUpit  = conn.prepareStatement("INSERT INTO pacijent VALUES(?,?,?,?,?,?)");
            dodajDoktoraUpit  = conn.prepareStatement("INSERT INTO doktor VALUES(?,?,?,?)");
            dodajMedicinskuSestruUpit  = conn.prepareStatement("INSERT INTO medicinskaSestra VALUES(?,?,?)");
            dodajLijekUpit  = conn.prepareStatement("INSERT INTO lijek VALUES(?,?,?)");
            dodajBolestUpit  = conn.prepareStatement("INSERT INTO bolest VALUES(?,?,?)");
            dodajPregledUpit  = conn.prepareStatement("INSERT INTO pregled VALUES(?,?,?,?,?,?,?)");

            //nadjiPacijentaUpit = conn.prepareStatement("SELECT * FROM pacijent WHERE ime=? AND prezime=?");
            //nadjiDoktoraUpit = conn.prepareStatement("SELECT * FROM doktor WHERE ime=? AND prezime=?");
            //nadjiMedicinskuSestruUpit = conn.prepareStatement("SELECT * FROM medicinskaSestra WHERE ime=? AND prezime=?");
            //nadjiLijekUpit = conn.prepareStatement("SELECT * FROM lijek WHERE naziv=?");
            //nadjiBolestUpit = conn.prepareStatement("SELECT * FROM bolest WHERE ime=?");

            odrediIDPacijentaUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM pacijent");
            odrediIDPregledaUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM pregled");
            odrediIDLijekaUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM lijek");
            odrediIDBolestiUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM bolest");

            promijeniPacijentaUpit = conn.prepareStatement("UPDATE pacijent SET ime=?, prezime=?, datumRodjenja=? bolest=?, lijek=? WHERE id=?");

            dajPacijenteUpit = conn.prepareStatement("SELECT * FROM  pacijent ORDER BY id");
            dajPregledeUpit = conn.prepareStatement("SELECT * FROM  pregled ORDER BY id");
            dajLijekoveUpit = conn.prepareStatement("SELECT * FROM  lijek ORDER BY id");
            dajBolestiUpit = conn.prepareStatement("SELECT * FROM  bolest ORDER BY id");
            dajDoktoreUpit = conn.prepareStatement("SELECT * FROM  doktor ORDER BY id");
            dajSestreUpit = conn.prepareStatement("SELECT * FROM  medicinskaSestra ORDER BY id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Lijek dajLijek(int id) {
        try {
            dajLijekUpit.setInt(1, id);
            ResultSet rs = dajLijekUpit.executeQuery();
            if (!rs.next()) return null;
            return dajLijekIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Bolest dajBolest(int id) {
        try {
            dajBolestUpit.setInt(1, id);
            ResultSet rs = dajBolestUpit.executeQuery();
            if (!rs.next()) return null;
            return dajBolestIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Pacijent dajPacijenta(int id) {
        try {
            dajPacijentaUpit.setInt(1, id);
            ResultSet rs = dajPacijentaUpit.executeQuery();
            if (!rs.next()) return null;
            return dajPacijentaIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Doktor dajDoktora(int id) {
        try {
            dajDoktoraUpit.setInt(1, id);
            ResultSet rs = dajDoktoraUpit.executeQuery();
            if (!rs.next()) return null;
            return dajDoktoraIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private MedicinskaSestra dajMedicinskuSestru(int id) {
        try {
            dajMedicinskuSestruUpit.setInt(1, id);
            ResultSet rs = dajMedicinskuSestruUpit.executeQuery();
            if (!rs.next()) return null;
            return dajMedicinskuSestruIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Pregled dajPregled(int id) {
        try {
            dajPregledUpit.setInt(1, id);
            ResultSet rs = dajPregledUpit.executeQuery();
            if (!rs.next()) return null;
            return dajPregledIzResultSeta(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void obrisiLijek(Lijek lijek) {
        try {
            obrisiLijekUpit.setInt(1, lijek.getId());
            obrisiLijekUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void obrisiBolest(Bolest bolest) {
        try {
            obrisiBolestUpit.setInt(1, bolest.getId());
            obrisiBolestUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void obrisiDoktora(Doktor doktor) {
        try {
            obrisiDoktoraUpit.setInt(1, doktor.getId());
            obrisiDoktoraUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void obrisiMedicinskuSestru(MedicinskaSestra sestra) {
        try {
            obrisiMedicinskuSestruUpit.setInt(1, sestra.getId());
            obrisiMedicinskuSestruUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void obrisiPacijenta(Pacijent pacijent) {
        try {
            obrisiPacijentaUpit.setInt(1, pacijent.getId());
            obrisiPacijentaUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ObrisiPregled(Pregled pregled ) {
        try {
            obrisiPregledUpit.setInt(1, pregled.getId());
            obrisiPregledUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajLijek(Lijek lijek) {
        try {
            ResultSet rs = odrediIDLijekaUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajLijekUpit.setInt(1, id);
            dodajLijekUpit.setString(2, lijek.getNazivLijeka());
            dodajLijekUpit.setString(3, lijek.getProizvodjacLijeka());
            dodajLijekUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajBolest(Bolest bolest) {
        try {
            ResultSet rs = odrediIDBolestiUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajBolestUpit.setInt(1, id);
            dodajBolestUpit.setString(2, bolest.getNazivBolesti());
            dodajBolestUpit.setString(3, bolest.getSimptomiBolesti());
            dodajBolestUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajPacijenta(Pacijent pacijent) {
        try {
            ResultSet rs = odrediIDPacijentaUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajPacijentaUpit.setInt(1, id);
            dodajPacijentaUpit.setString(2, pacijent.getIme());
            dodajPacijentaUpit.setString(3, pacijent.getPrezime());
            dodajPacijentaUpit.setDate(4, dajDatumFino(pacijent.getDatumRodjenja()));
            dodajPacijentaUpit.setInt(5, pacijent.getBolest().getId());
            dodajPacijentaUpit.setInt(6, pacijent.getLijek().getId());
            dodajPacijentaUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajPregled(Pregled pregled) {
        try {
            ResultSet rs = odrediIDPregledaUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajPregledUpit.setInt(1, id);
            dodajPregledUpit.setInt(2, pregled.getDoktor().getId());
            dodajPregledUpit.setInt(3, pregled.getSestra().getId());
            dodajPregledUpit.setInt(4, pregled.getPacijent().getId());
            dodajPregledUpit.setInt(5, pregled.getCijena());
            dodajPregledUpit.setInt(6, pregled.getDijagnoza().getId());
            dodajPregledUpit.setString(6, pregled.getOpisPregleda());
            dodajPregledUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Lijek> lijekovi() {
        ArrayList<Lijek> rezultat = new ArrayList();
        try {
            ResultSet rs = dajLijekoveUpit.executeQuery();
            while (rs.next()) {
                Lijek lijek = dajLijekIzResultSeta(rs);
                rezultat.add(lijek);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public ArrayList<Bolest> bolesti() {
        ArrayList<Bolest> rezultat = new ArrayList();
        try {
            ResultSet rs = dajBolestiUpit.executeQuery();
            while (rs.next()) {
                Bolest bolest = dajBolestIzResultSeta(rs);
                rezultat.add(bolest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public ArrayList<Doktor> doktori() {
        ArrayList<Doktor> rezultat = new ArrayList();
        try {
            ResultSet rs = dajDoktoreUpit.executeQuery();
            while (rs.next()) {
                Doktor doktor = dajDoktoraIzResultSeta(rs);
                rezultat.add(doktor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public ArrayList<MedicinskaSestra> sestre() {
        ArrayList<MedicinskaSestra> rezultat = new ArrayList();
        try {
            ResultSet rs = dajSestreUpit.executeQuery();
            while (rs.next()) {
                MedicinskaSestra seka = dajMedicinskuSestruIzResultSeta(rs);
                rezultat.add(seka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public ArrayList<Pacijent> pacijenti() {
        ArrayList<Pacijent> rezultat = new ArrayList();
        try {
            ResultSet rs = dajPacijenteUpit.executeQuery();
            while (rs.next()) {
                Pacijent ivoZadro = dajPacijentaIzResultSeta(rs);
                rezultat.add(ivoZadro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public ArrayList<Pregled> pregledi() {
        ArrayList<Pregled> rezultat = new ArrayList();
        try {
            ResultSet rs = dajPregledeUpit.executeQuery();
            while (rs.next()) {
                Pregled pregled = dajPregledIzResultSeta(rs);
                rezultat.add(pregled);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }



    public void izmijeniPacijenta(Pacijent pacijent) {
        try {
            promijeniPacijentaUpit.setString(1, pacijent.getIme());
            promijeniPacijentaUpit.setString(2, pacijent.getPrezime());
            promijeniPacijentaUpit.setDate(3, dajDatumFino(pacijent.getDatumRodjenja()));
            promijeniPacijentaUpit.setInt(4, pacijent.getBolest().getId());
            promijeniPacijentaUpit.setInt(5, pacijent.getLijek().getId());
            promijeniPacijentaUpit.setInt(6, pacijent.getId());
            promijeniPacijentaUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Lijek dajLijekIzResultSeta(ResultSet rs) throws SQLException {
        return new Lijek(rs.getInt(1),rs.getString(2), rs.getString(3));
    }
    private Bolest dajBolestIzResultSeta(ResultSet rs) throws SQLException {
        return new Bolest(rs.getInt(1), rs.getString(2), rs.getString(3));
    }
    private Doktor dajDoktoraIzResultSeta(ResultSet rs) throws SQLException {
        return new Doktor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
    }
    private MedicinskaSestra dajMedicinskuSestruIzResultSeta(ResultSet rs) throws SQLException {
        return new MedicinskaSestra(rs.getInt(1), rs.getString(2), rs.getString(3));
    }
    private Pregled dajPregledIzResultSeta(ResultSet rs) throws SQLException {
        Pregled pregled = new Pregled(rs.getInt(1), null, null, null, rs.getInt(5), null, rs.getString(3));
        pregled.setDoktor(dajDoktora(rs.getInt(2)));
        pregled.setSestra(dajMedicinskuSestru(rs.getInt(3)));
        pregled.setPacijent(dajPacijenta(rs.getInt(4)));
        pregled.setDijagnoza(dajBolest(rs.getInt(6)));

        return pregled;
    }
    private Pacijent dajPacijentaIzResultSeta(ResultSet rs) throws SQLException {
        Pacijent pacijent = new Pacijent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4) ,null , null);
        pacijent.setBolest(dajBolest(rs.getInt(5)));
        pacijent.setLijek(dajLijek(rs.getInt(6)));

        return pacijent;
    }

    private Date dajDatumFino(java.util.Date d){
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
        return sqlDate;
    }
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if ( sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }
}
