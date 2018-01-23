import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int counter = 0;
    protected int color = 1;
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)) Greenfoot.setWorld(new Instructions());
        changeColour("playbtn");
    }
    public void changeColour(String name){
        counter++;
        if(counter>25){
            setImage(name+ color +".jpg");
            color*=-1;
            counter=0;
        }
    }
}
