package machine.prob.machineproblem.menu;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class MenuOptions {
    private final SimpleStringProperty recipe;

    public MenuOptions(String name) {
        this.recipe = new SimpleStringProperty(name);
    }

    public String getName() {
        return recipe.get();
    }

    public void setName(String name){
        this.recipe.set(name);
    }
}
