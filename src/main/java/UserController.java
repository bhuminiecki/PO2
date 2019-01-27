import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import simulation.Simulation;

import javax.xml.soap.Text;
import java.awt.*;

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

    public void add()
    {
        Main.getSimulation().createUser(uname.getText(),upassword.getText(),uemail.getText(),tier.getValue());
    }

    public void close()
    {

    }

}
