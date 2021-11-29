import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InteractObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InteractObject extends Objects
{
    /**
     * Act - do whatever the InteractObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String[] text;
    
    public InteractObject(String name, String[] text) {
        setImage("house/" + name + ".png");
        this.text = text;
    }
}
