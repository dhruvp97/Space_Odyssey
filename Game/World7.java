import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class world3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World7 extends WorldB
{

    /**
     * Constructor for objects of class world3.
     * 
     */
    public World7(){
        this(0, 0, 0, 7);
    }

    public World7(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);

        addObject(ground2, ground2.getImage().getWidth()/2, 696);
        addObject(ground3, getWidth()/2, 503);
        addObject(ground4, getWidth()-ground4.getImage().getWidth()/2, 314);
        
        addObject(flybones1, ground3.getX(), ground3.getY() - ground3.getImage().getHeight()/2- flybones1.getImage().getHeight()/2+2);
        addObject(drybones1, ground4.getX(), ground4.getY()-ground4.getImage().getHeight()/2 - drybones1.getImage().getHeight()/2+2);
        addObject(mario, 35, ground2.getY() - ground.getImage().getHeight()/2 - mario.getImage().getHeight()/2 + 1);
        addObject(light, mario.getX(), mario.getY());

        addObject(new Block(22), 240, 502);
        addObject(new Block(21), 512, 202);
    }
}
