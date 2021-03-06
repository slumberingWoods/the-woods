import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dogHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DogHouseObject extends Objects
{
    /**
     * Act - do whatever the dogHouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String text;
    String name;
    int textTime = 60;
    boolean activateText = false;
    boolean interacted = false;
    public DogHouseObject(String name, int center, String text) {
        setImage("objects/" + name + ".png");
        this.text = text;
        this.center = center;
        this.name = name;
    }
    public void act()
    {
        checkPlayer();
        if (Greenfoot.isKeyDown("z")  && isInRange() && activateText == false && interacted == false) {
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
                    Player.keys += 1;
                    interacted = true;
                    setImage("objects/" + name + "1" + ".png");
        }  else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && interacted == true) {
            text = "There is nothing more to search here";
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        }
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null, getWorld().getWidth()/2, getWorld().getHeight()*4/5);;
                activateText = false;
                textTime = 60;
            }
        }
    }
}
