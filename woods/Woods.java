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
    
    static int originalX = 125;
    static int originalY = 150;
    
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
        setPaintOrder(Darkness.class, Player.class, Objects.class, WallTile.class, Wall.class);
    }
    public void act() {
        scroll();
        showText("Time: "+Player.time, getWidth()/2,getHeight()/2);
        showText("Light: "+Player.light,getWidth()/2,getHeight()/2+25);
        showText("Sanity: "+Player.sanity,getWidth()/2,getHeight()/2+50);
        if (Player.sanity == 0) {
            Greenfoot.stop();
            showText(null, getWidth()/2,getHeight()/2);
            showText(null,getWidth()/2,getHeight()/2+25);
            showText(null,getWidth()/2,getHeight()/2+50);
            showText("You lost", getWidth()/2,getHeight()/2);
        }
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
        scroller = new Scroller(this, bg, 2000, 1400);
        scrollActor = new Player(100,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }    
}
