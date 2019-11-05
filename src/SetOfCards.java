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

/* abstract class setOfCards */
abstract class SetOfCards {
    
    public Card card;
    public ArrayList<Card> deck;
    public ArrayList<Card> drawPile;
    public ArrayList<Card> playedPile;
    
    /**
     * Should add card to ArrayList
     * pre: Card card
     * post: card is added to ArrayList
     * @param card 
     */
    abstract void addCard(Card card);
    
    /**
     * Should remove card from ArrayList
     * pre: Card card
     * post: card has been removed from ArrayList.
     * @param card 
     */
    abstract void removeCard(Card card);
    
    
    
}
