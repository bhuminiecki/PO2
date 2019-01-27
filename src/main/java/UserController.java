import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    private TextField uname;

    @FXML
    private TextField upassword;

    @FXML
    private TextField uemail;

    @FXML
    private ChoiceBox<Integer> tier;

    @FXML
    private TextField ucard;

    public void add() {
        synchronized (Main.getSimulation()) {
            Main.getSimulation().createUser(uname.getText(), upassword.getText(), uemail.getText(), tier.getValue());
            uname.setText("");
            upassword.setText("");
            uemail.setText("");
            ucard.setText("");
        }
    }

    public void close() {

    }

}
