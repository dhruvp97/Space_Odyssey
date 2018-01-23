import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelScreen extends World
{

    /**
     * Constructor for objects of class Level.
     * 
     */
    private Level level1;
    private Level level2;
    private Level level3;
    private int gold;
    private int p1;
    private int p2;
    private int screen;

    public LevelScreen(int gold, int p1, int p2, int screen, boolean a, boolean b, boolean c)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        this.gold = gold;
        this.p1 = p1;
        this.p2 = p2;
        this.screen = screen;

        Greenfoot.playSound("course_clear.wav");
        
        if(a||b||c)level1 = new Level("A");
        else level1 = new Level();
        if(b||c)level2 = new Level("B");
        else level2 = new Level();
        if(c)level3 = new Level("C");
        else level3 = new Level();

        addObject(level1, level1.getImage().getWidth()/2, level1.getImage().getHeight()/2);
        addObject(level2, level1.getX() + level2.getImage().getWidth(), level2.getImage().getHeight()/2);
        addObject(level3, level2.getX() + level3.getImage().getWidth(), level3.getImage().getHeight()/2);
    }

    public void goToWorld(String level){
        if(level.equals("A"))Greenfoot.setWorld(new World1(gold, p1, p2, 1));
        else if(level.equals("B"))Greenfoot.setWorld(new World5(gold, p1, p2, 5));
        else if(level.equals("C"))Greenfoot.setWorld(new World9(gold, p1, p2, 9));
        
        
       /* if(screen==1) Greenfoot.setWorld(new World1(gold, p1, p2, screen));
        else if(screen==2) Greenfoot.setWorld(new World2(gold, p1, p2, screen));
        else if(screen==3) Greenfoot.setWorld(new World3(gold, p1, p2, screen));
        else if(screen==4) Greenfoot.setWorld(new World4(gold, p1, p2, screen));
        else if(screen==5) Greenfoot.setWorld(new World5(gold, p1, p2, screen));
        else if(screen==6) Greenfoot.setWorld(new World6(gold, p1, p2, screen));
        else if(screen==7) Greenfoot.setWorld(new World7(gold, p1, p2, screen));
        else if(screen==8) Greenfoot.setWorld(new World8(gold, p1, p2, screen));
        else if(screen==9) Greenfoot.setWorld(new World9(gold, p1, p2, screen));
        else if(screen==10) Greenfoot.setWorld(new World10(gold, p1, p2, screen));
        else if(screen==11) Greenfoot.setWorld(new World11(gold, p1, p2, screen));
        else if(screen==12) Greenfoot.setWorld(new World12(gold, p1, p2, screen));*/

    }
}
