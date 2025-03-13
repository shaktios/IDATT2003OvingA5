package no.ntnu.idatt2003.oving5.models;

import no.ntnu.idatt2003.oving5.enums.Suit;
import no.ntnu.idatt2003.oving5.enums.Rank;



public class PlayingCard {
    private final Rank rank;
    private final Suit suit;

    public PlayingCard(Rank rank, Suit suit){
        if(rank == null || suit == null){
            throw new IllegalArgumentException("Rank and Suit cannot be null");
        }

        this.rank = rank;
        this.suit = suit;

    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }

}
