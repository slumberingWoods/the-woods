import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    int PlayerX, PlayerY;
    int center;
    /**
     * Act - do whatever the Objects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        if(isTouching(Player.class) && PlayerY < getY() + center)
            player.checkColision();
    }
}
