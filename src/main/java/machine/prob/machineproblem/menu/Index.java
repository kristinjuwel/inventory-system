package machine.prob.machineproblem.menu;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Index {
    private final SimpleStringProperty item;
    private final SimpleStringProperty sku;
    private final SimpleStringProperty category;
    private final SimpleStringProperty quantity;
    private final SimpleStringProperty unit;
    private final SimpleStringProperty brand;
    private final SimpleStringProperty color;
    private final SimpleStringProperty description;


    public Index(String SKU, String Item, String Category, String Qty, String Unit,
                 String Brand, String Color, String Description)
    {
        this.item = new SimpleStringProperty(Item);
        this.sku = new SimpleStringProperty(SKU);
        this.category = new SimpleStringProperty(Category);
        this.quantity = new SimpleStringProperty(Qty);
        this.unit = new SimpleStringProperty(Unit);
        this.brand = new SimpleStringProperty(Brand);
        this.color = new SimpleStringProperty(Color);
        this.description = new SimpleStringProperty(Description);

    }
    //getter for item
    public String getItem(){return  item.get();}

    //setter for item
    public void  setItem(String Item){item.set(Item);}

    //getter for sku
    public String getSku(){return  sku.get();}

    //setter for sku
    public void  setSku(String SKU){sku.set(SKU);}

    //getter for category
    public String getCategory(){return  category.get();}

    //setter for category
    public void  setCategory(String Category){category.set(Category);}

    //getter for quantity
    public String getQuantity(){return quantity.get();}

    //setter for category
    public void setQuantity(String Qty){quantity.set(Qty);}

    //getter for unit
    public String getUnit(){return  unit.get();}

    //setter for unit
    public void  setUnit(String Unit){unit.set(Unit);}

    //getter for brand
    public String getBrand(){return  brand.get();}

    //setter for brand
    public void  setBrand(String Brand){brand.set(Brand);}

    //getter for color
    public String getColor(){return  color.get();}

    //setter for color
    public void  setColor(String Color){color.set(Color);}

    //getter for description
    public String getDescription(){return  description.get();}

    //setter for description
    public void  setDescription(String Description){description.set(Description);}



}
