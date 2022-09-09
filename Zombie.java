import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *  
 */
public class Zombie extends Actor
{
    // Declare and initialize variables
    private int animateImage = 1; // start at image 1 of the zombie
    private int animationCounter;
    private int zombieSpawnRate = 10; // to make zombies animate slower
    ScoreCounter counter;
    private int zombieSpeed = 1; // slow speed

    private GreenfootSound[] zombieSounds;
    private int zombieSoundIndex;
    public Zombie(ScoreCounter counter)
    {
        this.counter = counter;   
        setImage("idle0000.png"); 
        
       zombieSounds = new GreenfootSound[20]; // Make 20 copies of the zombie sound

       for (int i = 0; i < zombieSounds.length; i++){ 
            zombieSounds[i] = new GreenfootSound("zombiesound.wav");
        }        
        zombieSoundIndex = 0;
    }

    public void act() 
    {
        animationCounter++;
        animation();
        chasePlayer();
        hitByProjectile();
    }  

    public void animation(){
        if (animationCounter %  zombieSpawnRate == 0){  // to make it slower
            if (animateImage > 12){  // animate 12 pictures of the zombie
                animateImage = 1;  
            }
            setImage("run" + animateImage + ".png");
            animateImage++; // go onto the next image (to animate)
        }     
    }

    public void chasePlayer(){
        turnTowards(Player.playerX, Player.playerY); // Zombie pinpoints and chases the player
        move(zombieSpeed);
    }
    
    private void zombieSound(){
        zombieSounds[zombieSoundIndex].play();
        zombieSoundIndex++;
        if (zombieSoundIndex >= zombieSounds.length){
            zombieSoundIndex = 0;
        }
    }

    public void hitByProjectile(){
        // create general actors
        Actor projectile = getOneIntersectingObject(Projectile.class); // if zombie hit by projectile
        if (projectile != null){ // if there is something of the projectile class intersecting the zombie....
            zombieSound();
            counter.score++;
            getWorld().removeObject(projectile); // remove the projectle, if zombie is hit by projectile
            getWorld().addObject(new ZombieDeath(), getX(), getY()); // add dead zombie       
            getWorld().removeObject(this); // remove zombie
        } 
    }

}
