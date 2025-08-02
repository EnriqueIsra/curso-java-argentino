package org.enrique.javafx.app.javafxapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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

    private TextField nameField = new TextField();
    private TextField descField = new TextField();
    private TextField priceField = new TextField();

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

        tableView.getColumns().addAll(nameColumn, descColumn, priceColumn, deleteColumn);
        tableView.setItems(this.products);

        nameField.setPromptText("Nombre");
        descField.setPromptText("Descripción");
        priceField.setPromptText("Precio");

        Button addButton = new Button("Agregar");
        addButton.setOnAction(event -> {
            String name = nameField.getText();
            String desc = descField.getText();
            String priceText = priceField.getText();

            if (!name.isBlank() && !desc.isBlank() && !priceText.isBlank()){
                try {
                    Long price = Long.parseLong(priceText);
                    products.add(new Product(name, desc, price));

                    nameField.clear();
                    descField.clear();
                    priceField.clear();

                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El precio debe ser un número valido");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Debe completar todos los cambios");
            }
        });

        HBox formBox = new HBox(10, nameField, descField, priceField, addButton);
        formBox.setPadding(new Insets(10));
        VBox vBox = new VBox(formBox, tableView);
        Scene scene = new Scene(vBox, 620, 440);
        stage.setTitle("Gestión de Productos!");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}