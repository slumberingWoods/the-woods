import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Wall extends Actor
{
    int width, height;
    int PlayerX, PlayerY;
    public Wall(int width, int height) {
        getImage().scale(width, height);
    }
    public void act() {
        checkPlayer();
    }
    public void checkPlayer() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        if(isTouching(Player.class))
            player.checkColision();
    }
}
