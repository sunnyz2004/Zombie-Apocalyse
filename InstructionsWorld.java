import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsWorld extends World
{
    private Label backLabel;

    public InstructionsWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground (new GreenfootImage ("instructionsworldbackground.png"));
        
        backLabel = new Label ("Back", 40);
        addObject(backLabel, 85, 500);
    }
    
    public void act () {
        checkMouse();
    }
    
    // Check if user has clicked on the 'back' label
    private void checkMouse(){
        if (Greenfoot.mouseClicked(backLabel)){
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
}
