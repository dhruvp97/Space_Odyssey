import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet to be shot at asteroids.
 * 
 * The Shot moves to the top of the screen and then expires. If it hits an asteroid
 * on the way, it destroys the asteroid, and then expires immediately.
 */
public class Gold  extends Item
{
    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            addScore(1);
            getWorld().removeObject(this);
        }
    }
}