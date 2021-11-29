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
    static int direction;
    static int time;
    static int speed = 2;
    int keys = 0;
    
    int phase = 0;
    static int light;
    static int sanity;
    
    boolean isMoving;
    boolean isLight;
    
    static int originalX, originalY;
    static int worldX, worldY;
    static int previousWorldX, previousWorldY;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(int sanity, int light){
        this.sanity = sanity;
        this.light = light;
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
        if (light == 0 && !isLight) {
            if (Greenfoot.getRandomNumber(10) < 1)
            sanity--;
        }
    }
    public void checkMovement()
    {
        originalX = getX();
        originalY = getY();
        previousWorldX = worldX;
        previousWorldY = worldY;
        if(speed > 0)
        {    
            if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")) {
                time++;
                if(time == 10 && !isLight && light != 0) {
                light--;
                }
            }
            if (Greenfoot.isKeyDown("down")) {
                direction = 0;
                setLocation(getX(),getY()+speed);
                worldY += speed;
                if(getImage() == sprites[0] && time == 10 && phase == 0) {
                    setImage(sprites[1]);
                    phase = 1; 
                } else if (getImage() == sprites[0] && time == 10 && phase == 1) {
                    setImage(sprites[2]);
                    phase = 0; 
                } else if(time == 10)
                    setImage(sprites[0]);
            } else if (Greenfoot.isKeyDown("up")) {
                direction = 3;    
                setLocation(getX(),getY()-speed);
                worldY -= speed;
                if(getImage() == sprites[3] && time == 10 && phase == 0) {
                    setImage(sprites[4]);
                    phase = 1; 
                } else if (getImage() == sprites[3] && time == 10 && phase == 1) {
                    setImage(sprites[5]);
                    phase = 0; 
                } else if(time == 10)
                    setImage(sprites[3]);
            } else if (Greenfoot.isKeyDown("right")) {
                direction = 6;    
                setLocation(getX()+speed,getY());
                worldX += speed;
                if(getImage() == sprites[6] && time == 10 && phase == 0) {
                    setImage(sprites[7]);
                    phase = 1; 
                } else if (getImage() == sprites[6] && time == 10 && phase == 1) {
                    setImage(sprites[8]);
                    phase = 0; 
                } else if(time == 10)
                    setImage(sprites[6]);
            } else if (Greenfoot.isKeyDown("left")) {
                direction = 9;    
                setLocation(getX()-speed,getY());
                worldX -= speed;
                if(getImage() == sprites[9] && time == 10 && phase == 0) {
                    setImage(sprites[10]);
                    phase = 1; 
                } else if (getImage() == sprites[9] && time == 10 && phase == 1) {
                    setImage(sprites[11]);
                    phase = 0; 
                } else if(time == 10)
                    setImage(sprites[9]);
            }
            if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down"))
            {
                isMoving = true;
                if(time == 10)
                    time = 0;
            }
            else
            {
                isMoving = false;
                setImage(sprites[direction]);
                time = 0;
            }
        } else 
            isMoving = false;
    }
    public static boolean interactInput()
    {
        return Greenfoot.isKeyDown("enter");
    }
    public void checkColision() {
        setLocation(originalX, originalY);
        worldX = previousWorldX;
        worldY = previousWorldY;
    }
}
