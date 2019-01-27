import javafx.fxml.FXML;

import java.awt.*;
import java.math.BigDecimal;

public class DistributorController {

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField payment;

    @FXML
    private TextField account;

    public void add()
    {
        Main.getSimulation().createDistributor(name.getText(),password.getText(),email.getText(), new BigDecimal(Double.parseDouble(payment.getText())),Integer.parseInt(account.getText()));
    }

    public void close()
    {

    }

}
