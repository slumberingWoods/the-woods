import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    static final int WIDE = 1000;
    static final int HIGH = 700;
    GreenfootImage bg = new GreenfootImage("void.png");
    private GreenfootSound menu = new GreenfootSound("main_menu.wav");
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(WIDE, HIGH, 1);
        setBackground(bg);
        addObjects();
        menu.setVolume(40);
        menu.playLoop();
    }
    public void addObjects() {
        addObject(new MenuObject("title"), getWidth()/2, 125);
        addObject(new MenuObject("newgame"), getWidth()/2 + 200, 300);
        addObject(new MenuObject("howtoplay"), getWidth()/2 + 200, 450);
        addObject(new MenuObject("menusubs"), getWidth()/2 - 200, 450);
        addObject(new MenuObject("credits"), getWidth()/2 + 200, 600);
    }
}
