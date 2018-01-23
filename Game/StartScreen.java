import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 576, 1); 
        
        addObject(new Play(), 445, 540);
        addObject(new Load(), 625, 540);
        
        /**
         * Start image
         * Mario gif
         * if start image clicked then shows the instruction images
         * for intstructions either have them all on one page or have them open up as the
         * player clicks on them
         * save and load world can be added but needs to be researched first
         * selecting your character
         * cheatcode box(it will be a prompt not a textbox)
         * once instructions are done the world map to which ones are unlocked and which 
         * ones are locked
         * player either clicks or moves the character to the spot
         * the world opens and games starts
         */
    }
}
