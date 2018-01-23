import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PurpleLuma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PurpleLuma extends Shop
{
    /**
     * Act - do whatever the PurpleLuma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter =0;
    public void act() 
    {
        counter ++;
        int score = ((SuperWorld)getWorld()).score.getValue();
        if (Greenfoot.isKeyDown("k")&&counter>25) {
             purchase(score);
             counter=0;
        }
        if(Greenfoot.mouseClicked(this)) {
            purchase(score);
        }
    } 

    public void purchase (int score) {
        if(score - 25 >= 0) {
            Greenfoot.playSound("store.wav");
            ((SuperWorld)getWorld()).score.add(-25);
            ((SuperWorld)getWorld()).powerCounter2.add(5);
        }
    }
}
