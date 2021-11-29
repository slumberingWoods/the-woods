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
        public boolean isInRange()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        boolean isInRange = (Math.abs(player.getY() - getY()) < (getImage().getHeight() / 2 + player.getImage().getHeight() / 2 + 2) && 
            Math.abs(player.getX() - getX()) < (getImage().getWidth() / 2 + player.getImage().getWidth() / 2 + 4));
        if(isInRange && PlayerY - getY() < (center + 2) && PlayerY > getY() && 
        Math.abs(PlayerX - getX()) < getImage().getWidth() / 2 + player.getImage().getWidth() / 2)
            return(player.getImage() == player.sprites[1]);
        else if(getY() > (getImage().getHeight() / 2) + PlayerY + player.getImage().getHeight() / 2 - 2 && 
        Math.abs(PlayerX - getX()) < getImage().getWidth() / 2 + player.getImage().getWidth() / 2)
            return(player.getImage() == player.sprites[0]);
        else if(isInRange && PlayerX < getX())
            return(player.getImage() == player.sprites[3]);
        else if(isInRange && PlayerX > getX())
            return(player.getImage() == player.sprites[2]);
        return false;
    }
}
