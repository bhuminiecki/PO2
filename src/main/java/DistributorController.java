import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import java.math.BigDecimal;

public class DistributorController {

    @FXML
    private TextField dname;

    @FXML
    private TextField dpassword;

    @FXML
    private TextField demail;

    @FXML
    private TextField dpayment;

    @FXML
    private TextField daccount;

    public void add()
    {
        synchronized (Main.getSimulation()) {
            Main.getSimulation().createDistributor(dname.getText(), dpassword.getText(), demail.getText(), new BigDecimal(Double.parseDouble(dpayment.getText())), Integer.parseInt(daccount.getText()));
            dname.setText("");
            dpassword.setText("");
            demail.setText("");
            dpayment.setText("");
            daccount.setText("");
        }
    }

    public void close()
    {

    }
}
