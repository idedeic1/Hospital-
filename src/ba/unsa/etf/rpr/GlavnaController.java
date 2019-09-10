package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
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
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class GlavnaController {
    public TableView<Pregled> tableViewPregled;
    public TableColumn colPregledID;
    public TableColumn colPregledDoktor;
    public TableColumn colPregledSestra;
    public TableColumn colPregledPacijent;
    public TableColumn colPregledCijena;
    public TableColumn colPregledDijagnoza;
    public TableColumn colPregledOpis;
    private OrdinacijaDAO dao;
    private ObservableList<Pregled> listPregled;
    private ObservableList<Pacijent> listPacijent;

    public GlavnaController() {
        dao = OrdinacijaDAO.getInstance();
        listPregled = FXCollections.observableArrayList(dao.pregledi());
        listPacijent = FXCollections.observableArrayList(dao.pacijenti());

    }

    @FXML
    public void initialize() {
        tableViewPregled.setItems(listPregled);
        colPregledID.setCellValueFactory(new PropertyValueFactory("id"));
        colPregledDoktor.setCellValueFactory(new PropertyValueFactory("doktor"));
        colPregledSestra.setCellValueFactory(new PropertyValueFactory("sestra"));
        colPregledPacijent.setCellValueFactory(new PropertyValueFactory("pacijent"));
        colPregledCijena.setCellValueFactory(new PropertyValueFactory("cijena"));
        colPregledDijagnoza.setCellValueFactory(new PropertyValueFactory("dijagnoza"));
        colPregledOpis.setCellValueFactory(new PropertyValueFactory("opisPregleda"));
    }

    public void actionDodajPregled(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregled.fxml"));
            PregledController pregledController = new PregledController(null, dao.doktori(), dao.sestre(), dao.pacijenti(), dao.bolesti());
            loader.setController(pregledController);
            root = loader.load();
            stage.setTitle("Pregled");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Pregled pregled = pregledController.getPregled();
                if (pregled != null) {
                    dao.dodajPregled(pregled);
                    listPregled.setAll(dao.pregledi());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void actionPrikaziPacijente(ActionEvent actionEvent){
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pacijenti.fxml"));
            PacijentController pacijentController = new PacijentController(dao.pacijenti());
            loader.setController(pacijentController);
            root = loader.load();
            stage.setTitle("Pacijenti");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionIzmijeniPregled(ActionEvent actionEvent) {
        Pregled pregled = tableViewPregled.getSelectionModel().getSelectedItem();
        if (pregled == null) return;

        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregled.fxml"));
            PregledController pregledController = new PregledController(pregled, dao.doktori(), dao.sestre(), dao.pacijenti(), dao.bolesti());
            loader.setController(pregledController);
            root = loader.load();
            stage.setTitle("Pregled");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Pregled noviPregled = pregledController.getPregled();
                if (noviPregled != null) {
                    dao.izmijeniPregled(noviPregled);
                    listPregled.setAll(dao.pregledi());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionObrisiPregled(ActionEvent actionEvent) {
        Pregled pregled = tableViewPregled.getSelectionModel().getSelectedItem();
        if (pregled == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda brisanja");
        alert.setHeaderText("Brisanje pregleda");
        alert.setContentText("Da li ste sigurni da želite obrisati pregled sa ID-em " +pregled.getId()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.obrisiPregled(pregled);
            listPregled.setAll(dao.pregledi());
        }
    }
}
