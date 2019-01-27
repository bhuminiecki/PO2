import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {

    public DatePicker date;

    public Label balance;

    public ProgressIndicator running;

    public ListView<String> entries;

    public ListView<String> users;

    public ListView<String> distributors;

    public TextField base;

    public TextField family;

    public TextField premium;

    public TextField maxp;

    public TextField maxu;

    public Slider prob;

    public void startSimulation()
    {
        running.setVisible(true);
        Main.getSimulation().setStartDate(date.getValue());
        Main.getSimulation().run();
    }

    public void stopSimulation()
    {
        running.setVisible(false);
        Main.getSimulation().setRun(false);
    }

    public void loadSimulation() {
        try {
            Main.loadSim();
        } catch(Exception a) {
            System.out.println(a.toString());
        }
    }

    public void saveSimulation()
    {
        try {
            Main.saveSim();
        } catch(Exception a) {
            System.out.println(a.toString());
        }
    }

    public void resetSimulation()
    {
        Main.reset();
    }

    public void refresh()
    {

    }

    public void addEntries()
    {

    }

    public void addUsers()
    {

    }

    public void addDistributors()
    {

    }

    public void saveSettings()
    {


    }

}
