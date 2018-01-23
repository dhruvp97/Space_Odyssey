import greenfoot.*; 
/**
 * Write a description of class Motion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Effects extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    protected int gravity = 2;
    private int vy = 0;
    protected static int speed;
    protected static int jumpStrength;
    protected boolean jumping;
    protected boolean paused = false;
    protected static boolean limit = true;
    World1 world = (World1) getWorld();
    /**
     * Constructor for objects of class Motion
     */
    public Effects()
    {
        speed = 5;
        jumpStrength = 30;

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    public void fall(Actor player){
        player.setLocation(player.getX(), player.getY() + vy);
        if(vy <= 9){
            vy += gravity;
        }
        jumping = true;
    }
    protected void changeWorld(World world){
        changeWorld(world, 5);
    }
    protected void changeWorld(World world, int counter){
        ((SuperWorld)getWorld()).changeWorld(world, counter);
    }
    public void moveToGround(Actor floor, Actor player){
        int floorHeight = floor.getImage().getHeight();
        int newY = floor.getY() - (floorHeight + player.getImage().getHeight())/2;
        player.setLocation(player.getX(), newY+1);
        jumping = false;
    }

    public boolean onGround(Actor player){
        Actor floor = getOneIntersectingObject(Floor.class);
        if(floor == null) {
            jumping = true;
            return false;
        }
        else if(floor.getY()-floor.getImage().getHeight()/4 < player.getY()){
            if(jumping)vy=9;
            jumping = false;
            return false;
        }
        else {
            moveToGround(floor, player);
            return true;
        }
    }

    public boolean besideObject (Actor player){
        Actor floor = getOneIntersectingObject(Floor.class);
        if(floor == null) return false;
        else if((floor.getY()-floor.getImage().getHeight()/2+2 < player.getY())&&(floor.getY()+floor.getImage().getHeight()/2 > player.getY())){
            player.setLocation(player.getX()-1, player.getY());
            return true;
        }
        return false;
    }

    public void touchingSomething (Actor player){
        Actor obstacle = getOneIntersectingObject(Floor.class);
        if(obstacle != null) 
            if(besideObject(player)){
                if(obstacle.getX()>= player.getX()) player.setLocation(getX()-speed*2, getY());
                else player.setLocation(getX()+speed*2, getY());
            }
    }

    public void jump(Actor player){
        vy -= jumpStrength;
        jumping = true;
        fall(player);
    }

    public void checkFall(Actor player){
        touchingSomething(player);
        if(onGround(player)){
            vy = 0;
        }
        else fall(player);
    }

    public void addScore(int score){
        ((SuperWorld) getWorld()).score.add(score);
    }
    
    public void times2(){
        ((SuperWorld) getWorld()).score.times2();
    }

    public void addPowerup(){
        ((SuperWorld) getWorld()).powerCounter.add(10);          
        getWorld().removeObject(this);
    }

    public void addPowerup2(){
        ((SuperWorld) getWorld()).powerCounter2.add(1);          
        getWorld().removeObject(this);
    }
    
    public void gameOver(){
        ((SuperWorld) getWorld()).gameOver();
    }
}
