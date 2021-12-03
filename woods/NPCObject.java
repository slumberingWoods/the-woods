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
    public NPCObject(String name, int center) {
        setImage("npcs/" + name + ".png");
        this.name = name;
        this.text = text;
        this.center = center;
    }
    public void act() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        switch (name) {
            case "girlinroses":
            if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false) {
                getWorld().addObject(new TextBox(name), getWorld().getWidth()/2, getWorld().getHeight()*3/4);
                player.textOn = true;
                activateText = true;
            }    
            break;
        }
        checkPlayer();
    }
}
