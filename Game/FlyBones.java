import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shyguy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyBones extends Enemy
{
    /**
     * Act - do whatever the Shyguy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int moveSpeed = 1;
    private int chances = 500;

    public FlyBones(){
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.
        checkFall(this);
        moveFlyBones();
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)  {
                getWorld().removeObject(player);
                gameOver();
        }
    }    

    public void moveFlyBones(){

        if(isAtBound() || isAtEdge()) {
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
            moveSpeed *= -1;
        }
        if(!jumping) setLocation (getX()+moveSpeed, getY());
        if(!jumping && Greenfoot.getRandomNumber(chances+5)>chances )jump(this);

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
