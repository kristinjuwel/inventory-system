package machine.prob.machineproblem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import machine.prob.machineproblem.menu.CategoryOptions;
import machine.prob.machineproblem.menu.MenuOptions;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;


public class MenuController{

    public Button home_p;
    public Label select;
    public Button menu_p;
    public Button stock_p;
    public Button report_p;
    public Button quit;
    public ToggleGroup menu_choices;
    public AnchorPane tablePane;
    public ImageView menuImage;
    public Label recipeName;
    public TextArea ingredientList;
    public Label availableFood;

    String foodName = "";
    Double maximumUsage = 0.0;

    @FXML
    public Spinner<Double> mySpinner;
    private Stage stage;
    Image gyoza = new Image(Objects.requireNonNull(getClass().getResourceAsStream("APPETIZER/Gyoza.png")));
    Image karaage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("APPETIZER/Karaage.png")));
    Image onigiri = new Image(Objects.requireNonNull(getClass().getResourceAsStream("APPETIZER/Onigiri.png")));
    Image japanesePancakes = new Image(Objects.requireNonNull(getClass().getResourceAsStream("DESSERTS/JapanesePancakes.png")));
    Image hanamiDango = new Image(Objects.requireNonNull(getClass().getResourceAsStream("DESSERTS/HanamiDango.png")));
    Image mochiIceCream = new Image(Objects.requireNonNull(getClass().getResourceAsStream("DESSERTS/MochiIceCream.png")));
    Image omurice = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MAINCOURSE/Omurice.png")));
    Image shoyuRamen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MAINCOURSE/ShoyuRamen.png")));
    Image tonkatsu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MAINCOURSE/Tonkatsu.png")));
    Image yakisoba = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MAINCOURSE/Yakisoba.png")));
    Image shirt = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/shirt.png")));
    Image fan = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/fan.png")));
    Image shibaTote = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/ShibaTote.png")));
    Image kittyTote = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MERCH/JapaneseKitty.png")));
    Image chilledTofu = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SIDEDISHES/ChilledTofu.png")));
    Image nasuDengaku = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SIDEDISHES/NasuDengaku.png")));
    Image ramenEggs = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SIDEDISHES/RamenEggs.png")));
    Image tamagoyaki = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SIDEDISHES/Tamagoyaki.png")));
    Image californiaRoll = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SUSHI/CaliforniaRoll.png")));
    Image spicyTunaRoll = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SUSHI/SpicyTunaRoll.png")));
    Image yellowTailRoll = new Image(Objects.requireNonNull(getClass().getResourceAsStream("SUSHI/YellowtailSushiRoll.png")));
    Image bottledWater = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/BottledWater.png")));
    Image coffee = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/Coffee.png")));
    Image coke = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/Coke.png")));
    Image cranberryJuice = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/CranberryJuice.png")));
    Image pineappleJuice = new Image(Objects.requireNonNull(getClass().getResourceAsStream("BEVERAGES/PineappleJuice.png")));

    @FXML
    public void exit(ActionEvent actionEvent) {

        /**
         * The exit method is in charge of exiting the whole program.
         */
        Platform.exit();
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
    public void selectAppetizer(ActionEvent actionEvent) {
        /**
         * The selectAppetizer is responsible for displaying the details of the appetizer
         * selected which are showing the image of the appetizer, and changing the
         * [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of appetizer
         */
        ObservableList<MenuOptions> tableData = FXCollections.observableArrayList();
        TableView<MenuOptions> table = new TableView<>();
        select.setText("Appetizer");
        tableData.removeAll();
        tableData.add(new MenuOptions("Gyoza"));
        tableData.add(new MenuOptions("Karaage"));
        tableData.add(new MenuOptions("Onigiri"));
        TableColumn<MenuOptions, String> nameColumn = new TableColumn<>("Appetizers");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<MenuOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                    if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                        if (table.getSelectionModel().getSelectedItem().getName().equals("Gyoza")) {
                            menuImage.setImage(gyoza);
                            recipeName.setText("Gyoza");
                            ingredientList.setText("""
                                    Ingredient List:
                                    •1 tablespoon sesame oil
                                    •2 cups chopped cabbage
                                    •¼ cup chopped onion
                                    •1 clove garlic
                                    •¼ cup chopped carrot
                                    •½ pound ground pork
                                    •1 egg
                                    •1 tablespoon vegetable oil
                                    •1 package wonton wrappers
                                    •¼ cup water
                                    •¼ cup soy sauce
                                    •2 tablespoons rice vinegar
                                    """);
                            foodName = "Gyoza";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Sesame Oil") / 0.01);
                                ingredientList.add(maximumUse("Cabbage") / 0.1);
                                ingredientList.add(maximumUse("Onion") / 0.03);
                                ingredientList.add(maximumUse("Garlic") / 0.03);
                                ingredientList.add(maximumUse("Carrot") / 0.03);
                                ingredientList.add(maximumUse("Egg") / 1.0);
                                ingredientList.add(maximumUse("Vegetable Oil") / 0.01);
                                ingredientList.add(maximumUse("Wonton Wrappers") / 0.02);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.06);
                                ingredientList.add(maximumUse("Ground Pork") / 0.25);
                                ingredientList.add(maximumUse("Rice Vinegar") / 0.02);
                                for (int i = 0; i < ingredientList.size()-1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Karaage")) {
                            menuImage.setImage(karaage);
                            recipeName.setText("Karaage");
                            ingredientList.setText("""
                                    Ingredient List:
                                    •1 clove garlic
                                    •1 tablespoon fresh ginger
                                    •3 tablespoons soy sauce
                                    •3 tablespoons sake
                                    •⅛ teaspoon sesame oil
                                    •¼ teaspoon ground black pepper
                                    •1 pinch cayenne pepper
                                    •½ teaspoon white sugar
                                    •¼ teaspoon kosher salt
                                    •1¼ pounds chicken thighs
                                    •1 cup potato starch
                                    •1 quart canola oil, or as needed
                                    """);
                            foodName = "Karaage";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Garlic") / 0.03);
                                ingredientList.add(maximumUse("Ginger") / 0.5);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.04);
                                ingredientList.add(maximumUse("Sake") / 0.04);
                                ingredientList.add(maximumUse("Sesame Oil") / 0.002);
                                ingredientList.add(maximumUse("Black Pepper") / 0.001);
                                ingredientList.add(maximumUse("Cayenne Pepper") / 0.001);
                                ingredientList.add(maximumUse("White Sugar") / 0.002);
                                ingredientList.add(maximumUse("Kosher Salt") / 0.001);
                                ingredientList.add(maximumUse("Chicken Thigh") / 0.6);
                                ingredientList.add(maximumUse("Potato Starch") / 0.25);
                                ingredientList.add(maximumUse("Canola Oil") / 1.0);

                                for (int i = 0; i < ingredientList.size()-1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Onigiri")) {
                            menuImage.setImage(onigiri);
                            recipeName.setText("Onigiri");
                            ingredientList.setText("""
                                    Ingredient List:
                                    •2 cups sushi rice
                                    •2 cups water
                                    •1 can (5 ounces) light water-packed tuna
                                    •2 tablespoons reduced-sodium soy sauce
                                    •½ teaspoon prepared wasabi
                                    """);
                            foodName = "Onigiri";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Sushi Rice") / 0.4);
                                ingredientList.add(maximumUse("Drained Tuna") / 0.15);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.002);
                                ingredientList.add(maximumUse("Wasabi") / 0.001);
                                for (int i = 0; i < ingredientList.size()-1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));
                        }
                    }
                });
            });
            return row;
        });

    }
    public void selectMainCourse(ActionEvent actionEvent) {
        /**
         * The selectMainCourse is responsible for displaying the details of the main
         * course selected which are showing the image of the main course, and changing the
         * [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of main course
         */
        select.setText("Main Course");
        ObservableList<MenuOptions> tableData = FXCollections.observableArrayList();
        TableView<MenuOptions> table = new TableView<>();
        tableData.removeAll();
        tableData.add(new MenuOptions("Omurice"));
        tableData.add(new MenuOptions("Shoyu Ramen"));
        tableData.add(new MenuOptions("Tonkatsu"));
        tableData.add(new MenuOptions("Yakisoba"));
        tableData.add(new MenuOptions("California Roll"));
        tableData.add(new MenuOptions("Spicy Tuna Roll"));
        tableData.add(new MenuOptions("Yellowtail Sushi Roll"));
        TableColumn<MenuOptions, String> nameColumn = new TableColumn<>("Main Course");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<MenuOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Optional.ofNullable(row.getItem()).ifPresent(rowData -> {
                    if (event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())) {
                        if (table.getSelectionModel().getSelectedItem().getName().equals("Omurice")) {
                            menuImage.setImage(omurice);
                            recipeName.setText("Omurice");
                            ingredientList.setText("INGREDIENT LIST: \n•¼ onion (2.1 oz, 60 g)\n" +
                                    "•4 mushrooms (1.8 oz, 50 g)\n" +
                                    "•4 slices ham (2.8 oz, 80 g)\n" +
                                    "•1 tablespoon vegetable or canola oil\n" +
                                    "•⅛ teaspoon kosher salt\n" +
                                    "•⅛ teaspoon freshly ground black pepper\n" +
                                    "•2 cups cooked sushi rice\n" +
                                    "•2 tablespoons unsalted butter \n");
                            foodName = "Omurice";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Onion") / 0.006);
                                ingredientList.add(maximumUse("Mushroom") / 0.005);
                                ingredientList.add(maximumUse("Ham") / 0.008);
                                ingredientList.add(maximumUse("Vegetable Oil") / 0.014);
                                ingredientList.add(maximumUse("Kosher Salt") / 0.0001);
                                ingredientList.add(maximumUse("Black Pepper") / 0.0001);
                                ingredientList.add(maximumUse("Sushi Rice") / 0.5);
                                ingredientList.add(maximumUse("Unsalted Butter") / 0.03);
                                ingredientList.add(maximumUse("Ketchup") / 0.03);
                                ingredientList.add(maximumUse("Tomato Paste") / 0.03);
                                ingredientList.add(maximumUse("Egg") / 4.0);
                                ingredientList.add(maximumUse("Milk") / 0.03);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Shoyu Ramen")) {
                            menuImage.setImage(shoyuRamen);
                            recipeName.setText("Shoyu Ramen");
                            ingredientList.setText("INGREDIENT LIST: \n•1 teaspoon sesame oil\n" +
                                    "•1 teaspoon minced fresh ginger\n" +
                                    "•1 clove garlic\n" +
                                    "•1 cup dashi soup stock\n" +
                                    "•3 tablespoons soy sauce\n" +
                                    "•1 tablespoon sake\n" +
                                    "•1 teaspoon sugar\n" +
                                    "•1 teaspoon salt\n" +
                                    "•2 (3-ounce) packages dried chukamen noodles\n" +
                                    "•Green onion for optional garnish\n" +
                                    "•Nori, dried seaweed, for optional garnish\n" +
                                    "•Freshly ground black pepper, to taste\n");
                            foodName = "Shoyu Ramen";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Sesame Oil") / 0.001);
                                ingredientList.add(maximumUse("Ginger") / 0.001);
                                ingredientList.add(maximumUse("Garlic") / 0.03);
                                ingredientList.add(maximumUse("Dashi Soup Stock") / 0.25);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.04);
                                ingredientList.add(maximumUse("Sake") / 0.003);
                                ingredientList.add(maximumUse("White Sugar") / 0.002);
                                ingredientList.add(maximumUse("Salt") / 0.002);
                                ingredientList.add(maximumUse("Chukamen Noodles") / 0.12);
                                ingredientList.add(maximumUse("Green Onion") / 0.001);
                                ingredientList.add(maximumUse("Black Pepper") / 0.001);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Tonkatsu")) {
                            menuImage.setImage(tonkatsu);
                            recipeName.setText("Tonkatsu");
                            ingredientList.setText("INGREDIENT LIST: \n•¼ onion (2.1 oz, 60 g)\n" +
                                    "•4 mushrooms (1.8 oz, 50 g)\n" +
                                    "•4 slices ham (2.8 oz, 80 g)\n" +
                                    "•1 tablespoon vegetable or canola oil\n" +
                                    "•3 tablespoons green peas\n" +
                                    "•⅛ teaspoon kosher salt\n" +
                                    "•⅛ teaspoon freshly ground black pepper\n" +
                                    "•2 cups cooked sushi rice\n" +
                                    "•2 tablespoons unsalted butter\n" +
                                    "•3 tablespoons ketchup\n" +
                                    "•3 tablespoons tomato paste\n" +
                                    "•2 tablespoons water\n" +
                                    "•4 large eggs (50 g each w/o shell)\n" +
                                    "•2 tablespoons milk\n");
                            foodName = "Tonkatsu";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Vegetable Oil") / 0.25);
                                ingredientList.add(maximumUse("Pork Chops") / 0.5);
                                ingredientList.add(maximumUse("Black Pepper") / 0.001);
                                ingredientList.add(maximumUse("All-Purpose Flour") / 0.12);
                                ingredientList.add(maximumUse("Egg") / 1.0);
                                ingredientList.add(maximumUse("Panko Bread Crumbs") / 0.25);
                                ingredientList.add(maximumUse("Sushi Rice") / 0.24);
                                ingredientList.add(maximumUse("Tonkatsu Sauce") / 0.002);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Yakisoba")) {
                            menuImage.setImage(yakisoba);
                            recipeName.setText("Yakisoba");
                            ingredientList.setText("INGREDIENT LIST: \n•1 package fresh chukamen noodles\n" +
                                    "•½ yellow onion\n" +
                                    "•1 large carrot\n" +
                                    "•1 cup mushrooms\n" +
                                    "•¼ green cabbage\n" +
                                    "•2 sprigs green onions\n" +
                                    "•Vegetable oil\n" +
                                    "•Kosher salt\n" +
                                    "•1 tablespoon brown sugar\n" +
                                    "•4 tablespoons soy sauce\n" +
                                    "•1 tablespoon ketchup\n" +
                                    "•1 tablespoon sesame oil\n" +
                                    "•1 tablespoon rice vinegar\n" +
                                    "•1 teaspoon sriracha, optional\n");
                            foodName = "Yakisoba";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Chukamen Noodles") / 1.0);
                                ingredientList.add(maximumUse("Onion") / 0.005);
                                ingredientList.add(maximumUse("Carrot") / 0.005);
                                ingredientList.add(maximumUse("Mushroom") / 0.2);
                                ingredientList.add(maximumUse("Cabbage") / 0.05);
                                ingredientList.add(maximumUse("Green Onion") / 0.3);
                                ingredientList.add(maximumUse("Vegetable Oil") / 0.5);
                                ingredientList.add(maximumUse("Kosher Salt") / 0.003);
                                ingredientList.add(maximumUse("White Sugar") / 0.03);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.12);
                                ingredientList.add(maximumUse("Ketchup") / 0.03);
                                ingredientList.add(maximumUse("Sesame Oil") / 0.03);
                                ingredientList.add(maximumUse("Rice Vinegar") / 0.02);
                                ingredientList.add(maximumUse("Sriracha") / 0.001);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("California Roll")) {
                            menuImage.setImage(californiaRoll);
                            recipeName.setText("California Roll");
                            ingredientList.setText("INGREDIENT LIST: \n•2 cups of cooked sushi rice\n" +
                                    "•¼ cup seasoned rice vinegar\n" +
                                    "•Juice of 1/2 lemon\n" +
                                    "•1 avocado\n" +
                                    "•4 sheets Nori\n" +
                                    "•1/3 cup toasted sesame seeds\n" +
                                    "•1½ cucumber\n" +
                                    "•4 crabsticks\n" +
                                    "•Wasabi\n" +
                                    "•Soy sauce\n");
                            foodName = "California Roll";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Sushi Rice") / 0.03);
                                ingredientList.add(maximumUse("Rice Vinegar") / 0.5);
                                ingredientList.add(maximumUse("Lemon") / 0.04);
                                ingredientList.add(maximumUse("Avocado") / 0.04);
                                ingredientList.add(maximumUse("Nori") / 0.002);
                                ingredientList.add(maximumUse("Sesame Seeds") / 0.001);
                                ingredientList.add(maximumUse("Cucumber") / 0.001);
                                ingredientList.add(maximumUse("Crabsticks") / 0.002);
                                ingredientList.add(maximumUse("Wasabi") / 0.001);
                                ingredientList.add(maximumUse("Soy Sauce") / 0.6);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));

                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Spicy Tuna Roll")) {
                            menuImage.setImage(spicyTunaRoll);
                            recipeName.setText("Spicy Tuna Roll");
                            ingredientList.setText("INGREDIENT LIST: \n•2 cups cooked sushi rice\n" +
                                    "•¼ cup seasoned rice vinegar\n" +
                                    "•4 sheets of Nori\n" +
                                    "•1 can drained tuna\n" +
                                    "•1½ tbsp mayonnaise\n" +
                                    "•1½ tbsp sriracha\n" +
                                    "•1 green onion\n");
                            foodName = "Spicy Tuna Roll";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Sushi Rice") / 0.5);
                                ingredientList.add(maximumUse("Rice Vinegar") / 0.06);
                                ingredientList.add(maximumUse("Nori") / 0.5);
                                ingredientList.add(maximumUse("Drained Tuna") / 1.0);
                                ingredientList.add(maximumUse("Mayonnaise") / 0.02);
                                ingredientList.add(maximumUse("Sriracha") / 0.02);
                                ingredientList.add(maximumUse("Green Onion") / 0.002);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));


                        } else if (table.getSelectionModel().getSelectedItem().getName().equals("Yellowtail Sushi Roll")) {
                            menuImage.setImage(yellowTailRoll);
                            recipeName.setText("Yellowtail Sushi Roll");
                            ingredientList.setText("INGREDIENT LIST: \n•4 oz hamachi yellowtail (sushi-grade)\n" +
                                    "•1/2 cup cooked sushi rice\n" +
                                    "•¼ cup seasoned vinegar\n" +
                                    "•1 teaspoon Sriracha sauce\n" +
                                    "•1½ tbsp spicy mayonnaise\n" +
                                    "•1/2 sheet nori\n" +
                                    "•2 green onion\n" +
                                    "•¼ mini cucumber\n" +
                                    "•Wasabi\n");
                            foodName = "Yellowtail Sushi Roll";
                            try {
                                ArrayList<Double> ingredientList = new ArrayList<>();
                                ingredientList.add(maximumUse("Hamachi Yellow Tail") / 0.05);
                                ingredientList.add(maximumUse("Sushi Rice") / 0.12);
                                ingredientList.add(maximumUse("Rice Vinegar") / 0.06);
                                ingredientList.add(maximumUse("Sriracha") / 0.001);
                                ingredientList.add(maximumUse("Spicy Mayonnaise") / 0.02);
                                ingredientList.add(maximumUse("Nori") / 0.25);
                                ingredientList.add(maximumUse("Green Onion") / 0.003);
                                ingredientList.add(maximumUse("Cucumber") / 0.003);
                                ingredientList.add(maximumUse("Wasabi") / 0.002);

                                for (int i = 0; i < ingredientList.size() - 1; i++) {
                                    // return the minimum value of n numbers
                                    maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                    ingredientList.set(i + 1, maximumUsage);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            initSpinner();
                            availableFood.setText(String.valueOf(maximumUsage.intValue()));
                        }
                    }
                });
            });
            return row;
        });

    }
    public void selectDessert(ActionEvent actionEvent) {
        /**
         * The selectDessert is responsible for displaying the details of the merch
         * selected which are showing the image of the dessert, and changing the
         * [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of dessert
         */
        select.setText("Dessert");
        ObservableList<MenuOptions> tableData = FXCollections.observableArrayList();
        TableView<MenuOptions> table = new TableView<>();
        tableData.removeAll();
        tableData.add(new MenuOptions("Mochi Ice Cream"));
        tableData.add(new MenuOptions("Japanese Pancakes"));
        tableData.add(new MenuOptions("Hanami Dango"));
        TableColumn<MenuOptions, String> nameColumn = new TableColumn<>("Desserts");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<MenuOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData-> {
                if(event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())){
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Mochi Ice Cream")){
                        menuImage.setImage(mochiIceCream);
                        recipeName.setText("Mochi Ice Cream");
                        ingredientList.setText("INGREDIENT LIST: \n•100 g Shiratamako\n" +
                                "•180 ml water\n" +
                                "•55 g granulated white sugar\n" +
                                "•1/3 cup cornstarch\n" +
                                "•Ice cream of your choice\n");
                        foodName ="Mochi Ice Cream";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Shiratamako") / 0.01);
                            ingredientList.add(maximumUse("White Sugar") / 0.055);
                            ingredientList.add(maximumUse("Cornstarch") / 0.08);
                            ingredientList.add(maximumUse("Ice Cream") / 0.1);
                            for (int i = 0; i < ingredientList.size() - 1; i++) {
                                // return the minimum value of n numbers
                                maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                ingredientList.set(i + 1, maximumUsage);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Japanese Pancakes")){
                        menuImage.setImage(japanesePancakes);
                        recipeName.setText("Japanese Pancakes");
                        ingredientList.setText("INGREDIENT LIST: \n•4 large eggs\n" +
                                "•4 tablespoons milk\n" +
                                "•1 teaspoon vanilla extract\n" +
                                "•3 tablespoons white sugar\n" +
                                "•1 teaspoon baking powder\n" +
                                "•1/3 cup all-purpose flour\n" +
                                "•½ teaspoon canola oil\n");
                        foodName ="Japanese Pancakes";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Egg") / 4.0);
                            ingredientList.add(maximumUse("Milk") / 0.06);
                            ingredientList.add(maximumUse("Vanilla Extract") / 0.001);
                            ingredientList.add(maximumUse("White Sugar") / 0.04);
                            ingredientList.add(maximumUse("Baking Powder") / 0.001);
                            ingredientList.add(maximumUse("All-Purpose Flour") / 0.08);
                            ingredientList.add(maximumUse("Canola Oil") / 0.003);

                            for (int i = 0; i < ingredientList.size() - 1; i++) {
                                // return the minimum value of n numbers
                                maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                ingredientList.set(i + 1, maximumUsage);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Hanami Dango")) {
                        menuImage.setImage(hanamiDango);
                        recipeName.setText("Hanami Dango");
                        ingredientList.setText("INGREDIENT LIST: \n•1 cup Japanese Rice flour\n" +
                                "•1 cup shiratamako\n" +
                                "•½ cup sugar \n" +
                                "•¾ cup hot water\n" +
                                "•1 to 1½ teaspoon matcha green tea powder\n" +
                                "•2 tablespoons hot water\n");
                        foodName ="Hanami Dango";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Japanese Rice Flour") / 0.25);
                            ingredientList.add(maximumUse("Shiratamako") / 0.25);
                            ingredientList.add(maximumUse("White Sugar") / 0.007);
                            ingredientList.add(maximumUse("Matcha Green Tea Powder") / 0.004);

                            for (int i = 0; i < ingredientList.size() - 1; i++) {
                                // return the minimum value of n numbers
                                maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
                                ingredientList.set(i + 1, maximumUsage);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                }
            }));
            return row;
        });

    }
    public void selectBeverage(ActionEvent actionEvent) {
        /**
         * The selectBeverage is responsible for displaying the details of the beverage
         * selected which are showing the image of the beverage, and changing the
         * [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of beverage
         */
        select.setText("Beverage");
        ObservableList<MenuOptions> tableData = FXCollections.observableArrayList();
        TableView<MenuOptions> table = new TableView<>();
        tableData.removeAll();
        tableData.add(new MenuOptions("Bottled Water"));
        tableData.add(new MenuOptions("Coffee"));
        tableData.add(new MenuOptions("Coke"));
        tableData.add(new MenuOptions("Cranberry Juice"));
        tableData.add(new MenuOptions("Pineapple Juice"));
        TableColumn<MenuOptions, String> nameColumn = new TableColumn<>("Beverages");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<MenuOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData-> {
                if(event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())){
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Bottled Water")){
                        menuImage.setImage(bottledWater);
                        recipeName.setText("Bottled Water");
                        ingredientList.setText("DETAILS: \n•350mL\n•Summit");
                        foodName = "Bottled Water";
                        try {
                            maximumUsage = Double.valueOf(maximumUse(foodName));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Coffee")){
                        menuImage.setImage(coffee);
                        recipeName.setText("Coffee");
                        ingredientList.setText("DETAILS: \n•175mL\n•Lotte");
                        foodName = "Coffee";
                        try {
                            maximumUsage = Double.valueOf(maximumUse(foodName));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Coke")) {
                        menuImage.setImage(coke);
                        recipeName.setText("Coke");
                        ingredientList.setText("DETAILS: \n•330mL\n•Coca-Cola");
                        foodName = "Coke";
                        try {
                            maximumUsage = Double.valueOf(maximumUse(foodName));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Cranberry Juice")) {
                        menuImage.setImage(cranberryJuice);
                        recipeName.setText("Cranberry Juice");
                        ingredientList.setText("DETAILS: \n•156mL\n•Ocean Spray");
                        foodName = "Cranberry Juice";
                        try {
                            maximumUsage = Double.valueOf(maximumUse(foodName));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Pineapple Juice")) {
                        menuImage.setImage(pineappleJuice);
                        recipeName.setText("Pineapple Juice");
                        ingredientList.setText("DETAILS: \n•240mL\n•Del Monte");
                        foodName = "Pineapple Juice";
                        try {
                            maximumUsage = Double.valueOf(maximumUse(foodName));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                }
            }));
            return row;
        });

    }
    public void selectSideDish(ActionEvent actionEvent) {
        /**
         * The selectSideDish is responsible for displaying the details of the side
         * dish selected which are showing the image of the side dish, and changing the
         * [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes based on the
         *              user's choice of side dish
         */
        select.setText("Side Dish");
        ObservableList<MenuOptions> tableData = FXCollections.observableArrayList();
        TableView<MenuOptions> table = new TableView<>();
        tableData.removeAll();
        tableData.add(new MenuOptions("Chilled Tofu"));
        tableData.add(new MenuOptions("Nasu Dengaku"));
        tableData.add(new MenuOptions("Ramen Eggs"));
        tableData.add(new MenuOptions("Tamagoyaki"));
        TableColumn<MenuOptions, String> nameColumn = new TableColumn<>("Side Dishes");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<MenuOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData-> {
                if(event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())){
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Chilled Tofu")){
                        menuImage.setImage(chilledTofu);
                        recipeName.setText("Chilled Tofu");
                        ingredientList.setText("INGREDIENT LIST: \n•1 green onion\n" +
                                "•1 pound silken tofu\n" +
                                "•1 tablespoon of ginger\n" +
                                "•Soy sauce \n" +
                                "•2 tablespoons dried bonito flakes (Katsuobushi)\n");
                        foodName ="Chilled Tofu";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Green Onion") / 0.002);
                            ingredientList.add(maximumUse("Silken Tofu") / 0.5);
                            ingredientList.add(maximumUse("Ginger") / 0.005);
                            ingredientList.add(maximumUse("Soy Sauce") / 0.05);
                            ingredientList.add(maximumUse("Bonito Flakes") / 0.02);

                            itemRefresher(actionEvent, ingredientList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Nasu Dengaku")){
                        menuImage.setImage(nasuDengaku);
                        recipeName.setText("Nasu Dengaku");
                        ingredientList.setText("INGREDIENT LIST: \n•6 regular-sized Japanese eggplants\n" +
                                "•1 small onion sliced\n" +
                                "•½ cup miso paste or soybean paste\n" +
                                "•4 teaspoon ginger minced\n" +
                                "•2 teaspoon sesame oil\n" +
                                "•1 tablespoon white sugar\n" +
                                "•2 tablespoons vegetable oil\n" +
                                "•1 tablespoon sake\n" +
                                "•Salt and pepper to taste\n");
                        foodName ="Nasu Dengaku";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Japanese Eggplant") / 0.7);
                            ingredientList.add(maximumUse("Onion") / 0.004);
                            ingredientList.add(maximumUse("Miso Paste") / 0.12);
                            ingredientList.add(maximumUse("Ginger") / 0.02);
                            ingredientList.add(maximumUse("Sesame Oil") / 0.01);
                            ingredientList.add(maximumUse("White Sugar") / 0.013);
                            ingredientList.add(maximumUse("Vegetable Oil") / 0.027);
                            ingredientList.add(maximumUse("Sake") / 0.013);
                            ingredientList.add(maximumUse("Black Pepper") / 0.002);

                            itemRefresher(actionEvent, ingredientList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }



                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Ramen Eggs")) {
                        menuImage.setImage(ramenEggs);
                        recipeName.setText("Ramen Eggs");
                        ingredientList.setText("INGREDIENT LIST: \n•4 large eggs (50 g each w/o shell)\n" +
                                "•4 tablespoons soy sauce\n" +
                                "•4 tablespoons sake (or water)\n" +
                                "•1 teaspoon sugar\n");
                        foodName ="Ramen Eggs";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.add(maximumUse("Egg") / 4.00);
                            ingredientList.add(maximumUse("Soy Sauce") / 0.1);
                            ingredientList.add(maximumUse("Sake") / 0.1);
                            ingredientList.add(maximumUse("White Sugar") / 0.005);
                            itemRefresher(actionEvent, ingredientList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Tamagoyaki")) {
                        menuImage.setImage(tamagoyaki);
                        recipeName.setText("Tamagoyaki");
                        ingredientList.setText("INGREDIENT LIST: \n•4 large eggs\n" +
                                "•3 tablespoons dashi soup stock\n" +
                                "•1½ to 2 tablespoons sugar\n" +
                                "•Vegetable oil, as needed\n");
                        foodName ="Tamagoyaki";
                        try {
                            ArrayList<Double> ingredientList = new ArrayList<>();
                            ingredientList.clear();
                            ingredientList.add(maximumUse("Egg") / 4.00);
                            ingredientList.add(maximumUse("Dashi Soup Stock") / 0.04);
                            ingredientList.add(maximumUse("White Sugar") / 0.002);
                            ingredientList.add(maximumUse("Vegetable Oil") / 0.005);
                            itemRefresher(actionEvent, ingredientList);


                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }
            }));
            return row;
        });

    }
    public void selectMerch(ActionEvent actionEvent) {
        /**
         * The selectMerch is responsible for displaying the details of the merch
         * selected which are showing the image of the merchendise, and changing
         * the [selected item] and[menu item] into the corresponding choices of the
         * user.
         *
         * @return row  This returns the row with its respective changes.
         */
        select.setText("Merch");
        ObservableList<CategoryOptions> tableData = FXCollections.observableArrayList();
        TableView<CategoryOptions> table = new TableView<>();
        tableData.removeAll();
        tableData.add(new CategoryOptions("Made in Japan Shirt"));
        tableData.add(new CategoryOptions("Shiba Dog Tote Bag"));
        tableData.add(new CategoryOptions("Japanese Kitty Tote Bag"));
        tableData.add(new CategoryOptions("Cherry Blossom Fan"));
        TableColumn<CategoryOptions, String> nameColumn = new TableColumn<>("Merchandise");
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(1.00));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameColumn);
        table.setItems(tableData);
        AnchorPane.setTopAnchor(table, 0.0);
        AnchorPane.setRightAnchor(table, 0.0);
        AnchorPane.setBottomAnchor(table, 0.0);
        AnchorPane.setLeftAnchor(table, 0.0);
        tablePane.getChildren().addAll(table);
        table.setRowFactory(param -> {
            TableRow<CategoryOptions> row = new TableRow<>();
            row.setOnMouseClicked(event -> Optional.ofNullable(row.getItem()).ifPresent(rowData-> {
                if(event.getClickCount() == 2 && rowData.equals(table.getSelectionModel().getSelectedItem())){
                    if (table.getSelectionModel().getSelectedItem().getName().equals("Made in Japan Shirt")){
                        menuImage.setImage(shirt);
                        recipeName.setText("Made in Japan Shirt");
                        ingredientList.setText("DETAILS: \n•A chic shirt with a Torii Gate as design");
                        foodName = "Made in Japan Shirt";
                        try {
                            maximumUsage = maximumUse(foodName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Shiba Dog Tote Bag")){
                        menuImage.setImage(shibaTote);
                        recipeName.setText("Shiba Dog Tote");
                        ingredientList.setText("DETAILS: \n•A tote bag with a cute Shiba as a design");
                        foodName = "Shiba Dog Tote Bag";
                        try {
                            maximumUsage = maximumUse(foodName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Japanese Kitty Tote Bag")) {
                        menuImage.setImage(kittyTote);
                        recipeName.setText("Japanese Kitty Tote");
                        ingredientList.setText("DETAILS: \n•A tote bag with an adorable lucky cat as a design");
                        foodName = "Japanese Kitty Tote Bag";
                        try {
                            maximumUsage = maximumUse(foodName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                    else if (table.getSelectionModel().getSelectedItem().getName().equals("Cherry Blossom Fan")) {
                        menuImage.setImage(fan);
                        recipeName.setText("Cherry Blossom Fan");
                        ingredientList.setText("DETAILS: \n•A lovely and useful fan with a cherry blossom design");
                        foodName = "Cherry Blossom Fan";
                        try {
                            maximumUsage = maximumUse(foodName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        initSpinner();
                        availableFood.setText(String.valueOf(maximumUsage.intValue()));
                    }
                }
            }));
            return row;
        });
    }

    void initSpinner() {
        /**
         * The initSpinner is in charge of how the spinner works. Its least value being zero,
         * and the greatest being how many the maximum usage would be.
         */
        SpinnerValueFactory<Double> spinnerOne = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, maximumUsage);
        mySpinner.setValueFactory(spinnerOne);
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

    Double maximumUse(String itemToEdit) throws IOException {
        /**
         * The maximumUse is a double data type as this holds the value of maximum usages
         * an item can hold or attain.
         */
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU, oldItem, oldCateg, oldQty = "0", oldUnit, oldBrand, oldColor, oldDesc, oldLine = null;
        String s;
        String line;
        String[] lineIdx = new String[0];
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
        System.out.println(itemToEdit + ": " + oldQty);
        return Double.parseDouble(oldQty);
    }

    void removeStock(String itemToEdit, Double usageValue) throws IOException {
        /**
         * The removeStock method is responsible for removing a row of a certain ingredient in the
         * database.
         */
        final DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.DOWN);
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
                oldLine = oldSKU+ "," +oldItem+ "," +oldCateg+ "," +oldQty;
                newLine = newSKU+ "," +newItem+ "," +newCateg+ "," +newQty;

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
    @FXML
    void prepareFood(ActionEvent actionEvent) throws IOException {
        /**
         *  The prepareFood method is responsible for updating the quantity of the ingredients
         *  that is to be used by the selected menu item  The deduction of materials will be
         *  based on how much of the ingredient is needed for the recipe, and it will also
         *  depend on the quantity or amount on the spinner.
         */

        Double toPrepare = mySpinner.getValueFactory().getValue();


        switch(foodName){
            case "Gyoza":
                removeStock("Sesame Oil", 0.01 * toPrepare);
                removeStock("Cabbage", 0.1 * toPrepare);
                removeStock("Onion", 0.03 * toPrepare);
                removeStock("Garlic", 0.03 * toPrepare);
                removeStock("Carrot", 0.03 * toPrepare);
                removeStock("Egg", 1.0 * toPrepare);
                removeStock("Vegetable Oil", 0.01 * toPrepare);
                removeStock("Wonton Wrappers", 0.02 * toPrepare);
                removeStock("Soy Sauce", 0.06 * toPrepare);
                removeStock("Ground Pork", 0.25 * toPrepare);
                removeStock("Rice Vinegar", 0.02 * toPrepare);
                break;

            case "Karaage":
                removeStock("Garlic", 0.03 * toPrepare);
                removeStock("Ginger", 0.05 * toPrepare);
                removeStock("Soy Sauce", 0.04 * toPrepare);
                removeStock("Sake", 0.04 * toPrepare);
                removeStock("Sesame Oil", 0.002 * toPrepare);
                removeStock("Black Pepper", 0.001 * toPrepare);
                removeStock("Cayenne Pepper", 0.001 * toPrepare);
                removeStock("White Sugar", 0.002 * toPrepare);
                removeStock("Kosher Salt", 0.001 * toPrepare);
                removeStock("Chicken Thigh", 0.6 * toPrepare);
                removeStock("Potato Starch", 0.25 * toPrepare);
                removeStock("Canola Oil", 1.0 * toPrepare);
                break;

            case "Onigiri":
                removeStock("Sushi Rice", 0.4 * toPrepare);
                removeStock("Drained Tuna", 0.15 * toPrepare);
                removeStock("Soy Sauce", 0.002 * toPrepare);
                removeStock("Wasabi", 0.001 * toPrepare);
                break;

            case "Shoyu Ramen":
                removeStock("Sesame Oil", 0.001 * toPrepare);
                removeStock("Ginger", 0.001 * toPrepare);
                removeStock("Garlic", 0.03 * toPrepare);
                removeStock("Dashi Soup Stock", 0.25 * toPrepare);
                removeStock("Soy Sauce", 0.04 * toPrepare);
                removeStock("Sake", 0.003 * toPrepare);
                removeStock("White Sugar", 0.002 * toPrepare);
                removeStock("Salt", 0.002 * toPrepare);
                removeStock("Chukamen Noodles", 0.12 * toPrepare);
                removeStock("Green Onion", 0.001 * toPrepare);
                removeStock("Black Pepper", 0.001 * toPrepare);
                break;

            case "Tonkatsu":
                removeStock("Vegetable Oil", 0.25 * toPrepare);
                removeStock("Pork Chops", 0.5 * toPrepare);
                removeStock("Black Pepper", 0.001 * toPrepare);
                removeStock("All-Purpose Flour", 0.12 * toPrepare);
                removeStock("Egg", 1.0 * toPrepare);
                removeStock("Panko Bread Crumbs", 0.25 * toPrepare);
                removeStock("Sushi Rice", 0.24 * toPrepare);
                removeStock("Tonkatsu Sauce", 0.002 * toPrepare);
                break;

            case "Omurice":
                removeStock("Onion", 0.006 * toPrepare);
                removeStock("Mushroom", 0.005 * toPrepare);
                removeStock("Ham", 0.008 * toPrepare);
                removeStock("Vegetable Oil", 0.014 * toPrepare);
                removeStock("Kosher Salt", 0.0001 * toPrepare);
                removeStock("Black Pepper", 0.0001 * toPrepare);
                removeStock("Sushi Rice", 0.5 * toPrepare);
                removeStock("Unsalted Butter", 0.03 * toPrepare);
                removeStock("Ketchup", 0.03 * toPrepare);
                removeStock("Tomato Paste", 0.03 * toPrepare);
                removeStock("Egg", 4.0 * toPrepare);
                removeStock("Milk", 0.03 * toPrepare);
                break;

            case "Yakisoba":
                removeStock("Chukamen Noodles", 1.0 * toPrepare);
                removeStock("Onion", 0.005 * toPrepare);
                removeStock("Carrot", 0.05 * toPrepare);
                removeStock("Mushroom", 0.2 * toPrepare);
                removeStock("Cabbage", 0.05 * toPrepare);
                removeStock("Green Onion", 0.3 * toPrepare);
                removeStock("Vegetable Oil", 0.5 * toPrepare);
                removeStock("Kosher Salt", 0.003 * toPrepare);
                removeStock("White Sugar", 0.03 * toPrepare);
                removeStock("Soy Sauce", 0.12 * toPrepare);
                removeStock("Ketchup", 0.03 * toPrepare);
                removeStock("Sesame Oil", 0.03 * toPrepare);
                removeStock("Rice Vinegar", 0.02 * toPrepare);
                removeStock("Sriracha", 0.001 * toPrepare);
                break;

            case "Spicy Tuna Roll":
                removeStock("Sushi Rice", 0.5 * toPrepare);
                removeStock("Rice Vinegar", 0.06 * toPrepare);
                removeStock("Nori", 0.5 * toPrepare);
                removeStock("Drained Tuna", 1.0 * toPrepare);
                removeStock("Mayonnaise", 0.02 * toPrepare);
                removeStock("Sriracha", 0.02 * toPrepare);
                removeStock("Green Onion", 0.002 * toPrepare);
                break;

            case "Yellowtail Sushi Roll":
                removeStock("Hamachi Yellow Tail", 0.05 * toPrepare);
                removeStock("Sushi Rice", 0.12 * toPrepare);
                removeStock("Rice Vinegar", 0.06 * toPrepare);
                removeStock("Sriracha", 0.001 * toPrepare);
                removeStock("Spicy Mayonnaise", 0.02 * toPrepare);
                removeStock("Nori", 0.25 * toPrepare);
                removeStock("Green Onion", 0.003 * toPrepare);
                removeStock("Cucumber", 0.003 * toPrepare);
                removeStock("Wasabi", 0.002 * toPrepare);
                break;

            case "Mochi Ice Cream":
                removeStock("Shiratamako", 0.1 * toPrepare);
                removeStock("White Sugar", 0.055 * toPrepare);
                removeStock("Cornstarch", 0.08 * toPrepare);
                removeStock("Ice Cream", 0.1 * toPrepare);
                break;

            case "Japanese Pancakes":
                removeStock("Egg", 4.0 * toPrepare);
                removeStock("Milk", 0.06 * toPrepare);
                removeStock("Vanilla Extract", 0.001 * toPrepare);
                removeStock("White Sugar", 0.04 * toPrepare);
                removeStock("Baking Powder", 0.001 * toPrepare);
                removeStock("All-Purpose Flour", 0.08 * toPrepare);
                removeStock("Canola Oil", 0.003 * toPrepare);
                break;

            case "Hanami Dango":
                removeStock("Japanese Rice Flour", 0.25 * toPrepare);
                removeStock("Shiratamako", 0.25 * toPrepare);
                removeStock("White Sugar", 0.007 * toPrepare);
                removeStock("Matcha Green Tea Powder", 0.004 * toPrepare);
                break;

            case "Bottled Water":
                removeStock("Bottled Water", toPrepare);
                break;

            case "Coffee":
                removeStock("Coffee", toPrepare);
                break;

            case "Coke":
                removeStock("Coke", toPrepare);
                break;

            case "Cranberry Juice":
                removeStock("Cranberry Juice", toPrepare);
                break;

            case "Pineapple Juice":
                removeStock("Pineapple Juice", toPrepare);
                break;

            case "Made in Japan Shirt":
                removeStock("Made in Japan Shirt", toPrepare);
                break;

            case "Cherry Blossom Fan":
                removeStock("Cherry Blossom Fan", toPrepare);
                break;

            case "Japanese Kitty Tote Bag":
                removeStock("Japanese Kitty Tote Bag", toPrepare);
                break;

            case "Shiba Dog Tote Bag":
                removeStock("Shiba Dog Tote Bag", toPrepare);
                break;

            case "Tamagoyaki":
                removeStock("Egg", 4.0 * toPrepare);
                removeStock("Dashi Soup Stock", 0.04 * toPrepare);
                removeStock("White Sugar", 0.002 * toPrepare);
                removeStock("Vegetable Oil", 0.005 * toPrepare);
                break;

            case "Nasu Dengaku":
                removeStock("Japanese Eggplant", 0.7 * toPrepare);
                removeStock("Onion", 0.004 * toPrepare);
                removeStock("Miso Paste", 0.12 * toPrepare);
                removeStock("Ginger", 0.02 * toPrepare);
                removeStock("Sesame Oil", 0.01 * toPrepare);
                removeStock("White Sugar", 0.013 * toPrepare);
                removeStock("Vegetable Oil", 0.0027 * toPrepare);
                removeStock("Sake", 0.013 * toPrepare);
                removeStock("Black Pepper", 0.002 * toPrepare);
                break;

            case "Ramen Eggs":
                removeStock("Egg", 4.0 * toPrepare);
                removeStock("Soy Sauce", 0.1 * toPrepare);
                removeStock("Sake", 0.1 * toPrepare);
                removeStock("White Sugar", 0.005 * toPrepare);
                break;

            case "Chilled Tofu":
                removeStock("Green Onion", 0.002 * toPrepare);
                removeStock("Silken Tofu", 0.5 * toPrepare);
                removeStock("Ginger", 0.005 * toPrepare);
                removeStock("Soy Sauce", 0.05 * toPrepare);
                removeStock("Bonito Flakes", 0.002 * toPrepare);
                break;

            default:
                throw new IllegalStateException();
        }
    }

    public void itemRefresher(ActionEvent actionEvent, ArrayList<Double> ingredientList) {
        /**
         * The itemRefresher method is responsible for updating the availability of food, which
         * is based from the ingredients at present.
         */
        for (int i = 0; i < ingredientList.size() - 1; i++) {
            // return the minimum value of n numbers
            maximumUsage = Double.min(ingredientList.get(i), ingredientList.get(i + 1));
            ingredientList.set(i + 1, maximumUsage);
        }
        initSpinner();
        availableFood.setText(String.valueOf(maximumUsage.intValue()));

    }
}