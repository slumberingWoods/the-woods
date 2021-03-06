import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InteractObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InteractObject extends Objects
{
    String text;
    String name;
    int textTime = 60;
    boolean activateText = false;
    boolean interacted = false;
    /**
     * Act - do whatever the TextObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InteractObject(String name, int center, String text) {
        setImage("objects/" + name + ".png");
        this.text = text;
        this.center = center;
        this.name = name;
    }
    /**
     * If the player is in ranged and the haven't activated the text and press z
     * show the text
     * Interacted checks if the object has been interacted with so that the text can be change when interacted again
     * Once the object has been interacted with, change the next text to be generated
     */
    public void act() {
        checkPlayer();
        if (Greenfoot.isKeyDown("z")  && isInRange() && activateText == false && interacted == false) {
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
            switch (name) {
                case "pot":
                case "stump":
                    Player.keys += 1;
                    interacted = true;
                    setImage("objects/" + name + "2" + ".png");
                break;
                case "gas":
                    Player.light += 40;
                    getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                    getWorld().removeObject(this);
                    break;
            }
        }  else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && interacted == true) {
            text = "There is nothing more to search here";
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        }
        // if activateText is on, count down the delay and remove the text when the delay is done
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                activateText = false;
                textTime = 60;
            }
        }
    }
}
