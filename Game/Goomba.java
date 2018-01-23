import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goomba extends Enemy
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
        moveGoomba();
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)  {
            int pHeight = player.getY()+player.getImage().getHeight()/2;
            if(pHeight <= getY()) {
                addScore(5);
                Greenfoot.playSound("stomp_goomba.wav");
                getWorld().removeObject(this);
            }
            else  {
                getWorld().removeObject(player);
                gameOver();
            }

        }
    }

    public int randomNum (int min, int max){
        return (int)(Math.random()*(max-min) + min);
    }

    public void running(int counter) {
        setImage(name+counter+".png");
    }

    public void moveGoomba(){

        if(isAtBound() || isAtEdge()) moveSpeed *= -1;
        setLocation (getX()+moveSpeed, getY());
        counter++;
        if (counter == 1) running(1); 
        else if (counter == 2) {
            running(2);
            counter = 0;
        }
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

    public Goomba (int n, String name) {
        this.n = n;
        this.name = name;
    }
}
