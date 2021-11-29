import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitObject extends Objects
{
    String text;
    int keys;
    int textTime = 60;
    int transitionDelay = 120;
    boolean activateText = false;
    boolean doorUnlock = false;
    /**
     * Act - do whatever the TextObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ExitObject(String name, int center, String text, int keys) {
        setImage("exit/" + name + ".png");
        this.text = text;
        this.center = center;
        this.keys = keys;
    }
    public void act() {
        
        checkPlayer();
        if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && PKeys != keys) {
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*3/4);
            activateText = true;
        } else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && PKeys == keys) {
            text = "Door is unlocked";
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*3/4);
            activateText = true;
            doorUnlock = true;
        }
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null,getWorld().getWidth()/2, getWorld().getHeight()*3/4);
                activateText = false;
                textTime = 60;
            }
        }
        if (doorUnlock) {
            transitionDelay--;
            if (transitionDelay == 0) {
                Greenfoot.setWorld(new Woods());
            }
        }
    }
}