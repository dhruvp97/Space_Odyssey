import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;    
    private int n;
    private String name = ""; 
    private int timer = 0;
    private String shoot;
    public String shoot2;
    private String up;
    private String left;
    private String right;
    private Boolean onRocket;
    private int fuelUsed =0;
    private boolean played = false;

    public Player (int n, String name, String shoot, String shoot2, String up, String left, String right) {
        this.n = n;
        this.name = name;
        this.shoot = shoot;
        this.shoot2 = shoot2;
        this.up = up;
        this.left = left;
        this.right = right;
        this.onRocket = false;
    }

    public void alter(int n, String name) {
        this.n = n;
        this.name = name;
        counter = 0;
    }

    public void act() 
    {
        // Add your action code here
        if(!onRocket){
            checkFall(this);
            movePlayer();
        }
        else{
            checkBounds();
            move();
            flyPlayer();
        }
        usePower();
        timer++;
    }

    public void checkBounds(){
        Actor object = getOneIntersectingObject(Floor.class);
        if(object!=null){
            int x = getX();
            int y = getY();
            int ox = object.getX();
            int oy = object.getY();
            int pushBack = 5;

            if(x<ox)x-=pushBack;
            else if(x>=ox)x+=pushBack;
            if(y<oy)y-=pushBack;
            else if(y>=oy)y+=pushBack;
            setLocation(x, y);

        }

    }

    public void flyPlayer(){
        ignite(Greenfoot.isKeyDown("up"));
        if(Greenfoot.isKeyDown("down"))minusToVelocity(new Vector(getRotation(), 0.3));
        if (Greenfoot.isKeyDown("left")) 
        {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            turn(5);
        }
    }

    public void ignite(boolean boosterOn) 
    {
        if (boosterOn) 
        {           
            fuelUsed++;
            int powers = ((SuperWorld)getWorld()).powerCounter2.getValue();
            if (powers > 0 || !limit){
                setImage("marioFlying.png");
                addToVelocity(new Vector(getRotation(), 0.3));
                if(fuelUsed>100){
                    if(limit) ((SuperWorld)getWorld()).powerCounter2.add(-1);
                    fuelUsed = 0;
                }
                played = false;
            }
            else if (!played) {
                Greenfoot.playSound("out_of_fuel.wav");
                played = true;
                minusToVelocity(new Vector(getRotation(), 0.3));
            }
        }
        else 
        {
            setImage("marioFlying1.png");        
        }
    }

    public void changeType(){
        onRocket = true;
        setImage("marioFlying1.png");
    }

    public void usePower(){
        if(timer>25){
            if(Greenfoot.isKeyDown(shoot)){
                int powers = ((SuperWorld)getWorld()).powerCounter.getValue();
                if (powers > 0 || !limit){
                    if(limit)((SuperWorld)getWorld()).powerCounter.add(-1);
                    shootFireball();
                    timer=0;
                }
                // Greenfoot.delay(4);
            }
            else if(Greenfoot.isKeyDown(shoot2)){
                int powers = ((SuperWorld)getWorld()).powerCounter2.getValue();
                if (powers > 0 || !limit){
                    /*if(limit)*/
                    if(limit)((SuperWorld)getWorld()).powerCounter2.add(-1);
                    int screen = ((SuperWorld)getWorld()).screen;
                    if(screen<=4 || screen>=8)shootDarkBall();
                    timer=0;
                }
                // Greenfoot.delay(4);
            }
        }
    }

    private void shootFireball(){
        Fireball fireball = new Fireball();
        getWorld().addObject(fireball, getX()+fireball.getImage().getWidth()/2, getY());
    }

    private void shootDarkBall(){
        DarkBall darkball = new DarkBall();
        getWorld().addObject(darkball, getX()+darkball.getImage().getWidth()/2, getY());
    }

    private void running(int counter) {
        //Greenfoot.delay(1);
        setImage(name+counter+".png");
    }

    public void movePlayer(){
        if(Greenfoot.isKeyDown(right)) {
            setLocation(getX()+speed,getY());
            counter += 1;
        }
        if(Greenfoot.isKeyDown(left)) {
            setLocation(getX()-speed,getY());
            counter -= 1;
        }
        if(!jumping && Greenfoot.isKeyDown(up)) {
            Greenfoot.playSound("jump.wav");
            jump(this);
        }
        if(getY()>=getWorld().getHeight()-5) {
            gameOver();
            getWorld().removeObject(this);
        }
        else if(getX()>= getWorld().getWidth()-1){
            int screen = ++((SuperWorld)getWorld()).screen;
            Actor bubble = getOneIntersectingObject(SuperBubble.class);
            if(bubble!=null)((SuperBubble)bubble).pop();
            if(screen==2)changeWorld(new World2(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==3)changeWorld(new World3(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==4)changeWorld(new World4(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==6)changeWorld(new World6(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==7)changeWorld(new World7(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==8)changeWorld(new World8(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else ++((SuperWorld)getWorld()).screen;;
        }
        else if(getX()<= 1){
            int screen = --((SuperWorld)getWorld()).screen;
            Actor bubble = getOneIntersectingObject(SuperBubble.class);
            if(bubble!=null)((SuperBubble)bubble).pop();
            if(screen==1)changeWorld(new World1(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==2)changeWorld(new World2(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==3)changeWorld(new World3(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==5)changeWorld(new World5(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==6)changeWorld(new World6(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else if(screen==7)changeWorld(new World7(((SuperWorld)getWorld()).score.getValue(), ((SuperWorld)getWorld()).powerCounter.getValue(), ((SuperWorld)getWorld()).powerCounter2.getValue(), screen));
            else ++((SuperWorld)getWorld()).screen;
        }
        if(counter >=1 && counter <= n)
            running (counter);
        if (counter > n) counter = 1;
        else if(counter < 1) counter = n;
    }

    private void play(String soundFile){
        Greenfoot.playSound(soundFile);
    }
}

