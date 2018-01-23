import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueLuma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueLuma extends Shop
{
    /**
     * Act - do whatever the BlueLuma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    public void act() 
    {
        // Add your action code here.
        counter ++;
        if(Greenfoot.mouseClicked(this)||(Greenfoot.isKeyDown("l") && counter >25)) {
            int score = ((SuperWorld)getWorld()).score.getValue();
            if(score - 50 >= 0) {
                Greenfoot.playSound("store.wav");
                ((SuperWorld)getWorld()).score.add(-50);
                getWorld().addObject(new SuperBubble(), ((SuperWorld)getWorld()).mario.getX(), ((SuperWorld)getWorld()).mario.getY());
                counter=0;
            }


        }
    }    
}
