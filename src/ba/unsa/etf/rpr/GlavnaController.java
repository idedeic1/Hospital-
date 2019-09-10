package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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

    public GlavnaController() {
        dao = OrdinacijaDAO.getInstance();
        listPregled = FXCollections.observableArrayList(dao.pregledi());
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
}
