import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        Greenfoot.playSound("finish_game.wav");
        saveFile();
    }
    public void saveFile(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter("score.txt");
            bw = new BufferedWriter(fw);

            String line;

            
            line = "999-99-99-12-C";
            
            
            bw.write(line);
            bw.close();
        } catch (IOException e) {
            
        }

    }
}
