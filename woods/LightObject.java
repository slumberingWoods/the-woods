import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightObject extends Objects
{
    String text;
    String name;
    int textTime = 60;
    boolean activateText = false;
    boolean radius;
    public LightObject(String name, String text, int center) {
        setImage("objects/" + name + ".png");
        this.text = text;
        this.name = name;
        this.center = center;
    }
    public void act() {
        checkPlayer();
        checkLight();   
    }
    public void checkLight() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        PlayerX = player.getX();
        PlayerY = player.getY();
        radius = (Math.abs(getX() - player.getX()) < 100 && Math.abs(getY() - player.getY()) < 100);
        if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false) {
            getWorld().showText(text, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        }    
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                activateText = false;
                textTime = 100;
            }
        }
        if (radius) {
            player.isLight = true;
        } else if (!radius) {
            player.isLight = false;
        }
    }
}
