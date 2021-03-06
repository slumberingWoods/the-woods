import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextObject extends Objects
{
    String text;
    int textTime = 100;
    boolean activateText = false;
    /**
     * Act - do whatever the TextObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TextObject(String name, int center, String text) {
        setImage("objects/" + name + ".png");
        this.text = text;
        this.center = center;
    }
    public void act() {
        checkPlayer();
        if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false) {
            getWorld().showText(text, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        }    
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                activateText = false;
                textTime = 100;
            }
        }
    }
}
