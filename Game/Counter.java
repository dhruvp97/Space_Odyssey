import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private String prefix;
    private boolean type;

    public Counter()
    {
        this(new String(), true, 1);
    }

    public Counter(String prefix, boolean type, int img)
    {
        background = getImage();
        setImage("Counter"+img+".png");
        background = getImage();
        value = 0;
        this.prefix = prefix;
        this.type = type;
        target = 0;
        value = 0;
        updateImage();        
    }

    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add(int score)
    {
        target += score;
    }

    public void times2(){
        target*=2;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }

    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text;
        if (type) text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        else {
            if(value<10)text = new GreenfootImage("+"+prefix + value, 40, Color.WHITE, transparent);
            else text = new GreenfootImage("+"+prefix + value, 30, Color.WHITE, transparent);
        }
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        if (!type){
            if(value >= 10)image.drawImage(text, 27, 27);
            else image.drawImage(text, 27, 22);
        }
        else image.drawImage (text,(image.getWidth()-text.getWidth())/2, 
                (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
