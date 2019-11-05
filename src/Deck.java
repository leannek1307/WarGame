/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * Nov 3, 2019.
 * @author leannekim
 */

/* deck of 52 cards */

public class Deck extends SetOfCards{
    
    /**
     * constructor
     * pre: none
     * post: deck Object has been created.
     */
    public Deck(){
        deck = new ArrayList<Card>();
        addCards();
    }
    
    /**
     * add card type Card to deck
     * pre: none
     * post: Card type cards have been added to deck and shuffle method has been executed.
     */
    private void addCards(){
        for (int i = 2; i < 15; i++){
            card = new Card(i, 'S');    // spades
            deck.add(card);
            card = new Card(i, 'H');    // hearts
            deck.add(card);
            card = new Card(i, 'C');    // clubs
            deck.add(card);
            card = new Card(i, 'D');    // diamonds
            deck.add(card);
        }
        shuffle();
    }
    
    /**
     * shuffle cards
     * pre: none
     * post: deck has been shuffled.
     */
    private void shuffle(){
        Collections.shuffle(deck);
    }
    
    /**
     * add card to deck
     * pre: Card card
     * post: card has been added to deck.
     * @param card 
     */
    @Override
    public void addCard(Card card){
        deck.add(card);
    }
    
    /**
     * remove card from deck
     * pre: Card card
     * post: card has been removed from deck.
     * @param card 
     */
    @Override
    public void removeCard(Card card){
        deck.remove(card);
    }
    
    /**
     * return deck
     * pre: none
     * post: deck has been returned.
     * @return 
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }
    
    /**
     * return size of deck
     * pre: none
     * post: size of the deck has been returned.
     * @return 
     */
    public int getDeckSize(){
        return deck.size();
    }

    /**
     * return string
     * pre: none
     * post: string has been returned.
     * @return 
     */   
    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < deck.size(); i++){
            str += deck.get(i) + "\n";
        }
        return str;
    }
}
