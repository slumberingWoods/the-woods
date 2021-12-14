import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextConitnue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextContinue extends Actor
{
    int delay = 10;
    int phase = 0;
    /**
     * Act - The object moves up and down as an animation to show that the player can move to the next dialogue
     */
    public void act()
    {
    delay--;
       if (delay == 0 && phase == 0) {
           setLocation(getX(), getY() - 10);
           delay = 10;
           phase = 1;
       } else if (delay == 0 && phase == 1) {
           setLocation(getX(), getY() + 10);
           delay = 10;
           phase = 0;
       }
    }
}
