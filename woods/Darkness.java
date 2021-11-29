import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Darkness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Darkness extends Actor
{
    /**
     * Act - do whatever the Darkness wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        setLocation(player.getX(),player.getY());
    }
}
