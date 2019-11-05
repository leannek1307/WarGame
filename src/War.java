/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 * Nov 4, 2019.
 * @author leannekim
 */

/* Game of war 
 
[ GAME OF WAR ] RULES

1. Shuffle deck of 52 cards (eliminate 2 joker cards).
2. Hand out cards to player1 and player2 (26 cards each).
3. Game starts.
4. Each player places one card to the played pile. 
5. The player who placed the card with the higher rank takes both cards.
6. If the cards are tied, both players place down three cards faced down.
7. Draw another card, faced up.
8. Draw pile is automatically shuffled every round.
9. Repeat from #4.
10. If one player runs out of cards to play, the other player wins.
11. If one player runs out of cards to do the tiebreaker, that player should 
    give out all cards to the other player.
12. The player with all 52 card wins.

*/
    
public class War {
    
    private final static int cardsPlacedAtWar = 3;
    private int numRounds;
    Deck deck;
    DrawPile p1DP;
    DrawPile p2DP;
    PlayedPile p1PP;
    PlayedPile p2PP;
    
    /**
     * constructor
     * pre: none
     * post: deck, p1DP, p2DP, p1PP, p2PP Object has been created.
     */
    public War(){
        numRounds = 0;
        deck = new Deck();
        p1DP = new DrawPile();
        p2DP = new DrawPile();
        p1PP = new PlayedPile();
        p2PP = new PlayedPile();
        distribute();
    }
    
    /**
     * spilt the deck into two
     * pre: none
     * post: half of the deck has been assigned to p1DP and the other to p2DP.
     */
    private void distribute(){
        ArrayList<Card> temp = deck.getDeck();
        for (int i = 0; i < 26; i++){
            p1DP.addCard(temp.get(i));
        }
        for (int i = 26; i < 52; i++){
            p2DP.addCard(temp.get(i));
        }
    }
    
    /**
     * plays the game of War
     * pre: none
     * post: game of War has been played.
     * @return 
     */
    public int playGame(){
        /* shuffle draw pile every round */
        p1DP.shuffle();
        p2DP.shuffle();
        if (p1DP.isEmpty()){    // p1 pile is empty
            System.out.println("\nplayer 1 is out of cards.\nplayer 2 wins the game.");
            return 0;
        } else if (p2DP.isEmpty()){ // p2 pile is empty
            System.out.println("\nplayer 2 is out of cards.\nplayer 1 wins the game.");
            return 0;
        } else {    // both not empty
            numRounds++;
            Card p1 = p1DP.getCard(p1DP.getSize()-1); // get the top card
            Card p2 = p2DP.getCard(p2DP.getSize()-1);
            
            p1PP.addCard(p1);   // add card to playedPile
            p2PP.addCard(p2);

            p1DP.removeCard(p1);    // remove card from drawPile
            p2DP.removeCard(p2);
            
            System.out.println("\nRound " + numRounds);
            System.out.println("Player 1: " + p1 + " [" + p1DP.getSize() + "] cards left");
            System.out.println("Player 2: " + p2 + " [" + p2DP.getSize() + "] cards left");
            
            p1 = p1PP.getCard(p1PP.getSize()-1);    // get last card of playedPile
            p2 = p2PP.getCard(p2PP.getSize()-1);
            
            /* compare the cards drawn from playedPile */
            if(p1.compareTo(p2) == 0){   // tie
                System.out.println("\nIt's a tie.");
                tie(); 
            } else if (p1.compareTo(p2) > 0){   // p1 card is greater 
                System.out.println("p1 win");
                p1DP.addCard(p1); // add p1 and p2 to p1DP
                p1DP.addCard(p2);
                
                p2DP.removeCard(p2); // remove p2 from p2DP
                
                p1PP.removeCard(p1); // remove p1 and p2 from p1PP and p2PP
                p2PP.removeCard(p2);
            } else {    // p2 card is greater
                System.out.println("p2 win");
                
                p2DP.addCard(p1); // add p1 and p2 to p2DP
                p2DP.addCard(p2);
                
                p1DP.removeCard(p1); // remove p2 from p1DP
                
                p1PP.removeCard(p1); // remove p1 and p2 from p1PP and p2PP
                p2PP.removeCard(p2);
            } 
            return 1;
        }
    }
    
