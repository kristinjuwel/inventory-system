package machine.prob.machineproblem;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;



public class Controller{

    public Button home_p;
    public Button menu_p;
    public Button stock_p;
    public Button report_p;
    public Button quit;
    public Button start;

    private Stage stage;

    @FXML
    public void exit(ActionEvent actionEvent) {
        /**
         * The exit method is in charge of exiting the whole program.
         */
        Platform.exit();
    }
    @FXML
    public void enter(ActionEvent actionEvent) throws IOException {
        /**
         * The enter method is in charge of loading the main-view.fxml which will show the
         * user interface for the page where the options for what to do in the program will
         * be shown.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("main-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

    public void home(ActionEvent actionEvent) throws IOException{
        /**
         * The home method is in charge of loading the hello-view.fxml which will show the
         * home page. The home page is the first scene that is scene when the program is
         * loaded.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

    public void menu(ActionEvent actionEvent) throws IOException{
        /**
         * The menu method is in charge of loading the main-view.fxml which will show the
         * user interface for the page where the options for what to do in the program will
         * be shown.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("menu-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }
    public void stocks(ActionEvent actionEvent) throws IOException{
        /**
         * The stocks method is in charge of loading the stocks-view.fxml which will show the
         * user interface for the page where the information for each ingredient that is in
         * stock. This is complete with the ingredients photos, and other details.
         *
         * The user may add and remove ingredients, as well as adding and subtracting the
         * quantity.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("stocks-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }
    public void report(ActionEvent actionEvent) throws IOException{
        /**
         * The report method is in charge of loading the report-view.fxml which will show the
         * user interface for the report page. The report page shows the table which reflects
         * the csv files for the stocks.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("report-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

}