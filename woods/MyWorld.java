import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static final int WIDE = 1000;
    static final int HIGH = 700;
    
    static int originalX = 125;
    static int originalY = 150;
    
    Scroller scroller;
    Player scrollActor;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1, false);  
        addObjects();
        addWalls();
        addPlayer();
        setPaintOrder(Player.class, Objects.class, Wall.class, WallTile.class);
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
        GreenfootImage bg = new GreenfootImage("house/floor.png");
        scroller = new Scroller(this, bg, 1000, 700);
        scrollActor = new Player(100,100);
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }    
    private void addObjects() {       
        addObject(new BasicObject("bed", 40),75, 150);        
        addObject(new BasicObject("table", 15),200,125); 
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
