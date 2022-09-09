import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    private GreenfootImage projectile;
    
    public Projectile()
    {
        projectile = new GreenfootImage (15,6);
        setImage(projectile);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(0,0,15,6);
    }

    public void act() 
    {
        move(10);
        if (isAtEdge()) {  // remove projectile if it is at the edge of the screen/world
            getWorld().removeObject(this);
        }    
    }  

}
