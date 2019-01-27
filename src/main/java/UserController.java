import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TextField uname;

    @FXML
    private TextField upassword;

    @FXML
    private TextField uemail;

    @FXML
    private ChoiceBox tier;

    @FXML
    private TextField ucard;

    public void add() {
        synchronized (Main.getSimulation()) {
            Main.getSimulation().createUser(uname.getText(), upassword.getText(), uemail.getText(), tier.getSelectionModel().getSelectedIndex());
            uname.setText("");
            upassword.setText("");
            uemail.setText("");
            ucard.setText("");
        }
    }

    public void close() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        ObservableList obList = FXCollections.observableList(list);
        tier.getItems().clear();
        tier.getItems().clear();
        for(Object temp : obList)
        {
            tier.getItems().add(temp);
        }
    }
}
