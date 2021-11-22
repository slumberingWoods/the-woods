import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
    
        prepare();
    }
    public void act() {
        showText(""+Player.time, getWidth()/2,getHeight()/2);
    }
    private void prepare() {
        addObject (new Player(), 230, 100);        
        addObject(new Bed(),130,100);        

    }
}
