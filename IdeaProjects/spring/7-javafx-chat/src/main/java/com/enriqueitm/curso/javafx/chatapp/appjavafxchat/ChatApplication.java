package com.enriqueitm.curso.javafx.chatapp.appjavafxchat;

import com.enriqueitm.curso.javafx.chatapp.appjavafxchat.models.Message;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {

    private Message message = new Message();

    @Override
    public void start(Stage stage) throws IOException {

        TextField usernameField = new TextField();
        usernameField.setPromptText("Tu username...");
        Button connButton = new Button("Conectar");

        Button sendButton = new Button("Enviar");
        TextField messageField = new TextField();
        messageField.setPromptText("Escribe un mensaje...");

        Button deConnButton = new Button("Cerrar chat");

        HBox header = new HBox(10, usernameField, connButton);
        HBox footer = new HBox(10, messageField, sendButton, deConnButton);
        VBox chat = new VBox(10);
        ScrollPane scrollPane = new ScrollPane(chat);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);
        VBox panel = new VBox(10, header, scrollPane, footer);
        panel.setPadding(new Insets(10));
        Scene scene = new Scene(panel, 680, 400);
        stage.setTitle("¡Chat Web Socket con Spring Boot!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}