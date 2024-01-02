package machine.prob.machineproblem;

import java.io.*;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import machine.prob.machineproblem.menu.CategoryOptions;
import machine.prob.machineproblem.menu.Index;

public class StockController {
    public Label itemSKU;
    public Label itemItem;
    public Label itemCategory;
    public Label itemQuantity;
    public Label itemUnit;
    public Label itemBrand;
    public Label itemColor;
    public Label itemDescription;
    public Label itemEntry;
    public Label itemUsage;
    public Label itemAdded;
    @FXML
    AnchorPane importButton;
    @FXML
    TextField filenameText;
    @FXML
    Label labelText;
    @FXML
    Spinner<Double> usageSpinner;
    @FXML
    Spinner<Double> addSpinner;
    @FXML
    Button deleter;
    ArrayList<String> list = new ArrayList<>();
    @FXML
    Label SKUDisplay;
    @FXML
    TextField inputItem;
    @FXML
    TextField inputCategory;
    @FXML
    TextField inputQuantity;
    @FXML
    TextField inputUnit;
    @FXML
    TextField inputBrand;
    @FXML
    TextField inputColor;
    @FXML
    TextField inputDescription;

    public Label selectedCategory;
    public AnchorPane stockTablePane;
    public Label itemName;
    public ImageView imageView;
    private Stage stage;
    public Double maximumUsage = 0.0;
    public Double addedQuantity = 0.0;

    public Double totalUsage = 0.0;


    @FXML
    private ToggleGroup stockChoices;

    String finder = "";
    // IMAGES FOR CONDIMENTS
    Image blackPepper = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/BlackPepper.png")));
    Image bonitoFlakes = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/BonitoFlakes.png")));
    Image cayennePepper = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/CayennePepper.png")));
    Image greenOnion = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/GreenOnion.png")));
    Image ketchup = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Ketchup.png")));
    Image kosherSalt = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/KosherSalt.png")));
    Image mayo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Mayo.png")));
    Image misoPaste = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/MisoPaste.png")));
    Image sake = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Sake.png")));
    Image salt = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Salt.png")));
    Image sesameSeed = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/SesameSeed.png")));
    Image soySauce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/SoySauce.png")));
    Image sriracha = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Sriracha.png")));
    Image spicyMayo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/SpicyMayo.png")));
    Image tomatoPaste = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/TomatoPaste.png")));
    Image wasabi = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/Wasabi.png")));
    Image whiteSugar = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/CONDIMENTS/WhitePepper.png")));


    // IMAGES FOR OIL
    Image vegOil = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/VegetableOil.png")));
    Image canOil = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/CanolaOil.png")));
    Image sesameOil = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/SesameOil.png")));

    // IMAGES FOR VINEGAR
    Image riceVinegar = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/RiceVinegar.png")));

    // IMAGES FOR SAUCE
    Image tonkatsuSauce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/TonkatsuSauce.png")));

    // IMAGES FOR PRODUCE
    Image milk = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/Milk.png")));
    Image egg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/Egg.png")));

    // IMAGES FOR FLAVORING
    Image vanillaExtract = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/VanillaExtract.png")));
    Image nori = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/Nori.png")));

    // IMAGES FOR STOCK
    Image dashi = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/WET/DashiSoupStock.png")));

    // IMAGES FOR DRY INGREDIENTS
    Image pankoCrumbs = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/PankoBreadCrumbs.png")));
    Image allPurpose = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/AllPurposeFlour.png")));
    Image bakingPowder = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/BakingPowder.png")));
    Image japRiceFlour = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/JapRiceFlour.png")));
    Image shiratamako = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/Shiratamako.png")));
    Image cornstarch = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/Cornstarch.png")));
    Image matcha = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/Matcha.png")));
    Image potatoStarch = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/DRY/PotatoStarch.png")));

    // IMAGES FOR NOODLES
    Image chukamen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/OTHERS/Chukamen.png")));

    // IMAGES FOR PASTA
    Image wonton = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/OTHERS/Wonton.png")));

    // IMAGES FOR DAIRY
    Image iceCream = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/OTHERS/IceCream.png")));
    Image butter = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/OTHERS/UnsaltedButter.png")));

    // IMAGES FOR RICE
    Image sushiRice = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/OTHERS/SushiRice.png")));

    // IMAGES FOR VEGETABLE
    Image avocado = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Avocado.png")));
    Image cabbage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Cabbage.png")));
    Image carrot = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Carrot.png")));
    Image cucumber = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Cucumber.png")));
    Image garlic = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Garlic.png")));
    Image ginger = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Ginger.png")));
    Image japEgg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/JapEggPlant.png")));
    Image lemon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Lemon.png")));
    Image mushroom = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Mushroom.png")));
    Image onion = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/VEGETABLE/Onion.png")));

