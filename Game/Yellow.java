import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yellow extends Item
{  
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            //addPowerup();
            Greenfoot.playSound("goldChange.wav");
            times2();
            getWorld().removeObject(this);
        }
        
   
        
        
    }  
    
}
