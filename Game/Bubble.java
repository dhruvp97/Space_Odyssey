import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Powerups
{
    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter;

    public Bubble(){
        this(5);
    }

    public Bubble(int hits){
        counter = hits;
    }

    public void act() 
    {
        // Add your action code here.
        Actor player = getOneIntersectingObject(Player.class);
        Actor enemy = getOneIntersectingObject(Enemy.class);
        Actor boss = getOneIntersectingObject(Boss.class);
        //Actor kingboo = getOneIntersectingObject(KingBoo.class);
        //Actor bowser = getOneIntersectingObject(Bowser.class);
        setLocation(player.getX(), player.getY());

        if(boss!=null){
            if(!hitBoss()){
                //hukum_ka_eka_boss();lolololololololol
                int screen = ((SuperWorld)getWorld()).screen;
                boolean a=true, b=false, c=false;
                if(screen==4)b=true;
                else if(screen==8)c=true;
                getWorld().removeObject(boss);
                Greenfoot.playSound("boss.wav");
                counter--;
                if(screen<=8)Greenfoot.setWorld(new LevelScreen(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), ++((SuperWorld)getWorld()).screen, a, b, c));
                if(screen==12)((World12)getWorld()).bigB();
            }
        }       
        else if(enemy!=null){
            getWorld().removeObject(enemy);
            Greenfoot.playSound("blue_shield.wav");
            counter--;
        }
        if(counter<=0)getWorld().removeObject(this);

    }    
}
