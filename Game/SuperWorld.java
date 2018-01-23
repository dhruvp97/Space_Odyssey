import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class SuperWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SuperWorld extends World
{

    /**
     * Constructor for objects of class SuperWorld.
     * 
     */
    protected static int gold = 0;
    protected static int power1 = 0;
    protected static int power2 = 0;
    protected static int screen = 1;

    protected boolean bowserDead = false;
    protected Counter score;
    protected Counter powerCounter;
    protected Counter powerCounter2;
    protected Bubble bubble;
    protected RedLuma luma1 = new RedLuma();
    protected PurpleLuma luma2 = new PurpleLuma();
    protected BlueLuma luma3 = new BlueLuma();
    
    

    protected Player mario = new Player(12,"marioRunning", "1", "2", "Up", "Left", "Right");
    protected Player sonic = new Player(8, "s", "v", "b", "w", "a", "d");
    protected HealthBar bossHealth;
    protected HealthBar bossHealth2;
    protected HealthBar bossHealth3;
    protected HealthBar bossHealth4;
    protected HealthBar bossHealth5;
    private static final String FILENAME = "score.txt";

    public SuperWorld(int gold, int power1, int power2, int screen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        this.gold = gold;
        this.power1 = power1;
        this.power2 = power2;
        this.screen = screen;

        score = new Counter ("Score: ", true, 1);
        addObject(score, 50, 20);
        score.setValue(gold);

        powerCounter = new Counter ("", false, 2);
        addObject(powerCounter, getWidth()-powerCounter.getImage().getWidth()/2, powerCounter.getImage().getHeight()/2);
        powerCounter.setValue(power1);

        powerCounter2 = new Counter ("", false, 3);
        addObject(powerCounter2, powerCounter.getX()-powerCounter2.getImage().getWidth(), powerCounter2.getImage().getHeight()/2);
        powerCounter2.setValue(power2);

        addObject(luma1, luma1.getImage().getWidth()/2, 10+score.getY() + score.getImage().getHeight()/2 + luma1.getImage().getHeight()/2);
        addObject(luma2, luma2.getImage().getWidth()/2, 10+luma1.getY() + luma1.getImage().getHeight()/2 + luma2.getImage().getHeight()/2);
        addObject(luma3, luma3.getImage().getWidth()/2, 10+luma2.getY() + luma2.getImage().getHeight()/2 + luma3.getImage().getHeight()/2);
    }

    public void gameOver(){
        addObject(new ScoreBoard(score.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("death.wav");

        // Code that in the text (resets).

        Greenfoot.delay(100);
        Greenfoot.stop();
        Greenfoot.setWorld(new StartScreen());
    }

    public void changeWorld(World world, int counter){
        gold = score.getValue();
        power1 = powerCounter.getValue();
        power2 = powerCounter2.getValue();
        Greenfoot.setWorld(world);

    }

    public boolean hitBoss(){
        return bossHealth.loseHealth();
    }

    public void act(){
        if(Greenfoot.isKeyDown("X")){
            saveFile();

        }
    }
    
    public void saveFile(){
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        try {

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            String line;
            
            power1 = powerCounter.getValue();
            power2 = powerCounter2.getValue();
            gold = score.getValue();
            
            line = gold+"-"+power1+"-"+power2+"-"+screen+"-";
            if(screen<5) line = line + "A";
            else if(screen<9) line = line + "B";
            else if(screen<=12) line = line + "C";
            Greenfoot.playSound("save.wav");
            
            bw.write(line);
            bw.close();
        } catch (IOException e) {
            
        }

    }

    

}

