import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitObject extends Objects
{
    String text;
    String name;
    int keys;
    int textTime = 100;
    int transitionDelay = 100;
    boolean activateText = false;
    boolean doorUnlock = false;
    /**
     * Act - do whatever the TextObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ExitObject(String name, int center, String text, int keys) {
        setImage("exit/" + name + ".png");
        this.text = text;
        this.center = center;
        this.keys = keys;
        this.name = name;
    }
    public void act() {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        checkPlayer();
        String displayName = "";
        switch (name) {
            case "houseDoor":
                displayName = "Electrical room door";
                break;
            case "woodsGate":
                displayName = "Garden gate";
                break;
            case "well":
                displayName = "Well";
                break;
        }
        if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && PKeys != keys) {
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
        } else if (Greenfoot.isKeyDown("z") && isInRange() && activateText == false && PKeys == keys) {
            text = displayName+" is unlocked";
            getWorld().showText(text,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
            activateText = true;
            doorUnlock = true;
        }
        if (activateText) {
            textTime--;
            if (textTime == 0) {
                getWorld().showText(null,getWorld().getWidth()/2, getWorld().getHeight()*4/5);
                activateText = false;
                textTime = 100;
            }
        }
        if (doorUnlock) {
            transitionDelay--;
            if (transitionDelay == 0) {
                switch (name) {
                    case "houseDoor" :
                        player.totalScore += player.light + player.sanity*2;
                        House.houseMusic.stop();
                        Greenfoot.setWorld(new Woods());
                        break;
                    case "woodsGate" :
                        player.totalScore += player.light + player.sanity*2;
                        Greenfoot.setWorld(new Garden());
                        break;
                    case "well":
                        player.totalScore += player.light + player.sanity*2;
                        player.menuOn = true;
                        getWorld().showText(null, 
                            getWorld().getWidth()*11/12,getWorld().getHeight()/5+25);
                        getWorld().showText(null, 
                            getWorld().getWidth()*11/12,getWorld().getHeight()/15+50);
                        getWorld().showText(null,
                            getWorld().getWidth()*11/12, getWorld().getHeight()/15+75);
                        getWorld().showText(null,
                            getWorld().getWidth()*11/12, getWorld().getHeight()/15+100);
                        getWorld().addObject(new MenuObject("background"), 
                            getWorld().getWidth()/2, getWorld().getHeight()/2);
                        getWorld().addObject(new MenuObject("mainmenu"), 
                            getWorld().getWidth()/2, 550);
                        getWorld().addObject(new MenuObject("newgame"), 
                            getWorld().getWidth()/2, 350);
                        getWorld().showText("You have escaped the woods. We welcome your return.", 
                            getWorld().getWidth()/2,125);
                        getWorld().showText("Total score: "+ player.totalScore, 
                            getWorld().getWidth()/2,150);
                }
            }
        }
    }
}
