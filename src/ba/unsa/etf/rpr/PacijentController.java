package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class PacijentController {
    public TableView<Pacijent> tableViewPacijenti;
    public TableColumn colPacijentID;
    public TableColumn colPacijentIme;
    public TableColumn colPacijentPrezime;
    public TableColumn colPacijentBolest;
    public TableColumn colPacijentLijek;
    private OrdinacijaDAO dao;
    private ObservableList<Pacijent> listPacijent;
    private Pacijent pacijent;

    public Pacijent getPacijent(){
        return pacijent;
    }

    public PacijentController(ArrayList<Pacijent> pacijenti) {
        dao = OrdinacijaDAO.getInstance();
        listPacijent = FXCollections.observableArrayList(pacijenti);
    }

    @FXML
    public void initialize() {
        tableViewPacijenti.setItems(listPacijent);
        colPacijentID.setCellValueFactory(new PropertyValueFactory("id"));
        colPacijentIme.setCellValueFactory(new PropertyValueFactory("ime"));
        colPacijentPrezime.setCellValueFactory(new PropertyValueFactory("prezime"));
        colPacijentBolest.setCellValueFactory(new PropertyValueFactory("bolest"));
        colPacijentLijek.setCellValueFactory(new PropertyValueFactory("lijek"));

    }

    public void actionDodajPacijenta(ActionEvent actionEvent){
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pacijent.fxml"));
            PacijentFormularController pacijentFormularController = new PacijentFormularController(null, dao.lijekovi(), dao.bolesti());
            loader.setController(pacijentFormularController);
            root = loader.load();
            stage.setTitle("Pregled");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Pacijent pacijent = pacijentFormularController.getPacijent();
                if (pacijent != null) {
                    dao.dodajPacijenta(pacijent);
                    listPacijent.setAll(dao.pacijenti());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void actionObrisiPacijenta(ActionEvent actionEvent){
        Pacijent pacijent = tableViewPacijenti.getSelectionModel().getSelectedItem();
        if (pacijent == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda brisanja");
        alert.setHeaderText("Brisanje pacijenta!");
        alert.setContentText("Da li ste sigurni da želite obrisati pacijenta  " + pacijent + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.obrisiPacijenta(pacijent);
            listPacijent.setAll(dao.pacijenti());
        }
    }

    public void actionIzmijeniPacijenta(ActionEvent actionEvent){
        Pacijent pacijent = tableViewPacijenti.getSelectionModel().getSelectedItem();
        if (pacijent == null) return;

        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pacijent.fxml"));
            PacijentFormularController pacijentFormularController = new PacijentFormularController(pacijent, dao.lijekovi(), dao.bolesti());
            loader.setController(pacijentFormularController);
            root = loader.load();
            stage.setTitle("Pacijent");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Pacijent noviPacijent = pacijentFormularController.getPacijent();
                if (noviPacijent != null) {
                    dao.izmijeniPacijenta(noviPacijent);
                    listPacijent.setAll(dao.pacijenti());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void actionNatrag(ActionEvent actionEvent) {
        pacijent = null;
        Stage stage = (Stage) tableViewPacijenti.getScene().getWindow();
        stage.close();
    }
}
