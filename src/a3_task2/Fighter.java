/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

/**
 * The class Fighter is defined to maintain Fighter object having 3 fields;
 * wizardName to keep track of name;
 * shootingAccuracy used to know his shooting Accuracy
 * and his alive status is captured in "alive"
 * @author VinayaSaiD
 */
public class Fighter {
    // maintain 3 fields for each player, his name, accuracy and is he alive or not
    String wizardName;
    double shootingAccuracy;
    boolean alive;
    
    // Default constructor
    public  Fighter(){
    }
    
    // Constructor with 2 variables, to initailize the player
    public  Fighter(String name, double accuracy){
        wizardName = name;
        shootingAccuracy = accuracy;
        alive = true;
    }
}
