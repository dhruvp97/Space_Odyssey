import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World5 extends WorldB
{

    /**
     * Constructor for objects of class World5.
     * 
     */
    public World5(){
        this(0, 0, 0, 5);
    }

    public World5(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);

        addObject(ground2, ground2.getImage().getWidth()/2, 311);
        addObject(ground6, ground6.getImage().getWidth()/2, 741);
        addObject(ground4, getWidth() - ground4.getImage().getWidth()/2, getHeight()- ground4.getImage().getHeight()/2);
        addObject(ground5, getWidth() - ground5.getImage().getWidth()/2, 522);
        addObject(drybones1, ground5.getX(), ground5.getY() - ground5.getImage().getHeight()/2- drybones1.getImage().getHeight()/2+2);
        addObject(drybones2, ground4.getX()+150, ground4.getY() - ground4.getImage().getHeight()/2- drybones2.getImage().getHeight()/2+2);
        
        addObject(new Block(21), 60, 476);
        addObject(new Block(22), 219, 476);
        addObject(new Block(22), 506, 357);

        //966
        addObject(mario, 35, ground2.getY() - ground2.getImage().getHeight()/2 - mario.getImage().getHeight()/2 + 1);
        addObject(light, mario.getX(), mario.getY());
        //addObject(sonic, 70, ground2.getY() - ground2.getImage().getHeight()/2 - sonic.getImage().getHeight()/2 + 1);
        
    }
}
