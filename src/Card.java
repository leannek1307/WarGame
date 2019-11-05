/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Nov 3, 2019.
 * @author leannekim
 */

/* Card class */
public class Card implements Comparable <Card>{
    
    private int rank;
    private char suit;

    /**
     * constructor
     * pre: none 
     * post: values have been assigned to rank and suit.
     * @param rank
     * @param suit 
     */
    public Card(int rank, char suit){  
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * return rank
     * pre: none
     * post: Rank has been returned.
     * @return 
     */
    public int getRank(){
        return rank;
    }
    
    /**
     * return suit
     * pre: none
     * post: Suit has been returned.
     * @return 
     */
    public char getSuit(){
        return suit;
    }
    
    /**
     * Compare cards
     * pre: other card
     * post: 0 has been returned if cards were equal, 1 if thisCard was larger than otherCard, -1 else.
     * @param other
     * @return 
     */
    public int compareTo(Card other){
        int thisCard = this.rank;
        int otherCard = other.rank;
        
        if (thisCard == otherCard){
            return 0;
        } else if (thisCard > otherCard){
            return 1;
        } else {
            return -1;
        }
    }
       
    /**
     * Return string
     * pre: none
     * post: String has been returned.
     * pre: none
     * @return 
     */
    public String toString(){
        String str;
        str = getRank() + " " + getSuit();
        return str;
    }
    
}
