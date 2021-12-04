import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NCPGIRObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCGIRObject extends Objects
{
    int flag = 0;
    String world;
    int delay = 40;
    boolean activated;
    boolean continueSymbol;
    boolean endText;
    boolean choiceBox;
    public NPCGIRObject(String world) {
        this.world = world;  
        setImage("npcs/girlinroses.png");
    }
    public void act()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        checkPlayer();
        getWorld().showText("delay" +delay, 500, 100);
        switch (world) {
            case "woods":
                if (Greenfoot.isKeyDown("z") && isInRange() && flag == 0 && activated == false) {
                    player.textOn = true;
                    activated = true;
                    getWorld().addObject(new TextBox(1), 500, 500);
                    getWorld().showText("Hello there.", 500, 500);
                    getWorld().showText("???", 740, 400);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
                    delay = 40;
                    getWorld().showText("It seems that you have entered into the woods.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
                    TextBox box = (TextBox)getWorld().getObjects(TextBox.class).get(0);
                    box.direction = 0;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText("You", 250, 400);
                    getWorld().showText("Who are you?", 500, 500);
                    delay = 40;
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
                    TextBox box = (TextBox)getWorld().getObjects(TextBox.class).get(0);
                    box.direction = 1;
                    getWorld().showText(null, 250, 400);
                    getWorld().showText("???", 740, 400);
                    getWorld().showText("I am just a simple imhabitant of the woods.", 500, 500);
                    delay = 40;
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
                    delay = 40;
                    getWorld().showText("If you want to return to where you come from...", 500, 500);
                    flag++;
                }  else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
                    delay = 40;
                    getWorld().showText("You should seek to open the gate south of here.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
                    delay = 40;
                    getWorld().showText("Of course, the gate is locked and the keys have gone missing.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
                    TextBox box = (TextBox)getWorld().getObjects(TextBox.class).get(0);
                    box.direction = 0;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText("You", 250, 400);
                    getWorld().showText("I guess will look for the keys then", 500, 500);
                    delay = 40;
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 8 && delay == 0) {
                    TextBox box = (TextBox)getWorld().getObjects(TextBox.class).get(0);
                    box.direction = 1;
                    getWorld().showText(null, 250, 400);
                    getWorld().showText("???", 740, 400);
                    getWorld().showText("Good hunting.", 500, 500);
                    delay = 40;
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 9 && delay == 0) {
                    player.textOn = false;
                    activated = false;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText(null, 500, 500);
                    getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                    delay = 40;
                    endText = true;
                    flag++;
                } 
                if (Greenfoot.isKeyDown("z") && isInRange() && flag == 10 && activated == false && delay == 0) {
                    delay = 40;
                    player.textOn = true;
                    activated = true;
                    getWorld().addObject(new TextBox(1), 500, 500);
                    getWorld().showText("Hmmm? Still lost?", 500, 500);
                    getWorld().showText("???", 740, 400);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 11 && delay == 0) {
                    delay = 40;
                    getWorld().showText("I guess I can give you some help. For a price of course.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 12 && delay == 0) {
                    delay = 40;
                    getWorld().showText("How about trading some of your sanity for a clue.", 500, 500);
                    flag++;
                }
        }
        if (activated || endText) {
            checkTime();
        }
        if (delay == 0 && activated && continueSymbol == false) {
            getWorld().addObject(new TextContinue(), 740, 580);
            continueSymbol = true;
        } else if (delay > 0 || activated == false) {
            getWorld().removeObjects(getWorld().getObjects(TextContinue.class));
            continueSymbol = false;
        }
    }
    public void checkTime() {
        if (delay > 0) {
            delay--;
        }
        if (delay == 0 && endText == true) {
            endText = false;
        }
    }
}
