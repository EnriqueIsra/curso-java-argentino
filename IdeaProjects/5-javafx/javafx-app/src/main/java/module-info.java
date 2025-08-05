module org.enrique.javafx.app.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires spring.webflux;
    requires reactor.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.enrique.javafx.app.javafxapp to javafx.base;
    opens org.enrique.javafx.app.javafxapp.models to javafx.base, com.fasterxml.jackson.databind;
    exports org.enrique.javafx.app.javafxapp;
}