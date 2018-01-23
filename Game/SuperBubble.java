import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperBubble extends Powerups
{
    /**
     * Act - do whatever the SuperBubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 500;
    public SuperBubble(){
        Greenfoot.playSound("bubble_start.wav");
        jumpStrength += 5;
        speed += 2;
        limit = false;
    }

    public void act() 
    {
        // Add your action code here.
        Actor player = getOneIntersectingObject(Player.class);
        Actor enemy = getOneIntersectingObject(Enemy.class);
        Actor boss = getOneIntersectingObject(Boss.class);
        setLocation(player.getX(), player.getY());

        if(enemy!=null && boss==null){
            addScore(10);
            getWorld().removeObject(enemy);
        }
        counter--;
        if(counter<=0){
            pop();
        }
    }    

    public void pop(){
        Greenfoot.playSound("bubble_stop.wav");
        jumpStrength -= 5;
        speed -= 2;
        limit = true;
        getWorld().removeObject(this);
    }
}
