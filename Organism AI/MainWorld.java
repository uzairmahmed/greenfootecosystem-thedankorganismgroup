import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Main GameState
 * 
 * @author Class
 * @author Uzair Ahmed
 * @author Cameron Dickie
 * @author Laura Balofsky
 * @version 1.0
 */

public class MainWorld extends World {

    //VARIABLES ---------------------------------------------------------
    static public ArrayList<ArrayList> lifeForms;
    static public ArrayList<Organism> team1;
    static public ArrayList<Organism> team2;
    static public ArrayList<Organism> team3;
    static public ArrayList<Organism> team4;

    static int startingMaxHealth = 10;
    static int startingMaxXp = 10;
    static int startingSpeed = 3;
    static int startingAttackPower = 1;
    static int startingDefensePower = 1;
    static int startingSight = 100;

    static int maxBuyableMaxHealth = 100;
    static int maxBuyableMaxXp = 100;
    static int maxBuyableSpeed = 30;
    static int maxBuyableAtt = 10;
    static int maxBuyableDef = 10;
    static int maxBuyableSight = 10;

    static int startingFood = 50;

    //ACTUAL CODE--------------------------------------------------------

    //Initializes classes
    IntroScreen intro;

    UIBack UI;
    PauseButton pauseButton;
    PauseWorld pause;

    Organism player1;
    Organism player2;
    Organism player3;
    Organism player4;

    public MainWorld() {
        //Creates new world of the size given
        super(1920,1080, 1);

        //Instantiates other world classes
        intro = new IntroScreen(this);
        pause = new PauseWorld();

        //Sets the world to Introscreen
        Greenfoot.setWorld(intro);

        //Sets paint order
        setPaintOrder(Actor.class);

        //Instantiates team arraylists
        team1 = new ArrayList<Organism>();
        team2 = new ArrayList<Organism>();
        team3 = new ArrayList<Organism>();
        team4 = new ArrayList<Organism>();
        lifeForms = new ArrayList<ArrayList>();

        //Adds each team to 2D arraylist
        lifeForms.add(team1);
        lifeForms.add(team2);
        lifeForms.add(team3);
        lifeForms.add(team4);

        //Instantiates players
        player1 = new Organism(startingMaxHealth, startingMaxXp, startingSpeed, startingAttackPower, startingDefensePower, startingSight, 1 , Color.RED);
        player2 = new Organism(startingMaxHealth, startingMaxXp, startingSpeed, startingAttackPower, startingDefensePower, startingSight, 2, Color.BLUE);
        player3 = new Organism(startingMaxHealth, startingMaxXp, startingSpeed, startingAttackPower, startingDefensePower, startingSight, 3, Color.GREEN);
        player4 = new Organism(startingMaxHealth, startingMaxXp, startingSpeed, startingAttackPower, startingDefensePower, startingSight, 4, Color.YELLOW);

        //Adds player to world
        addObject(player1, 10, 10);
        addObject(player2, 990, 0);
        addObject(player3, 0, 990);
        addObject(player4, 990, 990);

        //Runs UI method
        openUI();

        //Adds initial food
        for (int i = 0; i < startingFood; i++) {
            addObject(new Food(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(1000));
        }

    }

    public void act(){
        //10% chance of new food being spawned
        if (Greenfoot.getRandomNumber(100)<10){
            addObject(new Food(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(1000));
        }
    }

    //UI Method
    public void openUI() {
        UI = new UIBack(); // creates a reference to draw the back of the UI
        pauseButton = new PauseButton(this, pause, 100,100);
        addObject(UI, 1920 - UI.width/2, 0 + UI.height/2); // spawning the ui back at the right hand side of the screen
        addObject(pauseButton, UI.getX(),UI.getY());
    }

}