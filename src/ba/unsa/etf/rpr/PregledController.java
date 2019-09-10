package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PregledController {
    public TextField fieldCijena;
    public TextField fieldOpis;

    public ChoiceBox<Doktor> choiceDoktor;
    public ChoiceBox<MedicinskaSestra> choiceSestra;
    public ChoiceBox<Pacijent> choicePacijent;
    public ChoiceBox<Bolest> choiceBolest;

    public ObservableList<Doktor> listDoktori;
    public ObservableList<MedicinskaSestra> listSestre;
    public ObservableList<Pacijent> listPacijenti;
    public ObservableList<Bolest> listBolesti;

    private Pregled pregled;

    public PregledController(Pregled pregled, ArrayList<Doktor> doktori, ArrayList<MedicinskaSestra> sestre, ArrayList<Pacijent> pacijenti, ArrayList<Bolest> bolesti) {
        this.pregled = pregled;
        listDoktori = FXCollections.observableArrayList(doktori);
        listSestre = FXCollections.observableArrayList(sestre);
        listPacijenti = FXCollections.observableArrayList(pacijenti);
        listBolesti = FXCollections.observableArrayList(bolesti);
    }

    @FXML
    public void initialize() {
        choiceDoktor.setItems(listDoktori);
        choiceSestra.setItems(listSestre);
        choicePacijent.setItems(listPacijenti);
        choiceBolest.setItems(listBolesti);
        if (pregled != null) {
            fieldCijena.setText(Integer.toString(pregled.getCijena()));
            fieldOpis.setText(pregled.getOpisPregleda());
            choiceDoktor.setValue(pregled.getDoktor());
            choiceSestra.setValue(pregled.getSestra());
            choicePacijent.setValue(pregled.getPacijent());
            choiceBolest.setValue(pregled.getDijagnoza());

        } else {
            choiceDoktor.getSelectionModel().selectFirst();
            choiceSestra.getSelectionModel().selectFirst();
            choicePacijent.getSelectionModel().selectFirst();
            choiceBolest.getSelectionModel().selectFirst();
        }
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void clickCancel(ActionEvent actionEvent) {
        pregled = null;
        Stage stage = (Stage) fieldOpis.getScene().getWindow();
        stage.close();
    }

    public void clickOk(ActionEvent actionEvent) {
        boolean sveOk = true;

        int cijena = 0;
        try {
            cijena = Integer.parseInt(fieldCijena.getText());
        } catch (NumberFormatException e) {
            // ...
        }
        if (cijena <= 0) {
            fieldCijena.getStyleClass().removeAll("poljeIspravno");
            fieldCijena.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldCijena.getStyleClass().removeAll("poljeNijeIspravno");
            fieldCijena.getStyleClass().add("poljeIspravno");
        }

        if (!sveOk) return;

        if (pregled == null) pregled = new Pregled();

        pregled.setDoktor(choiceDoktor.getValue());
        pregled.setSestra(choiceSestra.getValue());
        pregled.setPacijent(choicePacijent.getValue());
        pregled.setDijagnoza(choiceBolest.getValue());
        pregled.setCijena(Integer.parseInt(fieldCijena.getText()));
        pregled.setOpisPregleda(fieldOpis.getText());

        Stage stage = (Stage) fieldCijena.getScene().getWindow();
        stage.close();
    }
}
