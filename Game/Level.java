import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Buttons
{
    /**
     * Act - do whatever the Level wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String level;
    public Level(){
        this("locked");
    }

    public Level (String levelName){
        level = levelName;
        setImage("world"+level+".png");
    }

    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if(level.equals("locked")) lockMessage();
            else ((LevelScreen)getWorld()).goToWorld(this.level);
        }
    }    

    public void lockMessage(){
        GreenfootImage lock = getImage();
        GreenfootImage message = new GreenfootImage("This world\nis locked!", 24, Color.RED, Color.BLACK); 
        lock.drawImage(message, getImage().getWidth()/2, getImage().getHeight()/2);
    }

}

