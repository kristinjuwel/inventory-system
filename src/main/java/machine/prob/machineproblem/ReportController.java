package machine.prob.machineproblem;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import machine.prob.machineproblem.menu.Index;

public class ReportController implements Initializable {
    public Button exportButton;
    private Stage stage;
    @FXML
    TableView<Index> tvStocks;
    @FXML
    TableColumn<Index, String> skuColumn;
    @FXML
    TableColumn<Index, String> itemColumn;
    @FXML
    TableColumn<Index, String> categoryColumn;
    @FXML
    TableColumn<Index, String> quantityColumn;
    @FXML
    TableColumn<Index, String> unitColumn;
    @FXML
    TableColumn<Index, String> brandColumn;
    @FXML
    TableColumn<Index, String> colorColumn;
    @FXML
    TableColumn<Index, String> descriptionColumn;



    @FXML
    void exit(ActionEvent actionEvent) {

        /**
         * The exit method is in charge of exiting the whole program.
         */
        Platform.exit();
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException{
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

    @FXML
    void menu(ActionEvent actionEvent) throws IOException{
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

    @FXML
    void report(ActionEvent actionEvent) throws IOException{
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

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /**
         *  The initialize method is responsible for initializing the information
         *  on each column for the database.
         */
        //set up the columns in the table
        skuColumn.setCellValueFactory(new PropertyValueFactory<>("sku"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));


        try
        {
            tvStocks.setItems(loadStockDB());
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        tvStocks.setEditable(true);
        skuColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        unitColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        brandColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        colorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tvStocks.setEditable(false);
    }

    public ObservableList<Index> loadStockDB() throws IOException {
        /**
         * The observableList is responsible for making the database observable
         * to the table in the report's scene.
         */
        final ObservableList<Index> stockItm = FXCollections.observableArrayList();
        File file = new File("stocks.csv");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while((line = br.readLine())!= null)
        {

            String [] lineIdx = line.split(",");

            try {
                stockItm.add(new Index(lineIdx[0], lineIdx[1], lineIdx[2], lineIdx[3], lineIdx[4], lineIdx[5], lineIdx[6], lineIdx[7]));
            } catch (IndexOutOfBoundsException e){
                System.out.println("Something went wrong!");
            }
        }
        return stockItm;
    }

    public void stocks(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("stocks-view.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

    public void exportFile(ActionEvent actionEvent) throws IOException {
        /**
         * The exportFile method is in charge of opening the export-view.fxml which will
         * open a new window.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("export-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 225, 122);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


}
