import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    int PlayerX, PlayerY, PKeys;
    int center;
    boolean isColision;
    static boolean canScroll;
    /**
     * Check if the player's y is less than the object's y plus the spacing. 
     * This allows for the player to pass through the object making it look more natural.
     */
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        PKeys = player.keys;
        isColision = isTouching(Player.class) && player.getY() < getY() + center;
        if(isColision) 
            player.checkColision();
    }
    /**
     * Check if the player is in range of the object and is facing the correct direction
     * isInRange boolean check if the distance between the x and y of the player and object
     * is less than the image width and height of the object divided by 2 plus spacing of 5.
     */
    public boolean isInRange() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        boolean isInRange = (Math.abs(player.getY() - getY()) < (getImage().getHeight() / 2 + player.getImage().getHeight()/ 2 + 5) && 
            Math.abs(player.getX() - getX()) < (getImage().getWidth() / 2 + player.getImage().getWidth() / 2 + 5));
        if(isInRange && PlayerY > getY())
             return(player.getImage() == player.sprites[3]);
        else if (getY() > PlayerY && (Math.abs(player.getY() - getY()) < 100 &&
        Math.abs(PlayerX - getX()) < getImage().getWidth() / 2 + player.getImage().getWidth() / 2))
             return(player.getImage() == player.sprites[0]);
        else if(isInRange && PlayerX < getX())
             return(player.getImage() == player.sprites[9]);
        else if(isInRange && PlayerX > getX())
             return(player.getImage() == player.sprites[6]);
        return false;
    }
} 
