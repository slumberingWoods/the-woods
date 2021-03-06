import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends World
{
    static final int WIDE = 1000;
    static final int HIGH = 700;
    
    static int originalX = 125;
    static int originalY = 150;
    
    Scroller scroller;
    Player scrollActor;
    public static GreenfootSound houseMusic = new GreenfootSound("house.wav");
    /**
     * Constructor for objects of class House.
     * 
     */
    public House()
    {    
        super(WIDE, HIGH, 1, false);  
        setPaintOrder(MenuObject.class, Darkness.class, Player.class, Objects.class, WallTile.class, Wall.class);
        addObjects();
        addWalls();
        addPlayer();
        Player player = (Player)getObjects(Player.class).get(0);
        player.keys = 0;
    }
    public void act() {
        houseMusic.setVolume(20);
        houseMusic.playLoop();
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
        GreenfootImage bg = new GreenfootImage("floor.png");
        scroller = new Scroller(this, bg, 1000, 700);
        scrollActor = new Player(350,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addObjects() {       
        addObject(new Darkness(), originalX, originalY);
        addObject(new LightObject("table", 
            "The light of the candles will keep me safe for now. If I stay near them, I don't have to use my lighter",
            15, true),200,125);        
        addObject(new BasicObject("bed", 40),75, 150); 
        addObject(new TextObject("closet", 15, 
            "A regular closet, all of my clothes are in here, unfolded."),300,100);
        addObject(new TextObject("fridge", 30, 
            "NOTE TO SELF: find a plant to hide the key in the living room."),800,440);
        addObject(new ExitObject("houseDoor", 15, 
            "Locked door to the basement. I need a key to open this.", 1), 625, 90);
        addObject( new InteractObject("pot", 15, 
            "I intended to put a plant here to hide the key but I never bought it."), 75, 450);
        addObject(new TextObject("carpet", 15, 
            "There's not need for me to go outside. Ever."),625,670);
        addObject(new TextObject("mirror", 15, "It's me..."), 780, 85);
        addObject(new BasicObject("sink", 15), 780, 125);
        addObject(new BasicObject("bathtub", 30), 925, 150);
        addObject(new TextObject("toilet", 10, 
            "I don't feel like it at the moment."), 925, 250);
        addObject(new TextObject("fireplace", 15, 
            "There's fire but no heat."), 375, 450);
        addObject(new TextObject("oven", 15, 
            "A don't need to cook food at the moment"), 860, 460);
        addObject(new TextObject("kitchenSink", 15, 
            "No water..."), 930, 550);
        addObject(new DecorObject("couch"), 75, 550);
    }
    private void addWalls() {
        for (int i = 0; i < 9; i++) {
            addObject(new WallTile("wall", 25),75+50*i,90); 
        }
        for (int i = 0; i < 3; i++) {
            addObject(new WallTile("wall", 25),(75+(50*10))+50*i,90); 
        }
        for (int i = 0; i < 4; i++) {
            addObject(new WallTile("wall", 25),(75+(50*14))+50*i,90); 
        }
        for (int i = 0; i < 4; i++) {
            addObject(new WallTile("wall", 25),(75+(50*14))+50*i,415); 
        }
        for (int i = 0; i < 9; i++) {
            addObject(new WallTile("wall", 25),75+50*i,415); 
        }
        addObject(new WallTile("wall", 25), 525 ,225);
        addObject(new WallTile("wall", 25), 725 ,225);
        addObject(new WallTile("wall", 25), 525 ,575);
        addObject(new WallTile("wall", 25), 725 ,575);
        addObject(new Wall(50,700),25,350); 
        addObject(new Wall(50,700),975,350); 
        addObject(new Wall(50,145),525,110);
        addObject(new Wall(50,145),725,110);
        addObject(new Wall(50,250),525,425);
        addObject(new Wall(50,250),725,425);
        addObject(new Wall(1000,50),500,675); 
        addObject(new Wall(1000,50),500,25); 
        addObject(new Wall(450,50),275,350); 
        addObject(new Wall(250,50),850,350);
    }
}
