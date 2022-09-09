import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieDeath extends Actor
{
    // Initialize 7 pictures of the zombie
    
    GreenfootImage death1 = new GreenfootImage("death1.png");
    GreenfootImage death2 = new GreenfootImage("death2.png");
    GreenfootImage death3 = new GreenfootImage("death3.png");
    GreenfootImage death4 = new GreenfootImage("death4.png");
    GreenfootImage death5 = new GreenfootImage("death5.png");
    GreenfootImage death6 = new GreenfootImage("death6.png");
    GreenfootImage death7 = new GreenfootImage("death7.png");

    public int animationCounter;
    public int frame = 1; 

    public void act() 
    {
        animationCounter++;
        if (animationCounter % 4 == 0){ // Make the animation slower
            animation();
        }
    }    

    public void animation()
    {
        // Animating the death of the zombie, after getting hit by the projectile
        if (frame == 1){
            setImage(death1);
            frame = 2;
        } 
        else if (frame == 2){
            setImage (death2);
            frame = 3;
        }
        else if (frame == 3){
            setImage (death3);
            frame = 4;
        } 
        else if (frame == 4){
            setImage (death4);
            frame = 5;
        } 
        else if (frame == 5){
            setImage (death5);
            frame = 6;
        } 
        else if (frame == 6){
            setImage (death6);
            frame = 7;
        } 
        else if (frame == 7){
            setImage (death7);
            frame = 8;
        }
        else{
            getWorld().removeObject(this); // remove the zombie after it gets to the last frame
        }
    }
}
