///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Game)
// File:             (Portal Pair)
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
 * The PortalPair class represents a pair of portals.
 * 
 * The Game class instantiates this class once for each pair of portals present
 * when a new level is loaded.
 */
public class PortalPair {
	// Create private field to hold the GraphicObject associated with the blue portal
	private GraphicObject bluePortal;
	// Create private field to hold the GraphicObject associated with the orange portal
	private GraphicObject orangePortal;
	/**
	 * TODO: Implement this
	 * 
	 * @param name		name displayed on each end of the portal pair
	 * @param blueX		the x position of the blue portal
	 * @param blueY		the y position of the blue portal
	 * @param orangeX	the x position of the orange portal
	 * @param orangeY	the y position of the orange portal
	 */
	public PortalPair(String name, float blueX, float blueY, 
			                       float orangeX, float orangeY) {
		// Initialize the GraphicObjects associated with the blue and orange
		// portals, setting the type to "BLUE_PORTAL_name" or
		// "ORANGE_PORTAL_name", respectively, and setting their x and y
		// coordinates appropriately
		
		bluePortal = new GraphicObject ("BLUE_PORTAL_" + name, blueX, blueY);
		orangePortal = new GraphicObject ("ORANGE_PORTAL_" + name, 
														orangeX, orangeY);
	}
		
	/**
	 * Checks if either end of this portal pair is colliding with the specified
	 * snake.
	 * 
	 * If either end of this portal pair is colliding with the snake, moves the
	 * snake past the other end of the portal.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param snake		the snake to check for collisions with
	 */
	public void teleportSnakeIfColliding(Snake snake) {
		// If the blue portal is colliding with the snake's head's GraphicObject,
		// move the snake's head's GraphicObject past the orange portal
		GraphicObject head;
		head = snake.getGraphicObject();
		if (bluePortal.isCollidingWith(head)) {
			head.movePast(orangePortal);
		}
		// If the orange portal is colliding with the snake's head's 
		// GraphicObject, move the snake's head's GraphicObject past the 
		// blue portal
		if (orangePortal.isCollidingWith(head)) {
			head.movePast(bluePortal);
		}
	}
}