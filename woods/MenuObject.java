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
                    getWorld().addObject(new MenuObject("background"), 
                        getWorld().getWidth()/2, getWorld().getHeight()/2);
                    getWorld().addObject(new MenuObject("instructions"), 
                        getWorld().getWidth()/2, getWorld().getHeight()/2);
                    getWorld().addObject(new MenuObject("exit"), 60,60);
                }
                break;
            case "credits":
                if (Greenfoot.mouseClicked(this)) {
                    getWorld().addObject(new MenuObject("background"), 
                        getWorld().getWidth()/2, getWorld().getHeight()/2);
                    getWorld().addObject(new MenuObject("exit"), 60,60);
                }
                break;
            case "exit":
                if (Greenfoot.mouseClicked(this)) {
                    if (Menu.class.isInstance(getWorld())) {
                        Greenfoot.setWorld(new Menu());
                    } else {
                        getWorld().addObject(new MenuObject("background"), 
                            getWorld().getWidth()/2, getWorld().getHeight()/2);
                        getWorld().addObject(new MenuObject("returntogame"), 
                            getWorld().getWidth()/2, 150);
                        getWorld().addObject(new MenuObject("howtoplay"), 
                            getWorld().getWidth()/2, 350);
                        getWorld().addObject(new MenuObject("mainmenu"), 
                            getWorld().getWidth()/2, 550);
                    }
                }
                break;
            case "returntogame":
                if (Greenfoot.mouseClicked(this)) {
                    Player player = (Player)getWorld().getObjects(Player.class).get(0);
                    getWorld().removeObjects(getWorld().getObjects(MenuObject.class));
                    player.menuOn = false;
                }
                break;
            case "mainmenu":
                if (Greenfoot.mouseClicked(this)) {
                    Player player = (Player)getWorld().getObjects(Player.class).get(0);
                    Greenfoot.setWorld(new Menu());
                    player.menuOn = false;
                }
                break;
        }
    }
}
