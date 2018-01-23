import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DryBones extends Enemy
{
    /**
     * Act - do whatever the Goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0; 
    private int moveSpeed = 5;
    private int n;
    private String name = ""; 
    public void act() 
    {
        moveDryBones();
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)  {
                getWorld().removeObject(player);
                gameOver();
        }
    }

    public void moveDryBones(){

        if(isAtBound() || isAtEdge()) {
            moveSpeed *= -1;
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
        }
        setLocation (getX()-moveSpeed, getY());
        counter++;
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

    public DryBones () {
        this.n = n;
        this.name = name;
    }
}
