import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicObject extends Objects
{
    /**
     * Act - do whatever the BasicObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BasicObject(String name, int center) {
        setImage("objects/" + name + ".png");
        this.center = center;
    }
    public void act() {
        checkPlayer();
    }
}
