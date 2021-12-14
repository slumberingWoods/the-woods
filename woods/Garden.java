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
    static int originalY = 100;
    
    Scroller scroller;
    Player scrollActor;
    public Garden()
    {    
        super(WIDE, HIGH, 1, false);  
        setPaintOrder(MenuObject.class, TextChoice.class, TextContinue.class, TextBox.class, Darkness.class, 
            Player.class, Objects.class, WallTile.class, Wall.class, DecorObject.class);
        addObjects();
        addWalls();
        addNPC();
        addPlayer();
        Player.keys = 0;
    }
    public void act() {
        scroll();
        addMonster();
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
        GreenfootImage bg = new GreenfootImage("woodsTile.png");
        scroller = new Scroller(this, bg, 2000, 1400);
        scrollActor = new Player(350,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addObjects() {
        addObject(new Darkness(), originalX, originalY);
        addObject(new TextObject("woodsGate", 15, 
            "There is no reason for me to return to the other side."), 1000, 50);
        addObject(new ExitObject("well", 45, 
            "A overgrown well, the opening is closed by 3 locks.", 3), 1000, 800);
        addObject(new LightObject("lantern", 
            "An unlit lantern. There is an inscription.\"When two are lit, he is summoned\"",
            15, false), 400, 75);
        addObject(new LightObject("lantern", 
            "An unlit lantern. There is an inscription.\"When two are lit, he is summoned\"",
            15, false), 400, 1000);
        addObject(new DogHouseObject("dogHouse", 15,
            "A dog house. There's a key inside, I should get out before the dog returns."
            ), 1800, 875);
        for (int i = 0; i < 32; i++) 
            addObject(new DecorObject("path"), 1000, 0+25*i);
        for (int i = 0; i < 19; i ++) 
            addObject(new DecorObject("footprints2"), 400, 125+50*i);
    }
    private void addNPC() {
        addObject(new NPCGIRObject("garden"), 1100 , 800);
        addObject(new NPCOMObject("garden"), 200 , 75);
        addObject(new DogObject(), 1800, 950);
    }
    private void addWalls() {
        for (int i = 0; i < 25; i++) {
            addObject(new WallTile("wallhorizontal", 25),1050+50*i,50);
            addObject(new WallTile("wallhorizontal", 25),950-50*i,50);
        }
        for (int i = 0; i < 25; i++) {
            addObject(new WallTile("wallhorizontal", 25),0+50*i,1350);
        }
        for (int i = 0; i < 27; i++) {
            addObject(new WallTile("tree", 25),50,0+50*i);
        }
        for (int i = 0; i < 27; i++) {
            addObject(new WallTile("tree", 25),1950,0+50*i);
        }
    }
    /**
     * Check reference from LightObject in world Garden
     * if light is 2 then spawn an eye ball in 500,350 a reference to the player's camera position'
     */
    public void addMonster() {
        if (LightObject.lanternLit == 2) {
            addObject(new NPCEYEObject("Garden"),500 , 350);
            LightObject.lanternLit = 0;
        }
    }
}   
