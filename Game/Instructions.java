import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    private String code;
    private String [] codes;
    private int gold;
    private int p1;
    private int p2;
    private int screen;
    private String worlds;
    private boolean worldA = false;
    private boolean worldB = false;
    private boolean worldC = false;

    public Instructions(){
        this("0-0-0-1-A");
    }

    public Instructions(String code)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(811, 1592, 1); 
        this.code = code;
        codes = code.split("-");
        gold = Integer.parseInt(codes[0]);
        p1 = Integer.parseInt(codes[1]);
        p2 = Integer.parseInt(codes[2]);
        screen = Integer.parseInt(codes[3]);
        worlds = codes[4];
        if(worlds.equals("A"))worldA=true;
        else if(worlds.equals("B")){
            worldA=true;
            worldB=true;
        }
        else if(worlds.equals("C")){
            worldA=true;
            worldB=true;
            worldC=true;
        }
        addObject(new Back(), 94, 1544);
        addObject(new Next(), 696, 1544);
    }
    public void proceed(){
        Greenfoot.setWorld(new LevelScreen(gold, p1, p2, screen, worldA, worldB, worldC));
    }
}
