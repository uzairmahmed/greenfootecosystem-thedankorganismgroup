import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Intro Screen
 *
 * @author class
 * @version 0.1
 */
public class IntroScreen extends World {

  MainWorld world;

  public IntroScreen() {
    super(1000, 400, 1);
  }

  public IntroScreen(MainWorld w) {
    super(600, 400, 1);
    world = w;
  }

  public void act() {
    if (Greenfoot.mouseClicked(this)) {
      Greenfoot.setWorld(world);
    }
    
    public IntroScreen(MainWorld w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1900, 1080, 1); 
        world = w;
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(world);
        }
    }
}
