import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author 
 * @version 
 * 
 */
public class GameWorld extends World
{
    private Player player; 
    private int spawnSpeed = 55; // the bigger the number, the slower it is
    private int randomSpawnNum;

    private GreenfootSound backgroundMusic;

    ScoreCounter counter = new ScoreCounter();
    BulletLeft trackBullet = new BulletLeft();

    HealthBar healthbar = new HealthBar();
    int spawnZombieRate = 600;
    public GameWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground (new GreenfootImage("gameworldbackground.png"));
        
        // Set up background music
        backgroundMusic = new GreenfootSound ("suspensefulbackgroundmusic.mp3");
        backgroundMusic.playLoop();
        
        // Set score to 0 every game
        ScoreCounter.score = 0;
        
        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2); // Middle of the screen
        addObject(counter,getWidth()-720,getHeight()-540); // Top left of screen
        addObject(trackBullet, 685, getHeight()-540); //  Top right of screen
        addObject (healthbar, player.getX(), player.getY()-65); // On top of player

    }

    public void started() {
        backgroundMusic.playLoop();
    }

    public void stopped() {
        backgroundMusic.pause();
    }

    public Player getPlayer(){
        return player;
    }

    public void act(){
        checkKeys();
        spawnZombie();

        // If the user has no more bullets left, switch to GameOverWorld
        if (player.getBullet() <= 0) {
            Greenfoot.setWorld(new GameOverWorld());
        }
    }

    private void checkKeys(){
        if (Greenfoot.isKeyDown("left")){
            // turn COUNTER-clockwise
            player.turn(-4);
        } 
        if (Greenfoot.isKeyDown("right")){
            // turn CLOCKWISE
            player.turn(4);
        }
        if (Greenfoot.isKeyDown("up")){
            // move FORWARD
            player.move(4);
        }
        if (Greenfoot.isKeyDown("down")){
            // move BACKWARD
            player.move(-4);
        }
    }   

    private void spawnZombie(){
        if (ScoreCounter.score > 0){
            if (ScoreCounter.score % 5 == 0){ // Every time the score is divisible by 5, decrease the spawnZombieRate
                if (spawnZombieRate >= 0){
                    spawnZombieRate --; // More zombies as score gets higher because there is a greater chance of getting the random number...
                }
            }        
        }

        // Spawn zombie at random points on 4 sides of the World
        if (Greenfoot.getRandomNumber(spawnZombieRate) == 1){  // random points on top side
            int randX = Greenfoot.getRandomNumber(800);
            addObject(new Zombie(counter), randX, 5);
        }

        else if (Greenfoot.getRandomNumber(spawnZombieRate) == 2){ // random points on left side
            int randY = Greenfoot.getRandomNumber(600);
            addObject(new Zombie(counter), 0, randY);
        }

        else if (Greenfoot.getRandomNumber(spawnZombieRate) == 3){ // random points on bottom side
            int randX = Greenfoot.getRandomNumber(800);
            addObject(new Zombie(counter), randX, 600);
        }

        if (Greenfoot.getRandomNumber(spawnZombieRate) == 4){ // random points on right side
            int randY = Greenfoot.getRandomNumber(600);
            addObject(new Zombie(counter), 800, randY);
        }

    }  

}
