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
    static int keys = 0;
    static int rose = 0;
    static int totalScore = 0;
    
    int phase = 0;
    static int light;
    static int sanity;
    
    boolean isLight;
    boolean menuOn = false;
    boolean textOn = false;
    boolean gameEnd;
    
    static int originalX, originalY;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(int light, int sanity){
        this.sanity = sanity;
        this.light = light;
        direction = 0;
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
        openMenu();
        displayResources();
        if (light == 0 && !isLight) {
            if (Greenfoot.getRandomNumber(10) < 1)
            sanity--;
        }
    }
    /* Check for current location and store x and y in originalX and OriginalY
    *   if speed is larger than 0 and menu and text is not on, the player can move
    *   When key is pressed, time is increased, when time is 10, change sprite and phase
    *   The walk cycle moves through idle[direction] > rightstep > idle[direction] > leftstep
    *   This is done by using int phase which represents the foot.
    */
    public void checkMovement()
    {
        originalX = getX();
        originalY = getY();
        if(speed > 0 && !menuOn && !textOn)
        {    
            if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")) {
                time++;
                if(time == 10 && !isLight && light != 0) 
                    light--;
            }
            if (Greenfoot.isKeyDown("down")) {
                direction = 0;
                setLocation(getX(),getY()+speed);
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
                if(time == 10)
                    time = 0;
            }
            else
            {
                setImage(sprites[direction]);
                time = 0;
            }
        } 
    }
    // Open menu and generate menu objects
    public void openMenu() {
        if (Greenfoot.isKeyDown("escape") && menuOn == false) {
            menuOn = true;
            getWorld().addObject(new MenuObject("background"), 
                        getWorld().getWidth()/2, getWorld().getHeight()/2);
            getWorld().addObject(new MenuObject("returntogame"), 
                        getWorld().getWidth()/2, 150);
            getWorld().addObject(new MenuObject("howtoplay"), 
                        getWorld().getWidth()/2, 350);
            getWorld().addObject(new MenuObject("mainmenu"), 
                        getWorld().getWidth()/2, 550);
        }
    }
    // Use by other objects to set the player back to the original location
    public void checkColision() {
        setLocation(originalX, originalY);
    }
    // Display resources at the top right of the screen.
    public void displayResources() {
        if (menuOn == false) {
            getWorld().showText("Light: "+Player.light,
                getWorld().getWidth()*11/12, getWorld().getHeight()/15+25);
            getWorld().showText("Sanity: "+Player.sanity,
                getWorld().getWidth()*11/12, getWorld().getHeight()/15+50);
            if (keys > 0) {
                getWorld().showText("Keys: "+Player.keys,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+75);
            } else 
                getWorld().showText(null,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+75);
            if (rose > 0) {
                getWorld().showText("Roses: "+Player.rose,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+100);
            }  else 
                getWorld().showText(null,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+100);
        } else {
            getWorld().showText(null, 
                getWorld().getWidth()*11/12,getWorld().getHeight()/15+25);
            getWorld().showText(null, 
                getWorld().getWidth()*11/12,getWorld().getHeight()/15+50);
            getWorld().showText(null,
                getWorld().getWidth()*11/12, getWorld().getHeight()/15+75);
            getWorld().showText(null,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+100);
        }
        if (Player.sanity == 0) {
                menuOn = true;
                getWorld().showText(null, 
                    getWorld().getWidth()*11/12,getWorld().getHeight()/5+25);
                getWorld().showText(null, 
                    getWorld().getWidth()*11/12,getWorld().getHeight()/15+50);
                getWorld().showText(null,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+75);
                getWorld().showText(null,
                    getWorld().getWidth()*11/12, getWorld().getHeight()/15+100);
                getWorld().addObject(new MenuObject("background"), 
                    getWorld().getWidth()/2, getWorld().getHeight()/2);
                getWorld().addObject(new MenuObject("mainmenu"), 
                    getWorld().getWidth()/2, 550);
                getWorld().addObject(new MenuObject("newgame"), 
                    getWorld().getWidth()/2, 350);
                getWorld().showText("You lost mind to the darkness of the woods.", 
                    getWorld().getWidth()/2,125);
                getWorld().showText("Total score: "+ totalScore, 
                    getWorld().getWidth()/2,150);
            }   
    }
}
