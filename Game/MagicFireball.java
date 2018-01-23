import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicFireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicFireball extends Enemy
{
    /**
     * Act - do whatever the MagicFireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        Actor player = getOneIntersectingObject(Player.class);
        Actor object = getOneIntersectingObject(Floor.class);
        setLocation(getX()-10, getY());
        if(isAtEdge()||object!=null)getWorld().removeObject(this);
        else if(player!=null){
            gameOver();
            getWorld().removeObject(player);
            getWorld().removeObject(this);
        }
    }
}
