import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldB extends SuperWorld
{

    /**
     * Constructor for objects of class WorldB.
     * 
     */
    protected static int screen = 1;
    protected Ground ground = new Ground(21);
    protected Ground ground2 = new Ground(22);
    protected Ground ground3 = new Ground(23);
    protected Ground ground4 = new Ground(22);
    protected Ground ground5 = new Ground(22);
    protected Ground ground6 = new Ground(22);
    protected Pipe pipe = new Pipe(11);

    
    protected DryBones drybones1 = new DryBones();
    protected DryBones drybones2 = new DryBones();
    protected FlyBones flybones1 = new FlyBones();
    
    protected Light light = new Light();
    protected KingBoo kingBoo = new KingBoo();
    protected Rain rain = new Rain(8, "rain");
    protected Lightning lightning = new Lightning();

    public WorldB(int gold, int powerUps, int power2, int screen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(gold, powerUps, power2, screen);
        bossHealth = new HealthBar(20, 80, 15, "King Boo");
    }
}
