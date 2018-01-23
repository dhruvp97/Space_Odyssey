import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World12 extends WorldC
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World12(){
        this(0, 90, 90, 12);
    }

    public World12(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        addObject(mario, 100, 600);
        bossHealth = new HealthBar(10, 80, 15, "Baby Bowser");
        BabyBowser bb = new BabyBowser();
        addObject(bb, getWidth()-50, getHeight()/2);
        addObject(bossHealth, bb.getX(), bb.getY()-bb.getImage().getHeight()/4*3);

    }

    public void bigB(){
        if(!bowserDead){
            Greenfoot.playSound("bowser_returns.wav");
            bossHealth = new HealthBar(20, 80, 15, "Bowser");
            Bowser bowser = new Bowser();
            addObject(bowser, getWidth()-50, getHeight()/2);
            addObject(bossHealth, bowser.getX(), bowser.getY()-bowser.getImage().getHeight()/4*3);
            addObject(portal, getWidth()-20, getHeight()/2);
            bowserDead = true;
        }
    }
}
