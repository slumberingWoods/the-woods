import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Woods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Woods extends World
{
    static final int WIDE = 1000;
    static final int HIGH = 700;
    
    static int originalX = 1250;
    static int originalY = 875;
    
    Scroller scroller;
    Player scrollActor;
    
    /**
     * Constructor for objects of class House.
     * 
     */
    public Woods()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1, false);  
        addPlayer();
        addNPC();
        setPaintOrder(MenuObject.class ,Darkness.class, Player.class, Objects.class, WallTile.class, Wall.class);
    }
    public void act() {
        scroll();
    }
    public void scroll()
    {
        if(scrollActor != null)
        {
            int dsX = scrollActor.getX() - WIDE / 2;
            int dsY = scrollActor.getY() - HIGH / 2;
            scroller.scroll(dsX, dsY);
        }
    }
    private void addPlayer() { 
        GreenfootImage bg = new GreenfootImage("void.png");
        scroller = new Scroller(this, bg, 2500, 1750);
        scrollActor = new Player(200,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addNPC() {
        addObject(new NPCGIRObject("woods"), 500, 200);
    }
}
