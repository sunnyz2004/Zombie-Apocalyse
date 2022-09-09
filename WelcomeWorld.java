import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Sunny Zhang 
 * @version June 2021
 * 
 * Image References:
 * WelcomeWorld Background - Apocalypse Wallpaper: https://www.wallpaperup.com/21946/Apocalypse.html
 * GameWorld Background - Pixelated Green Wallpaper - created by Raymond Schlitter: https://www.slynyrd.com/blog/2019/8/27/pixelblog-20-top-down-tiles 
 * Game Over Background: https://media.giphy.com/media/eJ4j2VnYOZU8qJU3Py/giphy.gif
 * Animated Zombie Sprites - created by Riley Gombart: https://lpc.opengameart.org/content/top-down-animated-zombie-set
 * Top Down Survivor Player - created by Riley Gombart: https://opengameart.org/content/animated-top-down-survivor-player
 * 
 * Code References:
 * Used same checkKeys() method as Mr.Cohen, in the GameWorld
 * Used animation techniques similar to mrligocki on Youtube: https://www.youtube.com/watch?v=el5SmbU53Fc
 * 
 * Music References (no copyright, royalty-free):
 * Suspense - created by Alex Koff: https://www.youtube.com/watch?v=vN8sBkJ8-24
 * Gun shot sound - created by fesliyanstudios: https://www.fesliyanstudios.com/royalty-free-sound-effects-download/gun-shooting-300
 * Zombie sound - created by fesliyanstudios: https://www.fesliyanstudios.com/sound-effects-search.php?q=zombie&page=2
 * 
 */
public class WelcomeWorld extends World
{
    private Label startLabel;
    private Label instructionsLabel;
    private UserInfo user;

    public WelcomeWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground (new GreenfootImage ("welcomeworldbackground.jpg"));

        // Add start label and instructions label for user to click to
        startLabel = new Label ("Start Game", 40);
        addObject(startLabel, 200, 400);

        instructionsLabel = new Label ("Instructions", 40);
        addObject(instructionsLabel, 600, 400);  

    }
    public void act () {
        checkMouse();
    }

    // Check if user has pressed on the labels
    private void checkMouse(){
        if (Greenfoot.mouseClicked(startLabel)){
            Greenfoot.setWorld(new GameWorld());
        }
        if (Greenfoot.mouseClicked(instructionsLabel)){
            Greenfoot.setWorld(new InstructionsWorld());
        }        
    }
}
