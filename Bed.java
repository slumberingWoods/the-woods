import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bed extends Objects
{
    public Bed()
    { 
       GreenfootImage myImage = getImage();
       int myNewHeight = (int)myImage.getHeight()/4;
       int myNewWidth = (int)myImage.getWidth()/4;
       myImage.scale(myNewWidth, myNewHeight);
    }
    /**
     * Act - do whatever the Bed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
