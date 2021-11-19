import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bed extends Actor
{
    public bed()
    { 
       GreenfootImage myImage = getImage();
       int myNewHeight = (int)myImage.getHeight()/3;
       int myNewWidth = (int)myImage.getWidth()/3;
       myImage.scale(myNewWidth, myNewHeight);
    }

    /**
     * Act - do whatever the bed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        
    }
}
