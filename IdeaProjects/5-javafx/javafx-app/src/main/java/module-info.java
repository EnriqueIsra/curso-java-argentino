module org.enrique.javafx.app.javafxapp {
    requires javafx.controls;
    requires javafx.base;


    opens org.enrique.javafx.app.javafxapp to javafx.base;
    opens org.enrique.javafx.app.javafxapp.models to javafx.base;
    exports org.enrique.javafx.app.javafxapp;
}