import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);  
        prepareObjects();
        addWalls();
        setBackground("house/floor.jpeg");
        setPaintOrder(Player.class, Objects.class, WallTile.class, Wall.class);
    }
    public void act() {
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
    private void prepareObjects() {
        addObject(new Player(100,100), 200, 150);        
        addObject(new BasicObject("bed", 30),75, 150);        
        addObject(new BasicObject("table", 10),200,250); 
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
            addObject(new WallTile("wall", 25),(75+(50*14))+50*i,410); 
        }
        for (int i = 0; i < 9; i++) {
            addObject(new WallTile("wall", 25),75+50*i,410); 
        }
        addObject(new WallTile("wall", 25), 525 ,200);
        addObject(new WallTile("wall", 25), 725 ,200);
        addObject(new WallTile("wall", 25), 525 ,550);
        addObject(new WallTile("wall", 25), 725 ,550);
        addObject(new Wall(50,700),25,350); 
        addObject(new Wall(50,700),975,350); 
        addObject(new Wall(50,250),525,75);
        addObject(new Wall(50,250),725,75);
        addObject(new Wall(50,250),525,425);
        addObject(new Wall(50,250),725,425);
        addObject(new Wall(1000,50),500,675); 
        addObject(new Wall(1000,50),500,25); 
        addObject(new Wall(500,50),250,350); 
        addObject(new Wall(250,50),850,350);
    }
}
