import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    String name;
    GreenfootImage[] sprites = new GreenfootImage[2];
    int delay = 60;
    int direction;
    boolean activated;
    TextContinue orb = new TextContinue();
    public TextBox(String name) {
        direction = 1;
        this.name = name;
        sprites[0] = new GreenfootImage("textbox.png");
        sprites[1] = new GreenfootImage("textbox2.png");
        setImage(sprites[direction]);
    }
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(sprites[direction]);
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        displayDialogue();
    }
    public void displayDialogue() {
        
    }
}
