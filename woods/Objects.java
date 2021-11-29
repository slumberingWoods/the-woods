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
    /**
     * Act - do whatever the Objects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        PKeys = player.keys;
        if(isTouching(Player.class) && PlayerY < getY() + center)
            player.checkColision();
    }
        public boolean isInRange() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        boolean isInRange = (Math.abs(player.getY() - getY()) < (getImage().getHeight() / 2 + player.getImage().getHeight() / 2 + 5) && 
            Math.abs(player.getX() - getX()) < (getImage().getWidth() / 2 + player.getImage().getWidth() / 2 + 5));
        if(isInRange && PlayerY > getY())
             return(player.getImage() == player.sprites[3]);
        else if(getY() > (getImage().getHeight() / 2) + PlayerY + player.getImage().getHeight() / 2 - 2 && 
        Math.abs(PlayerX - getX()) < getImage().getWidth() / 2 + player.getImage().getWidth() / 2)
             return(player.getImage() == player.sprites[0]);
        else if(isInRange && PlayerX < getX())
             return(player.getImage() == player.sprites[9]);
        else if(isInRange && PlayerX > getX())
             return(player.getImage() == player.sprites[6]);
        return false;
    }
} 
