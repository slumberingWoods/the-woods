import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPCEYEObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCEYEObject extends Objects
{
    int flag = 0;
    String world;
    int delay = 40;
    boolean occupied;
    boolean activated;
    boolean continueSymbol;
    boolean endText;
    boolean choiceText;
    public NPCEYEObject(String world) {
        this.world = world;  
        delay = 40;
        setImage("npcs/girlinroses.png");
    }
    public void act()
    {
        // Add your action code here.
    }
}
