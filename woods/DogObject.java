import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DogObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DogObject extends Objects
{
    GreenfootImage[] sprites = new GreenfootImage[6];
    static int direction;
    static int time = 20;
    int phase = 0;
    int speed;
    public DogObject() {
        direction = 0;
        sprites[0] = new GreenfootImage("npcs/dogDownLeft.png");
        sprites[1] = new GreenfootImage("npcs/dogDownRight.png");
        sprites[2] = new GreenfootImage("npcs/dogLeft.png");
        sprites[3] = new GreenfootImage("npcs/dogRight.png");
        sprites[4] = new GreenfootImage("npcs/dogUpLeft.png");
        sprites[5] = new GreenfootImage("npcs/dogUpRight.png");
        setImage(sprites[direction]);
    }
    public void act()
    {
        if (time != 0) 
            time--;
        // Speed is between 8 and 12
        speed = Greenfoot.getRandomNumber(4) + 8;
        checkMovement();
        checkPlayer();
    }
    /**
     * When time is 0, the dog has a movement opportunity. 
     * Up, down, left, right or do nothing
     * When moving the dog changes direction.
     */
    public void checkMovement() {
        if (time == 0) {
            int rand = Greenfoot.getRandomNumber(4);
            switch (rand) {
                case 0:
                    break;
                case 1:
                    setLocation(getX()+speed,getY());
                    time = 40;
                    direction = 2;
                    setImage(sprites[2]);
                    break;
                case 2:
                    setLocation(getX()-speed,getY());
                    time = 40;
                    direction = 3;
                    setImage(sprites[3]);
                    break;
                case 3:
                    setLocation(getX(),getY()+speed);
                    time = 40;
                    direction = 0;
                    if (phase == 1) {
                        setImage(sprites[0]);
                        phase = 0;
                    } else {
                        setImage(sprites[1]);
                        phase = 1;
                    }
                    break;
                case 4:
                    setLocation(getX(),getY()-speed);
                    time = 40;
                    direction = 4;
                    if (phase == 1) {
                        setImage(sprites[4]);
                        phase = 0;
                    } else {
                        setImage(sprites[5]);
                        phase = 1;
                    }
                    break;
            }
        }
    }
    /**
     * Override the checkPlayer in Objects.class
     * If touching player, send them to -5,-5 relative to the camera and minus sanity
     */
    @Override
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        isColision = isTouching(Player.class);
        if(isColision) {
            player.setLocation(-5, -5);
            player.sanity -= 10;
        }
    }    
}
