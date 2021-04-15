///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  (Game)
// File:             (Snake)
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
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Snake class represents the player-controlled snake. 
 *
 * The Game class instantiates this class exactly once, when a new level is
 * loaded.
 */
public class Snake 
{
	// Private variables to hold the GraphicObject associated with the snake's head
	private GraphicObject head;
	// and an ArrayList of GraphicObject associated with the snake's body
	private ArrayList<GraphicObject> bodySegments;
	/**
	 * Initializes a new Snake object at the specified (x,y) position.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param x		the initial x position of the snake
	 * @param y		the initial y position of the snake
	 */
	public Snake(float x, float y)
	{
		// Initialize new ArrayList to hold body segments
		bodySegments = new ArrayList<GraphicObject>();
		// Initialize the head
		head = new GraphicObject("HEAD",x,y);
		// Set the speed of the head
		head.setSpeed(2);
		// Set the direction of the head
		head.setDirection(90);
		// Add the head to the list of body segments
		bodySegments.add(head);
		// Add four body segments (grow the snake four times)
		grow();
		grow();
		grow();
		grow();
	}

	/**
	 * Returns the GraphicObject associated with the head of this snake.
	 *  
	 * TODO: Implement this.
	 * 
	 * @return the GraphicObject associated with the head of this snake
	 */
	public GraphicObject getGraphicObject() {
		return head;
	}

	/**
	 * Grows the snake by one body segment.
	 * 
	 * TODO: Implement this.
	 */
	public void grow()
	{
		float x = head.getX();
		float y = head.getY();
		// Create a new GraphicObject with type "BODY"
		GraphicObject body = new GraphicObject("BODY",x,y);
		// Find the last body segment in the list of body segments
		int numberSegments = bodySegments.size();
		GraphicObject leader = bodySegments.get(numberSegments-1);
		// Set the leader of the new body segment to be the last body segment
		body.setLeader(leader);
		// Add the new body segment to the end of the list of body segments
		bodySegments.add(body);
	}

	/**
	 * Reads keyboard input and changes the snake's direction as necessary.
	 * 
	 * TODO: Implement this.
	 * 
	 * @param controlType - 1: classic, 2: analog, 3: slither
	 */
	public void updateMoveDirection(int controlType) {
		
		float direction = head.getDirection();
	
		// if controlType is one
		
		if (controlType == 1) {
			// implementation for controlType one
			if (Engine.isKeyPressed("RIGHT")) {
			head.setDirection(direction - 90);
			}
			if (Engine.isKeyPressed("LEFT")) { 
					head.setDirection(direction + 90);
			}
		}
		// if controlType is two
		if (controlType == 2) {
			// implementation for controlType two
			if (Engine.isKeyHeld("RIGHT")) {
				head.setDirection(direction - 6);
			}
			if (Engine.isKeyHeld("LEFT")) {
				head.setDirection(direction + 6);
			}
		}
		// if controlType is three
		if (controlType == 3) {
			// implementation for controlType three
			if (Engine.isKeyHeld("SPACE")) {
				head.setDirection(direction + 6);
			}
			else {
				head.setDirection(direction - 6);
			}
		}
	}

	/**
	 * Kills the snake if the head is colliding with any of the body segments.
	 * 
	 * TODO: Implement this.
	 */
	public void dieIfCollidingWithOwnBody()
	{
		// For each game object in the body...
		for(int x = 0; x < this.bodySegments.size(); x++) {
			
			// if the head is colliding with this segment...
			if (head.isCollidingWith(bodySegments.get(x))) {
				// tell the snake to die.	
				die();
			}
		}
	}

	/**
	 * Kills the snake.
	 * 
	 * TODO: Implement this.
	 */
	public void die() {
		// Set the head's type to "DEAD"
		head.setType("DEAD");
		// For each GraphicObject in the snake's body, set its type to "DEAD"
		for(int x = 0; x < this.bodySegments.size(); x++) {
			bodySegments.get(x).setType("DEAD");
		}
	}

	/**
	 * Returns true if the snake is dead.
	 * 
	 * TODO: Implement this.
	 * 
	 * @return true if the snake is dead, false otherwise
	 */
	public boolean isDead() {
		String life;
		life = head.getType();
		if (life == "DEAD") {
			return true;
		}
		else {
		return false;
		}
	}
}