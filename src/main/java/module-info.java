module machine.prob.machineproblem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires net.synedra.validatorfx;

    opens machine.prob.machineproblem to javafx.fxml;
    exports machine.prob.machineproblem;
    exports machine.prob.machineproblem.menu;
}