import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PiranhaPlant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PiranhaPlant extends Enemy
{
    /**
     * Act - do whatever the PiranhaPlant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int move=1;
    private int y=0;
    private boolean up=true;
    
    public PiranhaPlant (int type) {
        setImage("pPlant"+type+".png");
    }
    public void act() 
    {
        if(up){
            setLocation(getX(), getY()-move);
            y ++;
            if(y>65)up = false;
        }
        else{
            if(y>0)
                setLocation(getX(), getY()+move);
            y--;
            if(y==-69){
                up =true;
                y=0;
            }
        }
        removeTouching();
    }
    
    public void removeTouching(){
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)  {
            removeTouching(Player.class);
            gameOver();
        }
    }
}
