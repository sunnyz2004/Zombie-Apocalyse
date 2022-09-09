import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    public static int score; // easily accessible by any class
    public ScoreCounter()
    {
        setImage (new GreenfootImage ("Points: " + score, 30, Color.BLACK, new Color(0,0,0,0))); // at the top left corner of the GameWorld
    }
    public void act() 
    { 
        setImage (new GreenfootImage ("Points: " + score, 30, Color.BLACK, new Color(0,0,0,0)));
        getScore();
    }
    public static int getScore(){ // to use in the GameWorld, and increase the number of zombies entered in the world
        return score;
    }    
}
