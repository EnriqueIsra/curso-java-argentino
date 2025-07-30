package org.enrique.javafx.app.javafxapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.enrique.javafx.app.javafxapp.models.Product;

import java.io.IOException;

public class HelloApplication extends Application {

    private ObservableList<Product> products = FXCollections.observableArrayList(
            new Product("Teclado", "desc ...", 1000L),
            new Product("Mouse", "desc para mouse ...", 500L),
            new Product("CPU", "desc i7 ...", 2000L),
            new Product("Memoria RAM", "desc de 32 GB...", 800L),
            new Product("Monitor", "monitor asus increible ...", 1500L)
    );
    @Override
    public void start(Stage stage) throws IOException {
        TableView<Product> tableView = new TableView<>();

        TableColumn<Product, String> nameColumn = new TableColumn<>("Nombre");
        TableColumn<Product, String> descColumn = new TableColumn<>("Descripción");
        TableColumn<Product, Long> priceColumn = new TableColumn<>("Precio");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getColumns().addAll(nameColumn, descColumn, priceColumn);
        tableView.setItems(this.products);

        VBox vBox = new VBox(tableView);
        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}