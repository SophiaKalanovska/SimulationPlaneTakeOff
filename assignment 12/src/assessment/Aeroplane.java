package assessment;

// this represents an Aeroplane.

public class Aeroplane {

	// the variables coordinates, inAir, speed, seconds, elevation,
	// requiredSpeed and elevationIncrease are declared.
	private Coordinates coordinates;
	private boolean inAir;
	private int speed;
	private int seconds;
	private int elevation;
	private int requiredSpeed;
	private int elevationIncrease;

	/* 
	* The constructor is used to assign the values to the supplied Coordinates and
	* requiredSpeed. Also inAir is set to false, elevation = 0,
	* seconds = 0, speed = 0 and elevationIncrease.
	*/
	public Aeroplane(Coordinates coordinates, int requiredSpeed) {
		this.coordinates = coordinates;
		this.requiredSpeed = requiredSpeed;
		inAir = false;
		elevation = 0;
		seconds = 0;
		speed = 0;
		elevationIncrease = 0;

	}

	/* 
	* sets the value of Coordinate x by taking an integer value and calling the set method in Coordinates. 
	*/
	public void setCoorX(int x) {
		coordinates.setX(x);
	}

	/* 
	 * sets the value of Coordinate y by taking an integer value and calling the set method in Coordinates.. 
	*/
	public void setCoorY(int y) {
		coordinates.setY(y);
	}

	/* 
	* resets the value of Coordinate y by taking an integer value and calling the reset method in Coordinates..
	*/
	public void resetCoorY(int y) {
		coordinates.resetY(y);
	}

	/* 
	* sets the value of speed by taking an integer value. 
	*/
	public void setSpeed(int s) {
		speed = s;
	}

	/*
	* Rewrites the String default representation of the objects of class Aeroplane.
	*/
	public String toString() {
		return "X: " + getCoorX() + " Y: " + getCoorY() + " Speed: " + speed + " Elevation: " + elevation;

	}

	/* 
	*returns Coordinate x. 
	*/
	public int getCoorX() {
		return coordinates.getX();
	}

	/* 
	*returns Coordinate y.
	 */
	public int getCoorY() {
		return coordinates.getY();
	}

	/* 
	* increments the seconds by one. 
	*/
	public void incrementSeconds() {
		seconds++;
	}

	/* 
	* sets the value of seconds by taking an integer value.
	*/
	public void setSeconds(int sec) {
		seconds = sec;
	}

	/* 
	*returns seconds. 
	*/
	public int getSeconds() {
		return seconds;
	}

	/*
	 * this method increments the elevationIncrease if the speed is equal to the
	 * required speed. Then if the speed is equal to the reqired speed for 
	 * at least 5 seconds( elevationIncrease is greater or equal to 5), the
	 * elevation is incremented by one and elevation is returned. Else the
	 * elevationIncrease is set to 0 and elevation is returned.
	 */
	public int elevation() {

		if (speed == requiredSpeed) {
			elevationIncrease++;

			if (elevationIncrease >= 5) {
				elevation++;
			}
			return elevation;

		} else {
			elevationIncrease = 0;
			return elevation;
		}

	}

	/*
	 * This method sets the boolean inAir to true of false .
	 * If the elevation is more than 5 it checks the following:
	 * if the plane is not on the runway and the plaane is not in the middle (sets the inAir to false)
	 * if the plane is still on the runway and the plaane is in the middle (sets the inAir to true)
	 * if the plane is still on the runway and the plaane is not in the middle (sets the inAir to false)
	 * in any other case inAr is set to false
	 */
	public void setInAir() {

		if (elevation >= 5) {

			if (getCoorY() >= 100 && getCoorX() != 5) {
				inAir = false;
			} else if (getCoorY() <= 100 && getCoorX() == 5) {
				inAir = true;
			} else if (getCoorY() <= 100 && getCoorX() != 5) {
				inAir = false;
			} else {
				inAir = false;
			}
		}
	}

	/* 
	*returns the value of inAir. 
	*/
	public boolean getInAir() {
		return inAir;
	}
}
