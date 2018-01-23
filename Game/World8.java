import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World8 extends WorldB
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World8(){
        this(0, 90, 90, 8);
    }

    public World8(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        
        addObject(ground, ground.getImage().getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        addObject(ground2, 413, 508);

        addObject(mario, 35, getHeight() - ground.getImage().getHeight() - mario.getImage().getHeight()/2 + 1);
        addObject(sonic, 301, 204);
        addObject(drybones1,700 , getHeight() - ground.getImage().getHeight() - drybones1.getImage().getHeight()/2+2);
        
        flybones1.setImage("db4.png");
        addObject(flybones1, ground2.getX(), ground2.getY()-ground2.getImage().getHeight()/2 - flybones1.getImage().getHeight()/2+2);
        addObject(kingBoo, 954, 417);
        addObject(bossHealth, kingBoo.getX(), kingBoo.getY()-kingBoo.getImage().getHeight()/4*3);
        
        addObject(new Block(21), 516, 281);
        addObject(new Block(22), 310, 281);

    }

}
