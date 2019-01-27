import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import simulation.Simulation;
import java.io.*;

public class Main extends Application {

    private static Simulation simulation = new Simulation();

    private static final String fpath = "sim.ser";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("NETBLING");
        primaryStage.setScene(new Scene(root, 540, 485));
        primaryStage.show();
    }

    public static void saveSim() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fpath)));
        out.writeObject(simulation);
        out.close();
    }

    public static void loadSim() throws Exception{
        ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(fpath)));
        simulation = (Simulation) in.readObject();
        in.close();
    }

    public static void reset() {
        simulation = new Simulation();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Simulation getSimulation() {
        return simulation;
    }
}
