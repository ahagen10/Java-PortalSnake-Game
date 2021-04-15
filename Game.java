///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (PortalSnake)
// Files:            (Snake, Rock, Apple, Portal Pair)
// Semester:         (CS 302) Fall 2015
//
// Author:           (Andy Hagen)
// Email:            (ashagen@wisc.edu)
// CS Login:         (ahagen)
// Lecturer's Name:  (Debra Deppeler)
// Lab Section:      (314)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (name of your pair programming partner)
// Email:            (email address of your programming partner)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.*;

/**
 * The Game class represents a running instance of the PortalSnake game. It
 * keeps track of the Snake object, lists of Apple, Rock, and PortalPair
 * objects, the current score, and whether the player has won.
 * 
 * The game engine (which we've written for you) will create a new instance of
 * this class when the player chooses a level to play. 
 * 
 * At each iteration of the game loop, the game engine calls the update() method
 * in the Game class. The update() method tells each of the objects in the game
 * to update itself based on the rules of the game. It then checks if the game
 * is over or not.
 */
public class Game {	
	// Store the instances of the game objects that you create for your game
	// in these member variables: 
	private Snake snake; //snake class is name of object. the constructor
						//initializes the object
	private ArrayList<Apple> apples;		
	private ArrayList<Rock> rocks;			
	private ArrayList<PortalPair> portals;	

	// Create member variables to track the controlType, score (ie number
	// of apples eaten by the snake), and whether the game has been won
	// or lost here.
	private int controlType;
	private int score;
	/**
	 * 
	 * TODO: Have students implement this
	 * 
	 * @param level - "RANDOM" or descriptions of the object to load
	 * @param controlType - 1: classic, 2: analog, 3: slither
	 */
	public Game(String level, int controlType) {
		
		float x = Engine.getWidth()/2;
		float y = 0;
	
		// Initialize all member variables
		rocks = new ArrayList<Rock>();
		portals = new ArrayList<PortalPair>();
		apples = new ArrayList<Apple>();
		//snake = new Snake(x,y);
		this.controlType = controlType;
		
		// Create a random level when level contains: RANDOM
		createRandomLevel();
		// Otherwise load the objects described in the string level
	}

	/**
	 * TODO: Have students implement this.
	 * create a new level with randomly positioned:
	 * Snake(1), Rocks(20), Apples(8), and PortalPairs(3)
	 */
	public void createRandomLevel() {
		Random coordinateAssigner = new Random();
		float height = Engine.getHeight();
		float width = Engine.getWidth();
		
		// create a randomly positioned snake
		float snakeY;
		float snakeX;
		
		snakeY = 0;
		snakeX = width/2;
		this.snake = new Snake(snakeX, snakeY);
		// create 20 randomly positioned rocks
		float rockY;
		float rockX;
		
		for (int rockNum = 0; rockNum < 20; rockNum++) {
			rockY = coordinateAssigner.nextFloat()*height;
			rockX = coordinateAssigner.nextFloat()*width;
			Rock rock = new Rock(rockX, rockY);
			rocks.add(rock);
		}
		/**rock x and y should be random and using get engine height and width**/
		// create 8 randomly positioned apples
		float appleY;
		float appleX;
		
		for (int appleNum = 0; appleNum < 8; appleNum++) {
			appleY = coordinateAssigner.nextFloat()*height;
			appleX = coordinateAssigner.nextFloat()*width;
			Apple apple = new Apple(appleX, appleY);
			apples.add(apple);
		}
		// create 3 randomly positioned portal pairs
		int portNum;
		float blueY;
		float blueX;
		float orangeY;
		float orangeX;
		
		for (portNum = 0; portNum < 3; portNum++) {
			
				
			blueY = coordinateAssigner.nextFloat()*height;
			blueX = coordinateAssigner.nextFloat()*width;
			orangeY = coordinateAssigner.nextFloat()*height;
			orangeX = coordinateAssigner.nextFloat()*width;
			PortalPair PortalPair = new PortalPair ("" + (char)(65+portNum), blueX, blueY, 
															orangeX, orangeY);
			portals.add(PortalPair);
		}
	}

