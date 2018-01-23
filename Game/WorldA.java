import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldA extends SuperWorld
{

    /**
     * Constructor for objects of class WorldA.
     * 
     */
   
    protected Ground ground = new Ground(11);
    protected Ground ground2 = new Ground(12);
    protected Ground ground3 = new Ground(13);
    protected Ground ground4 = new Ground(12);
    protected Ground ground5 = new Ground(12);
    protected Ground ground6 = new Ground(12);
    protected Pipe pipe = new Pipe(11);

    protected Goomba goomba = new Goomba(2,"goomba");
    protected Goomba goomba2 = new Goomba(2,"goomba");
    protected PiranhaPlant pPlant = new PiranhaPlant(11);
    protected Shyguy shyguy = new Shyguy();
    protected Rain rain = new Rain(8, "rain");
    protected Lightning lightning = new Lightning();

    public WorldA(int gold, int power1, int power2, int screen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(gold, power1, power2, screen);
        bossHealth = new HealthBar(20, 80, 15, "Shy Guy");
    }
}
