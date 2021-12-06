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
        setPaintOrder(MenuObject.class, TextChoice.class, TextContinue.class, TextBox.class, Darkness.class, 
            Player.class, Objects.class, WallTile.class, Wall.class);
        addNPC();
        addObjects();
        addPlayer();
        Player.keys = 0;
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
        scrollActor = new Player(300,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addObjects() {
        addObject(new LightObject("lantern", 
            "An unlit lantern, I think I can light it up.",
            15, false), 750,600); 
        addObject(new LightObject("lantern", 
            "An unlit lantern, I think I can light it up.",
            15, false), 250,200);
        addObject(new Darkness(), originalX, originalY);
        addObject(new ExitObject("woodsGate", 15, 
            "Locked gate, I could see a garden beyond the fencing", 2), 600, 1150);
        addObject(new InteractObject("stump", 15, 
            "A hollow stump. There's a key inside."), 1000, 200);
        addObject(new InteractObject("gas", 15,
            "A gas canister, can be used to refuel my light. +40 light."), 650, 1100);
        for (int i = 0; i < 25; i++) {
            addObject(new WallTile("wallhorizontal", 25),650+50*i,1150);
            addObject(new WallTile("wallhorizontal", 25),550-50*i,1150);
        }
        for (int i = 0; i < 10; i++)
            addObject(new DecorObject("footprints"),100+50*i,1125);
    }
    private void addNPC() {
        addObject(new NPCGIRObject("woods"), 600 , 600);
        addObject(new NPCOMObject("woods"), 50 , 1075);
    }
}
