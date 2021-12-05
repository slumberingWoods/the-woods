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
    int choice = 0;
    boolean activated;
    boolean continueSymbol;
    boolean endText;
    boolean choiceText;
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
                } else if (Greenfoot.isKeyDown("z") && flag == 13 && delay == 0) {
                    delay = 40;
                    getWorld().showText("It would only hurt for a bit.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 14 && delay == 0) {
                    delay = 40;
                    getWorld().showText("Do you want to trade 20 sanity for help?", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 15 && delay == 0) {
                    delay = 40;
                    choiceText = true;
                    getWorld().showText("Yes", 350, 550);
                    getWorld().showText("No", 600, 550);
                    getWorld().addObject(new TextChoice(), 300, 550);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 16 && delay == 0) {
                    TextChoice choice = (TextChoice)getWorld().getObjects(TextChoice.class).get(0);
                    if (choice.location == 0) {
                        player.rose = 1;
                        player. sanity -= 20;
                        choiceText = false;
                        getWorld().showText(null, 350, 550);
                        getWorld().showText(null, 600, 550);
                        delay = 40;
                        getWorld().showText("Lose 20 sanity.", 500, 500);
                        flag++;
                    } else if (choice.location == 1) {
                        choiceText = false;
                        getWorld().showText(null, 350, 550);
                        getWorld().showText(null, 600, 550);
                        delay = 40;
                        getWorld().showText("Maybe another time then.", 500, 500);
                        flag = 20;
                    }
                } else if (Greenfoot.isKeyDown("z") && flag == 17 && delay == 0) {
                    delay = 40;
                    getWorld().showText("Here's a rose, it will help you down the line.", 500, 500);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 18 && delay == 0) {
                    player.textOn = false;
                    activated = false;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText(null, 500, 500);
                    getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                    delay = 40;
                    endText = true;
                    flag = 100;    
                } else if (Greenfoot.isKeyDown("z") && flag == 20 && delay == 0) {
                    player.textOn = false;
                    activated = false;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText(null, 500, 500);
                    getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                    delay = 40;
                    endText = true;
                    flag++;
                }
                if (Greenfoot.isKeyDown("z") && isInRange() && flag == 21 && activated == false && delay == 0) {
                    delay = 40;
                    player.textOn = true;
                    activated = true;
                    getWorld().addObject(new TextBox(1), 500, 500);
                    getWorld().showText("Reconsidered?", 500, 500);
                    getWorld().showText("???", 740, 400);
                    flag = 12;
                }
                if (Greenfoot.isKeyDown("z") && isInRange() && flag == 100 && activated == false && delay == 0) {
                    delay = 40;
                    player.textOn = true;
                    activated = true;
                    getWorld().addObject(new TextBox(1), 500, 500);
                    getWorld().showText("Sorry but I don't have any left to help you with.", 500, 500);
                    getWorld().showText("???", 740, 400);
                    flag++;
                } else if (Greenfoot.isKeyDown("z") && flag == 101 && delay == 0) {
                    player.textOn = false;
                    activated = false;
                    getWorld().showText(null, 740, 400);
                    getWorld().showText(null, 500, 500);
                    getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                    delay = 40;
                    endText = true;
                    flag = 100;
                }
            }
        if (activated || endText) {
            checkTime();
        }
        if (delay == 0 && activated && continueSymbol == false && choiceText == false) {
            getWorld().addObject(new TextContinue(), 740, 580);
            continueSymbol = true;
        } else if (delay > 0 || activated == false || choiceText == true) {
            getWorld().removeObjects(getWorld().getObjects(TextContinue.class));
            continueSymbol = false;
        }
        if (choiceText == false) {
            getWorld().removeObjects(getWorld().getObjects(TextChoice.class));
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
