/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

import java.util.*;
import java.math.*;
/**
 * This program generate a game between 3 people Gandalf, Merlin and Dumbledore;
 * There are 2 strategies implemented in this program and the final output is printed for both the cases;
 * The main() method is to initiate the players, iterate through the strategies and print the result of 10000 matches each
 * @author VinayaSaiD
 */
public class A3_Task2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Fight fight = new Fight();
        // loop for 2 different strategies
        for (int strategy = 1; strategy <3; strategy++){
            // each player win out of 10000 games played
            int wizard1Wins = 0;
            int wizard2Wins = 0;
            int wizard3Wins = 0;
            // repeating for 10000 times
            for (int i=0;i<10000;i++)
            {   
                //Start the game with 3 player alive
                int participants=3;
                // setting each player accuracy
                Fighter wizard1 = new Fighter("Gandalf", (1.0/3));
                Fighter wizard2 = new Fighter("Merlin", (1.0/2));
                Fighter wizard3 = new Fighter("Dumbledore", (1.0));
                // used for implementing stratergy2
                int missCounter = 0; 
                int [] arraymissLeft = new int[2];
                // loop until only p1 participant is left
                while (participants>1)
                {
                    arraymissLeft = fight.shooterGandalf(wizard1,new Fighter[] {wizard3, wizard2} , participants, strategy, missCounter);
                    participants = arraymissLeft[0];
                    missCounter = arraymissLeft[1];
                    arraymissLeft = fight.shooterMerlin(wizard2,new Fighter[] {wizard3, wizard1} , participants, strategy, missCounter);
                    participants = arraymissLeft[0];
                    missCounter = arraymissLeft[1];
                    arraymissLeft = fight.shooterDumbledore(wizard3,new Fighter[] {wizard2, wizard1} , participants, strategy, missCounter);
                    participants = arraymissLeft[0];
                    missCounter = arraymissLeft[1];

                }
                // these are used to count the number of wins each player gets for 10000 games played
                if (wizard1.alive == true){
                    wizard1Wins = wizard1Wins +1;
                }
                if (wizard2.alive == true){
                    wizard2Wins = wizard2Wins +1;
                }
                if (wizard3.alive == true){
                    wizard3Wins = wizard3Wins +1;
                }
            }
            //System.out.println("Gandalf: "+ wizard1Wins);
            //System.out.println("Merlin: " + wizard2Wins);
            //System.out.println("Dumbeldore: "+ wizard3Wins);
            // Printing the table as given in the question
            System.out.println("For strategy "+ strategy);
            System.out.println("---------------------------------------------");
            System.out.println("LEADERBOARD – AFTER 10000 DUELS");
            System.out.format("%-20s%-20s%-20s\n","Contestant","Number of Wins","Winning Percentage");
            System.out.format("%-20s%-20d%-7.2f%%\n","Gandalf",wizard1Wins,(wizard1Wins/10000.0)*100);
            System.out.format("%-20s%-20d%-7.2f%%\n","Merlin",wizard2Wins,(wizard2Wins/10000.0)*100);
            System.out.format("%-20s%-20d%-7.2f%%\n","Dumbledore",wizard3Wins,(wizard3Wins/10000.0)*100);
            System.out.println();
            if (strategy == 1){
                System.out.println("Merlin have more chance of winning.");
                System.out.format("As Merlin have %.2f %% chance of winning, compared to Gandalf who has %.2f %% and Dumbledore who has %.2f %% chance.\n",(wizard2Wins/10000.0)*100,(wizard1Wins/10000.0)*100,(wizard3Wins/10000.0)*100);
                System.out.println("And the middle shooter has best chance of winning in this Strategy.");
            }
            System.out.println();
            if (strategy == 2){
                System.out.println("Gandalf have more chance of winning if he intentionally misses the first time.");
                System.out.format("As Gandalf have %.2f %% chance of winning, compared to Merlin who has %.2f %% and Dumbledore who has %.2f %% chance.\n",(wizard1Wins/10000.0)*100,(wizard2Wins/10000.0)*100,(wizard3Wins/10000.0)*100);
                System.out.println("And the worst shooter has best chance of winning in this Strategy.");
            }
        }
        // To answer the question asked in the Assignment
    }
}

