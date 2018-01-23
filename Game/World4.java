import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World4 extends WorldA
{

    /**
     * Constructor for objects of class World4.
     * 
     */
    public World4(){
        this(0, 20, 20, 4);
    }

    public World4(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);

        addObject(ground2, ground2.getImage().getWidth()/2, 311);
        addObject(ground6, ground6.getImage().getWidth()/2, 741);
        addObject(ground4, 507, 584);
        addObject(ground5, getWidth() - ground5.getImage().getWidth()/2, 522);
        addObject(new Block(11), 60, 476);
        addObject(new Block(12), 219, 476);
        addObject(new Block(12), 506, 357);

        //966
        addObject(mario, 35, ground2.getY() - ground2.getImage().getHeight()/2 - mario.getImage().getHeight()/2 + 1);
        addObject(sonic, 70, ground6.getY() - ground6.getImage().getHeight()/2 - sonic.getImage().getHeight()/2 + 1);
        addObject(shyguy, 966, ground5.getY() - ground5.getImage().getHeight()/2 - shyguy.getImage().getHeight()/2 + 1);
        addObject(bossHealth, shyguy.getX(), shyguy.getY()-shyguy.getImage().getHeight()/4*3);

        addObject(rain, getWidth()/2, 449);

    }
}
