import account.Account;
import account.Distributor;
import account.User;
import entry.Entry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Controller {

    @FXML
    private DatePicker date;

    @FXML
    private Label balance;

    @FXML
    private ProgressIndicator running;

    @FXML
    private ListView<String> entries;

    @FXML
    private ListView<String> users;

    @FXML
    private ListView<String> distributors;

    @FXML
    private TextField base;

    @FXML
    private TextField family;

    @FXML
    private TextField premium;

    @FXML
    private TextField maxp;

    @FXML
    private TextField maxu;

    @FXML
    private Slider prob;

    @FXML
    private LineChart<LocalDate, BigDecimal> chart;

    public void setBalance() {
        balance.setText(Main.getSimulation().getBalance().toString());
    }

    public void startSimulation() {
        running.setVisible(true);
        Main.getSimulation().setStartDate(date.getValue());
        Main.getSimulation().run();
    }

    public void stopSimulation() {
        running.setVisible(false);
        Main.getSimulation().setRun(false);
    }

    public void loadSimulation() {
        try {
            Main.loadSim();
        } catch (Exception a) {
            System.out.println(a.toString());
        }
    }

    public void saveSimulation() {
        try {
            Main.saveSim();
        } catch (Exception a) {
            System.out.println(a.toString());
        }
    }

    public void resetSimulation() {
        Main.reset();
    }

    public void refresh() {
        synchronized (Main.getSimulation()) {
            entries.getItems().clear();
            for (Entry temp : Main.getSimulation().getPool().getEntries()) {
                entries.getItems().add(temp.toString());
            }
            users.getItems().clear();
            for (Account temp : Main.getSimulation().getAccounts()) {
                if (temp instanceof User) {
                    users.getItems().add(temp.getUsername());
                }
            }
            distributors.getItems().clear();
            for (Account temp : Main.getSimulation().getAccounts()) {
                if (temp instanceof Distributor) {
                    distributors.getItems().add(temp.getUsername());
                }
            }
        }
    }

    public void addEntries() {
        try {
            showEntries(new Stage());
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    public void addUsers() {
        try {
            showUser(new Stage());
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    public void addDistributors() {
        try {
            showDistributor(new Stage());
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    public void saveSettings() {
        synchronized (Main.getSimulation()) {
            Main.getSimulation().setTierCosts(new ArrayList<>(Arrays.asList(new BigDecimal(0), new BigDecimal(Integer.parseInt(base.getText())), new BigDecimal(Integer.parseInt(family.getText())), new BigDecimal(Integer.parseInt(premium.getText())))));
            Main.getSimulation().setMaxEntries(Integer.parseInt(maxp.getText()));
            Main.getSimulation().setMaxUsers(Integer.parseInt(maxu.getText()));
            Main.getSimulation().setProbability((int) prob.getValue());
        }
    }


    /**
     * Responsible for showing the user popup window
     *
     * @param user
     * @throws Exception
     */
    public void showUser(Stage user) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        user.setTitle("Users");
        user.setScene(new Scene(root, 600, 400));
        user.show();
    }

    /**
     * Responsible for showing the distributor popup window
     *
     * @param distributor
     * @throws Exception
     */
    public void showDistributor(Stage distributor) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("distributor.fxml"));
        distributor.setTitle("Distributors");
        distributor.setScene(new Scene(root, 600, 400));
        distributor.show();
    }


    /**
     * Responsible for showing the entries popup window
     *
     * @param entries
     * @throws Exception
     */
    public void showEntries(Stage entries) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("entry.fxml"));
        entries.setTitle("Entries");
        entries.setScene(new Scene(root, 600, 400));
        entries.show();
    }

    public void draw() {
        Map<LocalDate, BigDecimal> data = Main.getSimulation().getData();
        chart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<LocalDate, BigDecimal> temp : data.entrySet()) {
            series.getData().add(new XYChart.Data<>(temp.getKey(), temp.getValue()));
        }
        chart.getData().add(series);
    }
}
