///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Game)
// File:             (Rock)
// Semester:         (CS 302) Fall 2015
//
// Author:           (Andy Hagen ashagen@wisc.edu)
// CS Login:         (ahagen)
// Lecturer's Name:  (Debra Deppeler)
// Lab Section:      (314)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (name of your pair programming partner)
// Email:            (email address of your programming partner)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * The Rock class represents a rock in the game.
 * 
 * The Game class instantiates this class once for each rock present when a new
 * level is loaded.
 */
public class Rock {
	// Create private field to hold the GraphicObject associated with this rock
	private GraphicObject rock;
	/**
	 * TODO: Implement this.
	 * 
	 * @param x		the x position of the rock
	 * @param y		the y position of the rock
	 */
	public Rock(float x, float y) {
		
		//initialize local variable
	
		// Initialize this rock's associated GraphicObject with type "ROCK" at 
		// this rock's x and y coordinates
		rock = new GraphicObject("ROCK",x,y);
	}
	/**
	 * Checks if this rock is colliding with the specified snake.
	 * 
	 * If the GraphicObject associated with this rock is colliding with the head 
	 * of the GraphicObject associated with the head of the snake, kills the 
	 * snake.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param snake		snake to check for collisions with
	 */
	public void killSnakeIfColliding(Snake snake)
	{
		// If this rock is colliding with the snake's head's GraphicObject, kill
		GraphicObject head;
		head = snake.getGraphicObject();
		if (rock.isCollidingWith(head)) {
			// the snake
			snake.die();
		}
	}
}