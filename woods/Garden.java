import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garden extends World
{
    static final int WIDE = 1000;
    static final int HIGH = 700;
    
    static int originalX = 1000;
    static int originalY = 200;
    
    Scroller scroller;
    Player scrollActor;
    public Garden()
    {    
        super(WIDE, HIGH, 1, false);  
        setPaintOrder(MenuObject.class ,Darkness.class, Player.class, Objects.class, WallTile.class, Wall.class);
        addNPC();
        addObjects();
        addPlayer();
        Player player = (Player)getObjects(Player.class).get(0);
        player.keys = 0;
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
        scroller = new Scroller(this, bg, 2000, 1400);
        scrollActor = new Player(200,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addObjects() {
        addObject(new TextObject("woodsGate", 15, 
            "There is no reason for me to return to the other side."), 1000, 150);
        for (int i = 0; i < 25; i++) {
            addObject(new WallTile("wallhorizontal", 25),1050+50*i,150);
            addObject(new WallTile("wallhorizontal", 25),950-50*i,150);
        }
    }
    private void addNPC() {
        addObject(new NPCGIRObject("garden"), 1000 , 800);
        addObject(new NPCOMObject("garden"), 50 , 1000);
    }
}   
