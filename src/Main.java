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

/* main class. client code. */

public class Main {
    public static void main(String[] args) {
        War game = new War();   // created War object
        Scanner input = new Scanner(System.in);
        int playWarGame = 1;
        String runProgram;
        
        /* intro */
        System.out.println("Welcome to the Game of War! Player with all 52 cards wins.");
        System.out.println("Jack = 11\nQueen = 12\nKing = 13\nAce = 14");
        System.out.println("Number of cards left in each player's draw pile is displayed in the square brackets.");
        
        /* assign value to runProgram */
        System.out.print("\nEnter 'p' to play the game: " );
        runProgram = input.nextLine();
        input.close();
        
        /* playGame when p is entered. Invalid input otherwise. */
        if (runProgram.equals("p")){
            /* loop to execute playGame method until 0 is returned. */
            while (playWarGame != 0){
                playWarGame = game.playGame();
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}