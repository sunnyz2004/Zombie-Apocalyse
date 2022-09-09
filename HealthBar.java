import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    public static final int HEALTH_BAR_WIDTH = 50;
    public static final int HEALTH_BAR_HEIGHT = 10;
    private int health =  HEALTH_BAR_WIDTH-2; // green part of the health bar
    public HealthBar()
    {
        // Draw rectangle
        setImage (new GreenfootImage (HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT));
        getImage().drawRect(0,0, HEALTH_BAR_WIDTH-1, HEALTH_BAR_HEIGHT-1);
        
        // draw red rectangle 
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1, HEALTH_BAR_WIDTH-2, HEALTH_BAR_HEIGHT-2);
        
        // draw green rectangle over the red rectangle
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1, health, HEALTH_BAR_HEIGHT-2);
    }

    public void act() 
    {
        // Same as constructor, to constantly check and update the colours
        setImage (new GreenfootImage (HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT));
        getImage().drawRect(0,0, HEALTH_BAR_WIDTH-1, HEALTH_BAR_HEIGHT-1);

        getImage().setColor(Color.RED);
        getImage().fillRect(1,1, HEALTH_BAR_WIDTH-2, HEALTH_BAR_HEIGHT-2);
        
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1, health, HEALTH_BAR_HEIGHT-2);
        
        // Put the healthbar on top of the player
        World world = getWorld(); // access the world the player is in
        GameWorld gameWorld = (GameWorld)world; // turn it into a GameWorld reference
        setLocation (gameWorld.getPlayer().getX(), gameWorld.getPlayer().getY()-60); // Just above the player
        losePlayerHealth();

    }

    public void losePlayerHealth(){
        World world = getWorld(); // access the world
        GameWorld gameWorld = (GameWorld)world; // turn it into a GameWorld reference
        if (gameWorld.getPlayer().hitByZombie() == true){
            health--;
        }

        if (health <= 0){
            Greenfoot.setWorld(new GameOverWorld());               
        }
    }

}
