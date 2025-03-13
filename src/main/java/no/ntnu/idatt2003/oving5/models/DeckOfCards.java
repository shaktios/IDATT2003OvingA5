package no.ntnu.idatt2003.oving5.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


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


    public PlayingCard drawCard(){
        if (cards.isEmpty()){
            throw new IllegalStateException("Deck of cards is empty or null");
        }

        return cards.remove(0);
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void resetDeck() {
        cards.clear();
        for (int i = 0; i < Rank.values().length; i++) {
            for (int j = 0; j < Suit.values().length; j++) {
                this.cards.add(new PlayingCard(Rank.values()[i], Suit.values()[j]));
            }
        }
        Collections.shuffle(cards);
    }


    public List<PlayingCard> dealHand(int n){
        if(n < 1 || n > cards.size()){
            throw new IllegalArgumentException("The number N cannot be less than 1 or bigger than" + cards.size());
        }

        List<PlayingCard> hand = new ArrayList <>();
        Random random = new Random();

        for(int i = 0; i<n; i++){
            int randomIndex = random.nextInt(cards.size());
            PlayingCard drawnCard = cards.remove(randomIndex);
            hand.add(drawnCard);
        }

        return hand;


    }


}

