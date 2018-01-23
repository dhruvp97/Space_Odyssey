import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends WorldA
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World1(){
        this(0, 0, 0, 1);
    }

    public World1(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        
        addObject(ground, ground.getImage().getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        addObject(ground2, getWidth(), getHeight() - ground2.getImage().getHeight()/2);
        addObject(pPlant, 960, getHeight()-pPlant.getImage().getHeight()/2-ground.getImage().getHeight());

        addObject(pipe, pPlant.getX(),getHeight()-pipe.getImage().getHeight()/2-ground.getImage().getHeight()+28);
        addObject(mario, 35, getHeight() - ground.getImage().getHeight() - mario.getImage().getHeight()/2 + 1);
        addObject(goomba, 503, getHeight() - ground.getImage().getHeight() - goomba.getImage().getHeight()/2+2);

        addObject(new Block(11), 300, 575);
        addObject(new Block(12), 400, 500);

    }

}
