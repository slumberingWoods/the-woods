import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPCEYEObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCEYEObject extends Objects
{
    String world;
    int textTime;
    boolean activateText = false;
    public NPCEYEObject(String world) {
        this.world = world;  
        textTime = 40;
        setImage("npcs/eyeball.png");
    }
    public void act()
    {
        checkPlayer();
        if (Greenfoot.isKeyDown("z")  && isInRange() && activateText == false) {
            getWorld().showText("Key...you want...", getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            Player.keys += 1;
            activateText = true;
        }
         if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                getWorld().removeObject(this);
            }
        }
    }
}
