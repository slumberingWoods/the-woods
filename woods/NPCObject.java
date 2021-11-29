import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObjectNPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCObject extends Objects
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
    public NPCObject(String name, int center, String text) {
        setImage("npcs/" + name + ".png");
        this.name = name;
        this.text = text;
        this.center = center;
    }
    public void act() {
        String secondText = text;
        switch (name) {
            case "girlinroses":
            secondText = "Test";
            if (Greenfoot.isKeyDown("z")  && isInRange() && activateText == false && interacted == false) {
                getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*3/4);
                activateText = true;
                interacted = true;
            }  else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && interacted == true) {
                getWorld().showText(secondText,getWorld().getWidth()/2, getWorld().getHeight()*3/4);
                activateText = true;
            }
            break;
        }
        checkPlayer();
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*3/4);;
                activateText = false;
                textTime = 60;
            }
        }
    }
}
