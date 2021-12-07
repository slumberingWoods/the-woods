import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story extends World
{
    int flag = 0;
    String world;
    int delay = 40;
    int choice = 0;
    boolean activated;
    boolean continueSymbol;
    boolean endText;
    boolean choiceText;
    GreenfootImage bg = new GreenfootImage("void.png");
    /**
     * Constructor for objects of class Story.
     * 
     */
    public Story()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        setBackground(bg);
    }
    public void act() {
        checkTime();
        checkText();
    }
    public void checkTime()  {
        if (delay > 0) {
            delay--;
        }
        if (delay == 0 && endText == true) {
            endText = false;
        }
    }
    public void checkText() {
        if (flag == 0 && activated == false) {
            activated = true;
            showText("Skip intro?", 500, 350);
            choiceText = true;
            showText("Yes", 375, 400);
            showText("No", 625, 400);
            addObject(new TextChoice(), 325, 400);
            flag++;
        } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
            TextChoice choice = (TextChoice)getObjects(TextChoice.class).get(0);
            if (choice.location == 0) {
                        Greenfoot.setWorld(new House());
                    } else if (choice.location == 1) {
                        choiceText = false;
                        showText(null, 375, 400);
                        showText(null, 625, 400);
                        delay = 40;
                        showText("...", 500, 350);
                        flag++;
                    }
        } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
            delay = 40;
            showText("*Thud*", 500, 350);
            flag++;
        } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
            delay = 40;
            showText("...", 500, 350);
            flag++;
        } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
            delay = 40;
            showText("I fell asleep on the floor.", 500, 350);
            flag++;
        } else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
            delay = 40;
            showText("It's dark here. The power is out.", 500, 350);
            flag++;
        }  else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
            delay = 40;
            showText("I need to get the electrical room and turn the power back on.", 500, 350);
            flag++;
        }  else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
            delay = 40;
            showText("Good thing I still have my lighter with me.", 500, 350);
            flag++;
        }  else if (Greenfoot.isKeyDown("z") && flag == 8 && delay == 0) {
            delay = 40;
            showText("This house is really giving me the creeps though.", 500, 350);
            flag++;
        } else if (Greenfoot.isKeyDown("z") && flag == 9 && delay == 0) {
            Greenfoot.setWorld(new House());
        } 
        if (activated || endText) {
            checkTime();
        }
        if (delay == 0 && activated && continueSymbol == false && choiceText == false) {
            addObject(new TextContinue(), 650, 400);
            continueSymbol = true;
        } else if (delay > 0 || activated == false || choiceText == true) {
            removeObjects(getObjects(TextContinue.class));
            continueSymbol = false;
        }
        if (choiceText == false) {
            removeObjects(getObjects(TextChoice.class));
        }
    }
}
