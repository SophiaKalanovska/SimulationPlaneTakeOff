package assessment;

// this class represents a Runway.
public class Runway {

	// integer variables width and length declared.
	private final int width;
	private final int length;

	/*
	*constructor is used to assign values to width and length.
	*/
	public Runway(int width, int length) {
		this.width = width;
		this.length = length;
	}

	/*
	* method getWidth is created to return width. 
	*/
	public int getWidth() {
		return width;

	}

	/* 
	* method getLength is created to return length. 
	*/
	public int getLength() {
		return length;
	}

}
