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
    
    static int originalX = 600;
    static int originalY = 700;
    
    Scroller scroller;
    Player scrollActor;
    
    /**
     * Constructor for objects of class House.
     * 
     */
    public Woods()
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
        scroller = new Scroller(this, bg, 1800, 1200);
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
        addObject(new ExitObject("woodsGate", 15, 
            "Locked gate, I could see a garden beyond the fencing", 2), 600, 1150);
        addObject(new InteractObject("stump", 15, 
            "A hollow stump. There's a key inside."), 800, 200);
    }
    private void addNPC() {
        addObject(new NPCGIRObject("woods"), 600 , 600);
        for (int i = 0; i < 25; i++) {
            addObject(new WallTile("wallhorizontal", 25),650+50*i,1150);
            addObject(new WallTile("wallhorizontal", 25),550-50*i,1150);
        }
    }
}
