///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Game)
// File:             (Apple)
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
 * The Apple class represents an apple in the game.
 * 
 * The Game class instantiates this class once for each apple present when a new
 * level is loaded.
 */
public class Apple 
{
	// Create private field to hold the GraphicObject associated with this apple
	private GraphicObject apple;
	/**
	 * Initializes a new Apple object.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param x		the x position of the apple
	 * @param y		the y position of the apple
	 */
	public Apple(float x, float y)
	{
		// Initialize this apple's associated GraphicObject with type "APPLE" at
		// this apple's x and y coordinates
		apple = new GraphicObject ("APPLE",x,y);
	}
			
	/**
	 * Checks if this apple is colliding with the specified snake.
	 * 
	 * If the GraphicObject associated with this apple is colliding with the
	 * GraphicObject associated with the specified snake's head, grows the snake,
	 * destroys the GraphicObject associated with this apple (causing it to
	 * disappear from the screen), and returns true. Otherwise, returns false.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param snake		snake to check for collisions with
	 * @return true after eating an apple, otherwise false
	 */
	public boolean getEatenBySnakeIfColliding(Snake snake) {
		// If this apple is colliding with the snake's head's GraphicObject,
		// grow the snake once and destroy this apple's GraphicObject, then
		// return true
		GraphicObject head;
		head = snake.getGraphicObject();
		if (apple.isCollidingWith(head)) {
			snake.grow();
			apple.destroy();
			return true;
		}
		
		// Otherwise, return false
		else {
		return false;	
		}
	}
}