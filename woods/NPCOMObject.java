import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPCOMObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPCOMObject extends Objects
{
    int flag = 0;
    String world;
    int delay = 40;
    int choice;
    /**
     * Occupied checks if the player is currently talking to another npc
     * Activated checks if the player is currentiung talking to this npc
     * continueSymbol checks if the continueSymbol is present on the dialogue box
     * endText checks if the player is at the end of the dialogue scene
     * choiceText checks if the player is currently in a choice scene
     */
    boolean occupied;
    boolean activated;
    boolean continueSymbol;
    boolean endText;
    boolean choiceText;
    public NPCOMObject(String world) {
        this.world = world;  
        setImage("npcs/oldman.png");
    }
    public void act()
    {
        checkPlayer();
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        NPCGIRObject girlrose = (NPCGIRObject)getWorld().getObjects(NPCGIRObject.class).get(0);
        /**
         * If the other npc is not occupied
         * check for the current world the npc using switch
         * Set the other npc to be occupied and the player to be using text so that they can't move
         * Create text and then increase the flag of the dialogue once it is done
         */
        if (!occupied) {
            switch (world) {
                case "woods":
                    if (Player.rose == 0) {
                    if (Greenfoot.isKeyDown("z") && isInRange() && flag == 0 && activated == false) {
                        girlrose.occupied = true;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("Howdy. What brings you here to this gloomy place?", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Care to give an old man a light?", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
                        delay = 40;
                        getWorld().showText("I will give you something special.", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Spend 20 light?", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
                        delay = 40;
                        choiceText = true;
                        getWorld().showText("Yes", 350, 550);
                        getWorld().showText("No", 600, 550);
                        getWorld().addObject(new TextChoice(), 300, 550);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
                        TextChoice choice = (TextChoice)getWorld().getObjects(TextChoice.class).get(0);
                        if (choice.location == 0) {
                            Player.keys++;
                            Player. light -= 20;
                            choiceText = false;
                            getWorld().showText(null, 350, 550);
                            getWorld().showText(null, 600, 550);
                            delay = 40;
                            getWorld().showText("Lose 20 light.", 500, 500);
                            flag++;
                        } else if (choice.location == 1) {
                            choiceText = false;
                            getWorld().showText(null, 350, 550);
                            getWorld().showText(null, 600, 550);
                            delay = 40;
                            getWorld().showText("No worries, not every likes smokes.", 500, 500);
                            flag = 20;
                        }
                    } else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Here's a key that I found while digging earlier.", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
                        girlrose.occupied = false;
                        player.textOn = false;
                        activated = false;
                        getWorld().showText(null, 740, 400);
                        getWorld().showText(null, 500, 500);
                        getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                        delay = 40;
                        endText = true;
                        flag = 100;    
                    } else if (Greenfoot.isKeyDown("z") && flag == 20 && delay == 0) {
                        girlrose.occupied = false;
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
                        girlrose.occupied = true;
                        delay = 40;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("You ready for the trade?", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag = 3;
                    }
                    if (Greenfoot.isKeyDown("z") && isInRange() && flag == 100 && activated == false && delay == 0) {
                        delay = 40;
                        girlrose.occupied = true;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("Sorry lad but I am busy smoking", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 101 && delay == 0) {
                        girlrose.occupied = false;
                        player.textOn = false;
                        activated = false;
                        getWorld().showText(null, 740, 400);
                        getWorld().showText(null, 500, 500);
                        getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                        delay = 40;
                        endText = true;
                        flag = 100;
                    }
                } else {
                    if (Greenfoot.isKeyDown("z") && isInRange() && flag == 0 && activated == false) {
                        girlrose.occupied = true;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("Is that a blue rose you have there", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Mind giving it to me?", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
                        delay = 40;
                        getWorld().showText("I will give you a key a found earlier.", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Trade rose for key?", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
                        delay = 40;
                        choiceText = true;
                        getWorld().showText("Yes", 350, 550);
                        getWorld().showText("No", 600, 550);
                        getWorld().addObject(new TextChoice(), 300, 550);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
                        TextChoice choice = (TextChoice)getWorld().getObjects(TextChoice.class).get(0);
                        if (choice.location == 0) {
                            Player.rose -= 1;
                            Player.keys++;
                            choiceText = false;
                            getWorld().showText(null, 350, 550);
                            getWorld().showText(null, 600, 550);
                            delay = 40;
                            getWorld().showText("Lose a rose.", 500, 500);
                            flag++;
                        } else if (choice.location == 1) {
                            choiceText = false;
                            getWorld().showText(null, 350, 550);
                            getWorld().showText(null, 600, 550);
                            delay = 40;
                            getWorld().showText("It's good, I know that thing is valuable.", 500, 500);
                            flag = 20;
                        }
                    } else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
                        delay = 40;
                        getWorld().showText("Here's the key I promiced ya.", 500, 500);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
                        girlrose.occupied = false;
                        player.textOn = false;
                        activated = false;
                        getWorld().showText(null, 740, 400);
                        getWorld().showText(null, 500, 500);
                        getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                        delay = 40;
                        endText = true;
                        flag = 100;    
                    } else if (Greenfoot.isKeyDown("z") && flag == 20 && delay == 0) {
                        girlrose.occupied = false;
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
                        girlrose.occupied = true;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("You ready for the trade?", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag = 3;
                    }
                    if (Greenfoot.isKeyDown("z") && isInRange() && flag == 100 && activated == false && delay == 0) {
                        delay = 40;
                        girlrose.occupied = true;
                        player.textOn = true;
                        activated = true;
                        getWorld().addObject(new TextBox(1), 500, 500);
                        getWorld().showText("If I picked up another shiny, I will tell ya.", 500, 500);
                        getWorld().showText("???", 740, 400);
                        flag++;
                    } else if (Greenfoot.isKeyDown("z") && flag == 101 && delay == 0) {
                        girlrose.occupied = false;
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
                break;
                case "garden":
                    if (player.rose == 0) {
                        if (Greenfoot.isKeyDown("z") && isInRange() && flag == 0 && activated == false) {
                            girlrose.occupied = true;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("You got the gate opened, huh?", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
                            delay = 40;
                            getWorld().showText("I just digged under the wall.", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
                            delay = 40;
                            getWorld().showText("Anyways, I need a light, you got any?", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
                            delay = 40;
                            getWorld().showText("Spend 20 light?", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
                            delay = 40;
                            choiceText = true;
                            getWorld().showText("Yes", 350, 550);
                            getWorld().showText("No", 600, 550);
                            getWorld().addObject(new TextChoice(), 300, 550);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
                            TextChoice choice = (TextChoice)getWorld().getObjects(TextChoice.class).get(0);
                            if (choice.location == 0) {
                                Player.keys++;
                                Player. light -= 20;
                                choiceText = false;
                                getWorld().showText(null, 350, 550);
                                getWorld().showText(null, 600, 550);
                                delay = 40;
                                getWorld().showText("Lose 20 light.", 500, 500);
                                flag++;
                            } else if (choice.location == 1) {
                                choiceText = false;
                                getWorld().showText(null, 350, 550);
                                getWorld().showText(null, 600, 550);
                                delay = 40;
                                getWorld().showText("No worries, not every likes smokes.", 500, 500);
                                flag = 20;
                            }
                        } else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
                            delay = 40;
                            getWorld().showText("Here's a key that I found while digging earlier.", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
                            girlrose.occupied = false;
                            player.textOn = false;
                            activated = false;
                            getWorld().showText(null, 740, 400);
                            getWorld().showText(null, 500, 500);
                            getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                            delay = 40;
                            endText = true;
                            flag = 100;    
                        } else if (Greenfoot.isKeyDown("z") && flag == 20 && delay == 0) {
                            girlrose.occupied = false;
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
                            girlrose.occupied = true;
                            delay = 40;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("You ready for the trade?", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag = 3;
                        }
                        if (Greenfoot.isKeyDown("z") && isInRange() && flag == 100 && activated == false && delay == 0) {
                            delay = 40;
                            girlrose.occupied = true;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("Sorry lad but I am busy smoking.", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 101 && delay == 0) {
                            girlrose.occupied = false;
                            player.textOn = false;
                            activated = false;
                            getWorld().showText(null, 740, 400);
                            getWorld().showText(null, 500, 500);
                            getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                            delay = 40;
                            endText = true;
                            flag = 100;
                        }
                    }  else {
                        if (Greenfoot.isKeyDown("z") && isInRange() && flag == 0 && activated == false) {
                            girlrose.occupied = true;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("I see that you have found a blue rose.", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 1 && delay == 0) {
                            delay = 40;
                            getWorld().showText("You want to do a trade?", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 2 && delay == 0) {
                            delay = 40;
                            getWorld().showText("I will give you a key a found earlier.", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 3 && delay == 0) {
                            delay = 40;
                            getWorld().showText("Trade rose for key?", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 4 && delay == 0) {
                            delay = 40;
                            choiceText = true;
                            getWorld().showText("Yes", 350, 550);
                            getWorld().showText("No", 600, 550);
                            getWorld().addObject(new TextChoice(), 300, 550);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 5 && delay == 0) {
                            TextChoice choice = (TextChoice)getWorld().getObjects(TextChoice.class).get(0);
                            if (choice.location == 0) {
                                Player.rose -= 1;
                                Player.keys++;
                                choiceText = false;
                                getWorld().showText(null, 350, 550);
                                getWorld().showText(null, 600, 550);
                                delay = 40;
                                getWorld().showText("Lose a rose.", 500, 500);
                                flag++;
                            } else if (choice.location == 1) {
                                choiceText = false;
                                getWorld().showText(null, 350, 550);
                                getWorld().showText(null, 600, 550);
                                delay = 40;
                                getWorld().showText("It's good, I know that thing is valuable.", 500, 500);
                                flag = 20;
                            }
                        } else if (Greenfoot.isKeyDown("z") && flag == 6 && delay == 0) {
                            delay = 40;
                            getWorld().showText("Here's the key I promiced ya.", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 7 && delay == 0) {
                            girlrose.occupied = false;
                            player.textOn = false;
                            activated = false;
                            getWorld().showText(null, 740, 400);
                            getWorld().showText(null, 500, 500);
                            getWorld().removeObjects(getWorld().getObjects(TextBox.class));
                            delay = 40;
                            endText = true;
                            flag = 100;    
                        } else if (Greenfoot.isKeyDown("z") && flag == 20 && delay == 0) {
                            girlrose.occupied = false;
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
                            girlrose.occupied = true;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("You ready for the trade?", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag = 3;
                        }
                        if (Greenfoot.isKeyDown("z") && isInRange() && flag == 100 && activated == false && delay == 0) {
                            delay = 40;
                            girlrose.occupied = true;
                            player.textOn = true;
                            activated = true;
                            getWorld().addObject(new TextBox(1), 500, 500);
                            getWorld().showText("If I picked up another shiny, I will tell ya.", 500, 500);
                            getWorld().showText("???", 740, 400);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 101 && delay == 0) {
                            delay = 40;
                            getWorld().showText("If we ever meet again.", 500, 500);
                            flag++;
                        } else if (Greenfoot.isKeyDown("z") && flag == 102 && delay == 0) {
                            girlrose.occupied = false;
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
                break;
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
    }
    /**
     * When delay is larger than 0, delays go down else, it doesn't
     * This is the timer for when the player can move on the next dialogue
     */
    public void checkTime() {
        if (delay > 0) {
            delay--;
        }
        if (delay == 0 && endText == true) {
            endText = false;
        }
    }
}
