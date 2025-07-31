package org.enrique.javafx.app.javafxapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
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



        TableColumn<Product, Void> deleteColumn = new TableColumn<>("Eliminar");
        deleteColumn.setCellFactory(param -> new TableCell<>(){
            private final Button deleteButton = new Button("Eliminar");
            {
                deleteButton.setOnAction(event -> {
                    Product product = getTableView().getItems().get(getIndex());
                    tableView.getItems().remove(product );
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty){
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        VBox vBox = new VBox(tableView);
        Scene scene = new Scene(vBox, 620, 440);
        stage.setTitle("Gestión de Productos!");
        stage.setScene(scene);
        stage.show();

        tableView.getColumns().addAll(nameColumn, descColumn, priceColumn, deleteColumn);
        tableView.setItems(this.products);
    }


    public static void main(String[] args) {
        launch();
    }
}