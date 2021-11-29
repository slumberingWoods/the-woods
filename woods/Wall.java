import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Wall extends Actor
{
    int width, height;
    public Wall(int width, int height) {
        getImage().scale(width, height);
    }
    public void act() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        if(isTouching(Player.class))
            player.checkColision();
    }
}
