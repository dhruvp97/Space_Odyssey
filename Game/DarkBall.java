import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkBall extends Powerups
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean bossIsHit = false;
    
    public DarkBall(){
        Greenfoot.playSound("darkball.wav");
    }
    
    public void act() 
    {
        // Add your action code here.
        Actor enemy = getOneIntersectingObject(Enemy.class);
        Actor boss = getOneIntersectingObject(Boss.class);
        Actor object = getOneIntersectingObject(Pipe.class);

        setLocation(getX()+10, getY());
        if(isAtEdge())getWorld().removeObject(this);
        if(boss!=null && !bossIsHit){
            if(!hitBoss()){
                //hukum_ka_eka_boss();lolololololololol
                int screen = ((SuperWorld)getWorld()).screen;
                boolean a=true, b=false, c=false;
                if(screen==4)b=true;
                else if(screen==8)c=true;
                getWorld().removeObject(boss);
                
                addScore(100);
                if(screen<=8)Greenfoot.setWorld(new LevelScreen(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), ++((SuperWorld)getWorld()).screen, a, b, c));
                if(screen==12)((World12)getWorld()).bigB();
            }
            Greenfoot.playSound("boss.wav");
            getWorld().removeObject(this);
        }
        else if(enemy!=null){
            addScore(10);
            getWorld().removeObject(enemy);
        }
        else if(object!=null){
            getWorld().removeObject(object);
        }

    }

}
