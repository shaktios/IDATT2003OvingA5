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


}
