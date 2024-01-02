package machine.prob.machineproblem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import machine.prob.machineproblem.menu.AutoCompleteComboBoxListener;
import org.controlsfx.control.PropertySheet;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ExistingController implements Initializable {
    public ComboBox<String> skuComboBox;
    public TextField quantityChange;
    public Label itemGenerated;
    public Label categoryGenerated;
    public Label unitGenerated;
    public Label brandGenerated;
    public Label colorGenerated;
    public Label description;
    StockController stock = new StockController();
    ObservableList<String> skuValues = FXCollections.observableArrayList();
    String[] detailsExistingStock(String itemToEdit) throws IOException {
        /**
         * The detailsExistingStock
         */
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU, oldItem = "", oldCateg= "", oldQty, oldUnit= "", oldBrand= "", oldColor= "", oldDesc= "", oldLine;
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
            if(sku.equals(itemToEdit)){
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
        String[] array = {oldItem,oldCateg, oldUnit, oldBrand, oldColor, oldDesc};
        return array;
    }
    void updateExistingStock(String itemToEdit, Double restockValue) throws IOException {
        File f = new File("stocks.csv");
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String oldSKU, oldItem = "", oldCateg= "", oldQty, oldUnit= "", oldBrand= "", oldColor= "", oldDesc, oldLine = null;
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
            if(sku.equals(itemToEdit)){
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
                newItem =oldItem;
                newCateg = oldCateg;
                newUnit = oldUnit;
                newBrand = oldBrand;
                newColor = oldColor;
                newDesc = oldDesc;
                /*-------------------------------
                    Papalitan si newQty base kung add or usage ba oldQty +- get.spinner(value)
                 --------------------------------*/
                Double newQuantity = Double.parseDouble(oldQty)+ restockValue; // if Restock -> newQty = oldQty + get.SpinnerValue // if Usage ->
                newQty = String.valueOf(newQuantity);
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
    void skuDrop(ActionEvent actionEvent) throws IOException {
        /**
         * The skDrop is responsible for getting the information
         */
        String[] array = detailsExistingStock(skuComboBox.getValue());

        itemGenerated.setText(array[0]);
        categoryGenerated.setText(array[1]);
        unitGenerated.setText(array[2]);
        brandGenerated.setText(array[3]);
        colorGenerated.setText(array[4]);
        description.setText(array[5]);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * The initialize method is responsible for the initialiizing the information
         * with regards to the SKU system.
         */
        skuValues.addAll(stock.listWholeSKU());
        skuComboBox.setItems(skuValues);
        new AutoCompleteComboBoxListener<>(skuComboBox);
    }
    @FXML
    void addExistingStock(ActionEvent actionEvent) throws IOException {
        /**
         * The addExistingStock is in charge of updating the current quantity of
         * stocks with the new changes done by the user.
         */
        updateExistingStock(skuComboBox.getValue(), Double.valueOf(quantityChange.getText()));

    }
}
