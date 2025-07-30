module org.enrique.javafx.app.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.enrique.javafx.app.javafxapp to javafx.fxml;
    exports org.enrique.javafx.app.javafxapp;
}