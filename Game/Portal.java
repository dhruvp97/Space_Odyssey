import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor player = getOneIntersectingObject(Player.class);
        if(player!=null){
            int gold = ((SuperWorld)getWorld()).score.getValue();
            int p1 = ((SuperWorld)getWorld()).powerCounter.getValue();
            int p2 = ((SuperWorld)getWorld()).powerCounter2.getValue();
            int screen = ((SuperWorld)getWorld()).screen;
            Greenfoot.playSound("portal.wav");
            if(screen==9)Greenfoot.setWorld(new World10(gold, p1, p2, ++screen));
            else if(screen==10)Greenfoot.setWorld(new World11(gold, p1, p2, ++screen));
            else if(screen==11)Greenfoot.setWorld(new World12(gold, p1, p2, ++screen));
            else if(screen==12)Greenfoot.setWorld(new GameOver());
        }
        // Add your action code here.
    }    
}