	/**
	 * Loads a level from a String description.
	 * 
	 * Initializes all of the class private fields which hold the Snake object
	 * and the lists of Apple, Rock, and PortalPair objects from the provided
	 * String which contains  
	 * 
	 * TODO: Implement this method
	 * 
	 * @param level - a string containing the names and locations of objects
	 */
	public void loadLevel(String level)
	{
		// Initialize Rock, Apple, and PortalPair ArrayLists
		// Create a new scanner to read the level description		
		// Loop through lines in the level description
			// Get the next line
			// Split the line into tokens			
			// Determine the type of object to add to the level
				// If it's a snake, create a new snake at the x and y
				// coordinates specified by the second and third tokens

				// If it's an apple, create a new apple at the x and y
				// coordinates specified by the second and third tokens, and add
				// it to the list of apples

				// If it's a rock, create a new rock at the x and y coordinates
				// specified by the second and third tokens and add it to the
				// list of rocks

				// If it's a portal pair, create a new PortalPair with the
				// name equal to the second token, with the first portal at the
				// x and y coordinates specified by the third and fourth
				// tokens, and the second portal at the x and y coordinates
				// specified by the fifth and sixth tokens
		
				// If it's anything else, ignore it.

		// Close the scanner		
	}

	/**
	 * Updates the game objects.
	 * 
	 * Goes through each of the objects--the snake, rocks, apples, and portals--
	 * and tells them to behave according to the rules of the game. This method
	 * returns true if the game should continue, or false if the game is over.
	 * 
	 * TODO: Implement this
	 * 
	 * @return - false if the game is over, otherwise true
	 */
	
	
	
	public boolean update() {
		
		// Tell the snake to update itself
		snake.updateMoveDirection(controlType);
		
		// Tell the snake to die if it's colliding with itself
		snake.dieIfCollidingWithOwnBody();
		
		// For each rock, tell the rock to kill the snake if the two are
		// colliding
		for (int index = 0; index < rocks.size(); index++) {
			Rock rock;
			rock = rocks.get(index);
			rock.killSnakeIfColliding(snake);
		}
		
		// For each apple, tell the apple to be eaten by the snake if the two
		// are colliding, and if so update the score
		for (int index = 0; index < apples.size(); index++) {
		Apple apple;
		apple = apples.get(index);
		
		// boolean ignoredReturnValue = lemons.squeezeOutToMakeLemonJuice();
		// if(lemons.squeezeOutToMakeLemonJuice())
		//		doSomething..
		
		
			boolean isAppleEaten =apple.getEatenBySnakeIfColliding(snake);
			if (isAppleEaten == true) {
				score++;
			}
		}
		
		// For each portal pair, tell the pair to teleport the snake if the two
		// are colliding
		for(int x = 0; x < portals.size(); x++) {
			portals.get(x).teleportSnakeIfColliding(snake);
		}
		// Check for win/loss
		boolean result;
		result = playerHasWon();
			// If the score is equal to the number of apples, make sure hasWon()
			// will return true and then return false 
			if(result == true) {
				return true;
			}
			// Else, if the snake is dead, make sure hasWon() will return false
			// and then return false
			
		
		// If the game isn't over, return true
		return true;
	}

	/**
	 *  Returns true if the player has won
	 * 
	 * TODO: Implement this
	 * 
	 * @return true when the player has won, and false when they have lost or
	 * the game is not over
	 */
	public boolean playerHasWon() {
		if (score == apples.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the player's score.
	 * 
	 * TODO: Implement this.
	 * 
	 * @return the current score (number of apples eaten)
	 */
	public int getScore() {
		return score;
	}	

	/**
	 * There is nothing left to implement in this method, it simply calls
	 * Engine.startEngineAndGame(), which in turn starts the Engine and creates
	 * an instance of this Game class.  The engine will then repeatedly call
	 * the update() method on this Game until it returns false.
	 * 
	 * If you want to turn off the logging you can change the parameter being
	 * passed to startEngineAndGame to false.  
	 *  
	 * @param args - command line arguments
	 */
	public static void main(String[] args)
	{
		Application.startEngineAndGame(true);
	}
}