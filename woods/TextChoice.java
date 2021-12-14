import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextChoice extends Actor
{
    int delay = 10;
    int phase = 0;
    int location = 0;
    /**
     * Act - The object moves left and right to highlight the choice
     * Moving left and right set the phase to 0 or 1 which is referenced when in dialogue choice
     */
    public void act()
    {
       delay--;
       if (delay == 0 && phase == 0) {
           setLocation(getX() - 10, getY());
           delay = 10;
           phase = 1;
       } else if (delay == 0 && phase == 1) {
           setLocation(getX() + 10, getY());
           delay = 10;
           phase = 0;
       }
       checkMovement();
    }
    public void checkMovement() {
        if (Greenfoot.isKeyDown("left") && location == 1) {
            setLocation(getX() - 250, getY());
            location = 0;
        } else if  (Greenfoot.isKeyDown("right") && location == 0) {
            setLocation(getX() + 250, getY());
            location = 1;
        }
    }
}
