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
        prepare();
        setBackground("house/floor.jpeg");
    }
    public void act() {
        showText(""+Player.time, getWidth()/2,getHeight()/2);
    }
    private void prepare() {
        addObject (new Player(), 230, 200);        
        addObject(new BasicObject("bed"),130,200);        
        addObject(new BasicObject("table"),400,200); 
        for (int i = 0; i < 18; i++) {
            addObject(new BasicObject("wall"),75+50*i,40); 
        }
        addObject(new Wall(50,700),25,350); 
        addObject(new Wall(50,700),975,350); 
        addObject(new Wall(1000,50),500,675); 
    }
}
