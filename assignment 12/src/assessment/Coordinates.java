package assessment;

// this represents coordinates of a plane.
public class Coordinates {
	
	// integer variables x and y declared.
	private int x;
	private int y;

	/* 
	*create a constructor to give initial values to the fields: x and y. 
	*/
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* 
	*create a method called getX to return the x 
	*/
	public int getX() {
		return x;
	}

	/* 
	*create a method called getY to return the y 
	*/
	public int getY() {
		return y;
	}

	/* 
	*create a method called setX, which sets an integer value to x 
	*/
	public void setX(int x) {
		this.x = x;
	}

	/* 
	*create a method called setY, wich sets an integer value to y 
	*/
	public void setY(int y) {
		this.y += y;
	}

	/* 
	*create a method called resetY, wich resets the value to y 
	*/  
	public void resetY(int y) {
		this.y = y;

	}
}
