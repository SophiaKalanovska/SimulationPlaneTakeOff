package assessment;
// Import in the program the class Diamension  class that existing within the external Java library 
import java.awt.Dimension;

// this is the main class.
public class FlightSimulator {

	/*
	 * the main method is used to create object of Coordinates with x = 5 and y = 0, 
	 * the object of Aeroplane with the coordinates and requiredSpeed = 10,
	 * the object of Frame with the supplied aeroplane 
	 * the object of Runway with length = 100 and width = 10.
	 * The size of the Frame is set to 500 by 800 and the startImplementation method is called with myFrame as
	 * the Frame and pista as Runway.
	 */
	public static void main(String[] args) {

		Coordinates coordinates = new Coordinates(5, 0);
		Aeroplane aeroplane = new Aeroplane(coordinates, 10);
		Frame myFrame = new Frame(aeroplane);
		myFrame.setPreferredSize(new Dimension(500, 800));
		Runway pista = new Runway(10, 100);

		myFrame.startImplementation(myFrame, pista);

	}

}
