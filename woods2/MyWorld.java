import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static final int WIDE = 800;
    public static final int HIGH = 600;
    
    Scroller scroller;
    Actor scrollActor;
    
    Colliders map = new Colliders();    //This is the image that the map will be drawn from
    GreenfootImage mapImg = map.getImage(); 
    final int MAPIMGWIDTH = mapImg.getWidth();  // The width of the map image
    final int MAPIMGHEIGHT  = mapImg.getHeight();
    public MyWorld()
    {
        super(WIDE, HIGH, 1);
        GreenfootImage bg = new GreenfootImage("Room.png");
        int bgWide = bg.getWidth();
        int bgHigh = bg.getHeight();
        scroller = new Scroller(this, bg, bgWide, bgHigh);
        scrollActor = new Player(100, 100);
        addObject(scrollActor, bgWide / 2, bgHigh / 2);
        scroll();
        prepare();
    }

    public void act()
    {
        //determines scrolling offsets and scroll
        int dsX = scrollActor.getX() - WIDE / 2;
        int dsY = scrollActor.getY() - HIGH / 2;
        scroller.scroll(dsX, dsY);

    }
    public void makeMap()
    {
        for(int y=0;y<MAPIMGHEIGHT;y++) //One for each row of pixels
        {
            for(int x=0;x<MAPIMGWIDTH;x++) //One for each pixel in the row
            {
                int colorRed = mapImg.getColorAt(x, y).getRed();
                int colorBlue = mapImg.getColorAt(x, y).getBlue();
                int colorGreen = mapImg.getColorAt(x, y).getGreen();
                if(colorRed == Color.BLACK.getRed() || colorBlue == Color.BLACK.getBlue() || colorGreen == Color.BLACK.getGreen()) 
                {
                    showText("hi", 100, 100);// color issue and add colider code here
                }
            }
        }
    }
    private void scroll()
    { 
        // roaming limits of actor
        int loX = 100;
        int hiX = WIDE - 100;
        int loY = 50;
        int hiY = HIGH - 50;

        // determines offset and scroll
        int dsX = 0, dsY = 0;
        if(scrollActor.getX() < loX) dsX = scrollActor.getX() - loX;
        if(scrollActor.getX() < hiX) dsX = scrollActor.getX() - hiX;
        if(scrollActor.getY() < loY) dsY = scrollActor.getY() - loY;
        if(scrollActor.getY() < hiY) dsY = scrollActor.getY() - hiY;
        scroller.scroll(dsX, dsY);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}
