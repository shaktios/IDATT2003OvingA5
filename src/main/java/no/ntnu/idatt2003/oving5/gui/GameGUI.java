package no.ntnu.idatt2003.oving5.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;

import no.ntnu.idatt2003.oving5.models.DeckOfCards;
import no.ntnu.idatt2003.oving5.models.PlayingCard;

public class GameGUI extends Application {

    private DeckOfCards deck = new DeckOfCards(); // Ny kortstokk
    private ListView<String> handView = new ListView<>(); // Viser trukne kort

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10); // Riktig navn
        root.setStyle("-fx-padding: 20;");



        Button dealHandButton = new Button("Deal Hand");
        Button checkHandButton = new Button("Check Hand");

        Label sumLabel = new Label("Sum of faces: ");
        Label heartsLabel = new Label("Cards that are hearts: ");
        Label queenOfSpades = new Label("Is there a queen of spades in the hand? ");
        Label flushLabel = new Label("Flush: Yes/No");



        // Opprett knapp-layout
        HBox buttonBox = new HBox(10, dealHandButton, checkHandButton);

        // Når vi trykker på "Deal Hand"
        dealHandButton.setOnAction(e -> dealHand(5));

        // Legger til alle elementene i GUI
        root.getChildren().addAll(handView, buttonBox, sumLabel, heartsLabel, flushLabel, queenOfSpades);

        // Oppretter scenen
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }


    private void dealHand(int n) {
        List<PlayingCard> hand = deck.dealHand(n);
        handView.getItems().clear(); // Rens tidligere kort
        for (PlayingCard card : hand) {
            handView.getItems().add(card.toString()); // Legg til kortene i visningen
        }
    }

    public static void main(String[] args) {
        launch(args); // Starter JavaFX-applikasjonen
    }
}

