import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.Contract;
import simulation.Simulation;
import java.io.*;

/* TODO:
    -thread synchronization
    -linking controllers
    -saving settings
    -popup management
    -plot
*/
public class Main extends Application {

    private static Simulation simulation = new Simulation();

    private static final String fpath = "sim.ser";

    /**
     * Starts the application with primary stage
     * @param primaryStage - primary stage of the application
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("NETBLING");
        primaryStage.setScene(new Scene(root, 540, 485));
        primaryStage.show();
    }

    /**
     * Saves the simulation using serialisation
     * @throws Exception
     */
    public static void saveSim() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fpath)));
        out.writeObject(simulation);
        out.close();
    }

    /**
     * Loads the simulation from file
     * @throws Exception
     */
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

    @Contract(pure = true)
    public static Simulation getSimulation() {
        return simulation;
    }
}
