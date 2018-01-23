import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedLuma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedLuma extends Shop
{
    /**
     * Act - do whatever the RedLuma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter =0;
    public void act() 
    {
        counter ++;
        int score = ((SuperWorld)getWorld()).score.getValue();
        if (Greenfoot.isKeyDown("j")&&counter>25) {
             purchase(score);
             counter=0;
        }
        if(Greenfoot.mouseClicked(this)) {
            purchase(score);
        }
    } 

    public void purchase (int score) {
        if(score - 10 >= 0) {
            Greenfoot.playSound("store.wav");
            ((SuperWorld)getWorld()).score.add(-10);
            ((SuperWorld)getWorld()).powerCounter.add(10);
        }
    }   
}
