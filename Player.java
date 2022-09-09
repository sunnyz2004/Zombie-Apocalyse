import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *
 */
public class Player extends Actor
{
    public static int playerX, playerY; 
    public static int bullet;

    private GreenfootSound[] shootSounds;
    private int shootSoundIndex;

    public Player()
    {
        setImage (new GreenfootImage("player.png"));
        setRotation(270); // face upright (since the picture is right initially)
        bullet = 80; // Player gets 80 bullets to start with

        shootSounds = new GreenfootSound[20]; // Make 20 copies of the shooting sound

        for (int i = 0; i < shootSounds.length; i++){
            shootSounds[i] = new GreenfootSound("shotsound.wav");
        }        
        shootSoundIndex = 0;

    }

    public void act() 
    {
        if ("space".equals(Greenfoot.getKey()))// Check if Player is pressing the key to shoot
        {
            shootProjectile();
        }
        playerX = getX(); // to access its coordinates at all times
        playerY = getY();
        hitByZombie();
    } 

    public void shootProjectile(){
        shootSound();
        Projectile projectile = new Projectile();
        getWorld().addObject(projectile, getX(), getY()); // Make the projectile at the same location as the player
        projectile.setRotation(getRotation()); // Get the rotation of the Player
        projectile.move(40);
        bullet--;
    }

    private void shootSound(){
        shootSounds[shootSoundIndex].play();
        shootSoundIndex++;
        if (shootSoundIndex >= shootSounds.length){
            shootSoundIndex = 0;
        }
    }    

    public boolean hitByZombie(){ 
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if (zombie != null){ // If there is a zombie at the offset of the player...
            return true;
        }
        else{
            return false;
        }
    }

    // get the number of bullets left to display in GameWorld
    public static int getBullet ()
    {
        return bullet;
    }
}

