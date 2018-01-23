import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class Load here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Load extends Buttons
{
    /**
     * Act - do whatever the Load wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String code = "";
    private static final String FILENAME = "score.txt";
    protected int counter = 0;
    protected int color = 1;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            //code = Greenfoot.ask("Enter the code here:");
            code = readFile();
            Greenfoot.setWorld(new Instructions(code));
        }
        changeColour("loadbtn");

        // Add your action code here.
    }    

    public void changeColour(String name){
        counter++;
        if(counter>25){
            setImage(name+ color +".jpg");
            color*=-1;
            counter=0;
        }
    }

    public String readFile(){
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String line;

            br = new BufferedReader(new FileReader(FILENAME));

            line = br.readLine();
            br.close();
            return line;

        } catch (IOException e) {
            return "0-0-0-1-A";
        }

    }
}
