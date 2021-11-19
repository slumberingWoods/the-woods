import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GreenfootImage[] sprites = new GreenfootImage[12];
    int direction;
    int time = 5;
    static int speed = 2;
    boolean isMoving;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(){
        sprites[0] = new GreenfootImage("Player/Down0.png");
        sprites[1] = new GreenfootImage("Player/Down1.png");
        sprites[2] = new GreenfootImage("Player/Down2.png");
        sprites[3] = new GreenfootImage("Player/Up0.png");
        sprites[4] = new GreenfootImage("Player/Up1.png");
        sprites[5] = new GreenfootImage("Player/Up2.png");
        sprites[6] = new GreenfootImage("Player/Right0.png");
        sprites[7] = new GreenfootImage("Player/Right1.png");
        sprites[8] = new GreenfootImage("Player/Right2.png");
        sprites[9] = new GreenfootImage("Player/Left0.png");
        sprites[10] = new GreenfootImage("Player/Left1.png");
        sprites[11] = new GreenfootImage("Player/Left2.png");
        setImage(sprites[direction]);
    }
    public void act()
    {
        checkMovement();
        setImage(sprites[direction]);
    }
    public void checkMovement()
    {
            if (Greenfoot.isKeyDown("down")) {
                direction = 0;
                setLocation(getX(),getY()+speed);
            }
            if (Greenfoot.isKeyDown("up")) {
                direction = 3;    
                setLocation(getX(),getY()-speed);
            }
            if (Greenfoot.isKeyDown("right")) {
                direction = 6;    
                setLocation(getX()+speed,getY());
            }
            if (Greenfoot.isKeyDown("left")) {
                direction = 9;    
                setLocation(getX()-speed,getY());
            }
    }
}
