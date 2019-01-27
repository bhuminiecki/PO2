import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class EntryController implements Initializable {

    @FXML
    private TextField mtitle;

    @FXML
    private TextField mgenre;

    @FXML
    private TextField mprice;

    @FXML
    private DatePicker mdate;

    @FXML
    private TextArea mdesc;

    @FXML
    private TextField mrating;

    @FXML
    private ChoiceBox mtier;

    @FXML
    private TextField stitle;

    @FXML
    private TextField sgenre;

    @FXML
    private TextField sprice;

    @FXML
    private DatePicker sdate;

    @FXML
    private TextArea sdesc;

    @FXML
    private TextField srating;

    @FXML
    private ChoiceBox stier;

    @FXML
    private TextField sepisodes;

    @FXML
    private TextField ename;

    @FXML
    private TextField eprice;

    @FXML
    private TextField elength;

    @FXML
    private DatePicker edate;

    public void addMovie() {
        synchronized (Main.getSimulation().getPool()) {
            Main.getSimulation().getPool().genMovie(mtitle.getText(), mgenre.getText(), new BigDecimal(mprice.getText()), Double.parseDouble(mrating.getText()), mtier.getSelectionModel().getSelectedIndex(), mdate.getValue(), mdesc.getText());
        }
    }

    public void addSeries() {
        synchronized (Main.getSimulation().getPool()) {
            Main.getSimulation().getPool().genSeries(stitle.getText(), sgenre.getText(), new BigDecimal(sprice.getText()), Double.parseDouble(srating.getText()), stier.getSelectionModel().getSelectedIndex(), sdate.getValue(), sdesc.getText(), Integer.parseInt(sepisodes.getText()));
        }
    }

    public void addEvent() {
        synchronized (Main.getSimulation().getPool()) {
            Main.getSimulation().getPool().genEvent(ename.getText(), Double.parseDouble(elength.getText()), new BigDecimal(eprice.getText()), edate.getValue());
        }
    }

    public void initialize(URL url, ResourceBundle rb)
    {
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        ObservableList obList = FXCollections.observableList(list);
        mtier.getItems().clear();
        for(Object temp : obList)
        {
            mtier.getItems().add(temp);
        }
        stier.getItems().clear();
        for(Object temp : obList)
        {
            stier.getItems().add(temp);
        }
    }
}
