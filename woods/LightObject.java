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
    boolean lightOn;
    static int lanternLit = 0;
    public LightObject(String name, String text, int center, boolean lightOn) {
        setImage("objects/" + name + ".png");
        this.text = text;
        this.name = name;
        this.center = center;
        this.lightOn = lightOn;
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
        if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && lightOn == true) {
            getWorld().showText(text, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        } else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && lightOn == false) {
            getWorld().showText(text, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            if (name == "lantern") {
                text = "I feel much safer with this lantern lit up.";
                if (Garden.class.isInstance(getWorld())) {
                    lanternLit++;
                } 
            }
            activateText = true;
            lightOn = true;
            setImage("objects/" + name + "1.png");
        }
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                activateText = false;
                textTime = 100;
            }
        }
        if (lightOn) {
            if (radius) {
                player.isLight = true;
            } else if (!radius) {
                player.isLight = false;
            }
        }
    }
}
