package machine.prob.machineproblem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * The start method is in charge of loading the hello-view.fxml which will show the
         * user interface. This will provide a new scene for the home page.
         *
         * @param stage     The stage here the scene will be seen
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}