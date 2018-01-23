import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World10 extends WorldC
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World10(){
        this(0, 90, 90, 10);
    }

    public World10(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        bossHealth = new HealthBar(20, 80, 15, "MagiKoopa");
        addObject(mario, 100, 600);
        portal.setImage("portal3.png");
        addObject(portal, 530, 750);

        Magikoopa koopa = new Magikoopa(2);
        addObject(koopa, getWidth()-50, getHeight()/2);
        addObject(bossHealth, koopa.getX(), koopa.getY()-koopa.getImage().getHeight()/4*3);

        addObject(new Block(32), 264, 209);
        addObject(new Block(31), 752, 209);
        addObject(new Block(32), 508, 418);
        addObject(new Block(31), 264, 626);
        addObject(new Block(32), 752, 626);

    }

}
