import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Floor
{
    private int numberOfHits;
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int type;
    public Block(){
        this(33);
    }
    public Block (int type){
        setImage("block"+type+".png");
        this.type = type;
        numberOfHits = 0;
    }

    public void act() 
    {
        //numberOfHits = 0;//for unlimited coins IOW for fun
        if(numberOfHits <5)bounce();         
    }  

    public boolean isHit(Actor player){

        if(player == null) return false;
        else if(player.getY() > getY()) return true; //cn climb like staircase
        else { 
            return false;
        }
    }

    public void bounce(){
        Actor player = getOneIntersectingObject(Player.class);
        if(isHit(player)){
            if(limit)numberOfHits++;
            jump(this, player, -5, type);
            if (type%10 == 2) numberOfHits =5;
            if (numberOfHits >= 5) {
                type = type/10*10 + 3;
                setImage("block"+type+".png");
            }

        }
    }
}
