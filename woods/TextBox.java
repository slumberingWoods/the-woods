import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    GreenfootImage[] sprites = new GreenfootImage[2];
    int delay = 60;
    int direction;
    int nameX = 255;
    int name2X = 740;
    boolean activated;
    TextContinue orb = new TextContinue();
    public TextBox(int direction) {
        this.direction = direction;
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
    }
} 
