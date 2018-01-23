import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldC extends SuperWorld
{

    /**
     * Constructor for objects of class WorldC.
     * 
     */
    protected Portal portal = new Portal();
    //protected HealthBar bossHealth;
    
    
    public WorldC(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        mario.changeType();


    }
}