    // IMAGES FOR MEAT
    Image chickenThigh = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/ChickenThigh.png")));
    Image crabSticks = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/Crabsticks.png")));
    Image drainedTuna = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/DrainedTuna.png")));
    Image groundPork = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/GroundPork.png")));
    Image ham = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/Ham.png")));
    Image porkChop = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/PorkChop.png")));
    Image silkenTofu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/SilkenTofu.png")));
    Image yellowTail = new Image(Objects.requireNonNull(getClass().getResourceAsStream("INGREDIENTS/MEAT/YellowTail.png")));

    // IMAGES FOR MERCH
    Image fan = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/fan.png")));
    Image kittyTote = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/JapaneseKitty.png")));
    Image shibaTote = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/ShibaTote.png")));
    Image shirt = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/shirt.png")));

    // IMAGES FOR BEVERAGES
    Image water = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/BottledWater.png")));
    Image coffee = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/Coffee.png")));
    Image coke = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/Coke.png")));
    Image cranberry = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/CranberryJuice.png")));
    Image pineapple = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/PineappleJuice.png")));


    @FXML
    void exit(ActionEvent actionEvent) {

        /**
         * The exit method is in charge of exiting the whole program.
         */
        Platform.exit();
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException {
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
    void menu(ActionEvent actionEvent) throws IOException {
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
    void report(ActionEvent actionEvent) throws IOException {
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

    @FXML
    void stocks(ActionEvent event) throws IOException {
        /**
         * The stocks method is in charge of loading the stocks-view.fxml which will show the
         * user interface for the page where the information for each ingredient that is in
         * stock. This is complete with the ingredients photos, and other details.
         *
         * The user may add and remove ingredients, as well as adding and subtracting the
         * quantity.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("stocks-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 963, 540);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.show();
    }

    void initSpinner() {

        SpinnerValueFactory<Double> spinnerOne = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100);
        SpinnerValueFactory<Double> spinnerTwo = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, maximumUsage);
        addSpinner.setValueFactory(spinnerOne);
        usageSpinner.setValueFactory(spinnerTwo);
    }

    @FXML
    void selectMeat(ActionEvent actionEvent) {
        /**
         * The selectMeat method is executed when the user chooses the meat option in the
         * stocks page (via radio button). It is in charge of displaying the meat
         * present in the inventory. Once meat has been clicked, it will display
         * what item that is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of meat
         */
        selectedCategory.setText("Meat");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Meat");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Meat");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Chicken Thigh")) {
                        itemName.setText("Chicken Thigh");
                        imageView.setImage(chickenThigh);
                        finder = "Chicken Thigh";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Pork Chops")) {
                        itemName.setText("Pork Chops");
                        imageView.setImage(porkChop);
                        finder = "Pork Chops";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Drained Tuna")) {
                        itemName.setText("Drained Tuna");
                        imageView.setImage(drainedTuna);
                        finder = "Drained Tuna";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Hamachi Yellow Tail")) {
                        itemName.setText("Hamachi Yellowtail");
                        imageView.setImage(yellowTail);
                        finder = "Hamachi Yellow Tail";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Crabsticks")) {
                        itemName.setText("Crab Sticks");
                        imageView.setImage(crabSticks);
                        finder = "Crabsticks";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Ham")) {
                        itemName.setText("Ham");
                        imageView.setImage(ham);
                        finder = "Ham";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Ground Pork")) {
                        itemName.setText("Ground Pork");
                        imageView.setImage(groundPork);
                        finder = "Ground Pork";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Silken Tofu")) {
                        itemName.setText("Silken Tofu");
                        imageView.setImage(silkenTofu);
                        finder = "Silken Tofu";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }));
            return row;
        });

    }

    @FXML
    void selectProduce(ActionEvent actionEvent) {
        /**
         * The selectProduce method is executed when the user chooses the produce option in the
         * stocks page (via radio button). It is in charge of displaying the produce present
         * in the inventory. Once the produce has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of produce
         */
        selectedCategory.setText("Produce");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Produce");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Produce");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Milk")) {
                        itemName.setText("Milk");
                        imageView.setImage(milk);
                        finder = "Milk";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Egg")) {
                        itemName.setText("Egg");
                        imageView.setImage(egg);
                        finder = "Egg";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });

    }

    @FXML
    void selectVegetable(ActionEvent actionEvent) {
        /**
         * The selectVegetable method is executed when the user chooses the vegetable option in the
         * stocks page (via radio button). It is in charge of displaying the vegetable present
         * in the inventory. Once the vegetable has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of vegetable
         */
        selectedCategory.setText("Vegetable");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Vegetable");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Vegetables");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Cabbage")) {
                        itemName.setText("Cabbage");
                        imageView.setImage(cabbage);
                        finder = "Cabbage";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Carrot")) {
                        itemName.setText("Carrot");
                        imageView.setImage(carrot);
                        finder = "Carrot";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Garlic")) {
                        itemName.setText("Garlic");
                        imageView.setImage(garlic);
                        finder = "Garlic";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Onion")) {
                        itemName.setText("Onion");
                        imageView.setImage(onion);
                        finder = "Onion";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Mushroom")) {
                        itemName.setText("Mushroom");
                        imageView.setImage(mushroom);
                        finder = "Mushroom";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Cucumber")) {
                        itemName.setText("Cucumber");
                        imageView.setImage(cucumber);
                        finder = "Cucumber";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Japanese Eggplant")) {
                        itemName.setText("Japanese Eggplant");
                        imageView.setImage(japEgg);
                        finder = "Japanese Eggplant";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Ginger")) {
                        itemName.setText("Ginger");
                        imageView.setImage(ginger);
                        finder = "Ginger";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Lemon")) {
                        itemName.setText("Lemon");
                        imageView.setImage(lemon);
                        finder = "Lemon";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Avocado")) {
                        itemName.setText("Avocado");
                        imageView.setImage(avocado);
                        finder = "Avocado";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectDryIngredient(ActionEvent actionEvent) {
        /**
         * The selectDryIngredient method is executed when the user chooses the dry ingredient
         * option in the stocks page (via radio button). It is in charge of displaying the dry
         * ingredients present in the inventory. Once a dry ingredient has been clicked, it
         * will display what item that is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of dry ingredient
         */
        selectedCategory.setText("Dry Ingredients");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Dry Ingredient");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Dry Ingredients");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Panko Bread Crumbs")) {
                        itemName.setText("Panko Bread Crumbs");
                        imageView.setImage(pankoCrumbs);
                        finder = "Panko Bread Crumbs";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("All-Purpose Flour")) {
                        itemName.setText("All-Purpose Flour");
                        imageView.setImage(allPurpose);
                        finder = "All-Purpose Flour";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Baking Powder")) {
                        itemName.setText("Baking Powder");
                        imageView.setImage(bakingPowder);
                        finder = "Baking Powder";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Japanese Rice Flour")) {
                        itemName.setText("Japanese Rice Flour");
                        imageView.setImage(japRiceFlour);
                        finder = "Japanese Rice Flour";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Shiratamako")) {
                        itemName.setText("Shiratamako");
                        imageView.setImage(shiratamako);
                        finder = "Shiratamako";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Cornstarch")) {
                        itemName.setText("Cornstarch");
                        imageView.setImage(cornstarch);
                        finder = "Cornstarch";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Matcha Green Tea Powder")) {
                        itemName.setText("Matcha Green Tea Powder");
                        imageView.setImage(matcha);
                        finder = "Matcha Green Tea Powder";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Potato Starch")) {
                        itemName.setText("Potato Starch");
                        imageView.setImage(potatoStarch);
                        finder = "Potato Starch";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });

    }

    @FXML
    void selectNoodles(ActionEvent actionEvent) {
        /**
         * The selectNoodles method is executed when the user chooses the noodles option in the
         * stocks page (via radio button). It is in charge of displaying the noodles present
         * in the inventory. Once a noodle has been clicked, it will display what
         * item that is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of noodle
         */
        selectedCategory.setText("Noodles");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Noodles");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Noodles");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Chukamen Noodles")) {
                        itemName.setText("Chukamen Noodles");
                        imageView.setImage(chukamen);
                        finder = "Chukamen Noodles";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectPasta(ActionEvent actionEvent) {
        /**
         * The selectPasta method is executed when the user chooses the pasta option in the
         * stocks page (via radio button). It is in charge of displaying the pasta present
         * in the inventory. Once pasta has been clicked, it will display what item that is
         * and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of pasta
         */
        selectedCategory.setText("Pasta");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Pasta");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Pasta");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Wonton Wrappers")) {
                        itemName.setText("Wonton Wrappers");
                        imageView.setImage(wonton);
                        finder = "Wonton Wrappers";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }

                }
            }));
            return row;
        });
    }

    @FXML
    void selectRice(ActionEvent actionEvent) {
        /**
         * The selectRice method is executed when the user chooses the rice option in the
         * stocks page (via radio button). It is in charge of displaying the rice present
         * in the inventory. Once the rice has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of rice
         */
        selectedCategory.setText("Rice");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Rice");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Rice");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Sushi Rice")) {
                        itemName.setText("Sushi Rice");
                        imageView.setImage(sushiRice);
                        finder = "Sushi Rice";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectDairy(ActionEvent actionEvent) {
        /**
         * The selectDairy method is executed when the user chooses the dairy option in the
         * stocks page (via radio button). It is in charge of displaying the dairy present
         * in the inventory. Once the dairy has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of dairy
         */
        selectedCategory.setText("Dairy");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Dairy");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Dairy");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Ice Cream")) {
                        itemName.setText("Ice Cream");
                        imageView.setImage(iceCream);
                        finder = "Ice Cream";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Unsalted Butter")) {
                        itemName.setText("Unsalted Butter");
                        imageView.setImage(butter);
                        finder = "Unsalted Butter";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectCondiment(ActionEvent actionEvent) {
        /**
         * The selectCondiment method is executed when the user chooses the condiment option in the
         * stocks page (via radio button). It is in charge of displaying the condiment present
         * in the inventory. Once the condiment has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of condiment
         */
        selectedCategory.setText("Condiment");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Condiment");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }


        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Condiment");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Kosher Salt")) {
                        itemName.setText("Kosher Salt");
                        imageView.setImage(kosherSalt);
                        finder = "Kosher Salt";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Salt")) {
                        itemName.setText("Salt");
                        imageView.setImage(salt);
                        finder = "Salt";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Black Pepper")) {
                        itemName.setText("Black Pepper");
                        imageView.setImage(blackPepper);
                        finder = "Black Pepper";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Ketchup")) {
                        itemName.setText("Ketchup");
                        imageView.setImage(ketchup);
                        finder = "Ketchup";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Wasabi")) {
                        itemName.setText("Wasabi");
                        imageView.setImage(wasabi);
                        finder = "Wasabi";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Bonito Flakes")) {
                        itemName.setText("Bonito Flakes");
                        imageView.setImage(bonitoFlakes);
                        finder = "Bonito Flakes";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Sriracha")) {
                        itemName.setText("Sriracha");
                        imageView.setImage(sriracha);
                        finder = "Sriracha";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Green Onion")) {
                        itemName.setText("Green Onion");
                        imageView.setImage(greenOnion);
                        finder = "Green Onion";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("White Sugar")) {
                        itemName.setText("White Sugar");
                        imageView.setImage(whiteSugar);
                        finder = "White Sugar";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Cayenne Pepper")) {
                        itemName.setText("Cayenne Pepper");
                        imageView.setImage(cayennePepper);
                        finder = "Cayenne Pepper";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Spicy Mayonnaise")) {
                        itemName.setText("Spicy Mayonnaise");
                        imageView.setImage(spicyMayo);
                        finder = "Spicy Mayonnaise";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Mayonnaise")) {
                        itemName.setText("Mayonnaise");
                        imageView.setImage(mayo);
                        finder = "Mayonnaise";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Tomato Paste")) {
                        itemName.setText("Tomato Paste");
                        imageView.setImage(tomatoPaste);
                        finder = "Tomato Paste";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Sesame Seeds")) {
                        itemName.setText("Sesame Seeds");
                        imageView.setImage(sesameSeed);
                        finder = "Sesame Seeds";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Miso Paste")) {
                        itemName.setText("Miso Paste");
                        imageView.setImage(misoPaste);
                        finder = "Miso Paste";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Soy Sauce")) {
                        itemName.setText("Soy Sauce");
                        imageView.setImage(soySauce);
                        finder = "Soy Sauce";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Sake")) {
                        itemName.setText("Sake");
                        imageView.setImage(sake);
                        finder = "Sake";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectFlavoring(ActionEvent actionEvent) {
        /**
         * The selectFlavoring method is executed when the user chooses the flavoring option in the
         * stocks page (via radio button). It is in charge of displaying the flavoring present
         * in the inventory. Once the flavoring has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of flavoring
         */
        selectedCategory.setText("Flavoring");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Flavoring");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Flavoring");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Vanilla Extract")) {
                        itemName.setText("Vanilla Extract");
                        imageView.setImage(vanillaExtract);
                        finder = "Vanilla Extract";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Nori")) {
                        itemName.setText("Nori");
                        imageView.setImage(nori);
                        finder = "Nori";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectVinegar(ActionEvent actionEvent) {
        /**
         * The selectVinegar method is executed when the user chooses the vinegar option in the
         * stocks page (via radio button). It is in charge of displaying the vinegar present
         * in the inventory. Once the vinegar has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of vinegar
         */
        selectedCategory.setText("Vinegar");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Vinegar");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Vinegar");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Rice Vinegar")) {
                        itemName.setText("Rice Vinegar");
                        imageView.setImage(riceVinegar);
                        finder = "Rice Vinegar";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectOil(ActionEvent actionEvent) {
        /**
         * The selectOil method is executed when the user chooses the oil option in the
         * stocks page (via radio button). It is in charge of displaying the oil present
         * in the inventory. Once the oil has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of oil
         */
        selectedCategory.setText("Oil");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Oil");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Oil");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Sesame Oil")) {
                        itemName.setText("Sesame Oil");
                        imageView.setImage(sesameOil);
                        finder = "Sesame Oil";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Vegetable Oil")) {
                        itemName.setText("Vegetable Oil");
                        imageView.setImage(vegOil);
                        finder = "Vegetable Oil";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Canola Oil")) {
                        itemName.setText("Canola Oil");
                        imageView.setImage(canOil);
                        finder = "Canola Oil";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectSauce(ActionEvent actionEvent) {
        /**
         * The selectSauce method is executed when the user chooses the sauce option in the
         * stocks page (via radio button). It is in charge of displaying the sauce present
         * in the inventory. Once the sauce has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of sauce
         */
        selectedCategory.setText("Sauce");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Sauce");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Sauce");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Tonkatsu Sauce")) {
                        itemName.setText("Tonkatsu Sauce");
                        imageView.setImage(tonkatsuSauce);
                        finder = "Tonkatsu Sauce";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectStock(ActionEvent actionEvent) {
        /**
         * The selectStock method is executed when the user chooses the stock option in the
         * stocks page (via radio button). It is in charge of displaying the stock present
         * in the inventory. Once the stock has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of stock
         */
        selectedCategory.setText("Stock");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Stock");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Stock");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Dashi Soup Stock")) {
                        itemName.setText("Dashi Soup Stock");
                        imageView.setImage(dashi);
                        finder = "Dashi Soup Stock";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectBeverage(ActionEvent actionEvent) {
        /**
         * The selectBeverage method is executed when the user chooses the beverage option in the
         * stocks page (via radio button). It is in charge of displaying the beverage present
         * in the inventory. Once the beverage has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of beverage
         */
        selectedCategory.setText("Beverage");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Beverage");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Beverages");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        URL location = null;
        ResourceBundle resources = null;
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Bottled Water")) {
                        itemName.setText("Bottled Water");
                        imageView.setImage(water);
                        finder = "Bottled Water";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Coffee")) {
                        itemName.setText("Coffee");
                        imageView.setImage(coffee);
                        finder = "Coffee";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Coke")) {
                        itemName.setText("Coke");
                        imageView.setImage(coke);
                        finder = "Coke";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Cranberry Juice")) {
                        itemName.setText("Cranberry Juice");
                        imageView.setImage(cranberry);
                        finder = "Cranberry Juice";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Pineapple Juice")) {
                        itemName.setText("Pineapple Juice");
                        imageView.setImage(pineapple);
                        finder = "Pineapple Juice";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void selectMerch(ActionEvent actionEvent) {
        /**
         * The selectMerch method is executed when the user chooses the merch option in the
         * stocks page (via radio button). It is in charge of displaying the merch present
         * in the inventory. Once the merch has been clicked, it will display what item that
         * is and its image.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of merch
         */
        selectedCategory.setText("Merch");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        ArrayList<String> categoryFilter = filter("Merch");
        for (int i = 0; i < categoryFilter.size(); i++) {
            tableData.add(new CategoryOptions(categoryFilter.get(i)));
        }
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Merchandise");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        stockTablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Made in Japan Shirt")) {
                        itemName.setText("Made in Japan Shirt");
                        imageView.setImage(shirt);
                        finder = "Made in Japan Shirt";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Shiba Dog Tote Bag")) {
                        itemName.setText("Shiba Dog Tote Bag");
                        imageView.setImage(shibaTote);
                        finder = "Shiba Dog Tote Bag";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Japanese Kitty Tote Bag")) {
                        itemName.setText("Japanese Kitty Tote Bag");
                        imageView.setImage(kittyTote);
                        finder = "Japanese Kitty Tote Bag";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (table.getSelectionModel().getSelectedItem().getName().equals("Cherry Blossom Fan")) {
                        itemName.setText("Cherry Blossom Fan");
                        imageView.setImage(fan);
                        finder = "Cherry Blossom Fan";
                        try {
                            fullRefresher();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }));
            return row;
        });
    }

    @FXML
    void addWindow(ActionEvent actionEvent) throws IOException {
        /**
         * The addWindow method is responsible for opening a new window that will show what the
         * add-stocks.fxml contains. The user will be able to add new ingredients into the system.
         * The user is to input different details needed for the new ingredient.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("add-stocks.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 317, 350);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    @FXML
    void appendToStock(ActionEvent event) throws IOException {
        /**
         * The appendToStock method adds to the csv database file the input of information
         * about the new ingredient. The information about the ingredients is from the
         * add-stocks.fxml.
         */
        String SKU, Item, Category, Qty, Unit, Brand, Color, Description;
        Item = inputItem.getText();
        Category = inputCategory.getText();
        Qty = inputQuantity.getText();
        Unit = inputUnit.getText();
        Brand = inputBrand.getText();
        Color = inputColor.getText();
        Description = inputDescription.getText();
        SKU = codeGenerator(Category, Item);
        SKUDisplay.setText(SKU);
        Path file = Paths.get("stocks.csv");
        Files.writeString(file, SKU + "," + Item + "," + Category + "," + Qty + "," + Unit
                        + "," + Brand + "," + Color + "," + Description + System.getProperty("line.separator"),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    @FXML
    String codeGenerator(String category, String item) {
        /**
         * The codeGenerator method is in charge of generating the SKU code for the ingredients.
         * It generates a random four-digit code from 0000 to 9999.
         *
         * @return SKU  This returns the SKU of the chosen ingredient
         */
        for (int i = 0; i < 9999; i++) list.add(String.valueOf(i));
        Collections.shuffle(list);
        String c = category.toUpperCase();
        String i = item.toUpperCase();
        Random random = new java.util.Random();
        addTaken(listSKUNumb());
        int randomValue = random.nextInt(list.size() + 1);
        int skuNumber = Integer.parseInt(list.get(randomValue));
        return String.valueOf(c.charAt(0)) + c.charAt(c.length() - 1) + i.charAt(0) + i.charAt(i.length() - 1) + "-" + String.format("%04d", skuNumber);
    }

    ArrayList<String> listWholeSKU() {
        /**
         *  The listWholeSKU is in charge of listing the whole SKU itself which
         *  includes the letter and four-digit code.
         */

        File f = new File("stocks.csv");
        BufferedReader freader;
        try {
            freader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String oldSKU, oldItem, oldCateg, oldQty = null, oldLine = null;
        String s;
        ArrayList<String> containers = new ArrayList<>();

        while (true) {
            try {
                if (!((s = freader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            containers.add(sku);
        }
        return containers;
    }

    ArrayList<String> listSKUNumb() {
        /**
         *  The listSKUNumb is in charge of listing only the four-digit code.
         */
        File f = new File("stocks.csv");
        BufferedReader freader;
        try {
            freader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String oldSKU, oldItem, oldCateg, oldQty = null, oldLine = null;
        String s;
        ArrayList<String> containers = new ArrayList<>();

        while (true) {
            try {
                if (!((s = freader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            String[] stsku = sku.split("-");
            containers.add(stsku[1]);
        }
        return containers;
    }

    void addTaken(ArrayList<String> taken) {
        /**
         * The addTaken method is responsible for taking out the SKU numbers already generated.
         * This is to ensure that no SKU will be repeated.
         *
         * @param taken arraylist of the numbers already taken for the SKUs of other ingredients
         */
        for (int i = 0; i < taken.size(); i++) {
            list.remove(String.valueOf(taken.get(i)));
        }
    }

    @FXML
    void addExisting(ActionEvent actionEvent) throws IOException {
        /**
         *  The addExisting method is where the addition of exisiting ingredients 
         *  can be done with the help of displaying the add-existing.fml file. The
         *  fxml file is contains the code for the popping of a new window in order
         *  for the user to add to the existing ingredient.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("add-existing.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 317, 350);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();


    }

    @FXML
    void bulkAdd(ActionEvent actionEvent) throws IOException {
        /**
         *  The bulkAdd method is responsible for showing the user interface via the
         *  import-view.fxml.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("import-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 225, 122);
        stage.getIcons().add(new Image("file:Icon.png"));
        stage.setTitle("JUROUJIN INVENTORY");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void restock(ActionEvent actionEvent) throws IOException {
        /**
         *  The restock method is in charge of adding the quantity
         *  for each item placed via the spinner.
         */
        Double addValue = addSpinner.getValueFactory().getValue();
        addedQuantity = addedQuantity + addValue;
        updateStock(finder, addValue);
        try {
            fullRefresher();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        addSpinner.getValueFactory().setValue(0.0);
    }

    @FXML
    void addUsage(ActionEvent actionEvent) throws IOException {
        /**
         *
         */
        Double subtractValue = usageSpinner.getValueFactory().getValue();
        totalUsage = totalUsage + subtractValue;
        removeStock(finder, subtractValue);
        try {
            fullRefresher();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        usageSpinner.getValueFactory().setValue(0.0);
    }


    @FXML
    void deleteItem(ActionEvent actionEvent) throws IOException {
        /**
         * The deleteItem method is responsible for deleting the item as well
         * as its other information
         */
        File file = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(file));
        String s;
        String fileContent;
        //Ilalagay niya sa
        StringBuffer buffer = new StringBuffer();
        while((s = freader.readLine()) != null) {
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            if(item.equals(finder)){
                //do nothing
            }
            else
            {
                buffer.append(s+System.lineSeparator());
            }
            fileContent = buffer.toString();
            FileWriter writer = new FileWriter(file);
            writer.append(fileContent);
            writer.flush();
        }
    }


    void loadStock(String filename) throws IOException {
        /**
         *
         */
        //read item from the file and assign to ObservableList
        final ObservableList<Index> stockItm = FXCollections.observableArrayList();
        Path file = Paths.get("stocks.csv");
        File files = new File(filename);
        FileReader reader = new FileReader(files);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while((line = br.readLine())!= null)
        {
            Files.writeString(file, line + System.getProperty("line.separator"),
                    StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
    }

    @FXML
    void importFile(ActionEvent actionEvent){
        /**
         * The importFile method is where the importing of the file happens. This also
         * reads the filename string inputted by the user.
         */
        labelText.setText("Enter filename:");
        String filename = filenameText.getText();
        try {
            loadStock(filename);
        } catch (IOException e) {
            filenameText.clear();
        }
    }


    void removeStock(String itemToEdit, Double usageValue) throws IOException {
        /**
         *
         */
        final DecimalFormat df = new DecimalFormat("00.0");
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU, oldItem, oldCateg, oldQty, oldUnit, oldBrand, oldColor, oldDesc, oldLine = null;
        String newSKU, newItem, newCateg, newQty, newUnit, newBrand, newColor, newDesc, newLine = null;
        String s;
        while((s = freader.readLine()) != null) {
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            if(item.equals(itemToEdit)){
                oldSKU = sku;
                oldItem = item;
                oldCateg = categ;
                oldQty = Qty;
                oldUnit = unit;
                oldBrand = brand;
                oldColor = color;
                oldDesc = desc;
                newSKU = oldSKU;
                newItem =oldItem;
                newCateg = oldCateg;
                newUnit = oldUnit;
                newBrand = oldBrand;
                newColor = oldColor;
                newDesc = oldDesc;

                newQty = df.format(Double.parseDouble(oldQty) - usageValue);
                oldLine = oldSKU+ "," +oldItem+ "," +oldCateg+ "," +oldQty + "," + oldUnit + "," + oldBrand +","+ oldColor + "," + oldDesc;
                newLine = newSKU+ "," +newItem+ "," +newCateg+ "," +newQty + "," + newUnit + "," + newBrand +","+ newColor + "," + newDesc;
                Scanner sc = new Scanner(f);
                StringBuffer buffer = new StringBuffer();
                while(sc.hasNextLine())
                {
                    buffer.append(sc.nextLine()+System.lineSeparator());
                }
                String fileContents = buffer.toString();
                //System.out.println("Contents of the file: " + fileContents);
                sc.close();
                fileContents = fileContents.replace(oldLine, newLine);
                FileWriter writer = new FileWriter(f);
                writer.append(fileContents);
                writer.flush();
            }
        }
    }

    void updateStock(String itemToEdit, Double restockValue) throws IOException {
        /**
         * The updateStock method is in charge of changing the database when it is edited by the user.
         *
         * @param itemToEdit    The item that will be edited of its quantity
         * @param restockValue  This is the quantity of how much will be added to the quantity
         */
        final DecimalFormat df = new DecimalFormat("00.0");
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU, oldItem, oldCateg, oldQty, oldUnit, oldBrand, oldColor, oldDesc, oldLine = null;
        String newSKU, newItem, newCateg, newQty, newUnit, newBrand, newColor, newDesc, newLine = null;
        String s;
        String[] st;
        while((s = freader.readLine()) != null) {
            st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            if(item.equals(itemToEdit)){
                //System.out.println("Detected: " + sku+" "+item+" "+categ+" "+Qty);

                oldSKU = sku;
                oldItem = item;
                oldCateg = categ;
                oldQty = Qty;
                oldUnit = unit;
                oldBrand = brand;
                oldColor = color;
                oldDesc = desc;
                newSKU = oldSKU;
                newItem = oldItem;
                newCateg = oldCateg;
                newUnit = oldUnit;
                newBrand = oldBrand;
                newColor = oldColor;
                newDesc = oldDesc;



                newQty = df.format(Double.parseDouble(oldQty) + restockValue);
                oldLine = oldSKU+ "," +oldItem+ "," +oldCateg+ "," + oldQty + "," + oldUnit + "," + oldBrand +","+ oldColor + "," + oldDesc;
                newLine = newSKU+ "," +newItem+ "," +newCateg+ "," + newQty + "," + newUnit + "," + newBrand +","+ newColor + "," + newDesc;

                Scanner sc = new Scanner(f);
                StringBuffer buffer = new StringBuffer();
                while(sc.hasNextLine())
                {
                    buffer.append(sc.nextLine()+System.lineSeparator());
                }
                String fileContents = buffer.toString();
                //System.out.println("Contents of the file: " + fileContents);
                sc.close();
                fileContents = fileContents.replaceAll(oldLine, newLine);
                FileWriter writer = new FileWriter(f);
                writer.append(fileContents);
                writer.flush();
            }
            else {

            }
        }

    }

    double maximumUse(String itemToEdit) throws IOException {
        /**
         *
         */
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String s;
        String line;
        String[] lineIdx = new String[0];
        Double quantityMax = 0.0;
        while ((s = freader.readLine()) != null) {
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            if (item.equals(itemToEdit)) {
                quantityMax = Double.parseDouble(Qty);
            }
        }
        return quantityMax;
    }

    ArrayList<String> filter(String Selection){
        /**
         *
         */
        File f = new File("stocks.csv");
        BufferedReader freader;
        try {
            freader = new BufferedReader(new FileReader(f));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String oldSKU, oldItem, oldCateg, oldQty = null, oldLine = null;
        String s;
        ArrayList<String> containers = new ArrayList<>();
        while (true)
        {
            try {
                if (!((s = freader.readLine()) != null)) break;
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            String[] stsku = sku.split("-");
            if (Selection.equals(categ))
            {
                containers.add(item);
            }
        }
        return containers;
    }

    String[] detailsExistingStock(String itemToEdit) throws IOException {
        /**
         *
         */
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU = "", oldItem = "", oldCateg= "", oldQty="", oldUnit= "", oldBrand= "", oldColor= "", oldDesc= "", oldLine;
        String s;
        while((s = freader.readLine()) != null) {
            String[] st = s.split(",");
            String sku = st[0];
            String item = st[1];
            String categ = st[2];
            String Qty = st[3];
            String unit = st[4];
            String brand = st[5];
            String color = st[6];
            String desc = st[7];
            if(item.equals(itemToEdit)){
                //System.out.println("Detected: " + sku+" "+item+" "+categ+" "+Qty);
                oldSKU = sku;
                oldItem = item;
                oldCateg = categ;
                oldQty = Qty;
                oldUnit = unit;
                oldBrand = brand;
                oldColor = color;
                oldDesc = desc;
            }
        }
        String[] array = {oldSKU, oldItem,oldCateg, oldQty, oldUnit, oldBrand, oldColor, oldDesc};
        return array;
    }
    public void fullRefresher() throws IOException {
        /**
         *
         */
        String array[] = detailsExistingStock(finder);

        try {
            maximumUsage = Double.valueOf(maximumUse(finder));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initSpinner();
        itemSKU.setText(array[0]);
        itemItem.setText(array[1]);
        itemCategory.setText(array[2]);
        itemQuantity.setText(array[3]);
        itemUnit.setText(array[4]);
        itemBrand.setText(array[5]);
        itemColor.setText(array[6]);
        itemDescription.setText(array[7]);
        itemEntry.setText(String.valueOf(maximumUsage + totalUsage - addedQuantity));
        itemUsage.setText(String.valueOf(totalUsage));
        itemAdded.setText(String.valueOf(addedQuantity));

    }

}
