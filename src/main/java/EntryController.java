import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.math.BigDecimal;

public class EntryController {

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
    private ChoiceBox<Integer> mtier;

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
    private ChoiceBox<Integer> stier;

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
            Main.getSimulation().getPool().genMovie(mtitle.getText(), mgenre.getText(), new BigDecimal(mprice.getText()), Double.parseDouble(mrating.getText()), mtier.getValue(), mdate.getValue(), mdesc.getText());
        }
    }

    public void addSeries() {
        synchronized (Main.getSimulation().getPool()) {
            Main.getSimulation().getPool().genSeries(stitle.getText(), sgenre.getText(), new BigDecimal(sprice.getText()), Double.parseDouble(srating.getText()), stier.getValue(), sdate.getValue(), sdesc.getText(), Integer.parseInt(sepisodes.getText()));
        }
    }

    public void addEvent() {
        synchronized (Main.getSimulation().getPool()) {
            Main.getSimulation().getPool().genEvent(ename.getText(), Double.parseDouble(elength.getText()), new BigDecimal(eprice.getText()), edate.getValue());
        }
    }
}
