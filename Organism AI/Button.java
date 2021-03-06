import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Button Class
 * 
 * @author Cameron Dickie
 * @version 1.2
 */

public class Button extends Actor
{
    public GreenfootImage img;
    public MainWorld game;
    public boolean active = false;

    public Button(MainWorld w, String s) {
        img = new GreenfootImage(s);
        setImage(img); //setting the image to the filepath
        game = w; // setting the reference to the world

    }

    public void act() 
    {
        // Add your action code here.
        checkActive();
    }    

    public void checkActive() {
        if(Greenfoot.mouseClicked(this)) {
            active =  true;
        }
    }

    public boolean setActive(boolean n) {
        active = n;
        return active;
    }

    public boolean getActive() {
        return active;
    }

}
