package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PacijentFormularController {

    public TextField fieldIme;
    public TextField fieldPrezime;
    public ChoiceBox<Lijek> choiceLijek;
    public ChoiceBox<Bolest> choiceBolest;

    private Pacijent pacijent;
    public ObservableList<Lijek> listLijekovi;
    public ObservableList<Bolest> listBolesti;

    @FXML
    public void initialize() {
        choiceLijek.setItems(listLijekovi);
        choiceBolest.setItems(listBolesti);
        if (pacijent != null) {
            fieldIme.setText(pacijent.getIme());
            fieldPrezime.setText(pacijent.getPrezime());
            choiceLijek.setValue(pacijent.getLijek());
            choiceBolest.setValue(pacijent.getBolest());

        } else {
            choiceLijek.getSelectionModel().selectFirst();
            choiceBolest.getSelectionModel().selectFirst();
        }
    }

    public PacijentFormularController(Pacijent pacijent, ArrayList<Lijek> lijekovi, ArrayList<Bolest> bolesti) {
        this.pacijent = pacijent;
        listLijekovi = FXCollections.observableArrayList(lijekovi);
        listBolesti = FXCollections.observableArrayList(bolesti);
    }

    public Pacijent getPacijent(){
        return pacijent;
    }

    public void clickCancel(ActionEvent actionEvent) {
        pacijent = null;
        Stage stage = (Stage) fieldPrezime.getScene().getWindow();
        stage.close();
    }

    public void clickOk(ActionEvent actionEvent) {

        if (pacijent == null) pacijent = new Pacijent();

        pacijent.setIme(fieldIme.getText());
        pacijent.setPrezime(fieldPrezime.getText());
        pacijent.setBolest(choiceBolest.getValue());
        pacijent.setLijek(choiceLijek.getValue());

        Stage stage = (Stage) fieldPrezime.getScene().getWindow();
        stage.close();
    }
}
