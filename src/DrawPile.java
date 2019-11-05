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

/* player's drawPile class */
public class DrawPile extends SetOfCards{
    
    /**
     * constructor
     * pre: none
     * post: drawPile object has been created.
     */
    public DrawPile(){
        drawPile = new ArrayList<>();

    }

    /**
     * add card to drawPile
     * pre: Card card
     * post: card has been added to drawPile.
     * @param card 
     */
    @Override
    public void addCard(Card card){
        drawPile.add(card);
    }
    
    /**
     * remove card from drawPile
     * pre: Card card
     * post: card has been removed from drawPile
     * @param card 
     */
    @Override
    public void removeCard(Card card){
        drawPile.remove(card);
    }
    
    /**
     * return card at index from drawPile
     * pre: index
     * post: card at index has been returned.
     * @param index
     * @return 
     */
    public Card getCard(int index){
        card = drawPile.get(index);
        return card;
    }
    
    /**
     * return size of drawPile
     * pre: none
     * post: size of drawPile has been returned.
     * @return 
     */
    public int getSize(){
        return drawPile.size();
    }
    
    /**
     * return drawPile
     * pre: none
     * post: drawPile has been returned.
     * @return 
     */
    public ArrayList<Card> getAL(){ // returns the whole arraylist
        return drawPile;
    }
    
    /**
     * return true if ArrayList is empty, false otherwise.
     * pre: none
     * post: true or false has been returned.
     * @return 
     */
    public boolean isEmpty(){
        if (drawPile.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * shuffle drawPile
     * pre: none
     * post: drawPile has been shuffled.
     */
    public void shuffle(){
        Collections.shuffle(drawPile);
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
        for (int i = 0; i < drawPile.size(); i++){
            str += drawPile.get(i);
        }
        return str;
    }

}
