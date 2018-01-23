import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shyguy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shyguy extends Boss
{
    /**
     * Act - do whatever the Shyguy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int moveSpeed = 1;
    private int chances = 500;
    private int shoots = 200;

    public void act() 
    {
        // Add your action code here.
        checkFall(this);
        moveShyguy();
        shoot();
    }    

    public void moveShyguy(){

        if(isAtBound() || isAtEdge()) moveSpeed *= -1;
        if(!jumping) setLocation (getX()+moveSpeed, getY());
        if(!jumping && Greenfoot.getRandomNumber(chances+5)>chances )jump(this);
        ((SuperWorld)getWorld()).bossHealth.setLocation(getX(), getY()-getImage().getHeight()/4*3);

    }

    public void shoot(){
        if(Greenfoot.getRandomNumber(shoots+5)>shoots) getWorld().addObject(new Knife(), getX(), getY());
    }

    public boolean isAtBound (){
        Actor floor = getOneIntersectingObject(Floor.class);
        Actor pipe = getOneIntersectingObject(Pipe.class);
        if(pipe != null) return true;
        else if(floor != null) {
            if (getX()+getImage().getWidth()/2 > floor.getX()+floor.getImage().getWidth()/2) return true;
            else if (getX()-getImage().getWidth()/2  < floor.getX()-floor.getImage().getWidth()/2) return true;
        } 
        return false;
    }
}
