import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends WorldA
{

    /**
     * Constructor for objects of class World1_1.
     * 
     */
    public World2(){
        this(0, 0, 0, 2);
    }

    public World2(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);

        addObject(ground2, 0, getHeight() - ground2.getImage().getHeight()/2);
        addObject(ground4, getWidth()-ground4.getImage().getWidth()/2, getHeight() - ground4.getImage().getHeight()/2);
        addObject(ground3, getWidth()/2, getHeight()/4*3);

        addObject(pPlant, getWidth()/8*3, ground3.getY()-pPlant.getImage().getHeight()/2-ground3.getImage().getHeight()/2);
        addObject(pipe, pPlant.getX(),ground3.getY()-pipe.getImage().getHeight()/2-ground3.getImage().getHeight()/2+28);
        addObject(mario, 35, getHeight() - ground.getImage().getHeight() - mario.getImage().getHeight()/2 + 1);

        addObject(goomba, 607, ground3.getY() - ground3.getImage().getHeight()/2 - goomba.getImage().getHeight()/2+2);
        
        addObject(new Block(12), 45, 507);
        addObject(new Block(11), 586, 345);
    }
}
