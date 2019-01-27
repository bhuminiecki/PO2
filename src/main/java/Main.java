import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import simulation.Simulation;

public class Main extends Application {

    private Simulation simulation = new Simulation();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("NETBLING");
        primaryStage.setScene(new Scene(root, 540, 485));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
