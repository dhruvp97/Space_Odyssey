import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World11 extends WorldC
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public World11(){
        this(0, 90, 90, 11);
    }

    public World11(int gold, int power1, int power2, int screen)
    {
        super(gold, power1, power2, screen);
        bossHealth = new HealthBar(20, 80, 15, "MagiKoopa");
        addObject(mario, 100, 600);
        portal.turn(45);
        portal.setImage("portal4.png");
        addObject(portal, 972, 715);

        Magikoopa koopa = new Magikoopa(3);
        addObject(koopa, getWidth()-50, getHeight()/2);
        addObject(bossHealth, koopa.getX(), koopa.getY()-koopa.getImage().getHeight()/4*3);

        addObject(new Block(31), 669, 677);
        addObject(new Block(32), 669, 587);
        addObject(new Block(31), 669, 183);
        addObject(new Block(32), 669, 273);
        addObject(new Block(31), 413, 441);
        addObject(new Block(32), 291, 634);
        addObject(new Block(31), 291, 242);

    }

}
