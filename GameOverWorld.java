import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class GameOverWorld extends World
{
    /**
     * Act - do whatever the GameOverWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
         */
    // Declare variables 
    private Label scoreDisplayLabel; 
    private Label bulletDisplayLabel; 
    public GameOverWorld()
    {
        super(800, 600, 1); 
        setBackground (new GreenfootImage ("gameover.png"));
        
        if (Player.getBullet() > 0){ // If there are still bullets left...
            bulletDisplayLabel = new Label ("Bullets left: " + Player.bullet, 45);
        }
        else{ // If Player uses all the bullets
            bulletDisplayLabel = new Label ("YOU USED ALL BULLETS", 30);

        }
        scoreDisplayLabel = new Label ("Points gained: " + ScoreCounter.score, 45);
        addObject (scoreDisplayLabel, getWidth()/4-20, getHeight() - 250); 
        addObject (bulletDisplayLabel, getWidth()/2 + 230, getHeight()-255); 
    }

    public void act() 
    {
        checkKeys();
    }    

    // Check if user wants to play again
    public void checkKeys(){
        if (Greenfoot.isKeyDown("p")){
            Greenfoot.setWorld(new GameWorld());
        } 
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new WelcomeWorld());
        }         
    }

}