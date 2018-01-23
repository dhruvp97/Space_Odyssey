import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rain extends Actor
{
    /**
     * Act - do whatever the Rain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;    
    private int n;
    private String name = ""; 
    
    public Rain (int n, String name) {
        this.n = n;
        this.name = name;
    }
    
    public void act() 
    {
        // Add your action code here.
        rainRain();
    }    
    public void rainRain(){
        counter++;
        if(counter >=1 && counter <= n)
            animate (counter);
        if (counter > n) counter = 1;
        else if(counter < 1) counter = n;
    }
    private void animate(int counter) {
        Greenfoot.delay(1);
        setImage(name+counter+".png");
    }
}
