import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World9 extends WorldC
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World9(){
        this(0, 5, 5, 9);
    }

    public World9(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        bossHealth = new HealthBar(20, 80, 15, "MagiKoopa");
        addObject(mario, 100, 600);
        addObject(portal, 1010, 464);
        Magikoopa koopa = new Magikoopa(1);
        addObject(koopa, portal.getX()-50, portal.getY());
        addObject(bossHealth, koopa.getX(), koopa.getY()-koopa.getImage().getHeight()/4*3);

        addObject(new Block(31), 183, 620);
        addObject(new Block(32), 376, 620);
        addObject(new Block(31), 791, 620);
        addObject(new Block(32), 595, 620);
        addObject(new Block(31), 376, 400);
        addObject(new Block(32), 376, 168);

    }

}
