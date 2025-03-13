package no.ntnu.idatt2003.oving5.models;

import java.util.ArrayList;
import java.util.Collections;

import no.ntnu.idatt2003.oving5.enums.Suit;
import no.ntnu.idatt2003.oving5.enums.Rank;



public class DeckOfCards {

    private final ArrayList<PlayingCard> cards;

    public DeckOfCards() {
        cards = new ArrayList<>();
        for (int i = 0; i<Rank.values().length;i++){

            for (int j = 0; j<Suit.values().length; j++){

                this.cards.add(new PlayingCard(Rank.values()[i], Suit.values()[j]));

            }
        }
    }


    public void shuffle(){
        Collections.shuffle(cards);
    }




}
