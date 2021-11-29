import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MenuObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuObject extends Objects
{
    String name;
    public MenuObject(String name)
    {
        this.name = name;
        setImage("Menu/" + name + ".png");
    }
    public void act() {
        switch (name) {
            case "title": 
                break;
            case "newgame": 
                if (Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new House());
                }
                break;
            case "howtoplay": 
                if (Greenfoot.mouseClicked(this)) {
                    getWorld().addObject(new MenuObject("background"), getWorld().getWidth()/2, getWorld().getHeight()/2);
                    getWorld().addObject(new MenuObject("instructions"), getWorld().getWidth()/2, getWorld().getHeight()/2);
                    getWorld().addObject(new MenuObject("exit"), 60,60);
                }
                break;
            case "exit":
                if (Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Menu());
                }
                break;
        }
    }
}
