package machine.prob.machineproblem.menu;

import javafx.beans.property.SimpleStringProperty;

public class CategoryOptions {
    private final SimpleStringProperty ingredients;

    public CategoryOptions(String name) {
        this.ingredients = new SimpleStringProperty(name);
    }

    public String getName() {
        return ingredients.get();
    }

    public void setName(String name){
        this.ingredients.set(name);
    }
}
