import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingBoo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BabyBowser extends Boss
{
    /**
     * Act - do whatever the KingBoo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    private int shoots = 500;
    
    public void act() 
    {
        // Add your action code here.
        counter++;
        if(counter>=100) {
            setLocation(getX(), Greenfoot.getRandomNumber(590)+128);
            counter = 0;
        }
        shoot();
        ((WorldC)getWorld()).bossHealth.setLocation(getX(), getY()-getImage().getHeight()/4*3);
    }    
    public void shoot(){
        if(Greenfoot.getRandomNumber(shoots+5)>shoots) getWorld().addObject(new MagicFireball(), getX(), getY());
    }
}
