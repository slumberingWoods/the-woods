import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallTile extends Objects
{
    /**
     * Act - do whatever the WallTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WallTile(String name, int center)
    {
        setImage("house/" + name + ".png");
        this.center = center;
    }
    public void act() {
        checkPlayer();
    }
}