    /**
     * draw numWar number more cards, draw another then compare the cards again.
     * pre: none
     * post: tiebreaker has been played.
     * @param p1
     * @param p2 
     */
    private void tie(){
        boolean isTie = false;
        
        /* shuffle drawPile every round */
        p1DP.shuffle();
        p2DP.shuffle();

        do {
            numRounds++;
            /* when one of the decks have less than 4 cards */
            if (p1DP.getSize() < cardsPlacedAtWar){
                System.out.println("\nplayer 1 is out of cards to do tiebreaker.\nplayer 1 passes all remaining cards to player 2.");
                noMoreCards(p2DP.getAL(), p1DP.getAL());
                break;
            
            } else if (p2DP.getSize() < cardsPlacedAtWar){
                System.out.println("\nplayer 2 is out of cards to do tiebreaker.\nplayer 2 passes all remaining cards to player 1.");
                noMoreCards(p1DP.getAL(), p2DP.getAL());
                break;
            }
            
            /* put down cards cardsPlacesAtWar times */
            for (int i = 0; i < cardsPlacedAtWar; i++){
                
                Card one = p1DP.getCard(p1DP.getSize()-1);  // get last card of drawPile
                Card two = p2DP.getCard(p2DP.getSize()-1);
                
                p1PP.addCard(one); // add card to playedPile
                p2PP.addCard(two);
                
                p1DP.removeCard(one); // remove card from drawPile
                p2DP.removeCard(two);
            }
            
            /* when one decks have less than 4 cards after War cards are placed */
            if (p1DP.getSize() < cardsPlacedAtWar){
                System.out.println("\nplayer 1 is out of cards to do tiebreaker.\nplayer 1 passes all remaining cards to player 2.");
                noMoreCards(p2DP.getAL(), p1DP.getAL());
                break;
            
            } else if (p2DP.getSize() < cardsPlacedAtWar){
                System.out.println("\nplayer 2 is out of cards to do tiebreaker.\nplayer 2 passes all remaining cards to player 1.");
                noMoreCards(p1DP.getAL(), p2DP.getAL());
                break;
            }

            /* draw another card */
            Card one = p1DP.getCard(p1DP.getSize()-1);  // get last card of drawPile
            Card two = p2DP.getCard(p2DP.getSize()-1);
            
            p1PP.addCard(one);  // add card to playedPile
            p2PP.addCard(two);
            
            p1DP.removeCard(one);   // remove card from drawPile
            p2DP.removeCard(two);
            
            System.out.println("\nRound " + numRounds);
            System.out.println("WAR");
            System.out.println("Player 1: " + one + " [" + (p1DP.getSize()) + "] cards left");
            System.out.println("Player 2: " + two + " [" + (p2DP.getSize()) + "] cards left");

            /* compare cards */
            if (one.compareTo(two) == 0){  // equal cards
                isTie = true;
            } else if (one.compareTo(two) > 0){  // p1's card is greater
                isTie = false;
                System.out.println("p1 wins");
                
                /* add every card in p1PP and p2PP to p1DP */
                for (int i = 0; i < p1PP.getSize(); i++){
                    p1DP.addCard(p1PP.getCard(i));
                }
                p1PP.clearPile();
                for (int i = 0; i < p2PP.getSize(); i++){
                    p1DP.addCard(p2PP.getCard(i));
                } 
                p2PP.clearPile();
                playGame();
            } else {  // p2's card is greater
                isTie = false;
                System.out.println("p2 wins");
                
                /* add every card in p1PP and p2PP to p2DP */
                for (int i = 0; i < p1PP.getSize(); i++){
                    p2DP.addCard(p1PP.getCard(i));
                }
                p1PP.clearPile();
                for (int i = 0; i < p2PP.getSize(); i++){
                    p2DP.addCard(p2PP.getCard(i));
                } 
                p2PP.clearPile();
                playGame();
            }
        }  while (isTie);  
    }
    
    /**
     * passes all of the cards of the loser to the winner
     * pre: ArrayList<Card> winner, ArrayList<Card>loser 
     * post: All loser cards has been added to the winner arrayList.
     * @param winner
     * @param loser 
     */
    private void noMoreCards(ArrayList<Card> winner, ArrayList<Card> loser){
        /* remove card at index 0 */
        while (!loser.isEmpty()){
             winner.add(loser.remove(0));
        }
    } 
}
