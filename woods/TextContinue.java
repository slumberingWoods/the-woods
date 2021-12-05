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
     * Act - do whatever the TextConitnue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
