package no.ntnu.idatt2003.oving5.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import java.util.stream.Collectors;

import no.ntnu.idatt2003.oving5.models.DeckOfCards;
import no.ntnu.idatt2003.oving5.models.PlayingCard;

import no.ntnu.idatt2003.oving5.enums.Rank;
import no.ntnu.idatt2003.oving5.enums.Suit;



public class GameGUI extends Application {

    private DeckOfCards deck = new DeckOfCards(); // Ny kortstokk
    private ListView<String> handView = new ListView<>(); // Viser trukne kort

    private Label sumLabel = new Label("Sum of faces: ");
    private Label heartsLabel = new Label("Cards that are hearts: ");
    private Label queenOfSpades = new Label("Is there a queen of spades in the hand? ");
    private Label flushLabel = new Label("Flush: Yes/No");

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10); // Riktig navn
        root.setStyle("-fx-padding: 20;");



        Button dealHandButton = new Button("Deal Hand");
        Button checkHandButton = new Button("Check Hand");

        // Opprett knapp-layout
        HBox buttonBox = new HBox(10, dealHandButton, checkHandButton);

        // Når vi trykker på "Deal Hand"
        dealHandButton.setOnAction(e -> dealHand(5));
        checkHandButton.setOnAction(e -> checkHand());

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
        handView.getItems().clear();
        hand.forEach(card -> handView.getItems().add(card.toString())); // Beholder riktig hånd

    }

    private void checkHand() {
        List<PlayingCard> hand = getCurrentHand();

        int sum = hand.stream()
                .mapToInt(card -> card.getRank().ordinal() + 1)
                .sum();

        List<PlayingCard> hearts = hand.stream()
                .filter(card -> card.getSuit() == Suit.HEARTS)
                .toList();

        boolean hasQueenOfSpades = hand.stream()
                .anyMatch(card -> card.getSuit() == Suit.SPADES && card.getRank() == Rank.Queen);

        boolean isFlush = hand.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
                .values().contains(5);


        // Oppdater GUI
        sumLabel.setText("Sum of cards: " + sum);
        heartsLabel.setText("Amount of hearts: " + hearts.size() + " → " + hearts);
        String queenText;
        if (hasQueenOfSpades) {
            queenText = "Yes";
        } else {
            queenText = "No";
        }
        queenOfSpades.setText("Queen of Spades: " + queenText);

        String flushText;
        if (isFlush) {
            flushText = "Yes";
        } else {
            flushText = "No";
        }
        flushLabel.setText("Flush: " + flushText);
    }

    private List<PlayingCard> getCurrentHand() {
        return handView.getItems().stream()
                .map(this::convertStringToCard) // Konverterer GUI-strenger tilbake til PlayingCard-objekter
                .toList();
    }

    private PlayingCard convertStringToCard(String cardString) {
        try {
            String[] parts = cardString.split(" of ");
            Rank rank = Rank.valueOf(parts[0].trim()); // Trim fjerner ekstra mellomrom
            Suit suit = Suit.valueOf(parts[1].trim().toUpperCase()); // Uppercase for sikkerhet
            return new PlayingCard(rank, suit);
        } catch (Exception e) {
            System.out.println("Feil ved konvertering av kort: " + cardString);
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args); // Starter JavaFX-applikasjonen
    }
}

