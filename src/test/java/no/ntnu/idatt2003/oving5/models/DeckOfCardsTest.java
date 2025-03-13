package no.ntnu.idatt2003.oving5.models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckOfCardsTest {


    private DeckOfCards deck;

    @BeforeEach
    void init(){
        deck = new DeckOfCards();
    }


    @Test
    void checkIfDeckContains52Cards() {
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void checkIfDrawCardsStopsAfter52Times(){
        for(int i = 0; i<52; i++){
            deck.drawCard();
        }
        assertThrows(IllegalStateException.class, () -> deck.drawCard());
    }

    @Test
    void checkIfShuffleActuallyShuffles(){
        List <PlayingCard> originalOrder = List.copyOf(deck.getCards());

        deck.shuffle();

        assertNotEquals(originalOrder, deck.getCards());

        assertEquals(52, deck.getCards().size());
    }

    @Test
    void checkIfResetDeckActuallyResetsDeck() {
        deck.drawCard();
        deck.drawCard();

        List<PlayingCard> modifiedOrder = List.copyOf(deck.getCards());

        deck.resetDeck();

        assertNotEquals(modifiedOrder, deck.getCards());
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void dealHandShouldReturnCorrectNumberOfCards() {
        int handSize = 5;
        List<PlayingCard> hand = deck.dealHand(handSize);

        assertEquals(handSize, hand.size(), "Hand should contain " + handSize + " cards");
        assertEquals(52 - handSize, deck.getCards().size(), "Deck should have 52 - " + handSize + " cards left");
    }

    @Test
    void dealHandShouldThrowExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0), "Should throw exception for n = 0");
        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53), "Should throw exception for n = 53");
    }

    @Test
    void dealHandShouldRemoveDrawnCardsFromDeck() {
        List<PlayingCard> hand = deck.dealHand(10);
        for (PlayingCard card : hand) {
            assertFalse(deck.getCards().contains(card), "Deck should not contain drawn cards");
        }
    }


}
