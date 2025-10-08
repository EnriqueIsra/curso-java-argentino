package com.enriqueitm.curso.javafx.chatapp.appjavafxchat;

import com.enriqueitm.curso.javafx.chatapp.appjavafxchat.models.Message;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatApplication extends Application {

    private Message message = new Message();

    @Override
    public void start(Stage stage) throws IOException {

        TextField usernameField = new TextField();
        usernameField.setPromptText("Tu username...");
        Button connButton = new Button("Conectar");
        HBox header = new HBox(10, usernameField, connButton);

        VBox chat = new VBox(10);
        chat.setVisible(false);
        ScrollPane scrollPane = new ScrollPane(chat);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);
        scrollPane.setVisible(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Escribe un mensaje...");
        Button sendButton = new Button("Enviar");
        Button deConnButton = new Button("Cerrar chat");
        HBox footer = new HBox(10, messageField, sendButton, deConnButton);
        footer.setVisible(false);

        connButton.setOnAction(event ->{
            if (!usernameField.getText().isBlank()) {
                this.message.setUsername(usernameField.getText());
                System.out.println(usernameField.getText());
                chat.setVisible(true);
                scrollPane.setVisible(true);
                footer.setVisible(true);

                usernameField.setVisible(false);
                connButton.setVisible(false);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Favor de ingresar el nombre de usuario");
                alert.show();
            }
        });

        deConnButton.setOnAction(event -> {
            chat.setVisible(false);
            chat.getChildren().clear();
            scrollPane.setVisible(false);
            footer.setVisible(false);

            usernameField.setVisible(true);
            connButton.setVisible(true);

            this.message = new Message();
            messageField.setText("");
        });

        sendButton.setOnAction(event -> {
            if(!messageField.getText().isBlank()) {
                this.message.setType("MESSAGE");
                this.message.setText(messageField.getText());
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
                String time = format.format(new Date().getTime());
                Text username = new Text(message.getUsername());
                username.setFill(Color.RED);
                username.setFont(Font.font("Arial", FontWeight.BOLD, 12));

                TextFlow textFlow = new TextFlow(new Text(time + " @"));
                textFlow.getChildren().add(username);
                textFlow.getChildren().add(new Text(" dice: \n".concat(message.getText())));

                chat.getChildren().add(textFlow);
                messageField.setText("");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Favor de ingresar un mensaje");
                alert.show();
            }
        });

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