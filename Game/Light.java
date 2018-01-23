import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Light here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light extends Effects
{
    /**
     * Act - do whatever the Light wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    public void act() 
    {
        // Add your action code here.
        Actor player = getOneIntersectingObject(Player.class);
        setLocation(player.getX(), player.getY());
        if(Greenfoot.isKeyDown("2")){//fix this
            int powers = ((SuperWorld)getWorld()).powerCounter2.getValue();
            if (powers > 0 || !limit){
                /*if(limit)*/
                ((SuperWorld)getWorld()).powerCounter2.add(-1);
                int screen = ((SuperWorld)getWorld()).screen;
                if(screen>4 && screen <8 && counter<=0){
                    setImage("light3.png");
                    counter = 500;
                    
                }

            }
        }    
        if(counter==0)setImage("light2.png");
        counter--;
    }
}