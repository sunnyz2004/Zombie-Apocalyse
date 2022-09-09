import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletLeft extends Actor
{
    // This is displayed at the top right corner of the GameWorld
    public BulletLeft()
    {
        setImage (new GreenfootImage ("Bullets left: " + Player.bullet, 30, Color.BLACK, new Color(0,0,0,0)));
    }
    public void act() 
    { 
        setImage (new GreenfootImage ("Bullets left: " + Player.bullet, 30, Color.BLACK, new Color(0,0,0,0)));
    }
    }
    
    

