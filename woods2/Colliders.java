import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Colliders here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colliders extends Actor
{
    int PlayerX, PlayerY;
    /**
     * Act - do whatever the Colliders wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        if(isTouching(Player.class))
            player.checkColision();
    }
}
