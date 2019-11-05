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

/* pile of cards that are played. */
public class PlayedPile extends SetOfCards {
    
    /**
     * constructor
     * pre: none
     * post: playedPile Object has been created.
     */
    public PlayedPile(){
        playedPile = new ArrayList<>();
    }
    
    /**
     * add card to playedPile
     * pre: Card card
     * post: card has been added to playedPile.
     * @param card 
     */
    @Override
    public void addCard(Card card){
        playedPile.add(card);
    } 
    
    /**
     * remove card from playedPile
     * pre: Card card
     * post: card has been removed from playedPile
     * @param card 
     */
    @Override
    public void removeCard(Card card){
        playedPile.remove(card);
    }
    
    /**
     * return size of playedPile
     * pre: none
     * post: size of playedPile has been returned
     * @return 
     */
    public int getSize(){
        return playedPile.size();
    }
    
    /**
     * return Card at index of playedPile
     * pre: index
     * post: card at index n has been returned.
     * @param index
     * @return 
     */
    public Card getCard(int index){
        card = playedPile.get(index);
        return card;
    }
    
    /**
     * removes all elements in playedPile
     * pre: none
     * post: all elements in playedPile has been removed.
     */
    public void clearPile(){
        playedPile.clear();
    }
    
}
