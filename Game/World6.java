import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World6 extends WorldB
{

    /**
     * Constructor for objects of class World1_1.
     * 
     */
    public World6(){
        this(0, 0, 0, 6);
    }

    public World6(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);

        addObject(ground2, 0, getHeight() - ground2.getImage().getHeight()/2);
        addObject(ground4, getWidth()-ground4.getImage().getWidth()/2, getHeight() - ground4.getImage().getHeight()/2);
        addObject(ground3, 413, getHeight()/4*3);

        addObject(drybones1, ground3.getX(), ground3.getY() - ground3.getImage().getHeight()/2- drybones1.getImage().getHeight()/2+2);
        addObject(flybones1, ground4.getX(), ground4.getY()-ground4.getImage().getHeight()/2 - flybones1.getImage().getHeight()/2+2);
        addObject(mario, 35, getHeight() - ground.getImage().getHeight() - mario.getImage().getHeight()/2 + 1);
        addObject(light, mario.getX(), mario.getY());
        addObject(new Block(22), 45, 507);
        addObject(new Block(21), 586, 345);
    }
}
