/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

/**
 * This class is used to generate the fight depending on the shooter;
 * shooterGandalf() is used to play the duel when shooter is Gandalf 
 * and takes 5 inputs shooter a Fighter object, target array of Fighter objects, 
 * participants - no of participants left,strategy - 1 or 2,missCounter - used for missing 1st time in strategy2;
 * shooterMerlin() is used to play the duel when shooter is Merlin and the parameters are same as shooterGandalf() method;
 * shooterDumbledore() is used to play the duel when shooter is Dumbledore and the parameters are same as shooterGandalf() method and
 * @author VinayaSaiD
 */
public class Fight {
    // to play the game between two players
    public int[] shooterGandalf(Fighter shooter, Fighter[] target, int participants,int strategy,int missCounter){
        int[] returnArray = new int[2];
        // if the  shooter is Gandalf and he is alive
        if (shooter.wizardName == "Gandalf" && shooter.alive == true)
        {   
            missCounter = missCounter+1;
            // Only Gandalf differenciates the 2 strategies so using if loop for only him
            if (strategy==1){
                // he needs to kill Dumbledore if he is alive
                if (target[0].wizardName == "Dumbledore" && target[0].alive == true){
                    // generating random number and checking if it is less than or equal to accuracy
                    if (rand1() <= (shooter.shootingAccuracy))
                    {
                        target[0].alive = false;
                        participants= participants -1;
                    }
                }
                // he needs to kill Merlin if he is alive and Dumbledore is dead
                else if (target[1].wizardName == "Merlin" && target[1].alive == true){
                    // generating random number and checking if it is less than or equal to accuracy
                    if (rand1() <= (shooter.shootingAccuracy))
                    {
                        target[1].alive = false;
                        participants= participants -1;
                    }
                }
            }
            // For the second strategy
            else{
                // Intentionally miss the first chance
                if (missCounter ==1){
                    returnArray[0] = participants;
                    returnArray[1] = missCounter;
                    return returnArray;
                }
                // and play properly from next time
                else{
                if (target[0].wizardName == "Dumbledore" && target[0].alive == true){
                    if (rand1() <= (shooter.shootingAccuracy))
                    {
                        target[0].alive = false;
                        participants= participants -1;
                    }
                }
                else if (target[1].wizardName == "Merlin" && target[1].alive == true){
                    if (rand1() <= (shooter.shootingAccuracy))
                    {
                        target[1].alive = false;
                        participants= participants -1;
                    }
                }
                }
            }
            returnArray[0] = participants;
            returnArray[1] = missCounter;
            return returnArray;
        }
        returnArray[0] = participants;
        returnArray[1] = missCounter;
        return returnArray;
    }
    public int[] shooterMerlin(Fighter shooter, Fighter[] target, int participants,int strategy,int missCounter){
        int[] returnArray = new int[2];
        // if the  shooter is Merlin and he is alive
        if (shooter.wizardName == "Merlin" && shooter.alive == true)
        {
            // He needs to kill Dumbledore if he is alive
            if (target[0].wizardName == "Dumbledore" && target[0].alive == true){
                // generating random number and checking if it is less than or equal to accuracy
                if (rand1() <= (shooter.shootingAccuracy))
                {
                    target[0].alive = false;
                    participants= participants-1;
                }
            }
            // he needs to kill Gandalf if he is alive and Dumbledore is dead
            else if (target[1].wizardName == "Gandalf" && target[1].alive == true){
                // generating random number and checking if it is less than or equal to accuracy
                if (rand1() <= (shooter.shootingAccuracy))
                {
                    target[1].alive = false;
                    participants = participants -1;
                }
            }
            returnArray[0] = participants;
            returnArray[1] = missCounter;
            return returnArray;
        }
        returnArray[0] = participants;
        returnArray[1] = missCounter;
        return returnArray;
    }
    
    public int[] shooterDumbledore(Fighter shooter, Fighter[] target, int participants,int strategy,int missCounter){
        int[] returnArray = new int[2];
        // if the  shooter is Dumbledore and he is alive
        if (shooter.wizardName == "Dumbledore" && shooter.alive == true)
        {
            // He needs to kill Merlin if he is alive
            if (target[0].wizardName == "Merlin" && target[0].alive == true){
                target[0].alive = false;
                participants = participants - 1;
            }
            // he needs to kill Gandalf if he is alive and Merlin is dead
            else if (target[1].wizardName == "Gandalf" && target[1].alive == true){
                target[1].alive = false;
                participants= participants - 1;
            }
            returnArray[0] = participants;
            returnArray[1] = missCounter;
            return returnArray;
        }
        returnArray[0] = participants;
        returnArray[1] = missCounter;
        return returnArray;
        }
    // generate random numer between 0 and 1, i do not want this to be exposed so making it private
    private double rand1 (){
            return (Math.random());
    }  
}
