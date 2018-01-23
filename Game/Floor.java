import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Effects
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }     

    public void jump(Actor floor, Actor player, int jumpStrength, int type){
        for (int i = jumpStrength; i<= Math.abs(jumpStrength); i+=gravity) {
            Greenfoot.delay(1);
            checkFall(player);
            if(i>jumpStrength/2 && i<gravity+jumpStrength/2) {
                Greenfoot.playSound("smw_coin.wav");
                showItem(type, floor, player);
            }
            setLocation(floor.getX(), floor.getY() + i);
        }
    }

    public void showItem(int type, Actor floor, Actor player){
        int topOfFloor = floor.getY()-floor.getImage().getHeight()/2;
        Item item = itemType(type,player);
        int itemHeight = item.getImage().getHeight()/2;
        getWorld().addObject(item, floor.getX(), topOfFloor - itemHeight - 10);
        Greenfoot.playSound("smw_coin.wav");
    }

    public Item itemType(int type, Actor player){
        if(type%10==1) return new Gold();
        else if(type%10==2) {
            int item = Greenfoot.getRandomNumber(100);
           //return new Purple();
            if(item<10) return new Blue();
            else if(item<25) return new Green();
            else if(item<40) return new Purple();
            else if(item<70) return new Red();
            else if(item<=100) return new Yellow();
            
        }
        return null;
    }
}
