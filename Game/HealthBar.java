import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health;
    private int healthBarWidth;
    private int healthBarHeight;
    private int pixelsPerHP;
    private String name;
    
    public HealthBar(){
        this(4, 80, 10, "Boss");
    }
    
    public HealthBar(int health, int width, int height, String name){
        this.health = health;
        healthBarWidth = width;
        healthBarHeight = height;
        this.name = name;
        pixelsPerHP = (int) healthBarWidth/health;
        update();
    }
    
    public void act() 
    {
        // Add your action code here.
        update();
    }    
    
    public void update(){
        setImage(new GreenfootImage(healthBarWidth+2, healthBarHeight+2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health*pixelsPerHP, healthBarHeight);
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth+1, healthBarHeight+1);
        myImage.drawString(name, 18, 12);
    }
    
    public boolean loseHealth(){
        health--;
        if(health>0){
            update();
            return true;
        }
        else return false;
    }
    
    public boolean dead(){
        health--;
        if(health>0) return true;
        else if (health==0) return false;
        else {
            health++;
            return false;
        }
    }
}
